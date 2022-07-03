package com;

import java.sql.*;

public class MarkAttendance {
    private String att;
    private String date;
    private String username;
    MarkAttendance(String att, String date, String username){
        this.setAtt(att);
        this.setDate(date);
        this.setUsername(username);
    }

    public void setAtt(String att) {
        this.att = att;
    }

    public String getAtt() {
        return att;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void mark_attendance(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "abdularham123");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from attendance");
            while (rs.next()){
                if (rs.getString(1).equals(date)){
                    if (att.equals("P")){
                        if (rs.getString(2).contains(","+username+": A")){
                            String update = rs.getString(2).replace(","+username+": A", ","+username+": P");
                            PreparedStatement preparedStatement = con.prepareStatement("UPDATE attendance SET attendances = ? WHERE dates = ?");
                            preparedStatement.setString(1, update);
                            preparedStatement.setString(2, date);
                            preparedStatement.execute();
                        }
                    }else{
                        if (rs.getString(2).contains(","+username+": P")){
                            String update = rs.getString(2).replace(","+username+": P", ","+username+": A");
                            PreparedStatement preparedStatement = con.prepareStatement("UPDATE attendance SET attendances = ? WHERE dates = ?");
                            preparedStatement.setString(1, update);
                            preparedStatement.setString(2, date);
                            preparedStatement.execute();
                        }
                    }
                }
            }
            con.close();
            new DateAddedFrame("Attendance Marked");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
