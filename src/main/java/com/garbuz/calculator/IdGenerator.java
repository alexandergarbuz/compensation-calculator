package com.garbuz.calculator;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static final AtomicLong counter = new AtomicLong();

    public static final Long generateUniqueId() {
        return new Long(counter.incrementAndGet());
    }
}
