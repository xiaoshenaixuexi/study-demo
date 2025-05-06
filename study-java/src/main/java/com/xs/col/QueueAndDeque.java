package com.xs.col;

import java.util.*;

/**
 * ClassName: QueueAndDeque
 * Package: com.xs.col
 * Description:
 *
 * @Author 高伟
 * @Create 2025/3/6 09:27
 * @Version 1.0
 */
public class QueueAndDeque {

    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>(16, 0.75f, true);
        ArrayDeque<String> deque = new ArrayDeque<>();
        PriorityQueue<Animal> queue = new PriorityQueue<Animal>((a1, a2) -> {
            return a1.age - a2.age;
        });
        queue.add(new Animal("a1", 2));
        queue.add(new Animal("a2", 1));
        Animal peek = queue.peek();
        System.out.println(peek.name);
    }

}

class Animal {

    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
