package com.yq.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestEntity {
    private String specialCharacter1;
    private String specialCharacter2;
    private User user;
    private User innerBean;
    private List<String> list;
    private String[] array;
    private Set<String> set;
    private Map<String, String> map;
    private Properties properties;
    private String emptyValue;
    private String nullValue;

    public String getSpecialCharacter1() {
        return specialCharacter1;
    }

    public void setSpecialCharacter1(String specialCharacter1) {
        this.specialCharacter1 = specialCharacter1;
    }

    public String getSpecialCharacter2() {
        return specialCharacter2;
    }

    public void setSpecialCharacter2(String specialCharacter2) {
        this.specialCharacter2 = specialCharacter2;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getInnerBean() {
        return innerBean;
    }

    public void setInnerBean(User innerBean) {
        this.innerBean = innerBean;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getEmptyValue() {
        return emptyValue;
    }

    public void setEmptyValue(String emptyValue) {
        this.emptyValue = emptyValue;
    }

    public String getNullValue() {
        return nullValue;
    }

    public void setNullValue(String nullValue) {
        this.nullValue = nullValue;
    }
}
