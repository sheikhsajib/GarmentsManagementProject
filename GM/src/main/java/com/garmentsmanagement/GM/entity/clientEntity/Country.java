package com.garmentsmanagement.GM.entity.clientEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "allcountries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int cntId;

    @Column(length = 30, nullable = false)
    private  String cntName;

    @Column(length = 5, nullable = false)
    private  String cntShortCode;
}
