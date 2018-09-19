package com.codecool.krk.views;
import java.io.IOException;
import com.codecool.krk.controllers.FileContent;
import com.codecool.krk.controllers.StatisticalAnalysis;

public class View{

    String fileName;
    FileContent fileContent;
    StatisticalAnalysis charAnalysis;
    StatisticalAnalysis wordAnalysis;
    
    View(String fileName) throws IOException{
        this.fileName = fileName;
        fileContent = new FileContent(fileName);
        charAnalysis = new StatisticalAnalysis(fileContent.charIterator());
        wordAnalysis = new StatisticalAnalysis(fileContent.wordIterator());
    }

    public void printView(Integer numberWords, String ...text) throws IOException{
        System.out.println("==" + fileName + "==");
        System.out.println("Char count: " + charAnalysis.numberOf());
        System.out.println("Word count: " + wordAnalysis.numberOf());
        System.out.print("Dict count: " + wordAnalysis.dictionarySize() + "\n");
        System.out.print("Most used words" + "(>" +numberWords + ") "  + wordAnalysis.occureMoreThan(numberWords) + "\n");
        for(String x : text){
            System.out.print(x + " ");
        }
        System.out.print("count: " + charAnalysis.countOf(text) + "\n");
        

    }
}