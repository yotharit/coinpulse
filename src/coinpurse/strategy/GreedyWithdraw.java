package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;

public class GreedyWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		List<Valuable> templist = new ArrayList<Valuable>();
		List<Valuable> tempmoney = new ArrayList<Valuable>();
		tempmoney.addAll(money); //Use it instead of money
		Collections.sort(tempmoney, new CompareValuable());
		Collections.reverse(tempmoney);
		for( Valuable c : tempmoney ){
			if(c.getValue()<=amount){
				amount -= c.getValue();
				templist.add(c);

			}
		}
		if(amount == 0) return templist;
		else return null;
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
