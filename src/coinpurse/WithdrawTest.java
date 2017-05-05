package coinpurse;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import coinpurse.strategy.GreedyWithdraw;

public class WithdrawTest {

	private Purse purse;
	private GreedyWithdraw greedyStrategy;
	
	@Before
	public void setUp() throws Exception {
		this.purse = new Purse(10);
		this.greedyStrategy = new GreedyWithdraw();
		purse.setWithdrawStrategy(greedyStrategy);
	}

	@Test
	public void withdrawEmptyPurse() {
		assertNull("Should return null", purse.withdraw(10));
	}
	
	@Test
	public void withdrawInvalidValue() {
		purse.insert(new Coin(10));
		assertNull("Should return null",purse.withdraw(40));
		assertNull("Should return null",purse.withdraw(30));
		assertNull("Should return null",purse.withdraw(100));
	}
	
	@Test
	public void simpleWithdrawValidValue() {
		purse.insert(new Coin(10));
		Valuable[] value = {new Coin(10)};
		assertEquals(value, purse.withdraw(10));
	}
	
	@Test
	public void multipleWithdrawValidValue() {
		purse.insert(new Coin(10));
		purse.insert(new Coin(10));
		purse.insert(new Coin(10));
		Valuable[] value = {new Coin(10),new Coin(10)};
		assertEquals(value, purse.withdraw(20));
	}

}
