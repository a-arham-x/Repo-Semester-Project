package com;

public class CheckEmployeeDeletion extends CheckEmployeeCredentials{

    CheckEmployeeDeletion(String username){
        super(username);
        System.out.println(this.getUsername());
        boolean valid_deletion = this.username_in_database();
        if (valid_deletion){
            new ConfirmEmployeeDeletion(username);
        }else{
            new UserNotExist();
        }
    }

}
