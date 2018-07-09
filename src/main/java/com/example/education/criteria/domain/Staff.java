package com.example.education.criteria.domain;





import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "staffs")
public class Staff implements Serializable {
    @Id
    @Column
    @GeneratedValue
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Position position;

    @ManyToOne
    @JoinColumn(name = "id_dept", foreignKey = @ForeignKey(name = "staffs___fk_dept"))
    private Department department;

    @Column
    private Long salary;

}
