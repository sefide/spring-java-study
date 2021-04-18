package com.heedi.spring.concurrent;

import com.heedi.spring.model.Hippo;

import java.util.Arrays;

public class SynchronizedMain {

    private static Hippo sync = new Hippo("sync", "yellow");

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));

//        synchronized_power_one_write_thread();
        synchronized_power_two_write_thread();
    }

    private static void synchronized_power_one_write_thread() {
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 - " + sync.getPower());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                sync.pushSynchronizedPower("thread1");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread3 - " + sync.getPower());
            }
        }).start();
    }

    private static void synchronized_power_two_write_thread() {
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                sync.pushSynchronizedPower("thread1");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread3 - " + sync.getPower());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                sync.pushSynchronizedPower("thread2");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread4 - " + sync.getPower());
            }
        }).start();
    }

}
