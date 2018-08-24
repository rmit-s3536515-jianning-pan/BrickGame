package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Racquet {
	private int x=FixedData.WIDTH/2;
	private int xa = 0;
	
	public Racquet() {
		
	}
	public void move() {
		if (x + xa > 0 && x + xa < FixedData.WIDTH-FixedData.RAQ_WIDTH)
			x = x + xa;
//		else if(x+xa <0) {
//			x = 0-x+xa;
//		}
//		else if (x + xa > FixedData.WIDTH-FixedData.RAQ_WIDTH){
//			x = FixedData.WIDTH;
//		}
	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, FixedData.RAQ_Y, FixedData.RAQ_WIDTH, FixedData.RAQ_HEIGHT);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getXa() {
		return xa;
	}

	public void setXa(int xa) {
		this.xa = xa;
	}
	
	public  Rectangle getBounds() {
		return new Rectangle(x,FixedData.RAQ_Y,FixedData.RAQ_WIDTH,FixedData.RAQ_HEIGHT);
	}
	
	public int getY() {
		return FixedData.RAQ_Y;
	}
}
