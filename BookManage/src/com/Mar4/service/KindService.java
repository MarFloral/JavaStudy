package com.Mar4.service;

import com.Mar4.beans.Kind;

import java.util.ArrayList;

public interface KindService {
    boolean decideKind(String kind);

    void addKind(Kind kind);

    void deleteKind(int n);

    void updateKind(Kind kind);

    Kind getKind(int a);

    ArrayList<Kind> getKind();
}
