package com.leon;

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
        System.out.println(500 * ((2 << i) - 1) / 1000);
        }
    }
}
