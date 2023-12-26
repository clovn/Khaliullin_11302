import java.util.Scanner;

public class Player {
	
	private String name;
	private int hp;

	public Player(String name, int maxHP) {
		hp = maxHP;
		this.name = name;
	}
	
	public String toString() {
		return name + "(" + hp + ")"; 
	}

	public boolean isAlive() {
		return hp > 0;
	}
	
	public boolean attack(Player enemy, int f) {
		double d = (f - 1.0) / 10;
		if (Math.random() > d) {
			enemy.hp -= f;
			return true;
		} else {
			return false;
		}

	}
	
	public String getName() {
		return name;
	}
	
	public int getHp() {
		return hp;
	}
	
}


