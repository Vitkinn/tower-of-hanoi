package hanoitower;

import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {

		TowerController tower = new TowerController();
		tower.startGame(true, 5);

		 Scanner scan = new Scanner(System.in);
		 
		 int option;
		 
		 do {
			 System.out.println("--- Torre de Hanoi --- \n\n");
				
				System.out.println("Torre 1:\n" + tower.getTowers(1));
				System.out.println("Torre 2:\n" + tower.getTowers(2));
				System.out.println("Torre 3:\n" + tower.getTowers(3));
				
				System.out.println("Informe a torre que você deseja mover uma peça: ");
				option = scan.nextInt();
				System.out.println("Informe a torre que você deseja colocar a peça: ");
				option = scan.nextInt();
		} while (!tower.gameOver());

	}
}