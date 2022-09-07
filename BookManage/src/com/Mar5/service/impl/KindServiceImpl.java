package com.Mar5.service.impl;

import com.Mar5.beans.Kind;
import com.Mar5.dao.KindDao;
import com.Mar5.dao.impl.KindDaoImpl;
import com.Mar5.service.KindService;

import java.util.ArrayList;

public class KindServiceImpl implements KindService {
    KindDao kindDao = new KindDaoImpl();

    @Override
    public boolean decideKind(String kind) {//判断种类是否存在
        return kindDao.decideKind(kind);
    }

    @Override
    public void addKind(Kind kind) {
        kindDao.addKind(kind);
    }

    @Override
    public void deleteKind(int n) {
        kindDao.deleteKind(n);
    }

    @Override
    public void updateKind(Kind kind) {
        kindDao.updateKind(kind);
    }

    @Override
    public Kind getKind(int a) {
        return kindDao.getKind(a);
    }

    @Override
    public ArrayList<Kind> getKind() {
        return kindDao.getKind();
    }
}
