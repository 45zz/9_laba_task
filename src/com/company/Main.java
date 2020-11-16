package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Exception1 exception=new Exception1();
       // exception.exceptionDemo1(); //ошибка
        exception.exceptionDemo2(); //бесконечность
        exception.exceptionDemo3(); //как 1 но нет ошибки
        System.out.println("-------------");
        Exception2 exception2=new Exception2();
        exception2.exceptionDemo("1"); //могу умею
        //exception2.exceptionDemo("1,2"); // не могу не умею не работаю
        //exception2.exceptionDemo("0"); // не могу не умею не работаю
        System.out.println("-------------");
        exception2.exceptionDemo2("1");
        exception2.exceptionDemo2("1,2"); // ошибку поймали
        exception2.exceptionDemo2("0"); // ошибку поймали
        System.out.println("-------------");
        ThrowsDemo throwsDemo=new ThrowsDemo();
        //throwsDemo.getDetails(null); // не могу не умею не работаю
        throwsDemo.getDetails2(null); // ошибку поймали
        //throwsDemo.printMessage(null);
        //throwsDemo.getDetails3(null); // выдает ошибку -_-
        throwsDemo.getDetails4(null);
        System.out.println("-------------");
        ThrowsDemo2 throwsDemo2=new ThrowsDemo2();
        throwsDemo2.getKey();
        throwsDemo2.printDetails(null);
        //throwsDemo2.getDetails(""); // выдает ошибку -_-
    }

    public static class Exception1 {

        public void exceptionDemo1() {
            System.out.println(2 / 0);
        }

        public void exceptionDemo2() {
            System.out.println(2.0 / 0.0);
        }

        public void exceptionDemo3() {
            try {
                System.out.println(2 / 0);
            } catch (ArithmeticException e) {
                System.out.println("Attempted division by zero");
            }
        }
    }

    public static class Exception2 {

        public void exceptionDemo(String i) {
            //Scanner myScanner = new Scanner( System.in );
            //System.out.print( "Enter an integer ");
            //String intString = myScanner.next();
            int x = Integer.parseInt(i);
            System.out.println(2 / x);
        }

        public void exceptionDemo2(String i) {
            //Scanner myScanner = new Scanner( System.in );
            //System.out.print( "Enter an integer ");
            //String intString = myScanner.next();
            try {
                int x = Integer.parseInt(i);
                System.out.println(2 / x);
            } catch (ArithmeticException e) {
                System.out.println("Attempted division by zero");
            } catch (NumberFormatException f) {
                System.out.println("Attempted wrong format");
            } finally {
                System.out.println("А почему бы и нет"); // все равно сделаю
            }
        }
    }
    public static class ThrowsDemo {
        public void getDetails(String key) {
            if(key.equals(null)) {
                throw new NullPointerException( "null key in getDetails" );
            } else {
                System.out.println(key);
            }
        }
        public void getDetails2(String key) {
            try {
                if(key.equals(null)) {
                    throw new NullPointerException( "null key in getDetails" );
                } else {
                    System.out.println(key);
                }
            } catch (NullPointerException e){
                System.out.println( "null key in getDetails" );
            }
        }

        public void printMessage(String key) {
            String message = getDetails3(key);
            System.out.println( message );
        }
        public String getDetails3(String key) {
            if(key == null) {
                throw new NullPointerException( "null key in getDetails" );
            }
            return "data for" + key;
        }
        public String getDetails4(String key) {
            try {
                if (key == null) {
                    throw new NullPointerException("null key in getDetails");
                }
            } catch (NullPointerException e){
                System.out.println("null key in getDetails");
            } finally {
                return "data for" + key;
            }
        }
    }
    public static class ThrowsDemo2 {
        public void getKey() {
            Scanner myScanner = new Scanner( System.in );
            String key = myScanner.next();
            printDetails( key );
        }
        public void printDetails(String key) {
            try {
                String message = getDetails(key);
                System.out.println( message );
            }
            catch ( Exception e){
                throw e;
            }
        }
        private String getDetails(String key) {
            if(key == "") {
                try {
                    throw new Exception( "Key set to empty string" );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return "data for " + key;
        }
    }
}

