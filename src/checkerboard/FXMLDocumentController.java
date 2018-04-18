/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Shihui Xiong
 */
public class FXMLDocumentController implements Initializable, Starts {
    
    private Stage stage;
    
    private int numRows;
    private int numCols;
    
    private double boardWidth;
    private double boardHeight;

    private Color darkColor;
    private Color lightColor;
    
     private double cha;
     
    private CheckerBoard Board;
    
   @FXML
    private MenuBar menuBar;
       
   @FXML 
    private AnchorPane anchor;

    
    @FXML
    private void handleGrid16(ActionEvent event) {
        numRows = 16;
        numCols = 16;
        createBoard();
    }
    
    @FXML
    private void handleGridDefault(ActionEvent event) {
        numRows = 8;
        numCols = 8;
        createBoard();
    }
    
    @FXML
    private void handleGrid10(ActionEvent event) {
        numRows = 10;
        numCols = 10;
        createBoard();
    }
    @FXML
    private void handleGrid3(ActionEvent event) {
        numRows = 3;
        numCols = 3;
        createBoard();                     // The way it uses "switch" and "case" makes the program a lot shorter and looks better
    }
    
    @FXML
    private void handleColorDefault(ActionEvent event) {
        lightColor = Color.RED;
        darkColor = Color.BLACK;
        createBoard();
            
    }
    
    @FXML
    private void handleColorBlue(ActionEvent event) {
        lightColor = Color.SKYBLUE;
        darkColor = Color.DARKBLUE;
        createBoard();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
     public void start(Stage stage) {
        this.stage = stage;
        numRows = 8;
        numCols = 8;
        lightColor = Color.RED;
        darkColor = Color.BLACK;
        cha = stage.getHeight() - anchor.getHeight();
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            createBoard();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        createBoard();
    }
    
    
     private void createBoard() {
        anchor.getChildren().clear();
        boardWidth = stage.getWidth();
        boardHeight = stage.getHeight() - cha;
        Board board = new Board(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        AnchorPane ap = board.getBoard();
        anchor.getChildren().add(ap);
    }
}
