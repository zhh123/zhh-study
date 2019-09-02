package javabasic.equalAndHashcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author:zhh
 * @Date:Created in 16:09 2019/8/31 0031
 */
public class CreateObject {

    @Test
    public void test1(){
        User user1 = new User("1");
        User user2 = new User("1");
        System.out.println("user1 hashcode: "+user1.hashCode()+" user1: "+user1);
        System.out.println("user2 hashcode: "+user2.hashCode()+" user2: "+user2);
        System.out.println("user1.equal(user2): "+user1.equals(user2));
        Set<User> sets = new HashSet<>();
        sets.add(user1);
        sets.add(user2);
        System.out.println("sets size: "+sets.size());
        List<Integer> list = new ArrayList();


    }
}