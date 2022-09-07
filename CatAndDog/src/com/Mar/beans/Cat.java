package com.Mar.beans;

public class Cat {
    public static Cat cat = new Cat();
    private int id;//编号
    private String name;//名字
    public static final String[] kinds = {"挪威森林猫", "埃及猫", "加菲猫", "金吉拉", "孟加拉豹猫", "山东狮子猫", "布偶猫", "波斯猫", "英短"};//种类
    public static final double[] lifes = {126, 146, 200, 155, 132, 147, 100, 87, 73};//总血量
    public static final double[] powers = {35, 63, 22, 83, 45, 53, 52, 36, 73};//力量
    public static final double[] speeds = {63, 72, 35, 83, 100, 93, 66, 71, 86};//速度
    private int times;
    private String kind;
    private double life;
    private double power;
    private double speed;

    private Cat() {//私有化构造方法

    }

    private Cat(int id, String name, String kinds, double lifes, double powers, double speeds) {
        this(name, kinds, lifes, powers, speeds);
        this.id = id;
    }

    private Cat(String name, String kind, double life, double power, double speed) {
        this.name = name;
        this.kind = kind;
        this.life = life;
        this.power = power;
        this.speed = speed;
    }

    public static Cat getCat() {//静态方法访问对象
        return cat;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes() {
        this.times += 1;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getLife(String k) {//获取生命值
        this.life = 60;
        for (int i = 0; i < 9; i++) {
            if (k.equals(kinds[i]))
                this.life = lifes[i];
        }
        return this.life;
    }

    public double getLife() {
        return life;
    }

    public double getPower(String k) {//获取力量值
        this.power = 50;
        for (int i = 0; i < 9; i++) {
            if (k.equals(kinds[i]))
                this.power = powers[i];
        }
        return this.power;
    }

    public double getPower() {
        return power;
    }

    public double getSpeed(String k) {//获取速度值
        this.speed = 55;
        for (int i = 0; i < 9; i++) {
            if (k.equals(kinds[i]))
                this.speed = speeds[i];
        }
        return this.speed;
    }

    public double getSpeed() {
        return speed;
    }

    public double setLife(double c) {
        life = life - c;
        if (life <= 0) {
            life = 0;
        }
        return life;
    }

    public void atkC_D(Cat cat, Dog dog) {
        //Dog dog = Dog.getDog();
//        cat.getLife(cat.getKind());
//        dog.getLife(dog.getKind());
//
//        cat.getPower(cat.getKind());
//        dog.getPower(dog.getKind());
//
//        cat.getSpeed(cat.getKind());
//        dog.getSpeed(dog.getKind());
        System.out.println("猫的血量为：" + cat.getLife() + "，种类为：" + cat.getKind() + "，力量为：" + cat.getPower() + "，速度为：" + cat.getSpeed() + "。");
        System.out.println("狗的血量为：" + dog.getLife() + "，种类为：" + dog.getKind() + "，力量为：" + dog.getPower() + "，速度为：" + dog.getSpeed() + "。");
        if (dog.getSpeed() - cat.getSpeed() <= 10 || dog.getTimes() == 2) {
            double atk = cat.getPower() / dog.getPower();
            double rat = dog.setLife(cat.getPower() * atk * 0.5);
            System.out.println("猫" + cat.getName() + "攻击狗" + dog.getName() + "狗失去" + cat.getPower() * atk * 0.5 + "点血量");
            //dog.setLife(rat);
            dog.setTimes(0);
        } else {
            System.out.println("猫" + cat.getName() + "没有打到狗" + dog.getName());
            dog.setTimes();
        }
        System.out.println("猫剩余血量：" + cat.getLife());
        System.out.println("狗剩余血量：" + dog.getLife());
    }
}
