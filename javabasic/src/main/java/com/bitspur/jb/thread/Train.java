package com.bitspur.jb.thread;

public class Train extends Thread {
    private static final String MUTUAL = "mutual";

    public Train(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (MUTUAL){
            System.out.println(Thread.currentThread().getName() + " is going through the tunnel");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
