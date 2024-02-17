package application;
	

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {
	private static final int width = 1540;
	private static final int height = 790;
	private int pHeight = 100;
	private int pWidth  = 15;
	private int r = 20;
	private static boolean ready;
	Image img = new Image("field.png");
	Image img2 = new Image("icon.png");
	Player p1 = new Player(1,0, height/2-pHeight/2);
	Player p2 = new Player(2,width-pWidth, height/2-pHeight/2);
	Ball b = new Ball(width/2-12, height/2-20,r);
	Ball b1 = new Ball(width/2-12, height/2-20,r);
	Field f = new Field();
	Random rand = new Random();
	boolean turn1 = true;
	boolean turn2 = true;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root,width,height,Color.AZURE);
		Canvas canvas = new Canvas(width,height);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image icon = new Image("icon2.png");
		stage.setScene(scene);
		stage.getIcons().add(icon);
		stage.setTitle("2 Player Football");
		root.getChildren().add(canvas);
		Timeline t = new Timeline(new KeyFrame(Duration.millis(10), e ->{
			if(ready)
				run(gc,scene);
			else {
				gc.setFont(Font.font(30));
				gc.fillText("Press W ans S to Move Player 1", 100, 100);
				gc.fillText("Press UP ans DOWN to Move Player 2", 1000, 100);
				gc.fillText("If Ball Hits Player, it's Speed Increases", 100, 400);
				gc.fillText("If Ball Hits Wall, it's Speed Decreases", 1000, 400);
				gc.setFont(Font.font(50));
				gc.fillText("Click to Start", 100, 700);
				gc.fillText("Click to Start", 1000, 700);
			}
		}));
		t.setCycleCount(Timeline.INDEFINITE);
		scene.setOnMouseClicked(e -> {
			ready = true;
			b.start();
		});
		stage.setResizable(false);
		gc.drawImage(img, 0, 0,width,height);
		stage.show();
		draw(gc);
		t.play();
	}
	
	
	void draw(GraphicsContext gc) {
		f.draw(gc);
		p1.draw(gc);
		p2.draw(gc);
		b.draw(gc);
	}
	
	
	void KeyPressed(KeyEvent e) {
		if(b.posX<width/2-7)
			p1.keyPressed(e);
		else
			p2.keyPressed(e);
	}
	
	
	void KeyReleased(KeyEvent e) {
		if(b.posX<width/2-5)
			p1.keyReleased(e);
		else
			p2.keyReleased(e);
	}
	
	void crash() {
		b.crash();
		if(b.intersects(p1)) {
			System.out.println("left "+b.speedX);
			if(turn1)
			b.speedX = -(b.speedX);
			turn1 = false;
			turn2 = true;
			int randYDir = rand.nextInt(2);
			if(randYDir==0) b.speedY*=-1;
			b.posX+=b.speedX+=0.5;
			b.posY+=b.speedY;
			b.setLocation(b.posX, b.posY);
		}
		
		if(b.intersects(p2)) {
			System.out.println("right "+ b.speedX);
			if(turn2)
			b.speedX = -(b.speedX);
			turn2 = false;
			turn1 = true;
			int randYDir = rand.nextInt(2);
			if(randYDir==1) b.speedY*=-1;
			b.posX+=b.speedX;
			b.posY+=b.speedY;
			b.setLocation(b.posX, b.posY);
		}
	}
	
	private void run(GraphicsContext gc,Scene scene) {
		draw(gc);
		p1.draw(gc);
		p2.draw(gc);
		p1.draw(gc);
		p2.draw(gc);
		p1.draw(gc);
		p2.draw(gc);
		crash();
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				KeyPressed(e);
				p1.setLocation(p1.posX, p1.posY);
				p2.setLocation(p2.posX, p2.posY);
			}			
		});
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				KeyReleased(e);
				p1.setLocation(p1.posX, p1.posY);
				p2.setLocation(p2.posX, p2.posY);
			}	
		});
		p1.draw(gc);
		p2.draw(gc);
		p1.draw(gc);
		p2.draw(gc);
		p1.draw(gc);
		p2.draw(gc);
		p1.draw(gc);
		p2.draw(gc);
		b.draw(gc);
	}
}
