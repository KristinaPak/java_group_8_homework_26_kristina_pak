package com.company;

public interface Connectable {
    void openConnection();
    void closeConnection();
    void checkConnection() throws Exception;
    void readStringWithIndex(Dictionaries[] dictionaries) throws Exception;
    void checkWithKey(Dictionaries[] dictionaries) throws Exception;
    void readWithKey(Dictionaries[] dictionaries) throws Exception;
    void returnSomeStrings(Dictionaries[] dictionaries) throws Exception;
    void countNotes(Dictionaries[] dictionaries);
    void addNote(Dictionaries dictionaries);
    void updateValueWithIndex(Dictionaries[] dictionaries) throws Exception;
    void updateValueWithKey(Dictionaries[] dictionaries) throws Exception;
}
