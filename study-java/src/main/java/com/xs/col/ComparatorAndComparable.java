package com.xs.col;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ClassName: ComparatorAndComparable
 * Package: com.xs.basic
 * Description:
 *
 * @Author 高伟
 * @Create 2025/3/5 17:45
 * @Version 1.0
 */
public class ComparatorAndComparable {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "张三";
        p1.age = 20;
        Person p2 = new Person();
        p2.name = "李四";
        p2.age = 30;
        List<Person> peoples = new ArrayList<>();
        peoples.add(p2);
        peoples.add(p1);
//        Collections.sort(peoples);
    }

}

class Person implements Comparator<Person> {
    public String name;
    public int age;

    @Override
    public int compare(Person o1, Person o2) {
        return o1.age - o2.age;
    }
}
