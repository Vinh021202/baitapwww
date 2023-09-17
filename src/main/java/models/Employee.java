package models;

import enums.EmployeeStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;



import java.time.LocalDate;

@NamedQueries({
        //    @NamedQuery(name = "Employee.getAll", query = "FROM Employee"),
        //   @NamedQuery(name = "Employee.updateStatus", query = "UPDATE Employee SET status = :status WHERE id = :id")
})
@Entity
@Table(name = "employee")
public class Employee {
    private int emp_id;
    private String full_name;
    private LocalDate dod;
    private String email;
    private String phone;
    private String address;
    private EmployeeStatus staus;




}
