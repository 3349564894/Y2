package com.yq.crm.controller;

import com.yq.crm.entity.Chance;

import com.yq.crm.service.PlanService;
import com.yq.crm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/crm/plan")
@Controller
public class PlanController {

    @Resource
    private PlanService planService;

    @RequestMapping("/list")
    public String findAll(Model model, @RequestParam(required = false) String chcCustName, @RequestParam(required = false) String chcLinkman,
                          @RequestParam(required = false) String chcTitle, Integer currPageNo) {
        Integer page1 = currPageNo == null ? 1 : currPageNo;
        Page page = new Page();
        page.setTotal(planService.count(chcCustName, chcLinkman, chcTitle)); // 数据总条数
        page.setCurrent(page1); // 设置偏移量

        // 存储数据
        List<Chance> all = planService.findAll(chcCustName, chcLinkman, chcTitle, page.getOffset(), page.getPageSize());
        page.setList(all);

        model.addAttribute("planPage", page);


        return "plan/list";
    }

    @PostMapping("/toedit")
    String toedit(Model model, Long usrId) {
        return "edit";
    }

    @PostMapping("/edit")
    String edit(Chance chance) {
        return "list";
    }

    @PostMapping("/del")

    // 跳转添加页面
    @RequestMapping("/toAdd/{id}")
    String del(@PathVariable("id") Long usrId) {
        return "";
    }

    public String toAdd(Model model) {

//        List<User> user = userService.findAll();

//        model.addAttribute("users",user);

        return "plan/add";
    }

    // 添加信息
    @PostMapping("/add")
    public String add(Chance chance) {

        int add = planService.insert(chance);
        if (add > 0) {
            return "redirect:/crm/plan/list";
        }
        return "redirect:/crm/plan/toAdd";
    }
}
