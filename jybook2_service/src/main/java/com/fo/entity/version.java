package com.fo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jdd on 2018/6/28.
 */
@Entity
@Table(name = "jy_version")
public class version {
    private Integer id;
    private Integer client_type;
    private Integer version;
    private Date create_time;
    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "n_client_type")
    public Integer getClient_type() {
        return client_type;
    }

    public void setClient_type(Integer client_type) {
        this.client_type = client_type;
    }

    @Column(name = "n_version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Column(name = "d_create_time")
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Column(name = "n_status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
