package com.proj.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Book {
	
	@Id
	@SequenceGenerator(sequenceName = "bookIDSqn", name = "bookIDSqn" ,allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "bookIDSqn")
	private Integer id;
	
	@Nonnull
	@Column(length = 10)
	private String title;
		
	@Nonnull
	@Column(length = 10)
	private String author;
	
	@Nonnull
	@Column(length = 10)
	private String category;
	
	
	@Nonnull
	@Column(length = 10)
	private Double price;
	
	@Nonnull
	@Column(length = 10)
	private Boolean available = false;
	
	@Nonnull
	@Column(length = 10)
	private Boolean deleted = false;
	
	
	
	

}
