package com.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
		
	
	
}
