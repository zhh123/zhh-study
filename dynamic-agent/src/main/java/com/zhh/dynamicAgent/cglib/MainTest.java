package com.zhh.dynamicAgent.cglib;

/**
 * @Author:zhh
 * @Date:Created in 15:10 2019/6/11 0011
 */
public class MainTest {

    public static void main(String[] args){
        BookFacadeCglib bookFacadeCglib = new BookFacadeCglib();
        IBookFacade iBookFacade = (IBookFacade) bookFacadeCglib.createProxy(BookFacadeImpl.class);
        iBookFacade.getBook();
      /*  BookFacadeImpl bookFacade = bookFacadeCglib.createProxy(BookFacadeImpl.class);
        bookFacade.addBook("aaaaa");*/


    }
}