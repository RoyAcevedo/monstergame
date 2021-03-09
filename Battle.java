package DungeonGame;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Battle 
	Player player;
	Monster monster;
	Scanner scnr = new Scanner(System.in);
	String input;

	public Battle(Player player, Monster monster) {
		this.player = player;
		this.monster = monster;
		
	}

	public void run() {
		System.out.println("___________________________________________________________________________________________________________________________");
		System.out.println("A battle begins: " + player.getName() + " vs " + monster.getName());

		// while both player and monster are alive commence battle
		while (monster.isAlive() == true && player.isAlive() == true) {
			System.out.println("___________________________________________________________________________________________________________________________");
			System.out.println(
					player.getName() + ": " + player.getHP() + " vs " + monster.getName() + ": " + monster.getHP());
			System.out.println(player.getName() + "'s turn");
			input = JOptionPane.showInputDialog(null, "Do you want to Attack(a) or Heal(h)? ");
//			System.out.println("Do you want to Attack(a) or Heal(h)? ");
			System.out.println("___________________________________________________________________________________________________________________________");
//			input = scnr.next();
			if (input.equals("a") || input.equals("A")) {
				System.out.println(player.getName() + " attacks!");
				monster.takeDamage(player.getDMG());
				if (monster.isAlive()) {
					System.out.println("___________________________________________________________________________________________________________________________");
					System.out.println(monster.getName() + "'s turn");
					if ((monster.isAlive() && monster.canEnrage())) {
						monster.enrage();
						System.out.println(monster.getName() + " attacks!");
						player.takeDamage(monster.getDMG());
					} else if (monster.isAlive() && monster.canEnrage() == false) {
						System.out.println(monster.getName() + " attacks!");
						player.takeDamage(monster.getDMG());
					}
				}

			} else if (input.equals("h") || input.equals("H")) {
				player.heal();
				// System.out.println("___________________________________________________________________________________________________________________________");
				// System.out.println(player.getName() + " has chosen to heal");
				if (monster.isAlive()) {
					System.out.println("___________________________________________________________________________________________________________________________");
					System.out.println(monster.getName() + "'s turn");
					System.out.println("___________________________________________________________________________________________________________________________");
					if ((monster.isAlive() && monster.canEnrage())) {
						monster.enrage();
						player.takeDamage(monster.getDMG());
					} else if (monster.isAlive() && monster.canEnrage() == false) {
						player.takeDamage(monster.getDMG());
					}
				}
			} else {
//				System.out.println("___________________________________________________________________________________________________________________________");
				JOptionPane.showMessageDialog(null, "Invalid input, try again");
//				System.out.println("Invalid input, try again");
//				System.out.println("___________________________________________________________________________________________________________________________");
			}

			if (monster.isAlive() == false) {
				System.out.println("___________________________________________________________________________________________________________________________");
				System.out.println("You have defeated the creature!");
				System.out.println("___________________________________________________________________________________________________________________________");

			} else if (player.isAlive() == false) {
				// if player is dead print you lose
				System.out.println("___________________________________________________________________________________________________________________________");
				System.out.println("Game Over - YOU HAVE BEEN DEFEATED!");
				System.out.println("___________________________________________________________________________________________________________________________");

			}

		}
	}
}