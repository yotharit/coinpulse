package coinpurse;

public class Test {
	public static void main(String[] args) {
		Coin c = new Coin(0.5);
		System.out.println(c);
		MoneyFactory t = ThaiMoneyFactory.getInstance();
		Valuable v = t.createMoney(0.5);
		System.out.println(v);
	}
}
