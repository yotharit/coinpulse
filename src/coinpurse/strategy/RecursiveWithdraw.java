package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Coin;
import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		List<Valuable> list = new ArrayList<Valuable>();
		if(amount == 0 && money.isEmpty()) return list;
		if(amount != 0 && money.isEmpty()) return null;
		if(amount < 0) return null;
		if((list = withdraw(amount - money.get(0).getValue() , money.subList(1, money.size()))) != null){
			list.add(money.get(0));
			return list;
		}
		else if(( list = withdraw(amount, money.subList(1, money.size()))) != null){
			return list;
		} 
		return null;
	}	
}
