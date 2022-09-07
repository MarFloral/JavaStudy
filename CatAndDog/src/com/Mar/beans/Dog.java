package com.Mar.beans;
/* 1、私有化
 * 2、获取名字
 * 3、根据种类获取生命值life,访问生命值
 * 4、获取力量值power，访问力量值
 * 5、获取速度值speed，访问速度值
 * 6、扣血方法
 * 7、攻击————对猫：
 * {    判断速度差，猫 - 狗 > 10 猫闪避成功，如果猫连续闪避两次后将取消闪避
 *      攻击按力量比
 *      攻击倍率为0.8
 * }
 * */

public class Dog {
    public static Dog dog = new Dog();
    private int id;//编号
    private String name;//名字
    public static final String[] kinds = {"哈士奇", "柴犬", "藏獒", "苏牧犬", "猎狐犬", "狼青犬", "萨摩耶", "金毛", "牙水犬"};//种类
    public static final double[] lifes = {117, 126, 200, 156, 125, 161, 100, 86, 64};//总血量
    public static final double[] powers = {63, 35, 100, 75, 63, 68, 77, 55, 23};//力量
    public static final double[] speeds = {80, 76, 50, 63, 79, 72, 46, 50, 43};//速度
    private int times;//闪避次数最多连续闪避两次
    private String kind;
    private double life;//生命值
    private double power;//力量值
    private double speed;//速度值

    private Dog() {//私有化构造方法

    }

    private Dog(int id, String name, String kind, double life, double power, double speed) {
        this(name, kind, life, power, speed);
        this.id = id;
    }

    private Dog(String name, String kind, double life, double power, double speed) {
        this.name = name;
        this.kind = kind;
        this.life = life;
        this.power = power;
        this.speed = speed;
    }

    public static Dog getDog() {//静态调动方法
        return dog;
    }

    public void setTimes() {
        this.times += 1;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void setName(String name) {//获取名字
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

    public void atkD_C(Dog dog, Cat cat) {
        //Cat cat = Cat.getCat();
//        cat.getLife(cat.getKind());
//        dog.getLife(dog.getKind());
//        cat.getPower(cat.getKind());
//        dog.getPower(dog.getKind());
//        cat.getSpeed(cat.getKind());
//        dog.getSpeed(dog.getKind());
        System.out.println("猫的血量为：" + cat.getLife() + "，种类为：" + cat.getKind() + "，力量为：" + cat.getPower() + "，速度为：" + cat.getSpeed() + "。");
        System.out.println("狗的血量为：" + dog.getLife() + "，种类为：" + dog.getKind() + "，力量为：" + dog.getPower() + "，速度为：" + dog.getSpeed() + "。");
        if (cat.getSpeed() - dog.getSpeed() <= 10 || cat.getTimes() == 2) {
            double atk = dog.getPower() / cat.getPower();
            cat.setLife(dog.getPower() * atk * 0.5);
            System.out.println("狗" + dog.getName() + "攻击猫" + cat.getName() + "猫失去" + dog.getPower() * atk * 0.5 + "点血量");
            //cat.setLife(rat);
            cat.setTimes(0);
        } else {
            System.out.println("狗" + dog.getName() + "没有打到猫" + cat.getName());
            cat.setTimes();
        }
        System.out.println("猫剩余血量：" + cat.getLife());
        System.out.println("狗剩余血量：" + dog.getLife());
    }
}
