package com.tech1.personelmanagementsystem.Entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name="departments")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","directors","employees"})
public class Department {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    @OneToMany(mappedBy = "department")
    private List<Director> directors;
}
