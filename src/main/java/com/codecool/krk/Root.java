package com.codecool.krk;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import com.codecool.krk.controllers.StatisticalAnalysis;
import com.codecool.krk.controllers.FileContent;


public class Root extends Pane{
    
    private FileContent fileContent;
    private StatisticalAnalysis charAnalysis;
    private StatisticalAnalysis wordAnalysis;
    private TextField textFile;
    private TextField numberWords;
    private TextField wordsToCount;
    private Button submit;
    private Label label;


    Root() throws IOException{
        initSubmit();
        initTextFile();
        initNumberWords();
        initWordsToCount();
        initLabel();


    }


 

    private void initSubmit(){
        submit = new Button("Submit");
        getChildren().add(submit);
        submit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                if((textFile.getText() != null && !textFile.getText().isEmpty()) && (numberWords.getText() != null && !numberWords.getText().isEmpty())){
                    
                    String[] countOfText;
                    if(wordsToCount.getText() != null && !wordsToCount.getText().isEmpty()){
                        countOfText = wordsToCount.getText().split(" ");
                    }else{
                        countOfText = new String[0]; 
                    }
                        
                    Integer nWords = Integer.parseInt(numberWords.getText()); 
                    long start = System.nanoTime();

                    try{
                        fileContent = new FileContent("src/main/resources/" + textFile.getText());
                        charAnalysis = new StatisticalAnalysis(fileContent.charIterator());
                        wordAnalysis = new StatisticalAnalysis(fileContent.wordIterator());
                    }catch(IOException t){
                        
                    }

                    long elapsedTime = System.nanoTime() - start;
                    double seconds = (double)elapsedTime / 1000000000.0;
                    label.setText("==" + textFile.getText() + "==\n" + "Char count: " + charAnalysis.numberOf() + "\n" + "Word count: " + wordAnalysis.numberOf() + "\n" + "Dict count: " + wordAnalysis.dictionarySize() + "\n" + "Most used words" + "(>" + nWords + ") "  + wordAnalysis.occureMoreThan(nWords) + "\n" + "\n\ncount: " + charAnalysis.countOf(countOfText) + "\n" + "Time " +  seconds);
                }
            }
        });
    }

    private void initTextFile(){
        textFile = new TextField();
        textFile.setPromptText("Enter file name");
        textFile.setPrefColumnCount(10);
        textFile.setLayoutX(70);
        getChildren().add(textFile);
    }


    private void initNumberWords(){
        numberWords = new TextField();
        numberWords.setPromptText("Words more than(Integer)");
        numberWords.setPrefColumnCount(10);
        numberWords.setLayoutX(220);
        getChildren().add(numberWords);
    }

    private void initWordsToCount(){
        wordsToCount = new TextField();
        wordsToCount.setPromptText("Words to count");
        wordsToCount.setPrefColumnCount(15);
        wordsToCount.setLayoutX(370);
        getChildren().add(wordsToCount);
    }


    private void initLabel(){
        label = new Label();
        label.setLayoutX(200);
        label.setLayoutY(100);
        getChildren().add(label);
    }


}