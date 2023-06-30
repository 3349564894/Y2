package com.yq.crm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("product")
public class Product {
    private Integer prodId;
    private String prodName;
    private String prodType;
    private String prodBatch;
    private String prod_unit;
    private String prod_price;
    private String prod_memo;
}
