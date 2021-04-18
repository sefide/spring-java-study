package com.heedi.spring.concurrent;

import com.heedi.spring.model.Hippo;

public class AtomicMain {

    private static Hippo hippo;

    public static void main(String[] args) {
        hippo = new Hippo("tomi", "orange");

//        atomic_power_one_write_thread();
        atomic_power_two_write_thread();
    }

    private static void atomic_power_one_write_thread() {
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 - " + hippo.getAtomicPower());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                hippo.pushTheAtomicPower("thread1");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread3 - " + hippo.getAtomicPower());
            }
        }).start();
    }

    // 무조건 100으로 마무리
    public static void atomic_power_two_write_thread() {
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                hippo.pushTheAtomicPower("thread1");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(678);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 - " + hippo.getAtomicPower());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                hippo.pushTheAtomicPower("thread3");
            }
        }).start();

    }

}
