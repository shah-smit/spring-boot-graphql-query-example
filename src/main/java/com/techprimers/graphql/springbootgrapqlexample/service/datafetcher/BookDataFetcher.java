package com.techprimers.graphql.springbootgrapqlexample.service.datafetcher;

import com.techprimers.graphql.springbootgrapqlexample.model.Book;
import com.techprimers.graphql.springbootgrapqlexample.repository.BookRepository;
import com.techprimers.graphql.springbootgrapqlexample.service.BookService;
import com.techprimers.graphql.springbootgrapqlexample.service.CacheService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class BookDataFetcher implements DataFetcher<Book> {

    @Autowired
    BookService bookService;

    @Override
    public Book get(DataFetchingEnvironment dataFetchingEnvironment) {

        String isn = dataFetchingEnvironment.getArgument("id");
        return bookService.getBookByIsn(isn);
    }
}
