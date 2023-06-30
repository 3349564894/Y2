package com.yq.crm.controller;

import com.yq.crm.entity.Chance;
import com.yq.crm.service.ChanceService;
import com.yq.crm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/chance")
public class ChanceController {
    @Resource
    private ChanceService chanceService;

    @GetMapping("/list")
    String findAllAndPage(Model model) {
        Page page = new Page();
        //查询总数据
        int count = chanceService.count(null, null);
        //设置总数据
        page.setTotal(count);
        //设置偏移量
        page.setCurrent(1);
        //查询数据
        List<Chance> chanceList = chanceService.findByChcCustNameAndTitle(null, null, page.getOffset(), page.getPageSize());
        page.setList(chanceList);
        model.addAttribute("chancePage", page);
        return "chance/list";
    }

    @PostMapping("/list/find")
    public String findAndPage(Model model, String custName, String chcDesc, Integer currPageNo) {
        Integer page1 = currPageNo == null ? 1 : currPageNo;
        Page page = new Page();
        page.setTotal(chanceService.count(custName, chcDesc)); // 数据总条数
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
        List<Chance> all = chanceService.findByChcCustNameAndTitle(custName, chcDesc, page.getOffset(), page.getPageSize());
        page.setList(all);

        model.addAttribute("chancePage", page);

        return "chance/list";
    }

    @RequestMapping("/toedit")
    public String finNameAndTitle(Long chcId, Model model) {
        Chance chance = chanceService.findById(chcId);
        model.addAttribute("chance", chance);
        return "chance/edit";
    }

    @RequestMapping("/edit")
    public String uplChance(Chance chance, Model model) {
        int upl = chanceService.updateChance(chance);
        if (upl <= 0) {
            return "chance/edit";
        } else {
            return "redirect:/chance/list";
        }
    }

    @GetMapping("/toadd")
    public String toadd() {
        return "chance/add";
    }

    @RequestMapping("/add")
    public String addChance(Chance chance, Model model) {
        int add = chanceService.addChance(chance);
        if (add <= 0) {
            return "chance/add";
        } else {
            return "redirect:/chance/list";
        }
    }

    @RequestMapping("/del/{chcId}")
    @ResponseBody
    public String delChance(@PathVariable(name = "chcId") Long id) {
        int del = chanceService.deleteChance(id);
        if (del > 0) {
            return "{\"delResult\",\"true\"}";
        } else {
            return "{\"delResult\",\"false\"}";
        }
    }


}
