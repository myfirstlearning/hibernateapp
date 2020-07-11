package com.hibernate.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//@Table(name="commisionEmployeeTable")
public class Employee {

    private static final long serialVersionUID = 1L;

    @Id //== primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fName, lName, mName;

    //@Column(name = "createdDate", nullable = true, length = 50)
    private LocalDateTime createdDateTime;

    //mapped by property tells where to locate ur foreign key
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    public Employee() {
    }

    public Employee(String fName, String lName, String mName) {
        super();
        this.fName = fName;
        this.lName = lName;
        this.mName = mName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", mName='" + mName + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", address=" + address +
                '}';
    }
}
