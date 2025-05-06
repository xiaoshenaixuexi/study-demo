package com.xs.col;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: HashMapStudy
 * Package: com.xs.col
 * Description:
 *
 * @Author 高伟
 * @Create 2025/3/6 10:07
 * @Version 1.0
 */
public class HashMapStudy {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(16, 0.75f);
        Integer v1 = map.put("a", 1);
        System.out.println(v1);
        Integer a = map.put("a", 2);
        System.out.println(a);
    }

}
