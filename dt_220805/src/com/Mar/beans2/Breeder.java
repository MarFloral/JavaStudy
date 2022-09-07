package com.Mar.beans2;

public class Breeder {
    public void feed(Animal animal){
        animal.drink();
        animal.eat();
        if (animal instanceof Dog){
            ((Dog) animal).swim();
        }else if (animal instanceof Frog) {
            ((Frog) animal).swim();
        }
    }
}
