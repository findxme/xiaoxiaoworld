package com.xmx.ssm.dao;

import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.entity.TBookReader;
import com.xmx.ssm.entity.TBookReaderExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.xmx.ssm.entity.TReader;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TBookReaderMapper {

    List<Map<String,Object>> pagingInfo(@Param("currentIndex")Integer currentIndex,@Param("pageSize")Integer pageSize);

    List<TBookReader> queryInfoByBookReaderDate(@Param("bookNo")String bookNo,@Param("readerNo")String readerNo);

    List<Map<String,Object>> findAll();

    long countByExample(TBookReaderExample example);

    int deleteByExample(TBookReaderExample example);

    int deleteByPrimaryKey(@Param("bBookReaderId") Integer bBookReaderId, @Param("bBookNo") String bBookNo, @Param("bReaderNo") String bReaderNo, @Param("bUserNo") String bUserNo);

    int insert(TBookReader record);

    int insertSelective(TBookReader record);

    List<TBookReader> selectByExample(TBookReaderExample example);

    TBookReader selectByPrimaryKey(@Param("bBookReaderId") Integer bBookReaderId, @Param("bBookNo") String bBookNo, @Param("bReaderNo") String bReaderNo, @Param("bUserNo") String bUserNo);

    int updateByExampleSelective(@Param("record") TBookReader record, @Param("example") TBookReaderExample example);

    int updateByExample(@Param("record") TBookReader record, @Param("example") TBookReaderExample example);

    int updateByPrimaryKeySelective(TBookReader record);

    int updateByPrimaryKey(TBookReader record);

    int borrowOrReturnBook(@Param("tBook")TBook tBook, @Param("tReader")TReader tReader);

    /*查询多少书借出去了*/
    long findReadersBorrowingQuantity();

    /*查询当天借阅记录*/
    @Select("SELECT\n" +
            "\tt_book_reader.b_book_reader_id,\n" +
            "\tt_book_reader.b_book_no,\n" +
            "\tt_book.b_book_name,\n" +
            "\tt_book_reader.b_user_no,\n" +
            "\tt_admin.b_admin_name,\n" +
            "\tt_book_reader.b_reader_no,\n" +
            "\tt_reader.b_reader_name,\n" +
            "\tt_book_reader.b_borrow_date,\n" +
            "\tt_book_reader.is_return_book\n" +
            "FROM\n" +
            "\tt_book_reader,\n" +
            "\tt_reader,\n" +
            "\tt_book,\n" +
            "\tt_admin\n" +
            "WHERE\n" +
            "\tt_book_reader.b_book_no = t_book.b_book_no\n" +
            "\tAND t_book_reader.b_user_no = t_admin.b_admin_no\n" +
            "\tAND t_book_reader.b_reader_no = t_reader.b_reader_no\n" +
            "\tAND t_book_reader.b_borrow_date = date_format(now(), '%Y-%m-%d' ) limit #{currIndex},#{pageSize};")
    List<Map<String,Object>> selectDay(@Param("currIndex") int currIndex,@Param("pageSize") int pageSize);

    long countBydayQuantity();
}