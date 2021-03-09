package DungeonGame;

public class TreasureRoom extends Room {

	public TreasureRoom(int roomIndex, String description, Monster monster, String treasure) {
		super(roomIndex, description, monster);
	}

	public void enter(Player player) {
		System.out.println("This room is " + this.getDescription() + " and has a " + getMonster().getName() + " that " + getMonster().getDescription());



		}
	}
