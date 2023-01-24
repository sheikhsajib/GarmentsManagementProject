package com.garmentsmanagement.GM.entity.employeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "startAttend")
public class StartAttend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long em_id;

    @Column
    private long em_IdPK;

    @Column
    private String att_emId;

    @Column
    private boolean em_attend = false;

    @Column
    public LocalDate startDate = LocalDate.now();
    @Column
    public LocalTime startTime = LocalTime.now();

    @ManyToOne
    @JoinColumn(name="empID_pk")
    Employees employees;


    @Override
    public String toString() {
        return "StartAttend{" +
                "em_id=" + em_id +
                ", em_IdPK=" + em_IdPK +
                ", att_emId='" + att_emId + '\'' +
                ", em_attend=" + em_attend +
                ", startDate=" + startDate +
                ", startTime=" + startTime +
                ", hrEmployees=" + employees +
                '}';
    }
}
