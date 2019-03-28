package com.magiccube.blockchain.core.repository;

import com.magiccube.blockchain.core.model.MessageEntity;

public interface MessageRepository extends BaseRepository<MessageEntity> {
    /**
     * 删除一条记录
     * @param messageId  messageId
     */
    void deleteByMessageId(String messageId);

    /**
     * 查询一个
     * @param messageId messageId
     * @return MessageEntity
     */
    MessageEntity findByMessageId(String messageId);
}
