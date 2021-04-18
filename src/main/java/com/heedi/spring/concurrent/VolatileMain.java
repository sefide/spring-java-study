package com.heedi.spring.concurrent;

import com.heedi.spring.model.Hippo;

public class VolatileMain {

    private static Hippo hippo;

    public static void main(String[] args) {
        hippo = new Hippo("po", "deepGray");

        power_one_write_thread();
//        volatile_power_one_write_thread();
//        volatile_power_two_write_thread();
    }

    private static void power_one_write_thread() {

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                hippo.pushThePower("thread1");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 - " + hippo.getPower());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread3 - " + hippo.getPower());
            }
        }).start();
    }

    private static void volatile_power_one_write_thread() {

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                hippo.pushTheVolatilePower("thread1");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 - " + hippo.getVolatilePower());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread3 - " + hippo.getVolatilePower());
            }
        }).start();
    }

    private static void volatile_power_two_write_thread() {

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                hippo.pushTheVolatilePower("thread1");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 - " + hippo.getVolatilePower());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                hippo.pushTheVolatilePower("thread3");
            }
        }).start();

    }
}
