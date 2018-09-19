package com.codecool.krk.controllers;
import java.util.Iterator;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Set;

public class StatisticalAnalysis{

    private Iterator<String> iterator;
    private HashMap<String, Integer> occurencies = new HashMap<String, Integer>();
    public StatisticalAnalysis(Iterator<String> iterator) throws IOException{
        this.iterator = iterator;
        countOccurencies();
    }


    
    public int countOf(String ... text){
        int count = 0;
        for(String x : text){
            Integer value = occurencies.get(x);
            if(value != null){
                count += (int) value;
            }else{
                continue;
            }
        }
        return count;
    }


    public int numberOf(){
        int count = 0;
        for(String key : occurencies.keySet()){
            System.out.println(key);
            count+= occurencies.get(key);
        }
        return count;
    }


    public int dictionarySize(){
        return occurencies.keySet().size();
   
    }


    public int vowelsCount(){
        int count = 0;
        for(String key : occurencies.keySet()){
            if(key.equals("a") || key.equals("e") || key.equals("i") || key.equals("o") || key.equals("u")){
                count += occurencies.get(key);
            }
        }
        float tempCount = ((numberOf()/count) *10);
        return (int) tempCount;
    }




    public Set<String> occureMoreThan(Integer number){
        try{
            TreeSet<String> properWords = new TreeSet<String>();
            for(String key : occurencies.keySet()){
                if(occurencies.get(key) > number){
                    if(properWords.size() % 10 == 0){
                        properWords.add(key + "\n");
                    }else{
                        properWords.add(key);
                    }
                    
                }
            }
            return properWords;
        }catch(NullPointerException e){
            return null;
        }

    }

    private void countOccurencies(){
        while(iterator.hasNext()){
            String word = iterator.next();
            if(occurencies.containsKey(word)){
                Integer value = occurencies.get(word);
                occurencies.put(word, value + 1);
            }else{
                occurencies.put(word, 1);
            }
        }
    }



}