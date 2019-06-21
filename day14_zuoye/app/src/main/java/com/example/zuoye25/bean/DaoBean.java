package com.example.zuoye25.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 康康 on 2019/6/21.
 */
@Entity
public class DaoBean {
    @Id(autoincrement = true)
    private Long id;

    private String url;

    private String type;

    private String desc;

    @Generated(hash = 2013836713)
    public DaoBean(Long id, String url, String type, String desc) {
        this.id = id;
        this.url = url;
        this.type = type;
        this.desc = desc;
    }

    @Generated(hash = 405743142)
    public DaoBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
