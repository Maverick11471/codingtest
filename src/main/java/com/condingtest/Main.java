package com.condingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    String bomb = br.readLine();

    StringBuilder sb = new StringBuilder();

    int bombLength = bomb.length();
    for (int i = 0; i < str.length(); i++) {
      sb.append(str.charAt(i));

      if (sb.length() >= bombLength) {
        boolean flag = true;
        for (int j = 0; j < bombLength; j++) {
          if (sb.charAt(sb.length() - bombLength + j) != bomb.charAt(j)) {
            flag = false;
            break;
          }
        }
        if (flag) {
          sb.delete(sb.length() - bombLength, sb.length());
        }
      }
    }

    if (sb.length() == 0) {
      System.out.println("FRULA");
    } else {
      System.out.println(sb.toString());
    }
  }
}
