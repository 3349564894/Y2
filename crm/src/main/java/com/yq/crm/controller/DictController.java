package com.yq.crm.controller;

import com.yq.crm.entity.Customer;
import com.yq.crm.entity.Dict;
import com.yq.crm.service.DictService;
import com.yq.crm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/dict")
public class DictController {
    @Resource
    private DictService dictService;

    @RequestMapping("/list")
    public String list(Integer dictId, String dictValue, Model model, Integer currPageNo) {
        Integer page1 = currPageNo == null ? 1 : currPageNo;

        Page page = new Page();
        page.setTotal(dictService.count(dictId, dictValue)); // 数据总条数
        page.setCurrent(page1); // 设置偏移量

        // 存储数据
        List<Dict> all = dictService.finIdAndValue(dictId, dictValue, page.getOffset(), page.getPageSize());
        page.setList(all);

        model.addAttribute("dictPage", page);

        return "dict/list";
    }

    @RequestMapping("/toedit/{id}")
    public String toedit(@PathVariable(name = "id") Integer id, Model model) {
        Dict dict = dictService.finId(id);
        model.addAttribute("dict", dict);
        return "/dict/edit";
    }

    @RequestMapping("/save")
    public String save(Dict dict, Model model) {
        int upd = dictService.updDict(dict);
        if (upd <= 0) {
            return "dict/edit";
        } else {
            return "redirect:/dict/list";
        }
    }

    @RequestMapping("/toadd")
    public String toadd() {
        return "/dict/add";
    }

    @RequestMapping("/add")
    public String add(Dict dict) {
        int add = dictService.allDict(dict);
        if (add <= 0) {
            return "dict/add";
        } else {
            return "redirect:/dict/list";
        }
    }

    @RequestMapping("/del/{dictId}")
    @ResponseBody
    public String del(@PathVariable(name = "dictId") Integer id, Model model) {
        int del = dictService.delDict(id);
        if (del > 0) {
            return "{\"delResult\",\"true\"}";
        } else {
            return "{\"delResult\",\"false\"}";
        }
    }

}
