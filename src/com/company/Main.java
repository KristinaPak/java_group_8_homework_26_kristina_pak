package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("|Ключ |Значение       |");
        System.out.println("+-----+---------------+");
        Dictionaries dictionaries = new Dictionaries();
        printDictionary(dictionaries);
    }
    private static void printDictionary(Dictionaries dictionaries) {
        String f = "|%-5s|%-15s|";
        System.out.println(String.format(f, dictionaries.getKey(), dictionaries.getValue()));

    }
}




