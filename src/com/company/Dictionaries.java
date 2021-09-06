package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Dictionaries implements Connectable {
    private Dictionaries[] strings;
    public Dictionaries() throws Exception {
        Dictionaries[] dictionaries = readFile("Base.json");
        Dictionaries dictionary;
        for (Dictionaries dictionaries2: strings){
            printDictionary(dictionaries2);
        }
        openConnection();
        checkConnection();
        readStringWithIndex(strings);
        checkWithKey(strings);
        readWithKey(strings);
        returnSomeStrings(strings);
        countNotes(strings);
       // addNote(dictionary);
        updateValueWithIndex(strings);
        updateValueWithKey(strings);
        for (Dictionaries dictionaries1: strings){
        printDictionary(dictionaries1);
        }
        closeConnection();
    }

    String key;
    String value;
    private boolean isConnect;


    public Dictionaries(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void openConnection() {
        isConnect = true;
        System.out.println("Открыто");

    }

    @Override
    public void closeConnection() {
        isConnect = false;
        System.out.println("Закрыто");
    }

    @Override
    public void checkConnection() throws Exception {
        if (isConnect == false) {
            throw new Exception();
        } else {
            System.out.println("Есть соединение");
        }
    }

    public void readStringWithIndex(Dictionaries[] dictionaries) throws Exception {

        System.out.println("Введите индекс что бы считать строку");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x == 1) {
            System.out.print(dictionaries[0].key);
            System.out.println(dictionaries[0].value);
        } else if (x == 2) {
            System.out.print(dictionaries[1].key);
            System.out.println(dictionaries[1].value);
        } else if (x == 3) {
            System.out.print(dictionaries[2].key);
            System.out.println(dictionaries[2].value);
        } else if (x == 4) {
            System.out.print(dictionaries[3].key);
            System.out.println(dictionaries[3].value);
        } else if (x == 5) {
            System.out.print(dictionaries[4].key);
            System.out.println(dictionaries[4].value);
        } else throw new Exception();

    }

    @Override
    public void checkWithKey(Dictionaries[] dictionaries) throws Exception {
        System.out.println("Для проверки наличия записи введите ключ , провенряемой записи");
        if (dictionaries[0].key.equals("1")) {
            System.out.println("Записть по данному ключу есть = " + dictionaries[0].value);
        } else if (dictionaries[1].key.equals("2")) {
            System.out.println("Записть по данному ключу есть = " + dictionaries[1].value);
        } else if (dictionaries[2].key.equals("abc")) {
            System.out.println("Записть по данному ключу есть = " + dictionaries[2].value);
        } else if (dictionaries[3].key.equals("ABC")) {
            System.out.println("Записть по данному ключу есть = " + dictionaries[3].value);
        } else if (dictionaries[4].key.equals("meow")) {
            System.out.println("Записть по данному ключу есть = " + dictionaries[4].value);
        } else throw new Exception();
    }

    @Override
    public void readWithKey(Dictionaries[] d) throws Exception {
        System.out.println("Для считывания записи введите ключ");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        if (key.equals(d[0].key)) {
            System.out.println("Ключ = " + d[0].key + ". Значение = " + d[0].value);
        } else if (key.equals(d[1].key)) {
            System.out.println("Ключ = " + d[1].key + ". Значение = " + d[1].value);
        } else if (key.equals(d[2].key)) {
            System.out.println("Ключ = " + d[2].key + ". Значение = " + d[2].value);
        } else if (key.equals(d[3].key)) {
            System.out.println("Ключ = " + d[3].key + ". Значение = " + d[3].value);
        } else if (key.equals(d[4].key)) {
            System.out.println("Ключ = " + d[4].key + ". Значение = " + d[4].value);
        } else throw new Exception();
    }

    @Override
    public void returnSomeStrings(Dictionaries[] dictionaries) throws Exception {
        System.out.println("Для считывания некоторого набора записей введите индекс и конечный индекс");
        Scanner scanner = new Scanner(System.in);
        String f = "|%-5s|%-15s|";
        int index = scanner.nextInt();
        int indexEnd = scanner.nextInt();
        if (index == 1) {
            if (indexEnd == 1) {
                System.out.println(String.format(f,dictionaries[0].key , dictionaries[0].value));
            } else if (indexEnd == 2) {
                System.out.println(String.format(f,dictionaries[0].key + dictionaries[0].value));
                System.out.println(String.format(f,dictionaries[1].key + dictionaries[1].value));
            } else if (indexEnd == 3) {
                System.out.println(String.format(f,dictionaries[0].key + dictionaries[0].value));
                System.out.println(String.format(f,dictionaries[1].key + dictionaries[1].value));
                System.out.println(String.format(f,dictionaries[2].key + dictionaries[2].value));
            } else if (indexEnd == 4) {
                System.out.println(String.format(f,dictionaries[0].key + dictionaries[0].value));
                System.out.println(String.format(f,dictionaries[1].key + dictionaries[1].value));
                System.out.println(String.format(f,dictionaries[2].key + dictionaries[2].value));
                System.out.println(String.format(f,dictionaries[3].key + dictionaries[3].value));
            } else if (indexEnd == 5) {
                System.out.println(String.format(f,dictionaries[0].key + dictionaries[0].value));
                System.out.println(String.format(f,dictionaries[1].key + dictionaries[1].value));
                System.out.println(String.format(f,dictionaries[2].key + dictionaries[2].value));
                System.out.println(String.format(f,dictionaries[3].key + dictionaries[3].value));
                System.out.println(String.format(f,dictionaries[4].key + dictionaries[4].value));
            } else throw new Exception("Индекс не найден");
        } else if (index == 2) {
            if (indexEnd == 1) {
                throw new Exception("Нельзя вернуть предыдущую строку");
            } else if (indexEnd == 2) {
                System.out.println(String.format(f,dictionaries[1].key + dictionaries[1].value));
            } else if (indexEnd == 3) {
                System.out.println(String.format(f,dictionaries[1].key + dictionaries[1].value));
                System.out.println(String.format(f,dictionaries[2].key + dictionaries[2].value));
            } else if (indexEnd == 4) {
                System.out.println(String.format(f,dictionaries[1].key + dictionaries[1].value));
                System.out.println(String.format(f,dictionaries[2].key + dictionaries[2].value));
                System.out.println(String.format(f,dictionaries[3].key + dictionaries[3].value));
            } else if (indexEnd == 5) {
                System.out.println(String.format(f,dictionaries[1].key + dictionaries[1].value));
                System.out.println(String.format(f,dictionaries[2].key + dictionaries[2].value));
                System.out.println(String.format(f,dictionaries[3].key + dictionaries[3].value));
                System.out.println(String.format(f,dictionaries[4].key + dictionaries[4].value));
            } else throw new Exception("Индекс не найден");
        } else if (index == 3) {
            if (indexEnd == 1) {
                throw new Exception("Нельзя вернуть предыдущую строку");
            } else if (indexEnd == 2) {
                throw new Exception("Нельзя вернутьь предыдущую строку");
            } else if (indexEnd == 3) {
                System.out.println(String.format(f,dictionaries[2].key + dictionaries[2].value));
            } else if (indexEnd == 4) {
                System.out.println(String.format(f,dictionaries[2].key + dictionaries[2].value));
                System.out.println(String.format(f,dictionaries[3].key + dictionaries[3].value));
            } else if (indexEnd == 5) {
                System.out.println(String.format(f,dictionaries[2].key + dictionaries[2].value));
                System.out.println(String.format(f,dictionaries[3].key + dictionaries[3].value));
                System.out.println(String.format(f,dictionaries[4].key + dictionaries[4].value));
            } else throw new Exception("Индекс не найден");
        } else if (index == 4) {
            if (indexEnd == 1) {
                throw new Exception("Нельзя вернуть предыдущую строку");
            } else if (indexEnd == 2) {
                throw new Exception("Нельзя вернутьь предыдущую строку");
            } else if (indexEnd == 3) {
                throw new Exception("НЕльзя вернуть предыдущую строку");
            } else if (indexEnd == 4) {
                System.out.println(String.format(f,dictionaries[3].key + dictionaries[3].value));
            } else if (indexEnd == 5) {
                System.out.println(String.format(f,dictionaries[3].key + dictionaries[3].value));
                System.out.println(String.format(f,dictionaries[4].key + dictionaries[4].value));
            } else throw new Exception("Индекс не найден");
        } else if (index == 5) {
            if (indexEnd == 1) {
                throw new Exception("Нельзя вернуть предыдущую строку");
            } else if (indexEnd == 2) {
                throw new Exception("Нельзя вернутьь предыдущую строку");
            } else if (indexEnd == 3) {
                throw new Exception("Нельзя вернуть предыдущую строку");
            } else if (indexEnd == 4) {
                throw new Exception("Нельзя вернуть предыдущую строку");
            } else if (indexEnd == 5) {
                System.out.println(String.format(f,dictionaries[4].key + dictionaries[4].value));
            } else throw new Exception("Индекс не найден");
        } else throw new Exception("Индекс не найден");
    }

    @Override
    public void countNotes(Dictionaries[] dictionaries) {
        System.out.println("Количество записей в базе" + dictionaries.length);
    }

    @Override
    public void addNote(Dictionaries dictionaries) {
        System.out.println("Ведите новые ключ и значение");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        String value = scanner.nextLine();
        String f = "|%-5s|%-15s|";
        System.out.println(String.format(f, dictionaries.getKey() + dictionaries.getValue()));
        System.out.println(String.format(f, key, value));


    }

    @Override
    public void updateValueWithIndex(Dictionaries[] dictionaries) throws Exception {
        String f = "|%-5s|%-15s|";
        System.out.println("Введите индекс для смены значения");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a == 1) {
            System.out.println("Введите новое значение");
            String newValue = scanner.nextLine();
            System.out.println("Новая строка");
            System.out.println(String.format(f, dictionaries[0].key, newValue));
        } else if (a == 2) {
            System.out.println("Введите новое значение");
            String newValue = scanner.nextLine();
            System.out.println("Новая строка");
            System.out.println(String.format(f, dictionaries[1].key, newValue));
        } else if (a == 3) {
            System.out.println("Введите новое значение");
            String newValue = scanner.nextLine();
            System.out.println("Новая строка");
            System.out.println(String.format(f, dictionaries[2].key, newValue));
        } else if (a == 4) {
            System.out.println("Введите новое значение");
            String newValue = scanner.nextLine();
            System.out.println("Новая строка");
            System.out.println(String.format(f, dictionaries[3].key, newValue));
        } else if (a == 5) {
            System.out.println("Введите новое значение");
            String newValue = scanner.nextLine();
            System.out.println("Новая строка");
            System.out.println(String.format(f, dictionaries[4].key, newValue));
        } else throw new Exception("Индекс не найден");


    }

    @Override
    public void updateValueWithKey(Dictionaries[] dictionaries) throws Exception {
        String f = "|%-5s|%-15s|";
        System.out.println("Для обновления содержимого записи введите ключ");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        if (key.equals(dictionaries[0].key)) {
            System.out.println("Введите новое значение");
            String newValue = scanner.nextLine();
            System.out.println(String.format(f, dictionaries[0].key, newValue));
        } else if (key.equals(dictionaries[1].key)) {
            System.out.println("Введите новое значение");
            String newValue = scanner.nextLine();
            System.out.println(String.format(f, dictionaries[1].key, newValue));
        } else if (key.equals(dictionaries[2].key)) {
            System.out.println("Введите новое значение");
            String newValue = scanner.nextLine();
            System.out.println(String.format(f, dictionaries[2].key, newValue));
        } else if (key.equals(dictionaries[3].key)) {
            System.out.println("Введите новое значение");
            String newValue = scanner.nextLine();
            System.out.println(String.format(f, dictionaries[3].key, newValue));
        } else if (key.equals(dictionaries[4].key)) {
            System.out.println("Введите новое значение");
            String newValue = scanner.nextLine();
            System.out.println(String.format(f, dictionaries[4].key, newValue));
        } else throw new Exception("Ключ не найден");
    }
    public  Dictionaries[] readFile(String fileName) throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(fileName)) {
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            Dictionaries[] dictionaries = new Dictionaries[jsonArray.size()];
            Integer q = 0;
            for (Object o : jsonArray) {
                JSONObject fact = (JSONObject) o;

                dictionaries[q] = new Dictionaries(
                        (String) fact.get("key"),
                        (String) fact.get("value")) {
                };
                q = q + 1;
            }
            strings = dictionaries;
            return dictionaries;
        }
    }

    private static void printDictionary(Dictionaries dictionaries) {
        String f = "|%-5s|%-15s|";
        System.out.println(String.format(f, dictionaries.getKey(), dictionaries.getValue()));

    }

}
