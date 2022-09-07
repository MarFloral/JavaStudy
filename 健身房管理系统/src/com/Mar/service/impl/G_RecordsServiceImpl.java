package com.Mar.service.impl;

import com.Mar.beans.G_Equipment;
import com.Mar.beans.G_Records;
import com.Mar.beans.G_User;
import com.Mar.dao.G_EquipmentDao;
import com.Mar.dao.G_RecordsDao;
import com.Mar.dao.impl.G_EquipmentDaoImpl;
import com.Mar.dao.impl.G_RecordsDaoImpl;
import com.Mar.service.G_RecordsService;

import java.util.ArrayList;

public class G_RecordsServiceImpl implements G_RecordsService {
    G_RecordsDao recordsDao = new G_RecordsDaoImpl();
    G_EquipmentDao equipmentDao = new G_EquipmentDaoImpl();
    @Override
    public G_Records getRecord(G_User user) {
        return recordsDao.getRecord(user);
    }

    @Override
    public void addRecords(G_User user, G_Equipment equipment) {//添加记录，修改状态
        recordsDao.addRecords(user,equipment);
        equipmentDao.updateStatus(equipment);
    }

    @Override
    public void updateBtime(G_User user) {
        G_Records record = recordsDao.getRecord(user);
        if (record != null) {
            String ename = record.getEname();
            recordsDao.updateBtime(user);
            equipmentDao.updateStatus(ename);
        }else {
            System.out.println("没有借用过");
        }
    }

    @Override
    public ArrayList<G_Records> select(G_User user) {
        return recordsDao.select(user);
    }
}
