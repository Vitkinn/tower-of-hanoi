package hanoitower;

import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {

		int scanFirstOption;
		int scanSecondOption;
		boolean advanceGame;

		TowerController tower = new TowerController();
		Scanner scan = new Scanner(System.in);

		try {
			tower.startGame(args);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		do {
			System.out.println("----- Torre de Hanoi ----- \n\n");

			System.out.println("Torre 1:\n" + tower.getTowers(1));
			System.out.println("Torre 2:\n" + tower.getTowers(2));
			System.out.println("Torre 3:\n" + tower.getTowers(3));

			System.out.println("(Para sair do jogo, digite qualquer tecla que não seja um número.)");
			try {
				do {
					System.out.println("Informe a torre que você deseja mover uma peça: ");
					scanFirstOption = scan.nextInt();
					System.out.println("Informe a torre que você deseja colocar a peça: ");
					scanSecondOption = scan.nextInt();
					advanceGame = true;

					tower.transferDiscByNum(scanFirstOption, scanSecondOption);

					if (tower.isInvalidMove()) {
						advanceGame = false;
						System.out.println("\nJOGADA INVÁLIDA, por-favor tente novamente!\n");
					}
				} while (!advanceGame);
			} catch (Exception e) {
				break;
			}
		} while (!tower.isGameOver());

		System.out.println("Torre 1:\n" + tower.getTowers(1));
		System.out.println("Torre 2:\n" + tower.getTowers(2));
		System.out.println("Torre 3:\n" + tower.getTowers(3));

		if (tower.isGameOver()) {
			System.out.println("Parabéns, você completou o desafio da Torre de Hanoi!\n");

		}
		System.out.println("Você jogou com " + tower.getNumOfDiscs() + " discos, e foram feitos um total de " +
				tower.getMovesNumber() + " movimentos.\nCom essa quantidade de discos, o mínimo de movimentos " +
				"possíveis para completar o desafio é " + tower.calculateMinimumMoves() + ".");
	}
}
