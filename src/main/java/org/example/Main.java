package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1)
        String str1 = "Привет, Вася!";
        String str2 = "Вас";
        System.out.println(String.format("Вхождение: %1$d",str1.indexOf(str2)));
        // 2) вращение, если я правильно понял задание
        String str3 = "12345";
        String str4 = "54321";
//        Scanner scanner = new Scanner(System.in);
//        System.out.printf("Введите первую строку для проверки на вращение двух строк: ");
//        String str3 = scanner.nextLine();
//        System.out.printf("Введите вторую: ");
//        String str4 = scanner.nextLine();
//        scanner.close();
        boolean reverse = isReverse(str3,str4);
        System.out.println(String.format("Переходит ли строка %1$s в %2$s: %3$s",str3,str4,reverse));
        // 3) реверс и рекурсия
        String str5 = "1234567";
        System.out.println(String.format("Строка изначальная: %1$s",str5));
        StringBuilder sb = new StringBuilder(str5);
        StringBuilder sbReverse = reverse(sb);
        System.out.println(String.format("Реверс: %1$s",sbReverse));
        StringBuilder sbRecurse = recurse(sb,sb.length()-1);
        System.out.println(String.format("Рекурсия: %1$s",sbRecurse));
        // 4) Два числа
        int n1 = 3;
        int n2 = 54;
        StringBuilder numberSum = numbersSum(n1,n2);
        System.out.println(numberSum);
        //
        StringBuilder numberRazn = new StringBuilder();
        numberRazn.append(Integer.toString(n1)).append(" - ").append(Integer.toString(n2));
        numberRazn.append(" = ").append(Integer.toString(n1-n2));
        System.out.println(numberRazn);
        //
        StringBuilder numberPower = new StringBuilder(Integer.toString(n1));
        numberPower.append(" * ").append(Integer.toString(n2)).append(" = ").append(Integer.toString(n1*n2));
        System.out.println(numberPower);
        // 5) равно
        StringBuilder numberSum2= new StringBuilder(numberSum);
        String numberSum3= numberSum.toString();
        numberSum.insert(numberSum.indexOf("="),"равно");
        numberSum.deleteCharAt(numberSum.indexOf("="));
        System.out.println(numberSum);
        //
        numberRazn.insert(numberRazn.indexOf("="),"равно");
        numberRazn.deleteCharAt(numberRazn.indexOf("="));
        System.out.println(numberRazn);
        //
        numberPower.insert(numberPower.indexOf("="),"равно");
        numberPower.deleteCharAt(numberPower.indexOf("="));
        System.out.println(numberPower);
        // 6) replace
        numberSum2.replace(numberSum2.indexOf("="),numberSum2.indexOf("=")+1,"равно");
        System.out.println(numberSum2);
        // 7) Сравнение времени выполнения
        StringBuilder numbers = new StringBuilder();
        numbers.append(Integer.toString(n1));
        numbers.append(" + ");
        numbers.append(Integer.toString(n2));
        //numbers.append(" = ");// append(Integer.toString(n1+n2));
        var timeBegin = System.currentTimeMillis();
        String stringNumber = numbers.toString();
        for(int i = 0; i<10000; i++){
            stringNumber+="=";
        }
        stringNumber+=Integer.toString(n1+n2);
        var timeEnd = System.currentTimeMillis()-timeBegin;
        System.out.println(String.format("Время со String: %1$d",timeEnd));
        //
        timeBegin = System.currentTimeMillis();
        StringBuilder sbNumber = numbers;
        for(int i = 0; i<10000; i++){
            sbNumber.append("=");
        }
        sbNumber.append(Integer.toString(n1+n2));
        timeEnd = System.currentTimeMillis()-timeBegin;
        System.out.println(String.format("Время со StringBuilder: %1$d",timeEnd));
    }
    public static StringBuilder numbersSum(int n1, int n2){
        StringBuilder numbers = new StringBuilder();
        numbers.append(Integer.toString(n1));
        numbers.append(" + ");
        numbers.append(Integer.toString(n2));
        numbers.append(" = ").append(Integer.toString(n1+n2));
        return numbers;
    }
    public static StringBuilder reverse(StringBuilder str){
        StringBuilder result = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--){
            result.append(str.charAt(i));
        }
        return result;
    }
    public static StringBuilder recurse(StringBuilder str,int n){
        StringBuilder result = new StringBuilder().append(str.charAt(n));
        if(n>0)
            result.append(recurse(str,n-1));
        return result;
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