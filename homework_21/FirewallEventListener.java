package com.proftelran.org.homework_21;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FirewallEventListener implements Runnable{
    private final String handlerName;
    private final List<String> logList;
    private final AtomicInteger eventCounter;

    public FirewallEventListener(String handlerName, List<String> logList, AtomicInteger eventCounter) {
        this.handlerName = handlerName;
        this.logList = logList;
        this.eventCounter = eventCounter;
    }

    @Override
    public void run() {
        while (true) {
            Event event = EventCreator.getNextEvent();
            if (event == null || eventCounter.getAndIncrement() >= EventCreator.NUM_USERS) {
                break;
            }

            String log1 = "Обработчик " + handlerName + " " + event.getEventId() + " " + event.getUserName();
            String log2 = "Обработчик " + handlerName + " " + event.getEventId() + " " + event.getUserIp();
            String log3 = "Обработчик " + handlerName + " " + event.getEventId() + " " + event.getEventDate();
            String log4 = "Обработчик " + handlerName + " " + event.getEventId() + " " + event.getEventState();

            synchronized (logList) {
                logList.add(log1);
                logList.add(log2);
                logList.add(log3);
                logList.add(log4);
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

