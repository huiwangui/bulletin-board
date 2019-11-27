package com.hxyc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName ProjectVO
 * @Description TODO
 * @Author admin
 * @Date 2019/11/19 10:24
 **/
public class ProjectVO implements Serializable{

    /**
     * 招标任务编号
     */
    private String tenderCode;
    /**
     * 公司简称
     */
    private String orgAbbreviation;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 开标时间
     */
    private Date openTenderTime;

    /**
     * 星期几
     */
    private String dayOfWeek;

    /**
     * 招标任务编号
     */
    private String nextTenderCode;
    /**
     * 公司简称
     */
    private String nextOrgAbbreviation;
    /**
     * 项目名称
     */
    private String nextProjectName;
    /**
     * 开标时间
     */
    private Date nextOpenTenderTime;

    /**
     * 星期几
     */
    private String nextDayOfWeek;


    /**
     * 标志位：1 本周 2下周
     */
    private String weekFlag;



    /**
     * 本周一时间
     */
    private Date beginOfWeek;

    /**
     * 本周末时间
     */
    private Date endOfWeek;
    /**
     * 下周一时间
     */
    private Date beginOfNextWeek;

    /**
     * 下周末时间
     */
    private Date endOfNextWeek;
    /**
     * 采购模式，3=集采；1=自采
     */
    private String purchaseMode;
    /**
     * 本周标题
     */
    private String weekTitle;
    /**
     * 下周标题
     */
    private String nextWeekTitle;




    public String getOrgAbbreviation() {
        return orgAbbreviation;
    }

    public void setOrgAbbreviation(String orgAbbreviation) {
        this.orgAbbreviation = orgAbbreviation;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getOpenTenderTime() {
        return openTenderTime;
    }

    public void setOpenTenderTime(Date openTenderTime) {
        this.openTenderTime = openTenderTime;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Date getBeginOfWeek() {
        return beginOfWeek;
    }

    public void setBeginOfWeek(Date beginOfWeek) {
        this.beginOfWeek = beginOfWeek;
    }

    public Date getEndOfWeek() {
        return endOfWeek;
    }

    public void setEndOfWeek(Date endOfWeek) {
        this.endOfWeek = endOfWeek;
    }

    public Date getBeginOfNextWeek() {
        return beginOfNextWeek;
    }

    public void setBeginOfNextWeek(Date beginOfNextWeek) {
        this.beginOfNextWeek = beginOfNextWeek;
    }

    public Date getEndOfNextWeek() {
        return endOfNextWeek;
    }

    public void setEndOfNextWeek(Date endOfNextWeek) {
        this.endOfNextWeek = endOfNextWeek;
    }

    public String getTenderCode() {
        return tenderCode;
    }

    public void setTenderCode(String tenderCode) {
        this.tenderCode = tenderCode;
    }

    public String getWeekFlag() {
        return weekFlag;
    }

    public void setWeekFlag(String weekFlag) {
        this.weekFlag = weekFlag;
    }

    public String getPurchaseMode() {
        return purchaseMode;
    }

    public void setPurchaseMode(String purchaseMode) {
        this.purchaseMode = purchaseMode;
    }

    public String getNextTenderCode() {
        return nextTenderCode;
    }

    public void setNextTenderCode(String nextTenderCode) {
        this.nextTenderCode = nextTenderCode;
    }

    public String getNextOrgAbbreviation() {
        return nextOrgAbbreviation;
    }

    public void setNextOrgAbbreviation(String nextOrgAbbreviation) {
        this.nextOrgAbbreviation = nextOrgAbbreviation;
    }

    public String getNextProjectName() {
        return nextProjectName;
    }

    public void setNextProjectName(String nextProjectName) {
        this.nextProjectName = nextProjectName;
    }

    public String getNextDayOfWeek() {
        return nextDayOfWeek;
    }

    public void setNextDayOfWeek(String nextDayOfWeek) {
        this.nextDayOfWeek = nextDayOfWeek;
    }

    public Date getNextOpenTenderTime() {
        return nextOpenTenderTime;
    }

    public void setNextOpenTenderTime(Date nextOpenTenderTime) {
        this.nextOpenTenderTime = nextOpenTenderTime;
    }

    public String getWeekTitle() {
        return weekTitle;
    }

    public void setWeekTitle(String weekTitle) {
        this.weekTitle = weekTitle;
    }

    public String getNextWeekTitle() {
        return nextWeekTitle;
    }

    public void setNextWeekTitle(String nextWeekTitle) {
        this.nextWeekTitle = nextWeekTitle;
    }
}
