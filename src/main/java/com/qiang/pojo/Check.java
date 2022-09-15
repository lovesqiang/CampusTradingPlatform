package com.qiang.pojo;

import java.util.Date;

public class Check {
    private Integer checkId;

    private Integer checkGoodsId;

    private Integer checkAdminId;

    private Integer checkStatus;

    private Date checkTime;

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getCheckGoodsId() {
        return checkGoodsId;
    }

    public void setCheckGoodsId(Integer checkGoodsId) {
        this.checkGoodsId = checkGoodsId;
    }

    public Integer getCheckAdminId() {
        return checkAdminId;
    }

    public void setCheckAdminId(Integer checkAdminId) {
        this.checkAdminId = checkAdminId;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
}