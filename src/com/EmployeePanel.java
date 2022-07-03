package  com;

import javax.swing.*;
import java.awt.*;

public class EmployeePanel {
    public static void main(String[] args) {
        var admin_add_employee = new LargerEnlongedButton("Add Employee",5,5);
        var admin_remove_employee = new LargerEnlongedButton("Remove Employee",5,5);
        var admin_view_employees = new LargerEnlongedButton("View Employees",5,5);

        JFrame f = new JFrame("Panel");
        var admin_employee_panel = new JPanel();

        admin_employee_panel.setBackground(new Color(245,222,179));
        admin_employee_panel.setLayout(new BoxLayout(admin_employee_panel,BoxLayout.Y_AXIS));
        admin_add_employee.setAlignmentX(Component.CENTER_ALIGNMENT);
        admin_remove_employee.setAlignmentX(Component.CENTER_ALIGNMENT);
        admin_view_employees.setAlignmentX(Component.CENTER_ALIGNMENT);
        admin_employee_panel.add(Box.createRigidArea(new Dimension(300,80)));
        admin_employee_panel.add(admin_add_employee);
        admin_employee_panel.add(Box.createRigidArea(new Dimension(300,80)));
        admin_employee_panel.add(admin_remove_employee);
        admin_employee_panel.add(Box.createRigidArea(new Dimension(300,80)));
        admin_employee_panel.add(admin_view_employees);
        
        f.setSize(500,500);
        f.add(admin_employee_panel);
        f.setVisible(true);
    }
}
