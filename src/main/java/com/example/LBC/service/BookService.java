package com.example.LBC.service;

import com.example.LBC.model.BookModel;
import com.example.LBC.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public BookModel addBook(BookModel book) {
        book.setAvailable(true);
        return repo.save(book);
    }

    public List<BookModel> getAllBooks() {
        return repo.findAll();
    }

    public Optional<BookModel> getBookById(Integer id) {
        return repo.findById(id);
    }

    public boolean deleteBook(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<BookModel> updateAvailability(Integer id, Boolean status) {
        Optional<BookModel> bookOpt = repo.findById(id);
        bookOpt.ifPresent(book -> {
            book.setAvailable(status);
            repo.save(book);
        });
        return bookOpt;
    }
}
