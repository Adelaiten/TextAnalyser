package com.codecool.krk.controllers;
import java.util.Iterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import com.codecool.krk.iterators.IterableText;
import com.codecool.krk.iterators.CharIterator;
import com.codecool.krk.iterators.WordIterator;

public class FileContent implements IterableText{
    private ArrayList<String> charArray;
    private ArrayList<String> wordArray;
    private String fileName;
    private String fileText;

    public FileContent(String file) throws IOException{
        this.fileName = file;
        wordArray = new ArrayList<String>();
        fileText = readFile();
        charArray = splitToStringCharacters();
        addToWordArray();
    }

    public Iterator<String> charIterator() throws IOException{
        return new CharIterator(this);
    }

    public Iterator<String> wordIterator() throws IOException{
        return new WordIterator(this);
    }

    public String getFileName(){
        return fileName;
    }

    public ArrayList<String> getCharArray(){
        return charArray;
    }

    public ArrayList<String> getWordArray(){
        return wordArray;
    }

    private String readFile() throws IOException{
        File file = new File(fileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line = bufferedReader.readLine();
        while(line != null){
            sb.append(line + " ");
            line = bufferedReader.readLine();
        
        }
        return sb.toString();

    }


    private ArrayList<String> splitToStringCharacters() throws IOException{
        ArrayList<String> stringCharsArray = new ArrayList<String>();
        for(char x : fileText.replaceAll("\\W+", "").toLowerCase().toCharArray()){
            stringCharsArray.add(String.valueOf(x));
        }
        return stringCharsArray;
    }


    private void addToWordArray(){
        String[] tempArray = fileText.split("\\W+");
        for(String x : tempArray){
            wordArray.add(x);
            
        }
        
    }
}