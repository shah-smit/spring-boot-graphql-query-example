package com.techprimers.graphql.springbootgrapqlexample.resource;

import com.techprimers.graphql.springbootgrapqlexample.model.Book;
import com.techprimers.graphql.springbootgrapqlexample.service.BookService;
import com.techprimers.graphql.springbootgrapqlexample.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rest/books")
@RestController
public class BookResource {

    @Autowired
    GraphQLService graphQLService;

    @Value("${property.message}")
    private String message;

    @PostMapping
    public ResponseEntity<List<Book>> getAllBooks(@RequestBody String query) {
        return new ResponseEntity<>(graphQLService.getBooks(query), HttpStatus.OK);
    }

    @GetMapping
    public String getMessage(){
        return message;
    }
}
