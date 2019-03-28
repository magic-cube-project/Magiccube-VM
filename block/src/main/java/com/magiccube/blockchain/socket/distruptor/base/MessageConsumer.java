package com.magiccube.blockchain.socket.distruptor.base;


public interface MessageConsumer {
    void receive(BaseEvent baseEvent) throws Exception;
}
