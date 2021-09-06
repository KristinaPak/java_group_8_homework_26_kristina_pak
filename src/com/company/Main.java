package com.company;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
            System.out.println("|Ключ |Значение       |");
            System.out.println("+-----+---------------+");
            Dictionaries[] dictionaries = readFile("Base.json");

            for (Dictionaries dictionary : dictionaries) {
                printDictionary(dictionary);
        }
    }

    private static void printDictionary(Dictionaries dictionaries) {
        String f = "|%-5s|%-15s|";
        System.out.println(String.format(f, dictionaries.getKey(), dictionaries.getValue()));
    }

    public static Dictionaries[] readFile(String fileName) throws IOException, ParseException {

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
            return dictionaries;
        }
    }
}
