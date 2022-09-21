package com.happy.javautil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFile {

    public static void main(String[] args) {
        getDataFromBanks("F:\\dzd18FD2022082504.TXT");
    }

    public static List<Map<String, Object>> getDataFromBanks(String path) {
        List<Map<String, Object>> infos = new ArrayList<>();
        InputStreamReader inputStreamReader = null;
        BufferedReader fr = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(path), "UTF-8");
            fr = new BufferedReader(inputStreamReader);
            String lineContent = "";
            while ((lineContent = fr.readLine()) != null) {
                String[] split = lineContent.split("\\|");
                Map<String, Object> entity = new HashMap<>();
                for (int i = 0; i < split.length; i++) {
                    switch (i) {
                        case 0:
                            String transactionTime = split[0];
                            //                            entity.setTradingTime(DateTimeUtil.stringToDate(transactionTime, DATE_FORM_3));
                            System.out.println(transactionTime);
                            break;
                        case 1:
                            String accountNo = split[1];
                            System.out.println(accountNo);
                            break;
                        case 2:
                            String contractNo = split[2];
                            System.out.println(contractNo);
                            break;
                        case 3:
                            String loanUser = split[3];
                            System.out.println(loanUser);
                            break;
                        case 4:
                            String loanUserIdNo = split[4];
                            System.out.println(loanUserIdNo);
                            break;
                        case 5:
                            String position = split[5];
                            System.out.println(position);
                            break;
                        case 6:
                            String loanAmount = split[6];
                            System.out.println(loanAmount);
                            break;
                        case 7:
                            String remark = split[7];
                            System.out.println(remark);
                            break;
                        default:
                            break;
                    }
                }
                infos.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return infos;
    }

}
