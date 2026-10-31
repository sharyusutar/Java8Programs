package com.test;

public class Test2 {

    static void main() {
        String str="GeeksForGeeks";
        StringBuilder s=new StringBuilder();

        for(int i=0;i<str.length();i++) {
            if(s.toString().toLowerCase().contains(str.split("")[i].toLowerCase())){
                continue;
            }
            s.append(str.split("")[i]);
        }

        System.out.println(s.toString());


    }
}
