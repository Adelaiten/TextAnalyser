package com.codecool.krk.iterators;
import java.util.Iterator;
import com.codecool.krk.controllers.FileContent;


public class WordIterator implements Iterator{
    private FileContent fileContent;
    private int currentIndex;


    public WordIterator(FileContent fileContent){
        this.fileContent = fileContent;
        currentIndex = 0;

    }

    public boolean hasNext(){
      return currentIndex < fileContent.getWordArray().size() && fileContent.getWordArray() != null;
    }


    public String next(){
        return fileContent.getWordArray().get(currentIndex++);
    }



}