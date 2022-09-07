package com.Mar.service;

import com.Mar.beans.G_Equipment;

import java.util.ArrayList;

public interface G_EquipmentService {
    void addEquipment(G_Equipment equipment);

    void delete(int n);

    void updateEquipment(G_Equipment equipment);

    ArrayList<G_Equipment> getEquipment();

    G_Equipment getEquipmentById(int id);

}
