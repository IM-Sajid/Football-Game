package application;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.awt.Rectangle;

public class Ball extends Rectangle {
	private static final int width = 1540;
	private static final int height = 790;
	int r=20;
	int posX;
	int  posY;
	double speedX=0;
	double speedY=0;
	double iniSpeed = 1;
	int score1 = 0;
	int score2 = 0;
	Random rand = new Random();
	Ball(int x,int y,int r){
		super(x,y,r,r);
		posX=x;
		posY=y;	
	}
	
	
	void draw(GraphicsContext gc) {
		gc.setFill(Color.YELLOW);
		posX+=speedX;
		posY+=speedY;
		gc.fillOval(posX, posY, r, r);
		if(speedX==0 && speedY==0) {
			gc.setFill(Color.BLACK);
			gc.setFont(Font.font(50));
			gc.fillText(score1+"", width/2-45, 100);
			gc.fillText(score2+"", width/2+15, 100);
		}
	}

	void start() {
		int randXDir = rand.nextInt(2);
		if(randXDir==0) speedX=-iniSpeed;
		else speedX=iniSpeed;
		int randYDir = rand.nextInt(2);
		if(randYDir==0) speedY=-iniSpeed;
		else speedY=iniSpeed;
	}
	
	void crash() {
		if(posX<=0) {
			posX = width/2-12;
			posY = height/2-20;
			score2++;
			speedX = speedY = 0;
		}
		if(posX>=width-r) {
			posX = width/2-12;
			posY = height/2-20;
			score1++;
			speedX = speedY = 0;
		}
		if(posY<=0 || posY>=height-r) {
			speedY*=-1.0;
			if(speedX>3)speedX-=0.1;
			if(speedX<-3) speedX+=0.1;
		}
		setLocation(posX,posY);
	}
}
