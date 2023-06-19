package com.yq.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yq.entity.Follow;
import com.yq.entity.User;
import com.yq.service.BlogService;
import com.yq.service.FollowService;
import com.yq.service.impl.BlogServiceImpl;
import com.yq.service.impl.FollowServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FollowServlet", urlPatterns = "/control/follow")
public class FollowServlet extends HttpServlet {
    private static final long serialVersionUID = 4761216042804814763L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String contextPath = request.getContextPath();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String opr = request.getParameter("opr");
        String keyword = (request.getParameter("keyword") != null) ? request.getParameter("keyword").trim() : "";
        BlogService blogService = new BlogServiceImpl();
        FollowService followService = new FollowServiceImpl();
        Integer uid = ((User) session.getAttribute("user")).getId();
        if (opr.equals("followList")) {
            //关注列表
            try {
                List<User> list = followService.getFollowedByUidAndKeyword(uid, keyword);
                String json = JSON.toJSONString(list, SerializerFeature.WriteMapNullValue);
                out.print(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("fansList")) {
            //粉丝列表
            try {
                session.setAttribute("blogCount", blogService.getBlogCount(uid));
                session.setAttribute("followerCount", followService.getFollowedCount(uid));
                session.setAttribute("fansCount", followService.getFansCount(uid));
                List<User> list = followService.getFansByUidAndKeyword(uid, keyword);
                for (User fan : list) {
                    fan.setFollowed(followService.isFollowed(uid, fan.getId()));
                }
                request.setAttribute("list", list);
                request.setAttribute("keyword", keyword);
                request.getRequestDispatcher("/pages/myfans.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("follow")) {
            //加关注
            try {
                int followedUid = Integer.parseInt(request.getParameter("id"));
                Follow follow = new Follow();
                follow.setuId(uid);
                follow.setFollowerId(followedUid);
                int result = followService.addFollower(follow);
                StringBuffer json = new StringBuffer("{");
                if (result > 0) {
                    json.append("\"result\":1,\"message\":\"关注成功！\"");
                } else if (result == -1) {
                    json.append("\"result\":0,\"message\":\"您已关注该用户！\"");
                } else {
                    json.append("\"result\":0,\"message\":\"关注失败！\"");
                }
                json.append("}");
                out.println(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (opr.equals("delete")) {
            //取消关注
            try {
                int followedUid = Integer.parseInt(request.getParameter("id"));
                Follow follow = new Follow();
                follow.setuId(uid);
                follow.setFollowerId(followedUid);
                int result = followService.deleteFollower(follow);
                StringBuffer json = new StringBuffer("{");
                if (result > 0) {
                    json.append("\"result\":1,\"message\":\"取消关注成功！\"");
                } else {
                    json.append("\"result\":0,\"message\":\"取消关注失败！\"");
                }
                json.append("}");
                out.println(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
