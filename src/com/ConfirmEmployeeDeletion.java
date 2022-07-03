package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmEmployeeDeletion extends ConfirmUserRemoval implements ActionListener {
    ConfirmEmployeeDeletion(String username){
        super(username);
        this.confirm_user_removal_label.setText("Confirm Employee Removal ?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==confirm_user_removal_button){
            RemoveEmployee removeEmployee = new RemoveEmployee(this.getUsername());
            removeEmployee.remove_employee();
        }
    }
}
