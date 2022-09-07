package com.Mar.beans;

public class G_Equipment {
    private int id;//编号
    private String ename;//器材名
    private String status;//器材状态（使用，未使用）

    public G_Equipment() {
    }

    public G_Equipment(int id, String ename, String status) {
        this.id = id;
        this.ename = ename;
        this.status = status;
    }

    public G_Equipment(String ename, String status) {
        this.ename = ename;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "G_Equipment{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
