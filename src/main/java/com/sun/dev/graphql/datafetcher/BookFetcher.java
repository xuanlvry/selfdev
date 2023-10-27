package com.sun.dev.graphql.datafetcher;

import com.sun.dev.entity.Book;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

@Component
public class BookFetcher {
    public DataFetcher getBookById() {
        // dataFetchingEnvironment 封装了查询中带有的参数
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            Book book = new Book();
            book.setID(Integer.valueOf(bookId));
            book.setName("tom");
            return book;
        };
    }
}
