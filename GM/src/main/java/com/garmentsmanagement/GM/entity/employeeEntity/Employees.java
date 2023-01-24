package com.garmentsmanagement.GM.entity.employeeEntity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long em_id;
    @Column()
    private String em_employeeID;
    @Column(length = 50)
    private String em_name;
    @Column(length = 50)
    private String em_fatherName;
    @Column(length = 20)
    private String em_nid;
    @Column(length = 20)
    private String em_phone;
    @Column(length = 20)
    private String em_gender;

    @Column(length = 20)
    private String em_dob;

    @Column(length = 10)
    private String em_relationshipStatus;

    @Column(length = 50)
    private String em_spouseName;

    @Column(length = 20)
    private String em_spouseNID;

    @Column(length = 30)
    private String em_PreviousCompany;

    @Column(length = 40)
    private String em_profileImg;

    @Column()
    private String em_joiningDate;

    @Column(length = 200)
    private String em_resentAddress;

    @Column(length = 200)
    private String em_permanentAddress;

    @Column(length = 40)
    private String em_email;

    @Column(length = 10)
    private String em_password;



    @ManyToOne
    @JoinColumn(name="department_fk")
    Department department;

    @ManyToOne
    @JoinColumn(name="designation_fk")
    Designation designation;


    @Override
    public String toString() {
        return "HrEmployees{" +
                "em_id=" + em_id +
                ", em_employeeID='" + em_employeeID + '\'' +
                ", em_name='" + em_name + '\'' +
                ", em_fatherName='" + em_fatherName + '\'' +
                ", em_nid='" + em_nid + '\'' +
                ", em_phone='" + em_phone + '\'' +
                ", em_gender='" + em_gender + '\'' +
                ", em_dob='" + em_dob + '\'' +
                ", em_relationshipStatus='" + em_relationshipStatus + '\'' +
                ", em_spouseName='" + em_spouseName + '\'' +
                ", em_spouseNID='" + em_spouseNID + '\'' +
                ", em_PreviousCompany='" + em_PreviousCompany + '\'' +
                ", em_profileImg='" + em_profileImg + '\'' +
                ", em_joiningDate='" + em_joiningDate + '\'' +
                ", em_resentAddress='" + em_resentAddress + '\'' +
                ", em_permanentAddress='" + em_permanentAddress + '\'' +
                ", em_email='" + em_email + '\'' +
                ", em_password='" + em_password + '\'' +
                ", department=" + department +
                ", designation=" + designation +
                '}';
    }
}
