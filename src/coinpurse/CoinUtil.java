package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns only the coins
	 * that have a currency that matches the parameter value.
	 * 
	 * @param coinlist
	 *            is a List of Coin objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist that have
	 *         the requested currency.
	 */
	public static List<Coin> filterByCurrency(final List<Coin> coinlist, String currency) {
		List<Coin> result = new ArrayList<Coin>();
		for (Coin c : coinlist) {
			if (c.getCurrency().equalsIgnoreCase(currency))
				result.add(c);
		}
		return result;
	}

	/**
	 * Method to sort a list of coins by currency. On return, the list (coins)
	 * will be ordered by currency.
	 * 
	 * @param coins
	 *            is a List of Coin objects we want to sort.
	 *
	 *            TODO: 1. Write a Comparator<Coin> (you can write the class at
	 *            the end of this file. Declare it as "class CompareByCurrency"
	 *            without the "public"). You can also write Comparator as an
	 *            anonymous class, if you know how. The compare method should
	 *            order coins by currency. 2. Create a comparator instance and
	 *            use it to sort the coins.
	 */
	public static void sortByCurrency(List<Coin> coins) {
		Collections.sort(coins, new CompareByCurrency());
	}

	/**
	 * Sum coins by currency and print the sum for each currency. Print one line
	 * for the sum of each currency. For example: coins = { Coin(1,"Baht"),
	 * Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") } then
	 * sumByCurrency(coins) would print:
	 * 
	 * 11.00 Baht 20.50 Ringgit
	 * 
	 * Hint: this is easy if you sort the coins by currency first. :-)
	 */
	public static void sumByCurrency(List<Coin> coins) {
		sortByCurrency(coins);
		String currentCurrency = coins.get(0).getCurrency();
		double sum = 0;
		for ( int i = 0; i<coins.size(); i++ ){
			if( coins.get(i).getCurrency().equals(currentCurrency) ){
				sum += coins.get(i).getValue();
			}
			if( !coins.get(i).getCurrency().equals(currentCurrency) ) {
				System.out.printf("%.2f %s\n",sum,currentCurrency);
				sum = 0;
				currentCurrency = coins.get(i).getCurrency();
			}
		}
		System.out.printf("%.2f %s\n",sum,currentCurrency);
	}

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of " + currency);
		List<Coin> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		List<Coin> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (coins.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		sortByCurrency(coins);
		System.out.print("RESULT: ");
		printList(coins, " ");

		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= ");
		printList(coins, " ");
		sumByCurrency(coins);

	}

	/** Make a list of coins containing different currencies. */
	public static List<Coin> makeInternationalCoins() {
		List<Coin> money = new ArrayList<Coin>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of coins using given values. */
	public static List<Coin> makeCoins(String currency, double... values) {
		List<Coin> list = new ArrayList<Coin>();
		for (double value : values)
			list.add(new Coin(value, currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext())
				System.out.print(separator);

		}
		System.out.println(); // end the line
	}
}

class CompareByCurrency implements Comparator<Coin> {
	@Override
	public int compare(Coin c1, Coin c2) {
		return c1.getCurrency().compareToIgnoreCase(c2.getCurrency());
	}

}
