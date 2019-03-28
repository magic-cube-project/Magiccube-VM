package com.magiccube.blockchain.socket.distruptor.base;

import com.lmax.disruptor.EventFactory;


public class BaseEventFactory implements EventFactory<BaseEvent> {
    @Override
    public BaseEvent newInstance() {
        return new BaseEvent();
    }

}
