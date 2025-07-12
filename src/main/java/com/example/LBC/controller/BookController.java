package com.example.LBC.controller;

import com.example.LBC.model.BookModel;
import com.example.LBC.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> addBook(@Valid @RequestBody BookModel book) {
        try {
            BookModel saved = service.addBook(book);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add book");
        }
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {
        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) {
        try {
            return service.getBookById(id).<ResponseEntity<?>>map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(404).body("Book not found"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
        try {
            boolean deleted = service.deleteBook(id);
            if (deleted)
                return ResponseEntity.ok("Book deleted");
            else
                return ResponseEntity.status(404).body("Book not found");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Deletion failed");
        }
    }

    @PatchMapping("/{id}/availability")
    public ResponseEntity<?> updateAvailability(@PathVariable Integer id, @RequestParam Boolean available) {
        try {
            return service.updateAvailability(id, available).<ResponseEntity<?>>map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(404).body("Book not found"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Update failed");
        }
    }

}
