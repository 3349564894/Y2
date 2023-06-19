package com.yq.crm.entity;

import lombok.Data;

@Data
public class Product {
    private Integer prodId;
    private String prodName;
    private String prodType;
    private String prodBatch;
    private String prod_unit;
    private String prod_price;
    private String prod_memo;

    public Product() {
    }

    public Product(Integer prodId, String prodName, String prodType, String prodBatch, String prod_unit, String prod_price, String prod_memo) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodType = prodType;
        this.prodBatch = prodBatch;
        this.prod_unit = prod_unit;
        this.prod_price = prod_price;
        this.prod_memo = prod_memo;
    }
}
