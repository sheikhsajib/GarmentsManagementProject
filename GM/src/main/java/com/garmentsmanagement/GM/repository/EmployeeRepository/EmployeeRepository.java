package com.garmentsmanagement.GM.repository.EmployeeRepository;

import com.garmentsmanagement.GM.entity.employeeEntity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {


//    @Query("select e from HrEmployees e inner join e.department d on" +
//            " e.department.dep_id = d.dep_id inner join  e.designation dg on dg.desgi_id = d.dep_id")
//    public List<HrEmployees> findAllEmp();

    @Query("select count(em.em_id) from Employees em")
    public int countRow();

    @Query("select em from Employees em where em.em_employeeID = ?1")
    public List<Employees> findByEmid(String emid);

}
