package com.javatech.tdd.dto;

import com.javatech.tdd.enums.Gender;
import com.javatech.tdd.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 暂时没用
 * @author baiyu
 * @Desc
 * @date 2020/12/1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsUserItem {
    private Integer id;
    private String email;
    private String username;
    private String phone;
    private Gender gender;
    private Date birthday;
    private Date createTime;
    private Status status;
}
