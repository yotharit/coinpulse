package coinpurse;

public abstract class MoneyFactory {
	// static instance
	private static MoneyFactory factory = null;

	protected MoneyFactory() {
	}

	public static MoneyFactory getInstance() {
		if (factory == null)
			factory = new ThaiMoneyFactory();
		return factory;
	}

	public abstract Valuable createMoney(double value);

	public Valuable createMoney(String value) {
		return createMoney(Double.parseDouble(value));
	}
}
