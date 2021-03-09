package DungeonGame;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Game {
	
	Scanner scnr = new Scanner(System.in);

	private boolean active = true;
	public Player player;
	public Battle fight1;
	public Battle fight2;
	public Battle fight3;
	public Room[] dungeon;
	private Monster monster1;
	private Monster monster2;
	private Monster monster3;
	private Room room1;
	private Room room2;
	private TreasureRoom treasureRoom;

	public Game() {

	    player = new Player(JOptionPane.showInputDialog(null, "Input player name"), null, 100, 15, 30);
	    player = new Player(player.getName(), JOptionPane.showInputDialog(null, "Describe yourself in one word"), 100, 15, 30);
		
//		System.out.println("Hello, player! Whats your name?");
//		player = new Player(scnr.nextLine(), " ", 1,2,3);
//		System.out.println("Hi, " + player.getName() + ". Describe yourself in one word.");
//		player = new Player(player.getName(), scnr.nextLine(), 100, 15, 20);

		
		monster1 = new Monster("Orc", "covered with green blood", 20, 5, 0, active);
		fight1 = new Battle(player, monster1);
		room1 = new Room(0, "a room with an unbearable smell", monster1);
		monster2 = new Monster("Skeleton", "funny how it moves", 40, 10, 10, active);
		fight2 = new Battle(player, monster2);
		room2 = new Room(1, "dark and cold", monster2);
		monster3 = new Monster("Fire Dragon", "spouts fire with each breath", 100, 20, 40, active);
		fight3 = new Battle(player, monster3);
		treasureRoom = new TreasureRoom(2, "a giant hall with something shiny on the other end", monster3,
				"a large pile of gold");

		dungeon = new Room[] { room1, room2, treasureRoom };

	}

	public void play() {

		System.out.println(player.getName() + ", who is " + player.getDescription() + ", has started the game!");

		while (active) {

			if (monster1.isAlive()) {

				room1.enter(player);

				fight1.run();

			}

			if (monster2.isAlive()) {

				room2.enter(player);

				fight2.run();

			}

			if (monster3.isAlive()) {

				treasureRoom.enter(player);

				fight3.run();

			}

			if (monster3.isAlive() == false) {
				System.out.println("You've receiced a large pile of gold!");

			}

			if (!(monster1.isAlive() && monster2.isAlive() && monster3.isAlive()) || !player.isAlive()) {
				this.active = false;
				System.out.println("***************THE END***************");

			}
		}
	}

	public static void main(String[] args) {

		Game game = new Game();

		game.play();

	}

}