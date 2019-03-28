package com.magiccube.blockmanager.manager;

import com.magiccube.blockmanager.repository.MemberGroupRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class MemberGroupManager {
    @Resource
    private MemberGroupRepository memberGroupRepository;
}
