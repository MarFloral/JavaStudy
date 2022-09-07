package com.Mar.beans;

public class Kind {
    private String[] catKind = {"挪威森林猫","埃及猫","加菲猫","金吉拉","孟加拉豹猫","山东狮子猫","布偶猫","波斯猫","英短"};
    private double[] catLife = {63,73,100,75,66,73,50,43,35};
    private double[] catPower = {35,63,22,83,45,53,52,36,73};
    private double[] catSpeed = {63,72,35,83,100,93,66,71,86};
    private String[] dogKind = {"哈士奇","柴犬","藏獒","苏牧犬","猎狐犬","狼青犬","萨摩耶","金毛","牙水犬"};
    private double[] dogLife = {57,63,100,78,65,82,50,43,32};
    private double[] dogPower = {63,35,100,75,63,68,77,55,23};
    private double[] dogSpeed = {80,76,50,63,79,72,46,50,43};

    public double life(String kind,String c){
            if(c == "cat") {
                for (int i = 0; i < 9; i++) {
                    if (kind == catKind[i])
                    return catLife[i];
                }
            }else if (c == "dog"){
                for (int i = 0; i < 9; i++) {
                    if (kind == dogKind[i])
                        return dogLife[i];
                }
            }else {
                System.out.println("请输入“猫”或“狗”！");
            }
            return 0;
        }
    public double power(String kind,String c){
        if(c == "cat") {
            for (int i = 0; i < 9; i++) {
                if (kind == catKind[i])
                    return catPower[i];
            }
        }else if (c == "dog"){
            for (int i = 0; i < 9; i++) {
                if (kind == dogKind[i])
                    return dogPower[i];
            }
        }else {
            System.out.println("请输入“猫”或“狗”！");
        }
        return 0;
    }
    public double speed(String kind,String c){
        if(c == "cat") {
            for (int i = 0; i < 9; i++) {
                if (kind == catKind[i])
                    return catSpeed[i];
            }
        }else if (c == "dog"){
            for (int i = 0; i < 9; i++) {
                if (kind == dogKind[i])
                    return dogSpeed[i];
            }
        }else {
            System.out.println("请输入“猫”或“狗”！");
        }
        return 0;
    }
}
