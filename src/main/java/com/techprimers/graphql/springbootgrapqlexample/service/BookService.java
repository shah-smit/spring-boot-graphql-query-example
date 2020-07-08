package com.techprimers.graphql.springbootgrapqlexample.service;

import com.techprimers.graphql.springbootgrapqlexample.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private GraphQLService graphQLService;

    public List<Book> getBooks(String query){
        HashMap<String, List<Book>> hp = graphQLService.getGraphQL().execute(query).getData();

        for (Object value : hp.values()) {
            if(value instanceof List){
                return (List<Book>) value;
            }
        }

        return new ArrayList<>();
    }
}
