package com.proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.model.Book;
import com.proj.service.BookService;

@RestController
@RequestMapping("/books")
public class LibraryController {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/")
	public String showHome(){
		return "home";
	}
	
	@GetMapping("/activebooks")
	public String showActiveBook(Model model) {
		model.addAttribute("books",service.viewActiveBook());
		return "book-list";
	}

	@PostMapping("/add")
	public String showSave(Model model) {
		model.addAttribute("book",new Book());
		return "save-book";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditForm() {
		return "edit-book";
	}
		
	@PostMapping("/update")
	public String showUpdate() {
		return "edit-book";
	}
	
	@GetMapping("/delete/{id}")
	public String showSoftDeletion() {
		return "soft-deletion";
	}
	
	@GetMapping("/trash")
	public String showDeletedBook() {
		return "trash-books";
	}
	
	@GetMapping("/restore/{id}")
	public String showRestoreBook() {
		return "restore-books";
	}
	
	@GetMapping("/permanent-delete/{id}")
	public String showPermanetlyBook() {
		return "restore-books";
	}
	
		
}
