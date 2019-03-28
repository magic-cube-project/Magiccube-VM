package com.magiccube.blockchain.core.manager;

import com.magiccube.blockchain.core.model.MessageEntity;
import com.magiccube.blockchain.core.repository.MessageRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageManager {
    @Resource
    private MessageRepository messageRepository;

    public List<MessageEntity> findAll() {
        return messageRepository.findAll();
    }

    public List<String> findAllContent() {
        return findAll().stream().map(MessageEntity::getContent).collect(Collectors.toList());
    }

    public MessageEntity findById(String id) {
        return messageRepository.findByMessageId(id);
    }
}
