package com.rstech.springboottutorial.Springboottutorial.Controller;

import com.rstech.springboottutorial.Springboottutorial.entity.Department;
import com.rstech.springboottutorial.Springboottutorial.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentServiceImpl departmentService;


    @PostMapping("/department")
    public Department savedepartment(@Valid @RequestBody Department department) {

        return departmentService.savedepartment(department);

    }

    @GetMapping("/department")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchdpartment();
    }

    @GetMapping("/department/{id}")
    public Optional<Department> fetchdepartmentbyId(@PathVariable("id") Long departmentid) {
        return departmentService.fetchdepartmentbyId(departmentid);

    }

    @DeleteMapping("/department/{id}")
    public Optional<Department> deteledepartment(@PathVariable("id") Long departmentid) {
        return departmentService.deletedepartment(departmentid);
    }

    @PutMapping("/department/{id}")
    public Department updatedepartment(@PathVariable("id") Long departmentid, @RequestBody Department department) {
        return departmentService.updatedepartment(departmentid, department);

    }

    @GetMapping("/department/name/{name}")
    public Department fetchdepartmentByName(@PathVariable("name") String departmentname) {
        return departmentService.fetchdepartmentByName(departmentname);
    }

    @GetMapping("/department/{id}/{id1}")
    public List<Department> getBetween(@PathVariable("id") Long departmentid, @PathVariable("id1") Long departmentid1) {

        return departmentService.findByDepartmentIdBetween(departmentid, departmentid1);

    }

    @PostMapping("/departmentt")
    public List<Department> random(@RequestParam Long l) {
        return departmentService.random(l);

    }
}
