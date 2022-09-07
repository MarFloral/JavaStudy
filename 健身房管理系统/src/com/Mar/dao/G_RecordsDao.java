package com.Mar.dao;

import com.Mar.beans.G_Equipment;
import com.Mar.beans.G_Records;
import com.Mar.beans.G_User;

import java.util.ArrayList;

public interface G_RecordsDao {
    G_Records getRecord(G_User user);

    void addRecords(G_User user, G_Equipment equipment);

    void updateBtime(G_User user);

    ArrayList<G_Records> select(G_User user);
}
