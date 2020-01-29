package com.bitspur.jb.thread;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnable is executing");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
