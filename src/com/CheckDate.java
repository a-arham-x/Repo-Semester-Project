package com;

import java.util.HashMap;

public class CheckDate {
    private String date;
    HashMap<String, String> date_map = new HashMap<>();
    CheckDate(String date){
        this.setDate(date);
        date_map.put("01", "31");
        date_map.put("02", "28");
        date_map.put("03", "31");
        date_map.put("04", "30");
        date_map.put("05", "31");
        date_map.put("06", "30");
        date_map.put("07", "31");
        date_map.put("08", "31");
        date_map.put("09", "30");
        date_map.put("10", "31");
        date_map.put("11", "30");
        date_map.put("12", "31");
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void check_date(){
        boolean date_correct = true;
        String numbers = "1234567890";
        if (date.length()==10){
            for (int i=0; i<2; i++){
                if (!numbers.contains(String.valueOf(date.charAt(i)))){
                    date_correct = false;
                }
            }
            if (date.charAt(2)!='/' || date.charAt(5)!='/'){
                date_correct = false;
            }
            for (int i=3; i<5; i++){
                if (!numbers.contains(String.valueOf(date.charAt(i)))){
                    date_correct = false;
                }
            }
            if (!date.substring(6, 10).equals("2022")){
                date_correct = false;
            }
            if (Integer.parseInt(date.substring(3, 5))>0 && Integer.parseInt(date.substring(3, 5))<=12){
                if (Integer.parseInt(date.substring(0, 2))>0 && Integer.parseInt(date.substring(0, 2))<=Integer.parseInt(date_map.get(date.substring(3, 5)))){
                    date_correct = true;
                }else{
                    date_correct = false;
                }
            }else{
                date_correct = false;
            }
        }else{
            date_correct = false;
        }
        if (date_correct){
            AddDate addDate = new AddDate(date);
            addDate.add_date();
        }else{
            new DateAddedFrame("Incorrect date cannot be added");
        }
    }
}
