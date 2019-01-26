package com.synco.kava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wangshuai
 * @Date:2019/1/24
 */

@Data
@Entity
@Table(name = "o_member")
public class Member extends BaseEntity{

    /** 会员名称*/
    private String nickName;

    /** 会员手机号码*/
    private String phone;

    /** 会员图像*/
    private String headImg;

    /** 会员邮箱*/
    private String email;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(name = "o_member_course", joinColumns = @JoinColumn(name = "memberId", referencedColumnName = "id"), inverseJoinColumns =
    @JoinColumn(name = "courseId"))
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();
}

