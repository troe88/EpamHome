package MySolitaire.pokerCombs;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import MySolitaire.Card;
public class CombsCheckTest {

	CombsCheck check;

	@Before
	public void setup() {
		check = new CombsCheck();
	}

	@Test
	public void checkRF() {
		check.addCard(new Card(Suit.HEART, Rank.KING));
		check.addCard(new Card(Suit.HEART, Rank.LADY));
		check.addCard(new Card(Suit.HEART, Rank.JACK));
		check.addCard(new Card(Suit.HEART, Rank.ICE));
		check.addCard(new Card(Suit.HEART, Rank.TEN));
		
		if(!check.combs.contains(PokerCombs.ROYAL_FLUSH))
			fail();
			
	}

	@Test
	public void checkNoRF() {
		check.addCard(new Card(Suit.HEART, Rank.KING));
		check.addCard(new Card(Suit.DIAMOND, Rank.LADY));
		check.addCard(new Card(Suit.HEART, Rank.JACK));
		check.addCard(new Card(Suit.HEART, Rank.ICE));
		check.addCard(new Card(Suit.HEART, Rank.TEN));
		
		if(check.combs.contains(PokerCombs.ROYAL_FLUSH))
			fail();
			
	}
	
	@Test
	public void checkSF() {
		check.addCard(new Card(Suit.HEART, Rank.SIX));
		check.addCard(new Card(Suit.HEART, Rank.TWO));
		check.addCard(new Card(Suit.HEART, Rank.THREE));
		check.addCard(new Card(Suit.HEART, Rank.FIVE));
		check.addCard(new Card(Suit.HEART, Rank.FOUR));
		
		if(!check.combs.contains(PokerCombs.STRAIGHT_FLUSH))
			fail();
			
	}
	
	@Test
	public void checkNoSF() {
		check.addCard(new Card(Suit.HEART, Rank.TWO));
		check.addCard(new Card(Suit.HEART, Rank.THREE));
		check.addCard(new Card(Suit.HEART, Rank.TEN));
		check.addCard(new Card(Suit.HEART, Rank.FIVE));
		check.addCard(new Card(Suit.HEART, Rank.SIX));
		
		if(check.combs.contains(PokerCombs.STRAIGHT_FLUSH))
			fail();
			
	}
	
}
