package com.springdemo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long departmentId;
	@NotBlank(message="Please add department name")
	@Size(max=6,min=1)
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
	
}
