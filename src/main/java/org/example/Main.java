package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1)
        String str1 = "Привет, Вася!";
        String str2 = "Вас";
        System.out.println(String.format("Вхождение: %1$d",str1.indexOf(str2)));
        // 2)
//        String str3 = "12345";
//        String str4 = "54321";
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите первую строку для проверки на вращение двух строк: ");
        String str3 = scanner.nextLine();
        System.out.printf("Введите вторую: ");
        String str4 = scanner.nextLine();
        boolean reverse = isReverse(str3,str4);
        System.out.println(reverse);
    }
    public static boolean isReverse(String str1, String str2){
        int left = 0;
        int right = str2.length()-1;
        while(left<str2.length()){
            if(str1.charAt(left)!=str2.charAt(right)){
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}