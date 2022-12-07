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
			towers += this.getTowerEmptySpaces(0) + "|\n";
		}
		towers += this.createDiscs(stack);
		return towers;
	}

	public String createDiscs(IStack<Integer> stack) {
		int numOfDiscTower = stack.size();
		int[] towerArray = generateTowerArray(stack);
		String discStructure = "";
		
		for (int i = 0; i < numOfDiscTower; i++) {
			discStructure += this.getTowerEmptySpaces(i + 1) + "<";
			for (int j = 0; j < towerArray[i]; j++) {
				discStructure += "_";
			}
			discStructure += "|";
			for (int j = 0; j < towerArray[i]; j++) {
				discStructure += "_";
			}
			discStructure += ">" + this.getTowerEmptySpaces(i + 1) + "\n";
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

	public String getTowerEmptySpaces(int disc) {
		String result = "";

		if (disc == 0) {
			for (int i = 0; i < this.numOfDisc + 2; i++) {
				result += " ";
			}
			return result;
		} else {
			for (int i = 0; i < (this.numOfDisc - (disc - 1)); i++) {
				result += " ";
			}
		}
		return result;
	}
}
