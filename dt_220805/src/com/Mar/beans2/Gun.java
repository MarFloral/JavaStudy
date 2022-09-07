package com.Mar.beans2;

import java.util.Random;

public class Gun {
    public void gun(){
        Bird[] birds = new Bird[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int r = random.nextInt(2);
            boolean b = random.nextBoolean();
            if (b) {
                new FlyBird().run();
            }else {
                new RunBird().run();
            }
            //birds[i].run();
        }
//        for (int i = 0; i <20 ; i++) {
//
//        }
    }
}
