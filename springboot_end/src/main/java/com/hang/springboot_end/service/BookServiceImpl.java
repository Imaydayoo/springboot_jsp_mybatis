package com.hang.springboot_end.service;

import com.hang.springboot_end.dao.BookMapper;
import com.hang.springboot_end.domain.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//注册到spring容器中使controller可以调用
@Service
public class BookServiceImpl implements BookService{
    //调用dao层的操作，设置一个set接口，方便Spring管理
    @Autowired
    private BookMapper bookMapper;//aaaaaax

    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }


    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }


}
