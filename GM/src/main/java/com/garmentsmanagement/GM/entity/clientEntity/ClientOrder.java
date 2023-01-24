package com.garmentsmanagement.GM.entity.clientEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ClientOrderList")
public class ClientOrder {
    //01
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coid; //Client Order ID will Generate like COUNTRY-YEAR-Serial = USA-23-07

    //02
    @Column(length = 35, nullable = false) //Client Name
    private String coName;

    //03
    @Column(length = 50, nullable = false) //
    private String coRawMaterials;

    @Column(length = 25, nullable = false)
    private String orderStatus;
    // Status 1 = order placed - waiting for Admin Approve
    // Status 2 = Order Approve for sample - in Client list will show Order Approved;


    @ManyToOne
    @JoinColumn(name = "cid_fk")
    ClientRegistration coCid;



}
