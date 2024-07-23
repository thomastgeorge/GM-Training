package com.assignmet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoOnArrayDeque {

    public static void main(String[] args) {

        ArrayDeque<User> arr = new ArrayDeque<>();

        arr.add(new User(1, "User"));
        arr.add(new User(2, "Kille"));
        arr.add(new User(3, "Poyee"));
        arr.add(new User(4, "Ayoooooo"));
        
       

        System.out.println("Users in ArrayDeque:");
        System.out.println(arr);
        
        System.out.println("Deque First inserted user is removed: " + arr.remove());

        System.out.println("Users in ArrayDeque:");
        for (User user : arr) {
            System.out.println(user.getId() + " " + user.getName());
        }

        User checkUser = new User(3, "World");
        System.out.println("Checking if user is present or not: " + arr.contains(checkUser));

        System.out.println();
        arr.add(new User(5, "Amban"));

        for (User user : arr) {
            System.out.println(user.getId() + " " + user.getName());
        }
        
        List<User> userList = new ArrayList<>(arr);

        Collections.sort(userList, new DemoComparator());

        System.out.println("Prinitng sorted value:");
        for (User user : userList) {
            System.out.println(user.getId() + " " + user.getName());
        }
    }
    
}