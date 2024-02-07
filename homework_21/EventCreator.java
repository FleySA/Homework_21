package com.proftelran.org.homework_21;

import java.time.LocalDate;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventCreator {
    static final int NUM_USERS = 10;
    static final BlockingQueue<Event> events = new LinkedBlockingQueue<>();

    static {

        for (int i = 1; i <= NUM_USERS; i++) {
            events.add(new Event(i, "User" + i, "192.168.0." + i, LocalDate.now(), getRandomEventState()));
        }
    }

    public static Event getNextEvent() {
        return events.poll();
    }

    private static EventState getRandomEventState() {
        // Генерация случайного состояния события
        EventState[] states = EventState.values();
        int index = (int) (Math.random() * states.length);
        return states[index];
    }
}