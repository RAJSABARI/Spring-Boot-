package com.rstech.springboottutorial.Springboottutorial.repository;

import com.rstech.springboottutorial.Springboottutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findByDepartmentName(String departmentname);
   // @Query(value = "Select * from department where department_id between ?1 and  ?2",nativeQuery = true)[used to fetch all between values,ex:1 to 10=a,2,3,4,5,6,7,8,9,10]
//this is for findbyidbetter
    public List<Department> findByDepartmentIdBetween(Long departmentid, Long departmentid1);

}
