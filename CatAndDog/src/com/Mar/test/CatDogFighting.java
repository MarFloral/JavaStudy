package com.Mar.test;

import com.Mar.beans.Cat;
import com.Mar.beans.Dog;

import java.util.Scanner;

public class CatDogFighting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dog dog = Dog.getDog();
        Cat cat = Cat.getCat();
        System.out.print("输入猫的名字：");
        String cn = scanner.next();
        cat.setName(cn);
        System.out.print("输入猫的种类：");
        String ck = scanner.next();
        cat.setKind(ck);
        System.out.print("输入狗的名字：");
        String dn = scanner.next();
        dog.setName(dn);
        System.out.print("输入狗的种类：");
        String dk = scanner.next();
        dog.setKind(dk);

        cat.getLife(cat.getKind());
        dog.getLife(dog.getKind());

        cat.getPower(cat.getKind());
        dog.getPower(dog.getKind());

        cat.getSpeed(cat.getKind());
        dog.getSpeed(dog.getKind());
        System.out.println("猫的血量为：" + cat.getLife() + "，种类为：" + cat.getKind() + "，力量为：" + cat.getPower() + "，速度为：" + cat.getSpeed() + "。");
        System.out.println("狗的血量为：" + dog.getLife() + "，种类为：" + dog.getKind() + "，力量为：" + dog.getPower() + "，速度为：" + dog.getSpeed() + "。");
        int i = 1;
        while (cat.getLife() != 0 && dog.getLife() != 0) {
            System.out.println("第" + i + "回合");
            i++;
            if (cat.getSpeed() >= dog.getSpeed()) {
                cat.atkC_D(cat, dog);
                if (cat.getLife() == 0) {
                    System.out.println("狗" + dog.getName() + "打败了猫" + cat.getName() + "！");
                    break;
                } else if (dog.getLife() == 0) {
                    System.out.println("猫" + cat.getName() + "打败了狗" + dog.getName() + "！");
                    break;
                }
                System.out.println();
                dog.atkD_C(dog, cat);
            } else {
                dog.atkD_C(dog, cat);
                if (cat.getLife() == 0) {
                    System.out.println("狗" + dog.getName() + "打败了猫" + cat.getName() + "！");
                    break;
                } else if (dog.getLife() == 0) {
                    System.out.println("猫" + cat.getName() + "打败了狗" + dog.getName() + "！");
                    break;
                }
                System.out.println();
                cat.atkC_D(cat, dog);
            }
            System.out.println();
        }
    }
}
