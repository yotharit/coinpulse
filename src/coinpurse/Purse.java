package coinpurse;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Purse {
	private int capacity;
	private double balance;
	List<Coin> money = new ArrayList<Coin>();

	Purse(int capacity) {
		this.capacity = capacity;
		this.balance = 0;
	}

	public int count() {
		return money.size();
	}

	public double getBalance(){
		for( Coin c : money ){
			balance += c.getValue();
		}
		return balance;
	}

	public int getCapacity(){
		return this.capacity;
	}

	public boolean isFull(){
		if(money.size() == capacity) return true;
		return false;
	}

	public boolean insert(Coin coin) {
		if (isFull()) return false;
		if (coin.getValue() <= 0) return false;
		money.add(coin); 
		return true;
	}

	public Coin[] withdraw(double amount) {
		List<Coin> templist = new ArrayList<Coin>();
		money.addAll(templist);
		Collections.sort(templist);
		Collections.reverse(templist);
		for( Coin c : templist ){
			if(c.getValue()<=amount){
				amount -= c.getValue();
				templist.add(c);
			}
		}
		if(amount == 0){
			for(Coin c : templist){
				if(money.contains(c)){
					money.remove(c);
				}
			}
			Coin[] coin = new Coin[templist.size()];
			templist.toArray(coin);
			return coin;
		}
		else return null;
	}

	@Override
	public String toString() {
		return "Purse [capacity=" + capacity + ", balance=" + balance + ", money=" + money + "]";
	}


}
