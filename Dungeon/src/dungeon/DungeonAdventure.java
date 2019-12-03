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
		kb.close();
		//displays all rooms
		/*for(int y = dungeon.yDimension-1; y >= 0; y--) {
			for(int x = 0; x < dungeon.xDimension; x++)
				displayRoom(x,y);
		}*/
		displayRoom(dungeonXLoc, dungeonYLoc);
		//System.out.println(dungeonXLoc+" "+dungeonYLoc);
	}
	
	public void keyPressed(KeyEvent e) {
        Integer key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            if(roomXLoc > 0) {
            	roomXLoc--;
            	dungeon.dungeonRoom[dungeonXLoc][dungeonYLoc].floorTile[roomXLoc][roomYLoc].checkContains(mainHero);
            	displayRoom(dungeonXLoc, dungeonYLoc);
            }
        }
        if (key == KeyEvent.VK_RIGHT) {
        	if(roomXLoc < 4) {
            	roomXLoc++;
            	dungeon.dungeonRoom[dungeonXLoc][dungeonYLoc].floorTile[roomXLoc][roomYLoc].checkContains(mainHero);
            	displayRoom(dungeonXLoc, dungeonYLoc);
        	}
        }
        if (key == KeyEvent.VK_UP) {
        	if(roomYLoc < 4) {
            	roomYLoc++;
            	dungeon.dungeonRoom[dungeonXLoc][dungeonYLoc].floorTile[roomXLoc][roomYLoc].checkContains(mainHero);
            	displayRoom(dungeonXLoc, dungeonYLoc);
        	}
        }
        if (key == KeyEvent.VK_DOWN) {
        	if(roomYLoc > 0) {
            	roomYLoc--;
            	dungeon.dungeonRoom[dungeonXLoc][dungeonYLoc].floorTile[roomXLoc][roomYLoc].checkContains(mainHero);
            	displayRoom(dungeonXLoc, dungeonYLoc);
        	}
        }
        if(key == KeyEvent.VK_S) {
        	//save game
        }
    }
	
	public static void displayRoom(int x, int y) {
		
		if(y < 4)
			System.out.println("- - - D - - -");
		else
			System.out.println("- - - - - - -");
		for(int ry = dungeon.dungeonRoom[x][y].yDimension-1; ry >= 0; ry--) {
			if(ry == 2 && x != 0)
				System.out.print("D");
			else
				System.out.print("|");
			for(int rx = 0; rx < dungeon.dungeonRoom[x][y].xDimension; rx++) {
				if(rx == roomXLoc && ry == roomYLoc && dungeonXLoc == x && dungeonYLoc == y)
					System.out.print(" C");
				else if(dungeon.dungeonRoom[x][y].floorTile[rx][ry].contains) {
					if(dungeon.dungeonRoom[x][y].floorTile[rx][ry].hPotion)
						System.out.print(" H");
					if(dungeon.dungeonRoom[x][y].floorTile[rx][ry].vPotion)
						System.out.print(" V");
					if(dungeon.dungeonRoom[x][y].floorTile[rx][ry].pit)
						System.out.print(" O");
					if(dungeon.dungeonRoom[x][y].floorTile[rx][ry].pillarE)
						System.out.print(" E");
					if(dungeon.dungeonRoom[x][y].floorTile[rx][ry].pillarA)
						System.out.print(" A");
					if(dungeon.dungeonRoom[x][y].floorTile[rx][ry].pillarI)
						System.out.print(" I");
					if(dungeon.dungeonRoom[x][y].floorTile[rx][ry].pillarP)
						System.out.print(" P");
					if(dungeon.dungeonRoom[x][y].floorTile[rx][ry].entrance)
						System.out.print(" B");
					if(dungeon.dungeonRoom[x][y].floorTile[rx][ry].exit)
						System.out.print(" Z");
				}else 
					System.out.print(" #");
			}
			if(ry == 2 && x != 4)
				System.out.println(" D");
			else
				System.out.println(" |");
		}
		if(y > 0)
			System.out.println("- - - D - - -");
		else
			System.out.println("- - - - - - -");
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