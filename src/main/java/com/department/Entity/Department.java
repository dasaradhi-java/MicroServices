package com.department.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Department")
public class Department {
@Id
@GeneratedValue(strategy = GenerationType.AUTO )
    private Long departmentId;
    private String departmentName;
    private String departmentCode;
    private String departmentAddress;
}
