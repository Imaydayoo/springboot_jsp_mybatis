package com.hang.springboot_end.dao;

import com.hang.springboot_end.domain.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface BookMapper {

    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(@Param("bookID") int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books queryBookById(@Param("bookID")int id);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();

    Books queryBookByName(@Param("bookName") String bookName);

}
