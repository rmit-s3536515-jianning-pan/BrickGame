package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.FixedData;
import model.Racquet;

public class RacquetKeyListener implements KeyListener {
	
	private Racquet racquet;
	
	public RacquetKeyListener(Racquet racquet) {
		this.racquet = racquet;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			racquet.setXa(-FixedData.RAQ_ACC);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			racquet.setXa(FixedData.RAQ_ACC);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		racquet.setXa(0);
	}

}
