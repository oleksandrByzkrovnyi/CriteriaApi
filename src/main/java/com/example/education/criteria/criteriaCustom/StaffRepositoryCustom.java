package com.example.education.criteria.criteriaCustom;

import com.example.education.criteria.domain.Department;
import com.example.education.criteria.domain.Position;
import com.example.education.criteria.domain.Staff;

import java.util.List;

public interface StaffRepositoryCustom {
    Staff findByfirstNameAndLastName(String firstName, String LastName);

    Long getCountStaffInDept(Integer idDept);

    List<Staff> findStaffOnPosition(Position position);

    List findStaffWhereNameHas(String part);

    List<Staff> findStaffInDept(Integer idDept);

    List<Staff> findStaffWhereSalaryBetween(Integer avg);

    boolean deleteStaffById(Integer id);

    boolean deleteStaffByFirstNameAndLastName(String firstName, String lastName);

    boolean updateNameStaff(String name, Integer id);

    List<Object> getAvgSalaryInDept();
}
