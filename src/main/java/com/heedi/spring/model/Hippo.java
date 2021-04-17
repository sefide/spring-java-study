package com.heedi.spring.model;

public class Hippo {

    private String name;
    private String color;
    private int power;
    private volatile int volatilePower;

    public Hippo(String name, String color) {
        this.name = name;
        this.color = color;
        this.power = 0;
        this.volatilePower = 0;
    }

    public void pushThePower(String caller) {
        this.power++;
        System.out.println(caller + " - power Up : " + this.power);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void pushTheVolatilePower(String caller) {
        // Non-atomic operation on volatile field
        this.volatilePower++;
        System.out.println(caller + " - volatilePower Up: " + this.volatilePower);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public int getPower() {
        return this.power;
    }

    public int getVolatilePower() {
        return volatilePower;
    }
}
