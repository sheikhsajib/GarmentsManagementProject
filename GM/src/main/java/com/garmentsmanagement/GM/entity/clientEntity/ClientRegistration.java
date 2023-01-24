package com.garmentsmanagement.GM.entity.clientEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ClientInformation")
public class ClientRegistration {
    //01
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid; //Client ID will Generate like COUNTRY-YEAR-Serial = USA-23-07
    //02
    @Column(length = 35, nullable = false) //Client Name
    private String cName;

    //04
    @Column(length = 20, nullable = false)
    private String cPhoneNumber;
    //05
    @Column(length = 20, nullable = false)
    private String cNid;
    //06
    @Column(length = 10, nullable = false)
    private String cGender;
    //07
    @Column(length = 15, nullable = false)
    private String cDob;
    //08
//    @Column(length = 10, nullable = false)
//    private String cProfileImage;       // Client Profile

    //09
    @Column(length = 100, nullable = false)
    private String cAddress;
    //10
    @Column(length = 50, nullable = false)
    private String cEmail;
    //11
    @Column(length = 64, nullable = false)
    private String cPassword;

    @ManyToOne
    @JoinColumn(name = "cntId_fk")
    Country country;






}
