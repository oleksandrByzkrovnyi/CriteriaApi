package com.example.education.criteria.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "departments")
@Entity
public class Department implements Serializable{
    @Id
    @Column
    private Long idDepartment;
    @Column
    private String nameDept;
    @Column
    private String telephone;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Department{");
        sb.append("idDepartment=").append(idDepartment);
        sb.append(", nameDept='").append(nameDept).append('\'');
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
