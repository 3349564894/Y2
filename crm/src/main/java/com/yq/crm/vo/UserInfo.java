package com.yq.crm.vo;

import lombok.Data;

@Data
public class UserInfo {
    private Long usrId;
    private String usrName;
    private Long usrRoleId;
    private Long current = 1L;
}
