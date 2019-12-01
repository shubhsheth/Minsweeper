package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cell implements ActionListener {

	private Game game;
	private JButton button;

	private int id;
	private String value;
	
	private Boolean revealed;
	private Boolean sealed;
		
	public Cell(Game game) {
		button = new JButton();
		this.game = game;
		revealed = false;
		sealed = false;
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public JButton getButton() {
		return button;
	}
	
	public void setValue(String val) {
		this.value = val;
		button.setText(val);
	}
	
	private void reveal() {
		// To Do
	}
	
	private void seal() {
		// To Do
	}
	
	private void unseal() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// To Do
	}
	
}