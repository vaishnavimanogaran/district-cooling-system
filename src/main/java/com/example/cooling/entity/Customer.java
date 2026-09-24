package com.example.cooling.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Schema(description = "Customer information for commercial buildings")
@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Schema(description = "Unique customer ID", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Schema(description = "Commercial building name", example = "Tidel Park")
    @NotBlank(message = "Tower name is required")
    private String towerName;

    @Schema(example = "Rahul")
    @NotBlank(message = "Contact person is required")
    private String contactPerson;

    @Schema(example = "rahul@gmail.com")
    @Email(message = "Enter valid email")
    private String email;

    @Schema(example = "9876543210")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    private String phone;

    @Schema(example = "Coimbatore")
    @NotBlank(message = "Address is required")
    private String address;
}