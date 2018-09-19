package com.codecool.krk.iterators;
import java.util.Iterator;
import com.codecool.krk.controllers.FileContent;





public class CharIterator implements Iterator{
    private FileContent fileContent;
    private int currentIndex;
    

    public CharIterator(FileContent fileContent){

        this.fileContent = fileContent;
        currentIndex = 0;

    }

    
    public boolean hasNext(){
        return currentIndex < fileContent.getCharArray().size() && fileContent.getCharArray() != null;
       
    }

    public String next(){
        return fileContent.getCharArray().get(currentIndex++);

    }


}