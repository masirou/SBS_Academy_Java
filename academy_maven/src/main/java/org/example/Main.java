package org.example;

import com.google.gson.Gson;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();/*
        Person person = new Person("마시로" ,16, 171.6);
        String json = gson.toJson(person);
        System.out.println(json);
        File file = new File("data.json");

        if(!file.exists()) file.createNewFile();


        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(json);
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();*/
        File file = new File("data.json");
        Person person;
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String json = bufferedReader.readLine();
        bufferedReader.close();
        fileReader.close();

        person = gson.fromJson(json, Person.class);
        person.printInfo();


    }
}