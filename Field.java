package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.image.Image;

public class Field {
	private static final int width = 1540;
	private static final int height = 790;
	private int lw = 5;
	Image img = new Image("icon2.png");
	void draw(GraphicsContext gc) {
		gc.setFill(Color.LIMEGREEN);
		gc.fillRect(0, 0, width, height);
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, width, lw);
		gc.fillRect(0, height-lw,width, lw);
		gc.fillRect(width/2-lw, 0, lw, height);
		gc.setStroke(Color.WHITE);
		gc.setLineWidth(lw);
		gc.strokeOval(width/2-100, height/2-110, 200, 200);
		gc.fillOval(width/2-10, height/2-20,15,15);
	}
}
