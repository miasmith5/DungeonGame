package dungeon;
public class SpeedVelocity{
    @Override
	public void attack(DungeonCharacter player, DungeonCharacter opponent) {
		double surprise = Math.random();
		if (player.name.equals("African")){
			player.damageMax = 11; //meters per second
			player.attack(opponent);
		}else if (player.name.equals("European")){
			player.damageMax = 9; // meters per second
            player.attack(opponent);
		}else
            System.out.println("Oh no!");
	}
}