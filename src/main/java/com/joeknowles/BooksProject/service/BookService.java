package com.joeknowles.BooksProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joeknowles.BooksProject.models.Book;
import com.joeknowles.BooksProject.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() { return bookRepository.findAll(); }
    // creates a book
    public Book createBook(Book b) { return bookRepository.save(b); }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }
    // updates a book
    public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
        	Book book = optionalBook.get();
        	book.setTitle(title);
        	book.setDescription(desc);
        	book.setLanguage(lang);
        	book.setNumberOfPages(numOfPages);
            return bookRepository.save(book);
        } else {
            return null;
        }
    }
    // deletes a book
    public void deleteBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
        	bookRepository.delete(optionalBook.get());
        } 
    }

}

