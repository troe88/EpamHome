package MySolitaire.pokerCombs;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import MySolitaire.Card;

@RunWith(Parameterized.class)
public class PokerCombsTest2 {

	private List<Card> _in;
	private PokerCombs _out;

	@Parameters
	public static List<Object[]> data() {
		return Arrays
				.asList(new Object[][] { 
						{ Arrays.asList(
								new Card(Suit.CLUB, Rank.ICE),
								new Card(Suit.CLUB, Rank.KING), 
								new Card(Suit.CLUB, Rank.LADY ),
								new Card(Suit.CLUB, Rank.JACK),
								new Card(Suit.CLUB, Rank.TEN )
								), 
								PokerCombs.ROYAL_FLUSH },
						{ Arrays.asList(
								new Card(Suit.HEART, Rank.KING), 
								new Card(Suit.HEART, Rank.ICE ),
								new Card(Suit.HEART, Rank.LADY), 
								new Card(Suit.HEART, Rank.JACK),
								new Card(Suit.HEART, Rank.TEN )
								),
								PokerCombs.ROYAL_FLUSH },
						{ Arrays.asList(
								new Card(Suit.DIAMOND, Rank.TWO), 
								new Card(Suit.DIAMOND, Rank.THREE ),
								new Card(Suit.DIAMOND, Rank.FOUR), 
								new Card(Suit.DIAMOND, Rank.FIVE),
								new Card(Suit.DIAMOND, Rank.SIX)
								),PokerCombs.STRAIGHT_FLUSH },
						{ Arrays.asList(
								new Card(Suit.HEART, Rank.ICE), 
								new Card(Suit.DIAMOND, Rank.KING),
								new Card(Suit.HEART, Rank.ICE),
								new Card(Suit.SPADE, Rank.ICE),
								new Card(Suit.CLUB, Rank.ICE )
								), PokerCombs.FOUR_KIND },
						{ Arrays.asList(
								new Card(Suit.HEART, Rank.ICE), 
								new Card(Suit.DIAMOND, Rank.ICE),
								new Card(Suit.SPADE, Rank.ICE),
								new Card(Suit.SPADE, Rank.KING),
								new Card(Suit.CLUB, Rank.KING )
								), PokerCombs.FULL_HOUSE },
						{ Arrays.asList(
								new Card(Suit.HEART, Rank.FOUR), 
								new Card(Suit.DIAMOND, Rank.FOUR),
								new Card(Suit.SPADE, Rank.FOUR),
								new Card(Suit.SPADE, Rank.TWO),
								new Card(Suit.CLUB, Rank.TWO )
								), PokerCombs.FULL_HOUSE },
						{ Arrays.asList(
								new Card(Suit.DIAMOND, Rank.KING),
								new Card(Suit.SPADE, Rank.TWO),
								new Card(Suit.CLUB, Rank.LADY),
								new Card(Suit.HEART, Rank.SIX),
								new Card(Suit.HEART, Rank.TEN )
								), PokerCombs.HIGH_HAND },
//						{ Arrays.asList(
//								new Card(Suit.HEART, Rank.KING), 
//								new Card(Suit.HEART, Rank.ICE ),
//								new Card(Suit.HEART, Rank.LADY), 
//								new Card(Suit.HEART, Rank.JACK),
//								new Card(Suit.HEART, Rank.TEN )), PokerCombs.HIGH_HAND },
			});
	}

	public PokerCombsTest2(final List<Card> in, final PokerCombs out) {
		_in = in;
		_out = out;
	}

	@Test
	public void test() {
		CombsCheck2 cc2 = new CombsCheck2();
		assertEquals(_out, cc2.check(_in));
	}

}
