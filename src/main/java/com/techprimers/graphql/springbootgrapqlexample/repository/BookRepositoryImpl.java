package com.techprimers.graphql.springbootgrapqlexample.repository;

import com.techprimers.graphql.springbootgrapqlexample.model.Book;
import com.techprimers.graphql.springbootgrapqlexample.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BookRepositoryImpl {

    private BookRepository bookRepository;

    @Cacheable("byISN")
    public Book getBookByIsn(String isn){
        return bookRepository.findById(isn).get();
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }

    @Cacheable("books")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @CacheEvict(value = {"books","byISN"}, allEntries = true)
    @Scheduled(cron = "0 0 0 ? * *")
    public void deleteCacheEntries(){
        log.info(">>> Deleting Cache @ {}", LocalDateTime.now());
    }
}