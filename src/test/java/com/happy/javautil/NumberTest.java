package com.happy.javautil;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberTest {
    public static void main(String[] args) {
        NumberFormat numberFormat=NumberFormat.getInstance();
        DecimalFormat  numberDecimalFormat = (DecimalFormat) numberFormat;
        numberDecimalFormat.applyPattern("#.00");
        String result=numberDecimalFormat.format(123123.265863);
        System.out.println(result);
    }
}
