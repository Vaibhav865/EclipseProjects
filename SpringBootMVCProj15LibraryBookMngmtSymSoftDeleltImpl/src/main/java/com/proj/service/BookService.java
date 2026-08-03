package com.proj.service;

import java.util.List;

import com.proj.model.Book;

public interface BookService {
		
		public Book saveBook(Book book);
		public List<Book> viewActiveBook();
		public Book updateBook(Book book, Integer id);
		public void SoftDeleteBook(Integer id);
		public List<Book> viewDeActiveBook();
		public Book restoreBook(Integer id);
		public void permanentDelete(Integer id );
		
	
}
