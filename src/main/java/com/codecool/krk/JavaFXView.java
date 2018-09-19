package com.codecool.krk;
import javafx.collections.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

import java.io.IOException;

import javafx.application.*;

public class JavaFXView extends Application{
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage myStage) throws IOException{
        myStage.setTitle("Text Analyser");
        Root root = new Root();
 
        Scene myScene = new Scene(root, 1400, 900);
        myStage.setScene(myScene);
        myStage.show();
    }
}