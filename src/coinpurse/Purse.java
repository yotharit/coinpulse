package coinpurse;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Purse  {
	private int capacity;
	private double balance;
	List<Valuable> money = new ArrayList<Valuable>();

	Purse(int capacity) {
		this.capacity = capacity;
		this.balance = 0;
	}

	public int count() {
		return money.size();
	}

	public double getBalance(){
		balance = 0;
		for( Valuable c : money ){
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

	public boolean insert(Valuable valuable) {
		if (isFull()) return false;
		if (valuable.getValue() <= 0) return false;
		money.add(valuable); 
		return true;
	}

	public Valuable[] withdraw(double amount) {
		List<Valuable> templist = new ArrayList<Valuable>();
		money.addAll(templist);
		Collections.sort(templist, new CompareValuable());
		Collections.reverse(templist);
		for( Valuable c : money ){
			if(c.getValue()<=amount){
				amount -= c.getValue();
				templist.add(c);
			}
		}

		System.out.println(templist.size());

		if(amount == 0){
			for(Valuable c : templist){
				if(money.contains(c)){
					money.remove(c);
				}
			}
			Valuable[] valuable = new Valuable[templist.size()];
			templist.toArray(valuable);
			return valuable;
		}
		else return null;
	}

	@Override
	public String toString() {
		return "Purse [capacity=" + capacity + ", balance=" + balance + ", money=" + money + "]";
	}
}
class CompareValuable implements Comparator<Valuable>{

	@Override
	public int compare(Valuable o1, Valuable o2) {
		if(o1.getValue()<o2.getValue()) return -1;
		else if(o1.getValue()>o2.getValue()) return 1;
		else return 0;
	}

}
