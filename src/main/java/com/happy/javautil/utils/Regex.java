package com.happy.javautil.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    
    
    public static void main(String[] args) {
        //匹配一个字
        //        String regex="t.n";
        //        String value="taccccn";
        //        boolean  matches= Pattern.matches(regex,value);
        //        System.out.println("matches="+matches);
        //        //* >=0次  + >=1次  ? 0或者1 {1}  =1  {1,4} 1<= <=4
        //        String regex1="t[a-z]+n";
        //        boolean  matches1= Pattern.matches(regex1,value);
        //        System.out.println("matches="+matches1);
        //
        //
        //        String regex2="t(a|b|dd|adc)n";
        //        String value2="tadcn";
        //        boolean  matches2= Pattern.matches(regex2,value2);
        //        System.out.println("matches="+matches2);
        
        //        String value = "5245.65";
        //        String regexN = "\\d{2,}(\\.\\d+)?";
        //        Pattern compile = Pattern.compile(regexN);
        //        Matcher matcher = compile.matcher(value);
        //        System.out.printf(matcher.matches() + "");
        //        int start = matcher.start();
        //        int end = matcher.end();
        //        System.out.printf(start + " - "+end);
        nominateMeth();
    }
    
    public static void nominateMeth() {
        String regex = "(?<year>\\d{4})-(?<mon>\\d{2})-(?<day>\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("2020-12-11");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group("year"));
            System.out.println(matcher.group("mon"));
            System.out.println(matcher.group("day"));
        }
        
    }
    
    public static void groupTest() {
        String regex = "(\\D*)((\\d+)(\\.))";
        String content = "Bao Zhong 3 is 1.5 p19!";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        int count = matcher.groupCount();
        System.out.println("一共" + count + "分组");
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
        }
        
    }
    
    
    public static void matcherTest() {
        String regex = "[1-9][1-9]*";
        Pattern pattern = Pattern.compile(regex);
        
        String content = "123456789";
        
        Matcher matcher = pattern.matcher(content);
        
        while (matcher.find()) {
            System.out.printf(matcher.group(0));
        }
    }
    
    
}
