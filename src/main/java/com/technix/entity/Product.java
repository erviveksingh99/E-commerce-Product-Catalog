package com.technix.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Name should be require")
	private String name;

	@NotBlank(message = "description should be require")
	private String description;

	@NotNull(message = "Price should be required")
	private Double price;

	@NotBlank(message = "category should be require")
	private String category;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
}
