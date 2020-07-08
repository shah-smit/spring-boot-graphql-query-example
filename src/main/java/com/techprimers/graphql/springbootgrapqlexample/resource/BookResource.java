package com.techprimers.graphql.springbootgrapqlexample.resource;

import com.techprimers.graphql.springbootgrapqlexample.model.Book;
import com.techprimers.graphql.springbootgrapqlexample.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/books")
@RequiredArgsConstructor
public class BookResource {

    private final BookService bookService;

    @Value("${property.message}")
    private String message;

    @PostMapping
    public ResponseEntity<List<Book>> getAllBooks(@RequestBody String query) {
        return new ResponseEntity<>(bookService.getBooks(query), HttpStatus.OK);
    }

    @GetMapping
    public String getMessage(){
        return message;
    }
}
