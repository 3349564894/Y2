package com.yq.crm.controller;

import com.yq.crm.entity.Customer;
import com.yq.crm.entity.Services;
import com.yq.crm.entity.User;
import com.yq.crm.service.ServicesService;
import com.yq.crm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServicesController {
    @Resource
    private ServicesService servicesService;

    @RequestMapping("/dispatch")
    public String dispatch(String svrCustName, String svrTitle, String svrType, Model model, Integer currPageNo) {
        Integer page1 = currPageNo == null ? 1 : currPageNo;

        Page page = new Page();
        page.setTotal(servicesService.count(svrCustName, svrTitle, svrType)); // 数据总条数
        if (page1 < 1) {
            page1 = 1;
            model.addAttribute("page", "没有上一页了");
        }
        if (page1 > page.getPages()) {
            page1 = page.getPages();
            model.addAttribute("page", "没有下一页了");
        }
        page.setCurrent(page1); // 设置偏移量

        // 存储数据
        List<Services> all = servicesService.finAll(svrCustName, svrTitle, svrType, page.getOffset(), page.getPageSize());
        page.setList(all);

        model.addAttribute("dispatchPage", page);

        return "service/dispatch";
    }

    @RequestMapping("/deal")
    public String deal(String svrCustName, String svrTitle, String svrType, Model model, Integer currPageNo) {
        Integer page1 = currPageNo == null ? 1 : currPageNo;

        Page page = new Page();
        page.setTotal(servicesService.count(svrCustName, svrTitle, svrType)); // 数据总条数
        page.setCurrent(page1); // 设置偏移量

        // 存储数据
        List<Services> all = servicesService.finAll(svrCustName, svrTitle, svrType, page.getOffset(), page.getPageSize());
        page.setList(all);

        model.addAttribute("dealPage", page);
        return "service/deal";
    }


    @RequestMapping("/feedback")
    public String feedback(String svrCustName, String svrTitle, String svrType, Model model, Integer currPageNo) {
        Integer page1 = currPageNo == null ? 1 : currPageNo;

        Page page = new Page();
        page.setTotal(servicesService.count(svrCustName, svrTitle, svrType)); // 数据总条数
        page.setCurrent(page1); // 设置偏移量

        // 存储数据
        List<Services> all = servicesService.finAll(svrCustName, svrTitle, svrType, page.getOffset(), page.getPageSize());
        page.setList(all);

        model.addAttribute("feedbackPage", page);

        return "service/feedback";
    }

    @RequestMapping("/arch")
    public String arch(String svrCustName, String svrTitle, String svrType, Model model, Integer currPageNo) {
        System.out.println(svrCustName);
        System.out.println(svrTitle);
        Integer page1 = currPageNo == null ? 1 : currPageNo;

        Page page = new Page();
        page.setTotal(servicesService.count(svrCustName, svrTitle, svrType)); // 数据总条数
        page.setCurrent(page1); // 设置偏移量

        // 存储数据
        List<Services> all = servicesService.finAll(svrCustName, svrTitle, svrType, page.getOffset(), page.getPageSize());
        page.setList(all);

        model.addAttribute("archPage", page);

        return "service/arch";
    }


    @RequestMapping("/toAdd")
    public String add() {
        return "service/add";
    }

    @RequestMapping("/findArch/{chcId}")
    public String findArch(@PathVariable(name = "chcId") Integer id, Model model) {
        Services services = servicesService.findId(id);
        model.addAttribute("serviceFindArch", services);
        return "/service/findArch";
    }

    @RequestMapping("/toedit/{chcId}")
    public String edit(@PathVariable(name = "chcId") Integer id, Model model) {
        Services services = servicesService.findId(id);
        model.addAttribute("serviceEdit", services);
        return "service/edit";
    }

    @RequestMapping("/toedit1/{chcId}")
    public String edit1(@PathVariable(name = "chcId") Integer id, Model model) {
        Services services = servicesService.findId(id);
        model.addAttribute("serviceEdit", services);
        return "service/edit1";
    }

    @RequestMapping("/add")
    public String add(Services services, Model model) {
        int add = servicesService.addService(services);
        if (add > 0) {
            return "redirect:/service/feedback";
        } else {
            return "service/add";
        }
    }

    @RequestMapping("/edit")
    public String edit(Services services, Model model) {
        int update = servicesService.updaService(services);
        if (update > 0) {
            return "redirect:service/feedback";
        } else {
            return "service/edit";
        }
    }

    @RequestMapping("/edit1")
    public String edit1(Services services, Model model) {
        int update = servicesService.updaService(services);
        if (update > 0) {
            return "redirect:/service/feedback";
        } else {
            return "service/edit";
        }
    }

    @RequestMapping("/del/{svrId}")
    @ResponseBody
    public String del(@PathVariable(name = "svrId") Integer id, Model model) {
        int del = servicesService.delServices(id);
        return "{\"delResult\",\"true\"}";
    }


    @RequestMapping("/upd")
    @ResponseBody
    public String upd(String dueId, String dueName, String id) {
        int upd = servicesService.updServiceTo(id, dueId, dueName);
        if (upd > 0) {
            return "true";
        } else {
            return "0";
        }

    }
}
