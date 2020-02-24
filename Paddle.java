package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.*; 


public class Paddle {
    
    //instance variables
    private int length;//length of the paddle
    private int width;//width of the paddle
    private int x;//x coordinate of the paddle
    private int y;//y coordinate of the paddle
    private int velocityY;

    public Paddle (int x, int y, int length, int width){
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
        this.velocityY = 0;
    }
   
        
    //draw the paddle
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(this.x, this.y, this.length, this.width);//drawing the rectangle
        g.setColor(Color.white);
        g.fillRect(this.x, this.y, this.length, 1);
    }

     
    public void change(int yChange){
        this.y += yChange;
        //changing the y value to move
    }
    
    //getters and setters
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY() {
       return this.y;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getWidth(){
        return this.width;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getLength(){
        return this.length;
    }
    public void setLength(int length){
        this.length = length;
    }
    public int getVelocityY(){
        return this.velocityY;
    }
    public void setVelocityY(int velY){
        this.velocityY = velY;
    }
    

}
