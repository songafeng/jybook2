package com.fo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jdd on 2018/6/27.
 */
@Entity
@Table(name = "jy_book")
public class book {
    private Integer id;
    private String name;
    private String profile;
    private Integer type;
    private String remark;
    private Integer chapternum;
    private String url;
    private Integer size;
    private Integer sort;
    private Date create_time;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "s_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "s_profile")
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Column(name = "n_type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "s_remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "n_chapternum")
    public Integer getChapternum() {
        return chapternum;
    }

    public void setChapternum(Integer chapternum) {
        this.chapternum = chapternum;
    }

    @Column(name = "s_url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "n_size")
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Column(name = "n_sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Column(name = "d_create_time")
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
