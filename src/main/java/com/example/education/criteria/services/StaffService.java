package com.example.education.criteria.services;


import com.example.education.criteria.domain.Position;
import com.example.education.criteria.domain.Staff;

import java.util.List;


public interface StaffService {
    Staff findOneByFirstNameAndLastName(String firstName, String lastName);

    List<Staff> findAll();

    Long getCountStaffInDept(Integer idDept);

    List<Staff> findStaffOnPosition(Position position);

    List<Staff> findStaffWhereNameHas(String part);

    List<Staff> findStaffInDept(Integer idDept);

    List<Staff> findStaffWhereSalaryBetween(Integer avg);

    boolean deleteStaffById(Integer id);

    boolean deleteStaffByFirstNameAndLastName(String firstName, String lastName);

    boolean updateStaff(String name, Integer id);

    List<Object> getAvgSalaryInDept();

}
