package com.sun.dev.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * Created by sunchengfei on 2018/11/5.
 */
public class BloomFilterTest {
    public static void main(String[] args){
        // 1. 创建符合条件的布隆过滤器
        BloomFilter<String> filter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), 1000);
        //2. 将一部分数据添加进去
        for (int index = 0; index < 5000; index++) {
            filter.put("abc_test_" + index);
        }
        System.out.println("write all...");
        // 3. 测试结果
        for (int i = 5000; i < 10000; i++) {
            if (filter.mightContain("abc_test_" + i)) {
                System.out.println("yes");
            }
        }
    }
}
