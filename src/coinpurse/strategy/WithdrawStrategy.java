package coinpurse.strategy;

import java.util.List;
import coinpurse.Valuable;

public interface WithdrawStrategy {
	/**
	 * Looking through purse to find and return a collection of money to withdraw the requested amount
	 * @param amount amount of money that will be withdraw
	 * @param money	contents that will be able to withdraw
	 * @return if a solution found, return a list containing references from the money parameter (List) whose
	 * 		   sum equals the amount.
	 */
	public List<Valuable> withdraw(double amount, List<Valuable> money);
}
