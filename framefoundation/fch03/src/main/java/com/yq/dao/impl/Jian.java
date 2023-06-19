package com.yq.dao.impl;

import com.yq.dao.CalculatorDao;

public class Jian implements CalculatorDao {
    @Override
    public double jisuan(double number, double number1) {
        return number - number1;
    }
}
