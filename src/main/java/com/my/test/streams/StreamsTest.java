//package com.my.test.streams;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
///**
// * Created by sunchengfei on 2017/12/21.
// */
//public class StreamsTest {
//    public static void main(String[] args) {
//        StudentScore score1 = new StudentScore("A", "Mohamed", 87);
//        StudentScore score2 = new StudentScore("B", "Doaa", 89);
//        StudentScore score3 = new StudentScore("C", "Malik", 98);
//        StudentScore score4 = new StudentScore("A", "Betty", 72);
//        StudentScore score5 = new StudentScore("A", "Jack", 94);
//
//        List<StudentScore> scoreList = Arrays.asList(score1, score2, score3, score4, score5);
//
//
//        List<StudentScore> result = scoreList.stream().collect(Collectors.toList());
//        System.out.println(result);
//
//        Set<StudentScore> result2 = scoreList.stream().collect(Collectors.toSet());
//        System.out.println(result2);
//    }
//}
