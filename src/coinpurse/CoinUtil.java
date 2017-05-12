package coinpurse;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	 * @throws Exception 
	 */
	public static List<Valuable> filterByCurrency(final List<? extends Valuable> coinlist, String currency) throws Exception {

		if(currency == null) throw new Exception();
		Predicate<Valuable> predicateCurrency = (t) -> (t.getCurrency().equals(currency));
		return coinlist.stream().filter(predicateCurrency).collect(Collectors.toList());					
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
	public static void sortByCurrency(List<? extends Valuable> coins) {
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
	public static void sumByCurrency(List<Valuable> valuable) {

		Map<String, Double> moneyMap = new HashMap<String, Double>();
		for(Valuable value: valuable){
			String currency = value.getCurrency();
			Double orDefault = moneyMap.getOrDefault(currency, 0.0);
			double value2 = value.getValue();
			moneyMap.put(currency, orDefault+value2);
		}
		for(Map.Entry<String, Double> value : moneyMap.entrySet()){
			System.out.println(value.toString());
		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args
	 *            not used
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		//Test For max,sortByCurrency,filterByCurrency
		String m = CoinUtil.max("canary", "dog");
		System.out.println("Max of canary and dog is " + m);
		Valuable max = CoinUtil.max(new Coin(5), new Coin(10),new BankNote(100));
		System.out.println(max.toString());
		//Test For sortByCurrency
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		CoinUtil.sortByCurrency(money);
		System.out.println(money);
		//Test For filterByCurrency
		money = CoinUtil.filterByCurrency(money, "Baht");
		System.out.println(money);

		
		
		
		
//		String currency = "Rupee";
//		System.out.println("Filter coins by currency of " + currency);
//		List<Valuable> valuable = makeInternationalCoins();
//		int size = valuable.size();
//		System.out.print(" INPUT: ");
//		printList(valuable, " ");
//		List<Valuable> rupees = filterByCurrency(valuable, currency);
//		System.out.print("RESULT: ");
//		printList(rupees, " ");
//		if (valuable.size() != size)
//			System.out.println("Error: you changed the original list.");
//
//		System.out.println("\nSort coins by currency");
//		valuable = makeInternationalCoins();
//		System.out.print(" INPUT: ");
//		printList(valuable, " ");
//		sortByCurrency(valuable);
//		System.out.print("RESULT: ");
//		printList(valuable, " ");
//
//		System.out.println("\nSum coins by currency");
//		valuable = makeInternationalCoins();
//		System.out.print("coins= ");
//		printList(valuable, " ");
//		sumByCurrency(valuable);

	}

	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of coins using given values. */
	public static List<Valuable> makeCoins(String currency, double... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (double value : values)
			list.add(new Coin(value, currency, currency));
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
	
	public static <E extends Comparable<? super E>> E max(E ... a){
		List<E> list = Arrays.asList(a);
		return list.stream().max((e1,e2) -> e1.compareTo(e2)).get();
	}
}

class CompareByCurrency implements Comparator<Valuable> {
	@Override
	public int compare(Valuable c1, Valuable c2) {
		return c1.getCurrency().compareToIgnoreCase(c2.getCurrency());
	}

}
