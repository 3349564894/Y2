package com.yq.crm.controller;

import com.yq.crm.entity.Customer;
import com.yq.crm.service.CustomerService;
import com.yq.crm.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping("/list")
    public String finNameAndRegion(String cust_name, String cust_region, Model model, Integer currPageNo) {
        Integer page1 = currPageNo == null ? 1 : currPageNo;
        Page page = new Page();
        int count = customerService.count(cust_name, cust_region);
        if (count != 0) {
            page.setTotal(count); // 数据总条数
            if (page1 < 1) {
                page1 = 1;
                model.addAttribute("page", "这是首页了");
            }
            if (page1 > page.getPages()) {
                page1 = page.getPages();
                model.addAttribute("page", "这是最后一页了");
            }
            page.setCurrent(page1); // 设置偏移量

            // 存储数据
            List<Customer> all = customerService.finNameAndRegion(cust_name, cust_region, page.getOffset(), page.getPageSize());
            page.setList(all);

            model.addAttribute("customerPage", page);
        }
        return "customer/list";

    }

    @GetMapping("/list/edit")
    public String edit(String custNo, Model model) {
        Customer customer = customerService.findCustomer(custNo);
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @GetMapping("edit/update")
    public String update(Customer customer, Model model) throws IOException {
        //执行更新
        customerService.update(customer);
        Page page = new Page();
        int count = customerService.count(null, null);
        if (count != 0) {
            page.setTotal(count); // 数据总条数
            page.setCurrent(1); // 设置偏移量
            // 存储数据
            List<Customer> all = customerService.finNameAndRegion(null, null, page.getOffset(), page.getPageSize());
            page.setList(all);

            model.addAttribute("customerPage", page);
        } else {

        }
        return "customer/list";
    }

    @GetMapping("/list/del/{id}")
    public void del(@PathVariable("id") String custNo, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        customerService.delete1(custNo);
        customerService.delete2(custNo);
        customerService.delete3(custNo);
        customerService.delete4(custNo);
        out.print(customerService.delete5(custNo));
    }


}
