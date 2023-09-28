package models;

import enums.EmployeeStatus;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
            @NamedQuery(name = "Employee.getAll", query = "select  e from Employee  e where  e.status= 1 "),
           @NamedQuery(name = "Employee.updateStatus", query = "SELECT e from Employee e WHERE (e.id = :id )")
})
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;
    @Column(name = "full_name", length = 150, nullable = false)
    private String full_name;
    @Column(nullable = false, name = "dob")
    private LocalDate dod;
    @Column(name = "email", length = 150, unique = true)
    private String email;
    @Column(name = "phone", length = 15, nullable = false)
    private String phone;
    @Column(name = "address", length = 250, nullable = false)
    private String address;
    @Column(name = "status", nullable = false)
    private EmployeeStatus status;


    @OneToMany(mappedBy = "employee")
    private List<Order> lstOrder = new ArrayList<>();

    public Employee() {
    }

    public Employee(int id, String full_name, LocalDate dod, String email, String phone,
                    String address, EmployeeStatus status, List<Order> lstOrder) {
        this.id = id;
        this.full_name = full_name;
        this.dod = dod;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.lstOrder = lstOrder;
    }

    public int getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public LocalDate getDod() {
        return dod;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public List<Order> getLstOrder() {
        return lstOrder;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", dod=" + dod +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", lstOrder=" + lstOrder +
                '}';
    }
}
