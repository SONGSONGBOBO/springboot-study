package com.example.cache.utils;

import javax.xml.crypto.Data;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author songbo
 * @Date 19-8-24 下午7:14
 **/
public class Dog extends Animal {
    int x=2;
    public Dog(){
        System.out.println("d");
    }

    public static void main(String[] args) {
        Animal animal = new Dog();
        System.out.println(animal.x);
    }
}
