package views;

import java.awt.Color;
import java.awt.Graphics2D;

import model.Ball;
import model.FixedData;
import model.Racquet;

public class GameView implements Renderer{
	
	private Ball b;
	private Racquet r;
	
	
	

	public GameView(Ball b, Racquet r) {
		this.b = b;
		this.r = r;
	}
	
	@Override
	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		g.fillOval(b.getX(), b.getY(), FixedData.BALL_LENGTH, FixedData.BALL_LENGTH);
	
	
		g.setColor(Color.BLACK);
		g.fillRect(r.getX(), FixedData.RAQ_Y, FixedData.RAQ_WIDTH, FixedData.RAQ_HEIGHT);
	}
	

}
