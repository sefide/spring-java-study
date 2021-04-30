package com.heedi.spring.async;

public class AsyncApplication {

    public static void main(String[] args) {
        FixedThreadProcessor fixedThreadProcessor = new FixedThreadProcessor();
        fixedThreadProcessor.executeFixedThreadPool();


    }
}
