package hanoitower.commom;

import stackstructure.stackinterface.IStack;

public class TowerInterface {

	private int numOfDisc;

	public void buildGame(IStack<Integer> stack) {
		this.numOfDisc = stack.size();
	}
	
	public String generateTowers(IStack<Integer> stack) {
		String towers = "";
		int towerSize = this.numOfDisc - stack.size();

		for (int i = 0; i < towerSize; i++) {
			towers += this.getTowerEmptySpaces(this.numOfDisc + 2) + "| \n";
		}
		towers += this.createDiscs(stack);
		return towers;
	}

	public String createDiscs(IStack<Integer> stack) {
		int numOfDiscTower = stack.size();
		int[] towerArray = generateTowerArray(stack);
		String discStructure = "";
		
		for (int i = 0; i < numOfDiscTower; i++) {
			discStructure += this.getTowerEmptySpaces(numOfDiscTower - i) + "<";
			for (int j = 0; j < towerArray[i]; j++) {
				discStructure += "_";
			}
			discStructure += "|";
			for (int j = 0; j < towerArray[i]; j++) {
				discStructure += "_";
			}
			discStructure += ">" + this.getTowerEmptySpaces(numOfDiscTower - i) + "\n";
		}
		return discStructure;
	}
	
	public int[] generateTowerArray(IStack<Integer> stack) {
		int numOfDisc = stack.size();
		int[] towerArray;
		if (!stack.isEmpty()) {
			towerArray = new int[stack.size()];
			for (int i = 0; i < numOfDisc; i++) {
				towerArray[i] = stack.pop();
		}
			for (int i = numOfDisc - 1; i >= 0; i--) {
				stack.push(towerArray[i]);
			}
		} else {
			towerArray = null;
		}
		return towerArray;
	}

	public String getTowerEmptySpaces(int numOfDisc) {
		String result = "";
		for (int i = 0; i <= numOfDisc; i++) {
			result += " ";
		}
		return result;
	}
}
