package com.Mar5.dao;

import com.Mar5.beans.Kind;

import java.util.ArrayList;

public interface KindDao {
    //增加方法
    void addKind(Kind bkind);
    //删除方法
    void deleteKind(int bid);
    //修改方法
    void updateKind(Kind bkind);
    //查询方法
    ArrayList<Kind> getKind();
    //依据类型查询
    Kind getKind(int bid);

    boolean decideKind(String kind);
}
