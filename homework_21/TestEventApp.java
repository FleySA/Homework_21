package com.proftelran.org.homework_21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestEventApp {

    public static void main(String[] args) {
        List<String> logList = new ArrayList<>();
        AtomicInteger eventCounter = new AtomicInteger(0);

        Thread listener1 = new Thread(new FirewallEventListener("PrimaryHandler", logList, eventCounter));
        Thread listener2 = new Thread(new FirewallEventListener("SecondaryHandler", logList, eventCounter));
        Thread listener3 = new Thread(new FirewallEventListener("TertiaryHandler", logList, eventCounter));
        Thread listener4 = new Thread(new FirewallEventListener("QuaternaryHandler", logList, eventCounter));

        listener1.start();
        listener2.start();
        listener3.start();
        listener4.start();

        try {
            listener1.join();
            listener2.join();
            listener3.join();
            listener4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        logList.forEach(System.out::println);
    }
}
