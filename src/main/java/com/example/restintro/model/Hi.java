package com.example.restintro.model;

import java.util.ArrayList;
import java.util.List;

public class Hi {

    private String msg = "Hi";
    private int number = 0;
    private ArrayList<String> triple = new ArrayList<>();

    public Hi(){}

    public Hi(boolean n){
        triple.add("hello");
        triple.add("wave");
        triple.add("fistbump");

    }

    public ArrayList<String> addUser(String newUser){
        triple.add(newUser);
        return triple;
    }

    public void deleteUser(String deleteUser){
        if(triple.contains(deleteUser)){
            int x = triple.indexOf(deleteUser);
            triple.remove(x);
        }
    }
    public void editFromTo(String from, String to){

        if(triple.contains(from)){
            int x = triple.indexOf(from);
            triple.set(x, to);
        }
    }

    public ArrayList<String> getTriple(){
        return triple;
    }

    public int getNumber(){
        return number;
    }

    public String getMsg(){
        return msg;
    }
}
