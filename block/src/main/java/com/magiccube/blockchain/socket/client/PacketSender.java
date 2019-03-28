package com.magiccube.blockchain.socket.client;

import com.magiccube.blockchain.ApplicationContextProvider;
import com.magiccube.blockchain.core.event.ClientRequestEvent;
import com.magiccube.blockchain.socket.packet.BlockPacket;
import org.springframework.stereotype.Component;
import org.tio.client.ClientGroupContext;
import org.tio.core.Aio;

import javax.annotation.Resource;

import static com.magiccube.blockchain.socket.common.Const.GROUP_NAME;

/**
 * 发送消息的工具类
 */
@Component
public class PacketSender {
    @Resource
    private ClientGroupContext clientGroupContext;

    public void sendGroup(BlockPacket blockPacket) {
        //对外发出client请求事件
        ApplicationContextProvider.publishEvent(new ClientRequestEvent(blockPacket));
        //发送到一个group
        Aio.sendToGroup(clientGroupContext, GROUP_NAME, blockPacket);
    }

}
