package com.sun.dev.springbatch;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by Chengfei.Sun on 17/03/22.
 */
public class TestWriter implements ItemWriter<Message> {
    public void write(List<? extends Message> list) throws Exception {
        for(Message item : list){
            System.out.println("writer: " + item.getContent());
        }
    }
}
