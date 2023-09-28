package models;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;

import jakarta.persistence.*;




@Entity
@Table(name = "customer")
@NamedQueries({
        @NamedQuery(name = "Customer.getAll", query =" select c from Customer  c ")
})
public class Customer {
    @Id
    @Column(name = "cust_id", columnDefinition = "BIGINT(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(columnDefinition = "VARCHAR(250)", nullable = false)
    private String address;
    @Column(columnDefinition = "VARCHAR(150)")
    private String email;
    @Column(name = "cust_name", columnDefinition = "VARCHAR(150)", nullable = false)
    private String name;
    @Column(columnDefinition = "VARCHAR(15)", nullable = false)
    private String phone;

    public Customer() {
    }

    public Customer(int id, String address, String email, String name, String phone) {
        Id = id;
        this.address = address;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return Id;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
