package hanoitower.commom;

import stackstructure.stackinterface.IStack;

public class Towers<T> {

	public String createDiscs(IStack<T> stack) {
		int numOfDisc = stack.size();
		String discStructure = "";
		int[] towerArray = generateTowerArray(stack);

		for (int i = 0; i < numOfDisc; i++) {
			discStructure += this.getTowerEmptySpaces(numOfDisc - i) + "<";
			for (int j = 0; j < towerArray[i]; j++) {
				discStructure += "_";
			}
			discStructure += "|";
			for (int j = 0; j < towerArray[i]; j++) {
				discStructure += "_";
			}
			discStructure += ">" + this.getTowerEmptySpaces(numOfDisc - i) + "\n";
		}
		return discStructure;
	}
	
	public int[] generateTowerArray(IStack<T> stack) {
		int numOfDisc = stack.size();
		int[] towerArray = new int[stack.size()];
		for (int i = 0; i < numOfDisc; i++) {
			towerArray[i] = (int) stack.pop();
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
