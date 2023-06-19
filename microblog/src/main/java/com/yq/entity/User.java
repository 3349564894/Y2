package com.yq.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 */
public class User implements Serializable, Cloneable {
    private static final long serialVersionUID = -6890038231098895941L;
    private int id;
    private String userId;//账户
    private String password; //密码
    private String nickname; //昵称
    private String image;  //头像
    private String sex; //性别
    private String name;//真实姓名
    private Date birthday; //用户生日
    private String address;//地址
    private String email;//邮箱
    private String mysite;//个人站点
    private String sign;//签名
    private Date createtime;//创建时间
    private String ispublic;//是否公开
    private String pagebg;//自定义背景
    private boolean isFollowed;

    public boolean isFollowed() {
        return isFollowed;
    }

    public void setFollowed(boolean followed) {
        isFollowed = followed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMysite() {
        return mysite;
    }

    public void setMysite(String mysite) {
        this.mysite = mysite;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getIspublic() {
        return ispublic;
    }

    public void setIspublic(String ispublic) {
        this.ispublic = ispublic;
    }

    public String getPagebg() {
        return pagebg;
    }

    public void setPagebg(String pagebg) {
        this.pagebg = pagebg;
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
