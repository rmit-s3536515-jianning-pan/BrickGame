package main;

import javax.swing.JFrame;

import controllers.GameEngine;
import model.FixedData;

public class MainWindow  { //extends JPanel implements Runnable
	
	private JFrame f;
	
	public MainWindow() {

		f = new JFrame("Brick");

		GameEngine engine = new GameEngine();
		f.add(engine);
		f.setSize(FixedData.WIDTH, FixedData.HEIGHT);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

		engine.start();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWindow mw = new MainWindow();

	}

}
