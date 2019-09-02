package com.zhh.dynamicAgent.cglib;

/**
 * @Author:zhh
 * @Date:Created in 14:57 2019/6/11 0011
 */
public class BookFacadeImpl implements IBookFacade{
    @Override
    public void addBook(String bookName) {
        System.out.println("addBook name: "+bookName);
    }

   /* @Override
    public void updateBook(String oldName, String newName) {
        System.out.println("updateBook oldName: "+oldName+" newName: "+newName);
    }*/

    @Override
    public void getBook() {
        System.out.println("getBook");
    }
}