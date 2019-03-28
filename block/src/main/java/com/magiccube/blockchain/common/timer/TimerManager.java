package com.magiccube.blockchain.common.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class TimerManager {

    private volatile static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

    public static void schedule(Supplier<?> action, long delay) {
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                action.get();
            }
        }, delay, TimeUnit.MILLISECONDS);
    }

    public static void scheduleAtFixedRate(Supplier<?> action, long initialDelay, long period) {
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                action.get();
            }
        }, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    public static void scheduleWithFixedDelay(Supplier<?> action, long initialDelay, long period) {
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                action.get();
            }
        }, initialDelay, period, TimeUnit.MILLISECONDS);
    }


}
