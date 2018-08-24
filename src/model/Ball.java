package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import controllers.GameEngine;
import main.MainWindow;

public class Ball {
		private int x;
		private int y;
		private int xa = 1;
		private int ya = 1;
//		private MainWindow mw;
		private GameEngine engine;
//		public Ball(int x, int y,MainWindow mw) {
//			this.x = x;
//			this.y = y;
//			this.mw = mw;
//		}
		
		public Ball(int x, int y,GameEngine engine) {
			this.x = x;
			this.y = y;
			this.engine = engine;
		}
		
		public void move() {
			if (x + xa < 0)
				xa = 1;
			if (x + xa > FixedData.WIDTH - FixedData.BALL_LENGTH)
				xa = -1;
			if (y + ya < 0)
				ya = 1;
			if (y + ya > FixedData.HEIGHT - FixedData.BALL_LENGTH)
				engine.gameOver();
			if(collision()){
				ya = -1;
				y = engine.getRaq().getY()-FixedData.BALL_LENGTH;
				
			}
			x = x + xa;
			y = y + ya;
		}
		
		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public void paint(Graphics2D g) {
			g.setColor(Color.RED);
			g.fillOval(x, y, FixedData.BALL_LENGTH, FixedData.BALL_LENGTH);
		}
		
		private boolean collision() {
			return engine.getRaq().getBounds().intersects(getBounds());
		}
		
		public Rectangle getBounds() {
			return new Rectangle(x,y,FixedData.BALL_LENGTH,FixedData.BALL_LENGTH);
		}
}
