/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Shihui Xiong
 */
public class Board {
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor;
    private Color darkColor;
    private double rectangleWidth;
    private double rectangleHeight;
    
    public Board(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = Color.RED;
        this.darkColor = Color.BLACK;
    }
    public Board(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build() {
        rectangleWidth = Math.ceil(boardWidth / numCols);
        rectangleHeight = Math.ceil(boardHeight / numRows);
        AnchorPane anchor = new AnchorPane();
        
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Color color = (col%2 == row%2) ? lightColor : darkColor;
                Rectangle rect = new Rectangle(rectangleWidth*row, rectangleHeight*col, rectangleWidth, rectangleHeight);
                rect.setFill(color);
                anchor.getChildren().add(rect);
            }
        }
        return anchor;
    }
   
    public AnchorPane getBoard() {
        if(build() == null) {
            return null;
        }
        return build();
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public double getWidth() {
        return boardWidth;
    }

    public double getHeight() {
        return boardHeight;
    }

    public Color getLightColor() {
        return lightColor;
    }

    public Color getDarkColor() {
        return darkColor;
    }

    public double getRectangleWidth() {
        return rectangleWidth;
    }
    
    public double getRectangleHeight() {
        return rectangleHeight;
    } 
}
