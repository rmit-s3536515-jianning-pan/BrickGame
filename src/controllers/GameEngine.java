package controllers;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.MainWindow;
import model.Ball;
import model.Racquet;
import views.GameView;
import views.Renderer;

public class GameEngine extends JPanel implements Runnable{  
	
	private Ball ball = new Ball(0,0,this);
	private Racquet racquet = new Racquet();
	private Renderer view;
	private Thread t;
	private boolean running = true;
	public Ball getBall() {
		return ball;
	}
	
	public Racquet getRaq() {
		return racquet;
	}

	public GameEngine() {
		
		view = new GameView(ball,racquet);
		this.addKeyListener(new RacquetKeyListener(racquet));
		this.setFocusable(true);
		t = new Thread(this);
		t.start();
		
	}
	
	public void start() {
		t = new Thread(this);
		t.start();
	}

	
	public void update() {
		ball.move();
		racquet.move();
		
	}
	
	public void gameOver() {
		
		running = false;
		JOptionPane.showMessageDialog(this, "Game over" , "Game over !!!!", JOptionPane.NO_OPTION);
		System.exit(ABORT);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		view.paint(g2d);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		
		long lastTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS; // how many time it takes to run ONE  frame
		int fps = 0;
		long fpstime = 0;
		

		while(running) {
			long now = System.nanoTime();
			

			long updateTime = now - lastTime;
			lastTime = now;
			
			double delta = (updateTime) / (double)OPTIMAL_TIME; // the elapsed time / time
			
			fpstime +=updateTime;
			fps++;
			
			if(fpstime >= 1000000000) {
				 System.out.println("(FPS: "+fps+")");
				 fpstime = 0;
		         fps = 0;
			}
			
			//below  run the update and display
			update();
			repaint();
			
			try {
				Thread.sleep((lastTime-System.nanoTime() + OPTIMAL_TIME) / 1000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!running) {
				return;
			}
			
		}
	}
}
