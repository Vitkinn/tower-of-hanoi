package hanoitower;

import stackstructure.stackinterface.IStack;
import hanoitower.commom.TowerInterface;
import stackstructure.stack.ArrayStackImp;
import stackstructure.stack.LinkedStackImpl;

public class TowerController {

	private int numOfDiscs;
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

	public void transferDisc(int originTower, int destinyTower) {
		int firstTower = 1;
		int secondTower = 2;
		int thirdTower = 3;
		
		if (!this.gameOver()) {
			if (originTower == firstTower) {
				if (destinyTower == secondTower) {
					if (this.secondTower.isEmpty()) {
						this.secondTower.push(this.firstTower.pop());
					} else if (this.secondTower.top() < this.firstTower.top()) {
						this.secondTower.push(this.firstTower.pop());
					}
				} else if (destinyTower == thirdTower) {
					if (this.thirdTower.isEmpty()) {
						this.thirdTower.push(this.firstTower.pop());
					} else if (this.thirdTower.top() < this.firstTower.top()) {
						this.thirdTower.push(this.firstTower.pop());
					}
				}
			} else if (originTower == secondTower) {
				if (destinyTower == firstTower) {
					if (this.firstTower.isEmpty()) {
						this.firstTower.push(this.secondTower.pop());
					} else if (this.firstTower.top() < this.secondTower.top()) {
						this.firstTower.push(this.secondTower.pop());
					}
				} else if (destinyTower == thirdTower) {
					if (this.thirdTower.isEmpty()) {
						this.thirdTower.push(this.secondTower.pop());
					} else if (this.thirdTower.top() < this.secondTower.top()) {
						this.thirdTower.push(this.secondTower.pop());
					}
				}
			} else if (originTower == thirdTower) {
				if (destinyTower == firstTower) {
					if (this.firstTower.isEmpty()) {
						this.firstTower.push(this.thirdTower.pop());
					} else if (this.firstTower.top() < this.thirdTower.top()) {
						this.firstTower.push(this.thirdTower.pop());
					}
				} else if (destinyTower == secondTower) {
					if (this.secondTower.isEmpty()) {
						this.secondTower.push(this.thirdTower.pop());
					} else if (this.secondTower.top() < this.thirdTower.top()) {
						this.secondTower.push(this.thirdTower.pop());
					}
				}
			}
		}
	}

	private void populateTowers(int numOfDiscs) {
		for (int i = numOfDiscs; i > 0; i--) {
			this.firstTower.push(i);
		}
	}

	public boolean gameOver() {
		return this.thirdTower.size() == this.numOfDiscs;
	}
}
