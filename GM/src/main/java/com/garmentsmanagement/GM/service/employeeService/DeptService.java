package com.garmentsmanagement.GM.service.employeeService;

import com.garmentsmanagement.GM.entity.employeeEntity.Department;
import com.garmentsmanagement.GM.entity.employeeEntity.Designation;
import com.garmentsmanagement.GM.repository.EmployeeRepository.DepRepo;
import com.garmentsmanagement.GM.repository.EmployeeRepository.DesignationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptService {

    @Autowired
    DepRepo deptRepo;

    @Autowired
    DesignationRepo desigRepo;

    public List<Department> findAllDept(){ return deptRepo.findAll();}

    public void saveDesig(Designation dg){
        desigRepo.save(dg);}
}
