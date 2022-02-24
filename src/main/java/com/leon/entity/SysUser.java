package com.leon.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SysUser implements Serializable {

    private static final long serialVersionUID = 7272775729569778693L;

    private Integer id;

    private String username;

    private String usercode;

    private String password;

    private Integer sex;

    private Date createdate;

    private Integer isvalid;

    private Integer isstop;

    private Integer organid;
}