package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Game.Cell;

public class Game {
	
	private static final int SIZE = 10;
	private int cellID = 0;
	private int totalMines;
	
	private Cell[][] cells = new Cell[SIZE][SIZE];
	
	public Game() {
		// Init
		JFrame window = new JFrame("Minesweeper");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setSize(900, 900);
		
		window.add(createGrid());

		// Update Buttons
        assignMines();
        assignValues(); 
    }
	
	public JPanel createGrid() {
		JPanel panel = new JPanel(new GridLayout(SIZE,SIZE));
		
		//Create button for each grid block
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				cells[i][j] = new Cell(this);
				cells[i][j].setID(getID());
				panel.add(cells[i][j].getButton());
			}
		}
		
		return panel;
	}
	
	private void assignMines() {
		
		// Number of Mines - between 20 and 30
		Random r = new Random();
		this.totalMines = (int) r.nextInt((30 - 20) + 1) + 20;

		// Assign Mines Randomly
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
		    list.add(new Integer(i));
		}
		Collections.shuffle(list); //unique random numbers from 0 - 99
		
		for ( int i = 0; i < this.totalMines; i++) {
			Cell cell = getCellByID(list.get(i));
			cell.setValue("X");
		}
	}
	
	private void assignValues() {
		for ( int i = 0; i < 100; i++ ) {
			System.out.println("here");
			
			int surroundingMines = 0;
			
			// Get Cell
			Cell cell = getCellByID(i);
			
			// Get All Surrounding Cells
			int surroundingCells[] = new int[] {-11,-10,-9,-1,1,9,10,11};

			// Check for Mines
			for (int j = 0; j < 8; j++) {
				
				int cellid = i + surroundingCells[j];
				
				if (cellid > 0) {
					if (getCellByID(cellid).getValue() == "X") {						
						surroundingMines++;
					}
				}
			}
			
			// Update Current Cell
			if(surroundingMines > 0) {
				cell.setValue(String.valueOf(surroundingMines));
			}
		}
	}
	
	public void revealEmptyCells(int id) {
		// To Do
	}
	
	public int getID() {
		int id = this.cellID;
		this.cellID++;
		return id;
	}
	
	public Cell getCellByID(int id) {
		int i = id / 10;
		int j = id % 10;
		return cells[i][j];
	}
	
}
