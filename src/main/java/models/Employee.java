package models;

import convertes.EmployeeStatusConverter;
import enums.EmployeeStatus;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Employee.getAll", query = " SELECT e from Employee e "),
        @NamedQuery(name = "Employee.updateStatus", query = "UPDATE Employee SET status = :status WHERE id = :id")
})
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "emp_id", columnDefinition = "BIGINT(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "VARCHAR(250)", nullable = false)
    private String address;
    @Column(columnDefinition = "DATETIME(6)", nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime dob;
    @Column(columnDefinition = "VARCHAR(150)")
    private String email;
    @Column(name = "full_name", columnDefinition = "VARCHAR(150)", nullable = false)
    private String fullname;
    @Column(columnDefinition = "VARCHAR(15)", nullable = false)
    private String phone;
    @Column(columnDefinition = "INT(11)", nullable = false)
    @Convert(converter = EmployeeStatusConverter.class)
    private EmployeeStatus status;


    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Order> lstOrder = new ArrayList<>();

    public Employee() {
    }

    public Employee(long id, String address, LocalDateTime dob, String email, String fullname,
                    String phone, EmployeeStatus status, List<Order> lstOrder) {
        this.id = id;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.status = status;
        this.lstOrder = lstOrder;
    }


    public long getId() {
        return id;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public String getFullname() {
        return fullname;
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
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", lstOrder=" + lstOrder +
                '}';
    }
}
