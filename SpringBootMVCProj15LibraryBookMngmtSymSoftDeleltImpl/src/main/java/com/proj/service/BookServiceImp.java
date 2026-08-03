package com.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.model.Book;
import com.proj.repository.BookRepository;

@Service
public class BookServiceImp implements BookService {
	
	@Autowired
	private BookRepository repo;
	
	
	@Override
	public Book saveBook(Book book) {
		return repo.save(book);
	}

	@Override
	public List<Book> viewActiveBook() {
		return  repo.findAll().stream().filter(b -> b.getAvailable()==true).toList();
	}

	@Override
	public Book updateBook(Book book, Integer id) {
		return repo.findById(id).map(
				b->{
					 	book.setTitle(book.getTitle());
		                book.setAuthor(book.getAuthor());
		                book.setPrice(book.getPrice());
		                book.setDeleted(book.getDeleted());
		                
		                repo.save(b);
		               return b;
				}
				).orElseThrow(()-> new IllegalArgumentException("Invalid book id"));
		
		
	}

	@Override
	public void SoftDeleteBook(Integer id ) {
		repo.findById(id).get().setDeleted(true);
	}

	@Override
	public List<Book> viewDeActiveBook() {
		return repo.findAll().stream().filter(b -> b.getDeleted() == true).toList();
	}

	@Override
	public Book restoreBook(Integer id) {
		return repo.findById(id).map(b ->{ b.setDeleted(false); 
									return repo.save(b);}
								).orElseThrow(() ->  new IllegalArgumentException("Book id not found"));
	}

	@Override
	public void permanentDelete(Integer id ) {
		repo.deleteById(id);
	}

	
}
