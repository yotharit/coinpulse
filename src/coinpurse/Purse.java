package coinpurse;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import coinpurse.strategy.WithdrawStrategy;

public class Purse extends Observable {
	private int capacity;
	private double balance;
	List<Valuable> money = new ArrayList<Valuable>();
	private WithdrawStrategy strategy;

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
		setChanged();
		notifyObservers();
		return true;
	}

	public Valuable[] withdraw(double amount) {
		List<Valuable> templist = new ArrayList<Valuable>();
		if(strategy.withdraw(amount, money) != null){
		templist.addAll(strategy.withdraw(amount, money));
		for(Valuable c : templist){
			if(money.contains(c)){
				money.remove(c);
			}
		}
		Valuable[] withdrawMoney = new Valuable[templist.size()]; 
		setChanged();
		notifyObservers();
		return templist.toArray(withdrawMoney);
		}
		return null;
	}
	
	public void setWithdrawStrategy(WithdrawStrategy strategy){
		this.strategy = strategy;
	}

	@Override
	public String toString() {
		return "Purse [capacity=" + capacity + ", balance=" + balance + ", money=" + money + "]";
	}


}

