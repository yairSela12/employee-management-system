package com.work.sbemployees.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @NotBlank(message = "First name cannot be empty")
    @Column(nullable = false , name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Column(nullable = false , name = "last_name")
    private String lastName;


    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be empty")
    @Column(nullable = false , unique = true , name = "email")
    private String email;



}
