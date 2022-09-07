package com.Mar.dao;

import com.Mar.beans.G_Equipment;

import java.util.ArrayList;

public interface G_EquipmentDao {
    void addEquipment(G_Equipment equipment);

    ArrayList<G_Equipment> getEquipment();

    void delete(int n);

    void updateEquipment(G_Equipment equipment);

    G_Equipment getEquipmentById(int id);

    void updateStatus(G_Equipment equipment);

    void updateStatus(String ename);
}
