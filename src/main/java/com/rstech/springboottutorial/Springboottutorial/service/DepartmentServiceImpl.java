package com.rstech.springboottutorial.Springboottutorial.service;

import com.rstech.springboottutorial.Springboottutorial.entity.Department;
import com.rstech.springboottutorial.Springboottutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl {
    @Autowired
    private DepartmentRepository departmentRepository;


    public Department savedepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> fetchdpartment() {
        return departmentRepository.findAll();
    }

    public Optional<Department> fetchdepartmentbyId(Long departmentid) {
        Optional<Department> department = departmentRepository.findById(departmentid);

        if(department.isPresent()){
        return department;}
        else{
            return Optional.empty();
        }
    }


    public Optional<Department> deletedepartment(Long departmentid) {
        Optional<Department> delete = fetchdepartmentbyId(departmentid);

        if(fetchdepartmentbyId(departmentid).isPresent()){
        departmentRepository.deleteById(departmentid);
        return delete;}
        else {
            return Optional.empty();
        }
    }


    public Department updatedepartment(Long departmentid, Department department) {
        if (departmentRepository.findById(departmentid).isPresent()) {
            Department deptDb = departmentRepository.findById(departmentid).get();
            if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
                deptDb.setDepartmentName(department.getDepartmentName());
            }
            if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
                deptDb.setDepartmentAddress(department.getDepartmentAddress());
            }
            if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
                deptDb.setDepartmentCode(department.getDepartmentCode());

            }
            return departmentRepository.save(deptDb);
        }
        return null;
    }

    public Department fetchdepartmentByName(String departmentname) {
        return departmentRepository.findByDepartmentName(departmentname);

    }


    public List<Department> findByDepartmentIdBetween(Long departmentid, Long departmentid1) {
        return departmentRepository.findByDepartmentIdBetween(departmentid, departmentid1);}

    public List<Department> random(Long l) {
        return departmentRepository.random(l);
    }
    //->alter code for fetching id between  <--
//     Long a= departmentid;
//    Long b=departmentid1;
//    List<Department> departmentList= new ArrayList<>();
//
//        for (long i = departmentid; i <departmentid1 ; i++) {
//        if(     departmentRepository.findById(i).isPresent()){
//            departmentList.add(departmentRepository.findById(i).get());
//        }
//
//    }
//return departmentList;

}
