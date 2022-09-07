package com.Mar.beans;

import java.util.Date;

public class G_Records {
    private int id;
    private String uname;//用户名
    private String ename;//书编号
    private Date rtime;//借书时间
    private Date btime;//还书时间

    public G_Records() {
    }

    public G_Records(String uname, String ename, Date rtime, Date btime) {
        this.uname = uname;
        this.ename = ename;
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

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
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
                ", bname=" + ename +
                ", rtime='" + rtime + '\'' +
                ", btime='" + btime + '\'' +
                '}';
    }
}
