package dungeon;
import java.util.Scanner;
import java.awt.event.KeyEvent;

public class DungeonAdventure {

	static boolean pillarE;
	static boolean pillarA;
	static boolean pillarI;
	static boolean pillarP;
	static int dungeonXLoc;
	static int dungeonYLoc;
	static int roomXLoc;
	static int roomYLoc;
	static Dungeon dungeon = new Dungeon();
	static Hero mainHero;
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Dungeon Adventure!");//story
		System.out.println("Explore the dungeon, find the pillars of OO, and fight off monsters");
		System.out.println("press enter to continue, press s to load a saved game\n");
		kb.nextLine();////// modify here to add saved games
		System.out.println("please select a new Character by entering the number");
		System.out.println(" 1) King Arther");
		System.out.println(" 2) Brave Sir Robin");
		System.out.println(" 3) Zoot");
		String input = kb.nextLine();
		mainHero = Hero.factory(input);
		outerloop:
		for(int x = 0; x < dungeon.xDimension; x++) {
			for(int y = 0; y < dungeon.yDimension; y++) {
				if(dungeon.dungeonRoom[x][y].entrance) {
					dungeonXLoc = x;
					dungeonYLoc = y;
					break outerloop;
				}
			}
		}
		outerloop2:
		for(int x = 0; x < dungeon.dungeonRoom[dungeonXLoc][dungeonYLoc].xDimension; x++) {
			for(int y = 0; y < dungeon.dungeonRoom[dungeonXLoc][dungeonYLoc].yDimension; y++) {
				if(dungeon.dungeonRoom[dungeonXLoc][dungeonYLoc].floorTile[x][y].entrance) {
					roomXLoc = x;
					roomYLoc = y;
					break outerloop2;
				}
			}
		}
		//put main character at location
		kb.close();
		/*for(int x = 0; x < dungeon.xDimension; x++) {
			for(int y = 0; y < dungeon.yDimension; y++) {
				System.out.println("\n*******");
				for(int rx = 0; rx < dungeon.dungeonRoom[x][y].xDimension; rx++) {
					for(int ry = 0; ry < dungeon.dungeonRoom[x][y].yDimension; ry++) {
						
					}
				}
				System.out.println("\n*******");
			}
		}*///start of basic display
	}
	
	public void keyPressed(KeyEvent e) {
        Integer key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            if(roomXLoc > 0) {
            	roomXLoc--;
            	dungeon.dungeonRoom[dungeonXLoc][dungeonYLoc].floorTile[roomXLoc][roomYLoc].checkContains(mainHero);
            	//update display
            }
        }
        if (key == KeyEvent.VK_RIGHT) {
        	if(roomXLoc < 4) {
            	roomXLoc++;
            	dungeon.dungeonRoom[dungeonXLoc][dungeonYLoc].floorTile[roomXLoc][roomYLoc].checkContains(mainHero);
            	//update display
        	}
        }
        if (key == KeyEvent.VK_UP) {
        	if(roomYLoc < 4) {
            	roomYLoc++;
            	dungeon.dungeonRoom[dungeonXLoc][dungeonYLoc].floorTile[roomXLoc][roomYLoc].checkContains(mainHero);
            	//update display
        	}
        }
        if (key == KeyEvent.VK_DOWN) {
        	if(roomYLoc > 0) {
            	roomYLoc--;
            	dungeon.dungeonRoom[dungeonXLoc][dungeonYLoc].floorTile[roomXLoc][roomYLoc].checkContains(mainHero);
            	//update display
        	}
        }
        if(key == KeyEvent.VK_S) {
        	//save game
        }
    }

	public static void gameOver(String res) {
		//end game
	}

	public static void setPillarP(boolean b) {
		pillarP = b;
	}

	public static void setPillarI(boolean b) {
		pillarI = b;
	}

	public static void setPillarA(boolean b) {
		pillarA = b;
	}

	public static void setPillarE(boolean b) {
		pillarE = b;
	}

	public static boolean getPillarE() {
		return pillarE;
	}
	
	public static boolean getPillarA() {
		return pillarA;
	}
	
	public static boolean getPillarI() {
		return pillarI;
	}
	
	public static boolean getPillarP() {
		return pillarP;
	}
}
/* 
 Contains the main method
 Provides an introduction to the game describing what the game is about and how to play
 Creates a Dungeon Object and a Hero Object (based on user choice)
 Does the following repetitively:
 Prints the current room (this is based on the Hero's current location)
 Determines the Hero's options (Move, Use a Potion)
 Continues this process until the Hero wins or dies
 NOTE: Include a hidden menu option for testing that prints out the entire Dungeon
  -- specify what the menu option is in your documentation for the DungeonAdventure class
 At the end of the game, display the entire Dungeon
 */