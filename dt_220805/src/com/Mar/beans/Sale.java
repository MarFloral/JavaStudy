package com.Mar.beans;

public class Sale {

    public void sale(Goods goods){
        System.out.println("出售了" + goods.getName() + "，颜色是：" + goods.getColor() + "，价格为：" + goods.getPrice());
    }

}
