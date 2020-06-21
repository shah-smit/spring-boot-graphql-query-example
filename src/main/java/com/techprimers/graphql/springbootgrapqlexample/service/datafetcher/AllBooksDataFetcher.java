package com.techprimers.graphql.springbootgrapqlexample.service.datafetcher;

import com.techprimers.graphql.springbootgrapqlexample.model.Book;
import com.techprimers.graphql.springbootgrapqlexample.repository.BookRepository;
import com.techprimers.graphql.springbootgrapqlexample.service.BookService;
import com.techprimers.graphql.springbootgrapqlexample.service.CacheService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Slf4j
@Component
public class AllBooksDataFetcher implements DataFetcher<List<Book>> {

    @Autowired
    BookService bookService;

    @Override
    public List<Book> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return bookService.getAllBooks();
    }
}
