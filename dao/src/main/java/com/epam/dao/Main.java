package com.epam.dao;

import java.util.Map;

/**
 * Main class for own tests
 */
public class Main {
    public static void main(String[] args) {

        String java_home = System.getenv("PATH");

        System.out.println(java_home);

        Map<String, String> env = System.getenv();
        System.out.println(System.getenv("PSusername"));
        System.out.println(System.getenv("PSpassword"));

        // Java 8
       // env.forEach((k, v) -> System.out.println(k + ":" + v));

        // Classic way to loop a map
      /*for (Map.Entry<String, String> entry : env.entrySet()) {
          System.out.println(entry.getKey() + " : " + entry.getValue());
      }*/

    }
}
