import java.util.Scanner;
package dungeon;
public class UnladenSwallow{
    
    public UnladenSwallow(){
        super(choice(), 25, 10, .8, 1, 5, .2, SpecialAttackFactory.getAttack("Speed Velocity"));
    }
    public String choice(){
        String name;
        Scanner kb = new Scanner(System.in);
        System.out.println("Choose a type of Unladen Swallow:");
        System.out.println("1. African\r\n"+"2. European\r\n");
        if(kb.nextInt == 2){
            name = "European";
        }
        else{
            return name;
        }
    }
    public void attack(DungeonCharacter opponent){
		
		System.out.println(name + " drops a coconut at maximum velocity " + opponent.getName() + ":");
		super.attack(opponent);
	}

}