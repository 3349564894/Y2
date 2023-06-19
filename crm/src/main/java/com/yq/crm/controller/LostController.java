package com.yq.crm.controller;

import com.yq.crm.entity.Lost;
import com.yq.crm.service.LostService;
import com.yq.crm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/lost")
public class LostController {
    @Resource
    private LostService lostService;


    @GetMapping("/list")
    public String finNameAndRegion(String name, String name1, Model model, Integer currPageNo) {
        Integer page1 = currPageNo == null ? 1 : currPageNo;

        Page page = new Page();
        page.setTotal(lostService.count(name, name1)); // 数据总条数
        if (page1 < 1) {
            page1 = 1;
        }
        if (page1 > page.getPages()) {
            page1 = page.getPages();
        }
        page.setCurrent(page1); // 设置偏移量

        // 存储数据
        List<Lost> all = lostService.finNameAndName(name, name1, page.getOffset(), page.getPageSize());
        page.setList(all);

        model.addAttribute("lostPage", page);

        return "lost/list";
    }

    @GetMapping("/list/edit")
    public String edit(Integer lst_id, Model model) {
        Lost lost = lostService.finId(lst_id);
        model.addAttribute("lost", lost);
        return "lost/edit";
    }

    @PostMapping("/edit/update")
    public String update(Lost lost, Model model) throws IOException {
        //执行更新
        Integer result = lostService.update(lost);
        Page page = new Page();
        int count = lostService.count(null, null);
        if (count != 0) {
            page.setTotal(count); // 数据总条数
            page.setCurrent(1); // 设置偏移量
            // 存储数据
            List<Lost> all = lostService.finNameAndName(null, null, page.getOffset(), page.getPageSize());
            page.setList(all);

            model.addAttribute("lostPage", page);

        }
        return "lost/list";
    }
}
