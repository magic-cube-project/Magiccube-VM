package com.magiccube.blockmanager.controller;

import com.magiccube.blockmanager.bean.MemberData;
import com.magiccube.blockmanager.manager.MemberManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberManager memberManager;

    //    http://127.0.0.1:8888/member?name=single&appId=wolf&ip=192.168.1.75
    ///**
    // * 校验某服务是否合法，结果将决定对方能不能启动
    // * @param name 公司名
    // * @param appId 节点id
    // * @param ip 节点ip
    // * @return 合法与否的标志
    //  {"code":0,"message":null,"members":[{"id":1,"createTime":"2018-03-19T06:37:26.000+0000","updateTime":"2018-03-19T06:37:28.000+0000","appId":"wolf","name":"single","ip":"192.168.1.75","groupId":"1"},{"id":2,"createTime":"2018-03-19T06:37:26.000+0000","updateTime":"2018-03-19T06:37:28.000+0000","appId":"mingyi","name":"mingyi","ip":"192.168.1.121","groupId":"1"}]}
    // */
    //@GetMapping
    //public Integer checkId(String name, String appId, String ip) {
    //    return memberManager.checkIdAndIp(name, appId, ip);
    //}

    /**
     * 获取所有的节点信息
     * @param name name
     * @param appId appId
     * @param ip  ip
     * @return ip
     */
    @GetMapping
    public MemberData member(String name, String appId, String ip) {
        return memberManager.memberData(name, appId, ip);
    }
}
