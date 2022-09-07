package com.Mar.service.impl;

import com.Mar.beans.G_Equipment;
import com.Mar.dao.G_EquipmentDao;
import com.Mar.dao.impl.G_EquipmentDaoImpl;
import com.Mar.service.G_EquipmentService;

import java.util.ArrayList;

public class G_EquipmentServiceImpl implements G_EquipmentService {
    G_EquipmentDao equipmentDao = new G_EquipmentDaoImpl();
    @Override
    public void addEquipment(G_Equipment equipment) {
        equipmentDao.addEquipment(equipment);
    }

    @Override
    public ArrayList<G_Equipment> getEquipment() {
        return equipmentDao.getEquipment();
    }

    @Override
    public G_Equipment getEquipmentById(int id) {
        return equipmentDao.getEquipmentById(id);
    }



    @Override
    public void delete(int n) {
        equipmentDao.delete(n);
    }

    @Override
    public void updateEquipment(G_Equipment equipment) {
        equipmentDao.updateEquipment(equipment);
    }
}
