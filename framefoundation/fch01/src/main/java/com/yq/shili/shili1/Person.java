package com.yq.shili.shili1;

import java.sql.SQLException;

public final class Person extends BaseClass implements java.io.Serializable {
    static final int age = 20;
    public String message;
    protected String address;
    private String name;

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    protected Person(String name, String address, String message) {
        this.name = name;
        this.address = address;
        this.message = message;
    }

    public static int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws SQLException {
        this.message = message;
        throw new SQLException();
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
