package com.magiccube.blockchain.core.event;

import org.springframework.context.ApplicationEvent;

/**
 * 同步block到sqlite事件
 */
public class DbSyncEvent extends ApplicationEvent {
    public DbSyncEvent(Object source) {
        super(source);
    }
}
