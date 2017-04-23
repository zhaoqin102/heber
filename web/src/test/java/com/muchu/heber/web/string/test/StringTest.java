package com.muchu.heber.web.string.test;

import org.junit.jupiter.api.Test;

/**
 * @author 梁海鹏
 * @createTime 17-4-23 上午8:52
 */
public class StringTest {

    @Test
    public void reversalString() {
        String str = "abcdef";
        String x = str.substring(0, str.length() / 2);
        String y = str.substring(str.length() / 2);
        x = revere(x);
        y = revere(y);
        System.out.println(x);
        System.out.println(y);
        Object[] objects = reversalObject(new Object[]{x, y});
        for (Object object : objects) {
            System.out.print(object);
        }
        System.out.println();
    }

    private String revere(String str) {
        char[] chars = str.toCharArray();
        int i = 0, j = chars.length-1;
        while (i < j) {
           char temp = chars[i];
           chars[i++] = chars[j];
           chars[j--] = temp;
        }
        return new String(chars);
    }

    private Object[] reversalObject(Object[] objects){
        int i= 0,j = objects.length-1;
        while (i<j){
            Object object = objects[i];
            objects[i++] = objects[j];
            objects[j--] = object;
        }
        return objects;
    }
}
