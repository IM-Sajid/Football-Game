package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import java.awt.Rectangle;

public class Player extends Rectangle  {
	private static final int width = 1540;
	private static final int height = 790;
	private static final int pHeight=100;
	private static final int pWidth=15;
	int speedX = 25;
	int speedY = 25;
	int posX;
	int posY;
	int id;
	private int speed=20;
	int score = 0;
	
	
	Player(int id,int x,int y){
		super(x,y,pWidth,pHeight);
		this.id=id;
		posX=x;
		posY=y;
	}
	
	
	void draw(GraphicsContext gc) {
		if(id==1) {
			gc.setFill(Color.RED);
			gc.fillRect(posX, posY, pWidth, pHeight);
		}
		else {
			gc.setFill(Color.BLUE);
			gc.fillRect(posX, posY, pWidth, pHeight);
		}
	}
	
	
	public void keyPressed(javafx.scene.input.KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getCode()==KeyCode.W) {
				if(posY>speed) {
					posY-=speedY=speed;
					setLocation(posX,posY);
				}
					
			}
			if(e.getCode()==KeyCode.S) {
				if(posY<height-pHeight-speed) {
					posY+=speedY=speed;
					setLocation(posX,posY);
				}
					
			}
//			if(e.getCode()==KeyCode.A) {
//				if(posX>0) {
//					posX-=speedX=speed;
//					setLocation(posX,posY);
//				}	
//			}
//			if(e.getCode()==KeyCode.D) {
//				if(posX<width/2-pWidth-15) {
//					posX+=speedX=speed;
//					setLocation(posX,posY);
//				}
//			}
			break;
		case 2:
			if(e.getCode()==KeyCode.UP) {
				if(posY>speed) {
					posY-=speedY=speed;
					setLocation(posX,posY);
				}
				
			}
			else if(e.getCode()==KeyCode.DOWN) {
				if(posY<height-pHeight-speed) {
					posY+=speedY=speed;
					setLocation(posX,posY);
				}
				
			}
//			if(e.getCode()==KeyCode.LEFT) {
//				if(posX>width/2+15) {
//					posX-=speedX=speed;
//					setLocation(posX,posY);
//					speedX-=speed;
//				}
//			}
//			if(e.getCode()==KeyCode.RIGHT) {
//				if(posX<width-pWidth) {
//					posX+=speedX=speed;
//					setLocation(posX,posY);
//				}
//			}
			break;
		}
	}

	public void keyReleased(javafx.scene.input.KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getCode()==KeyCode.W) {
				posY-=speedY=0;
				setLocation(posX,posY);
			}
			else if(e.getCode()==KeyCode.S) {
				posY+=speedY=0;
				setLocation(posX,posY);
			}
//			else if(e.getCode()==KeyCode.A) {
//				posX-=speedX=0;
//				setLocation(posX,posY);
//			}
//			else if(e.getCode()==KeyCode.D) {
//				posX+=speedX=0;
//				setLocation(posX,posY);
//			}
			break;
		case 2:
			if(e.getCode()==KeyCode.UP) {
				posY-=speedY=0;
				setLocation(posX,posY);
			}
			else if(e.getCode()==KeyCode.DOWN) {
				posY+=speedY=0;
				setLocation(posX,posY);
			}
//			else if(e.getCode()==KeyCode.LEFT) {
//				posX-=speedX=0;
//				setLocation(posX,posY);
//			}
//			else if(e.getCode()==KeyCode.RIGHT) {
//				posX+=speedX=0;
//				setLocation(posX,posY);
//			}
			break;
		}
	}
}
