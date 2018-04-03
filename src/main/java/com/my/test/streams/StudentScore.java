package com.my.test.streams;

import lombok.Data;

/**
 * Created by sunchengfei on 2017/12/21.
 */
@Data
public class StudentScore {
    //课程
    private String course;
    //姓名
    private String name;
    //成绩
    private Integer score;

    public StudentScore() {

    }

    public StudentScore(String course, String name, Integer score) {
        this.course = course;
        this.name = name;
        this.score = score;
    }
}