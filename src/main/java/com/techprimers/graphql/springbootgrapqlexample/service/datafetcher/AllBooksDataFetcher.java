package com.techprimers.graphql.springbootgrapqlexample.service.datafetcher;

import com.techprimers.graphql.springbootgrapqlexample.model.Book;
import com.techprimers.graphql.springbootgrapqlexample.repository.BookRepository;
import com.techprimers.graphql.springbootgrapqlexample.service.CacheService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Component
public class AllBooksDataFetcher implements DataFetcher<List<Book>>{

    @Autowired
    CacheService cacheService;

    @Override
    public List<Book> get(DataFetchingEnvironment dataFetchingEnvironment) {
        String orderBy = dataFetchingEnvironment.getArgument("orderBy");
        try {
            if(orderBy != null && orderBy.equalsIgnoreCase("title")){
                return cacheService.getAllBooks().stream()
                        .sorted((b1,b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()))
                        .collect(Collectors.toList());
            } else {
                return cacheService.getAllBooks();
            }
        } catch (ExecutionException e) {
            return new ArrayList<>();
        }
    }
}
