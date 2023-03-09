package objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class dice {
	private List<Integer> num = new ArrayList<Integer>();
	
	public List<Integer> getNum() {
		return this.num;
	}
	
	public int roll() {
		Random rand = new Random();
		int val = rand.nextInt(100);
		int diceNum;
		if (val < 20)
			diceNum = this.num.get(0);
		else if (20 <= val && val < 36)
			diceNum = this.num.get(1);
		else if (36 <= val && val < 52)
			diceNum = this.num.get(2);
		else if (52 <= val && val < 68)
			diceNum = this.num.get(3);
		else if (68 <= val && val < 84)
			diceNum = this.num.get(4);
		else
			diceNum = this.num.get(5);
		return diceNum;
	}
	
	public dice(int num) {
		this.num.add(num);
		for(int i = 1; i <= 6; i++) {
			if(i == num)
				continue;
			this.num.add(i);
		}
	}

	public static void main(String[] args) {
		dice dice = new dice(3);
		for(int i: dice.num) {
			System.out.println(i);
		}
	}

}
