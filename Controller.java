package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    private ListView<Worker> employeeListView;

    @FXML //these are the handle for the control boxes in the sample file
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private JCheckBox isActiveCheckBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        employeeListView.getSelectionModel().selectedItemProperty().addListener((
                        ObservableValue<? extends Worker> ov, Worker old_val, Worker new_val) ->
                {
                    Worker selectedItem = employeeListView.getSelectionModel().getSelectedItem();
                    firstNameTextField.setText(((Employee)selectedItem).firstName);  //casting from worker to employee
                    lastNameTextField.setText(((Employee)selectedItem).lastName);
                    isActiveCheckBox.setSelected(((Employee)selectedItem).isActive);
                }
                );

        ObservableList<Worker> items = employeeListView.getItems();
        Employee employee1 = new Employee();
        employee1.firstName = "Robert";
        employee1.lastName = "Smith";
        Employee employee2 = new Employee();
        employee2.firstName = "Lisa";
        employee2.lastName = "Smith";
        items.add(employee1);
        items.add(employee2);

        //creating a loop to add 10 more employees
        for(int i = 0; i < 10; i++)
        {
           Employee employee = new Employee();
           employee.firstName = "Generic";
           employee.lastName = "Employee" + " " + i;
           items.add(employee);
        }

        Staff staff1 = new Staff();
        staff1.firstName = "StaffPerson";
        staff1.lastName = "GoodWorker";

        Faculty faculty1 = new Faculty();
        faculty1.firstName = "FacultyPerson";
        faculty1.lastName = "BadWorker";

        items.add(staff1);
        items.add(faculty1);


    }
}
