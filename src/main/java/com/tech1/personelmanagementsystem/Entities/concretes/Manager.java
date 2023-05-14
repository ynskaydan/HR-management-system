package com.tech1.personelmanagementsystem.Entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name="managers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employees"})
public class Manager {
    @Id
    @Column(name="id")
    private int manager_id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @ManyToOne()
    @JoinColumn(name="region_id")
    private Region region;

    @OneToMany(mappedBy = "manager")
    private List<Employee> employees;
}
