package com.yq.crm.vo;

public interface UserInfo {
    Long getUsrId();

    String getUsrName();

    String getUsrPassword();

    Long getUsrRoleId();

    Integer getUsrFlag();

    String getUsrRoleName();

    Long getCurrent();

    Long getPageSize();
}
