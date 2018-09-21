package com.my.test.databuild;

import com.my.test.springbean.SpringContextUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by sunchengfei on 2018/4/17.
 */
public class DataBuilderManager {
    private ExecutorService executor = Executors.newFixedThreadPool(3);

    private Map<String, Future<Object>> result = new HashMap<String, Future<Object>>();

    public void execute(List<String> modules){
        for(String item : modules){
            result.put(item, executor.submit(new Handler(item)));
        }
    }

    private class Handler implements Callable<Object>{
        private String module;

        public Handler(String name) {
            this.module = name;
        }

        @Override
        public Object call() throws Exception {
            return ((DataHandler) SpringContextUtil.getBean(module)).buiness(null);
        }
    }

    public Map<String, Future<Object>> getResult() {
        return result;
    }
}
