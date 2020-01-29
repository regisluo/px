package com.bitspur.jb.thread;

public class TrainTunnelDemo {
    public static void main(String[] args) {
        Train train1 = new Train("train-1");
        Train train2 = new Train("train-2");
        Train train3 = new Train("train-3");
        Train train4 = new Train("train-4");
        Train train5 = new Train("train-5");

        train1.start();
        train2.start();
        train3.start();
        train4.start();
        train5.start();

    }
}
