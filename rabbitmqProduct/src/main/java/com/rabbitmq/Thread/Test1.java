package com.rabbitmq.Thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yakungao
 * @date 2018/2/7
 **/
public class Test1 {

    private final char value[] = new char[0];
    String str = "1111";

    List<Integer>[] lists = new ArrayList[2];


    List<Integer>[] a = new ArrayList[2];
    int b = 0;
    int c = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Test1)) {
            return false;
        }

        Test1 test1 = (Test1) o;

        if (b != test1.b) {
            return false;
        }
        return c == test1.c;
    }

    @Override
    public int hashCode() {
        int result = b;
        result = 31 * result + c;
        return result;
    }


    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list1.add("6");
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("3");
        list2.add("6");
        list2.add("7");
        list2.add("8");
        list2.add("9");

        long st = System.nanoTime();
        Map<String, Integer> map = new HashMap<String, Integer>(list1.size() + list2.size());
        List<String> diff = new ArrayList<String>();
        List<String> addList = new ArrayList<String>();
        List<String> delList = new ArrayList<String>();
        List<String> maxList = list1;
        List<String> minList = list2;
        if (list2.size() > list1.size()) {
            maxList = list2;
            minList = list1;
        }
        for (String string : maxList) {
            map.put(string, 1);
        }
        for (String string : minList) {
            Integer cc = map.get(string);
            if (cc != null) {
                maxList.remove(string);
                continue;
            }
            addList = maxList;
            //map.put(string, 1);
            delList.add(string);
        }
    }

}
