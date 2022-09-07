package com.Mar4.beans;

import java.util.Date;

public class Records {
    private int id;
    private String uname;//用户名
    private String bname;//书编号
    private Date rtime;//借书时间
    private Date btime;//还书时间

    public Records() {
    }

    public Records(String uname, String bname, Date rtime, Date btime) {
        this.uname = uname;
        this.bname = bname;
        this.rtime = rtime;
        this.btime = btime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }



    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public Date getRtime() {
        return rtime;
    }

    public Date getBtime() {
        return btime;
    }

    public void setBtime(Date btime) {
        this.btime = btime;
    }

    @Override
    public String toString() {
        return "Records{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", bname=" + bname +
                ", rtime='" + rtime + '\'' +
                ", btime='" + btime + '\'' +
                '}';
    }
}
