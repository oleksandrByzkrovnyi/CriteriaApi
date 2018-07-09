package com.example.education.criteria.repositories;


import com.example.education.criteria.criteriaCustom.DepartmentRepositoryCustom;
import com.example.education.criteria.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department,Long>, DepartmentRepositoryCustom{
}
