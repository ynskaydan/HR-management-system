package com.tech1.personelmanagementsystem.Api.controllers;

import com.tech1.personelmanagementsystem.Business.abstracts.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {
    private final DepartmentService departmentService;
    public DepartmentsController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }
}
