package hanoitower;

import stackstructure.stackinterface.IStack;
import hanoitower.commom.TowerInterface;
import stackstructure.stack.ArrayStackImp;
import stackstructure.stack.LinkedStackImpl;

public class TowerController {

	private int numOfDiscs;
	private int movesNumber = 0;
	private boolean invalidMove;
	private boolean gameOver;
	private TowerInterface tower;
	private IStack<Integer> firstTower;
	private IStack<Integer> secondTower;
	private IStack<Integer> thirdTower;

	public void startGame(boolean stackType, int numOfDiscs) {
		this.numOfDiscs = numOfDiscs;
		this.tower = new TowerInterface();
		
		if (stackType) {
			this.firstTower = new LinkedStackImpl<>();
			this.secondTower = new LinkedStackImpl<>();
			this.thirdTower = new LinkedStackImpl<>();
		} else {
			this.firstTower = new ArrayStackImp<>(numOfDiscs);
			this.secondTower = new ArrayStackImp<>(numOfDiscs);
			this.thirdTower = new ArrayStackImp<>(numOfDiscs);
		}
		this.populateTowers(numOfDiscs);

		tower.buildGame(this.firstTower);
	}

	public String getTowers(int towerNumber) {
		String towers = "";

		switch (towerNumber) {

			case 1:
				towers += tower.generateTowers(this.firstTower);
				break;
			case 2:
				towers += tower.generateTowers(this.secondTower);
				break;
			case 3:
				towers += tower.generateTowers(this.thirdTower);
				break;
		}
		return towers;
	}

	public void transferDiscByNum(int originTower, int destinyTower) {
		try {
			if (originTower == 1 && destinyTower == 2) {
				this.transferDisc(this.firstTower, this.secondTower);
			} else if (originTower == 1 && destinyTower == 3) {
				this.transferDisc(this.firstTower, this.thirdTower);
			} else if (originTower == 2 && destinyTower == 1) {
				this.transferDisc(this.secondTower, this.firstTower);
			} else if (originTower == 2 && destinyTower == 3) {
				this.transferDisc(this.secondTower, this.thirdTower);
			} else if (originTower == 3 && destinyTower == 1) {
				this.transferDisc(this.thirdTower, this.firstTower);
			} else if (originTower == 3 && destinyTower == 2) {
				this.transferDisc(this.thirdTower, this.secondTower);
			} else {
				this.invalidMove = true;
			}
		} catch (Exception e) {
			this.invalidMove = true;
		}
	}

	public void transferDisc(IStack<Integer> originTower, IStack<Integer> destinyTower) {
		if (!this.isGameOver()) {
			if (destinyTower.isEmpty()) {
				destinyTower.push(originTower.pop());
				this.movesNumber++;
			} else if (destinyTower.top() > originTower.top()) {
				destinyTower.push(originTower.pop());
				this.movesNumber++;
			} else {
				this.invalidMove = true;
			}
		}
	}

	private void populateTowers(int numOfDiscs) {
		for (int i = numOfDiscs; i > 0; i--) {
			this.firstTower.push(i);
		}
	}

	public boolean isGameOver() {
		return this.thirdTower.size() == this.numOfDiscs;
	}

	public void gameOver() {
		this.gameOver = true;
	}

	public boolean isInvalidMove() {
		boolean result = this.getInvalidMove();
		this.invalidMove = false;
		return result;
	}

	public int getMovesNumber() {
		return this.movesNumber;
	}

	public boolean getInvalidMove() {
		return this.invalidMove;
	}
}
