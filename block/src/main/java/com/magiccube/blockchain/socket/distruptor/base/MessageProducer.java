package com.magiccube.blockchain.socket.distruptor.base;


public interface MessageProducer {
    void publish(BaseEvent baseEvent);
}
