package com.java8.interviewquestions.EY;

import java.util.*;

/*
public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        for(String str : strs){
           char[] chars=str.toCharArray();
           System.out.println("chars : "+ Arrays.toString(chars));
           Arrays.sort(chars);
           System.out.println("sort(chars) : "+ Arrays.toString(chars));

            String key=new String(chars);
            System.out.println("key : "+key);

            map.computeIfAbsent(key,k->new ArrayList<>()).add(str);
            System.out.println("map : "+map);
            System.out.println("----------------------------------------------------");

        }
        return new ArrayList<>(map.values());

    }

    static void main() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }
}

