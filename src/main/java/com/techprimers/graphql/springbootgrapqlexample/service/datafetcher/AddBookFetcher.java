package com.techprimers.graphql.springbootgrapqlexample.service.datafetcher;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.techprimers.graphql.springbootgrapqlexample.model.Book;
import com.techprimers.graphql.springbootgrapqlexample.repository.BookRepository;
import com.techprimers.graphql.springbootgrapqlexample.service.BookService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddBookFetcher implements DataFetcher<Book> {

    @Autowired
    BookService bookService;

    public Book addBook(String isn, String title, String publisher) {
        Book book  = new Book();
        book.setIsn(isn);
        book.setTitle(title);
        book.setPublisher(publisher);
        this.bookService.saveBook(book);

        return this.bookService.getBookByIsn(book.getIsn());
    }

    @Override
    public Book get(DataFetchingEnvironment dataFetchingEnvironment) {
        return addBook(
                dataFetchingEnvironment.getArgument("isn"),
                dataFetchingEnvironment.getArgument("title"),
                dataFetchingEnvironment.getArgument("publisher")
        );
    }
}
