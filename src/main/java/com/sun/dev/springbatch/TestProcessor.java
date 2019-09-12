package com.sun.dev.springbatch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.dev.service.UserInfo;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Chengfei.Sun on 17/03/21.
 */
public class TestProcessor implements ItemProcessor<UserInfo, Message> {
    public Message process(UserInfo userInfo) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("process: " + objectMapper.writeValueAsString(userInfo));

        Message message = new Message();
        message.setContent(userInfo.getId() + " : " + userInfo.getName() + " : " + userInfo.getAge());

        return message;
    }
}
