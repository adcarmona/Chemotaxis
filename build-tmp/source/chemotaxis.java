import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class chemotaxis extends PApplet {

 Bacteria [] colony;
 Food [] snacks;
 boolean mouseTrace = false;
 boolean backgroundOn = true;
 boolean jumper = false;
 public void setup()   
 {     
 	//initialize bacteria variables here   
 	frameRate(30);
 	size(600,600);
 	background(0);
 	colony = new Bacteria[100];
 	for(int i=0; i<colony.length; i++)
 	{
 		colony[i] = new Bacteria();
 	}
 }   
 public void draw()   
 {    
 	//move and show the bacteria 
 	if (backgroundOn == true)
 	{
 		fill(0,0,0,30);
 		rect(0,0,600,600);
 	}
 	for (int i=0; i<colony.length; i++)
 	{
 		colony[i].move();
 		colony[i].show();
 	}
 }  
 class Food
 {
 	int foodX,foodY, fr, fg, fb;
 	Food()
 	{
 		fr = (int)(Math.random()*255);
 		fg = (int)(Math.random()*255);
 		fb = (int)(Math.random()*255);
 		foodX = 150;
 		foodY = 150;
 	}
 	public void place()
 	{
 		foodX = mouseX;
 		foodY = mouseY;
 	}
 	public void show()
 	{
 		fill(fr,fg,fb);
 		ellipse(foodX, foodY, 20,20);
 	}
 }
  class Bacteria    
 {     
 	int myX, myY, r, g, b;
 	Bacteria()
 	{
 		myX = (int)(Math.random()*601);
 		myY = (int)(Math.random()*601);
 		r = (int)(Math.random()*255);
 		g = (int)(Math.random()*255);
 		b = (int)(Math.random()*255);
 	}
 	public void move()
 	{
 		if (jumper == true)
 		{
 			myX = (int)(Math.random()*601);
 			myY = (int)(Math.random()*601);
 		}
 		else 
 		{
 		if (mouseTrace == true)
 		{
 			if (mouseX > myX) 
 			{
 			myX = myX + (int)(Math.random()*4)-1;
 			}
 			if (mouseX < myX) 
 			{
 			myX = myX - (int)(Math.random()*4)+1;
 			}
 			if (mouseX == myX) 
 			{
 			myX = myX - (int)(Math.random()*3)-1;
 			}
 			if (mouseY > myY) 
 			{
 			myY = myY + (int)(Math.random()*4)-1;
 			}
 			if (mouseY < myY) 
 			{
 			myY = myY - (int)(Math.random()*4)+1;
 			}
 			if (mouseY == myY) 
 			{
 			myY = myY - (int)(Math.random()*3)-1;
 			}
 		}
 		else
 		{
 			myX = myX + (int)(Math.random()*3)-1;
 			myY = myY + (int)(Math.random()*3)-1;
 		}
 		}
 	}
 	public void show()
 	{
 		fill(r,g,b);
 		noStroke();
 		ellipse(myX,myY,10,10);
 	}
 } 
 public void mouseClicked()
 {
 	if (mouseButton == LEFT && mouseTrace == false)
 	{
 		mouseTrace = true;
 	}
 	else if (mouseButton == LEFT && mouseTrace == true)
 	{
 		mouseTrace = false;
 	}
 	 	if (mouseButton == RIGHT && jumper == false)
 	{
 		jumper = true;
 	}
 	else if (mouseButton == RIGHT && jumper == true)
 	{
 		jumper = false;
 	}
 }   
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
