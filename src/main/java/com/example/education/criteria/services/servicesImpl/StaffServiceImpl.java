package com.example.education.criteria.services.servicesImpl;

import com.example.education.criteria.domain.Position;
import com.example.education.criteria.domain.Staff;
import com.example.education.criteria.repositories.StaffRepository;
import com.example.education.criteria.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "staffService")
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository staffRepository;

    @Override
    public Staff findOneByFirstNameAndLastName(String firstName, String lastName) {
        return staffRepository.findByfirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public Long getCountStaffInDept(Integer idDept) {
        return staffRepository.getCountStaffInDept(idDept);
    }

    @Override
    public List<Staff> findStaffOnPosition(Position position) {
        return staffRepository.findStaffOnPosition(position);
    }

    @Override
    public List<Staff> findStaffWhereNameHas(String part) {
        return staffRepository.findStaffWhereNameHas(part);
    }

    @Override
    public List<Staff> findStaffInDept(Integer idDept) {
        return staffRepository.findStaffInDept(idDept);
    }

    @Override
    public List<Staff> findStaffWhereSalaryBetween(Integer avg) {
        return staffRepository.findStaffWhereSalaryBetween(avg);
    }

    @Override
    public boolean deleteStaffById(Integer id) {
        return false;
    }

    @Override
    public boolean deleteStaffByFirstNameAndLastName(String firstName, String lastName) {
        return false;
    }

    @Override
    public boolean updateStaff(String name, Integer id) {
        return staffRepository.updateNameStaff(name, id);
    }

    @Override
    public List<Object> getAvgSalaryInDept() {
        return staffRepository.getAvgSalaryInDept();
    }
}
