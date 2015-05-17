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
public class CombsCheckTest2ThreeKind {

	private List<Card> _in;
	private PokerCombs _out;

	@Parameters
	public static List<Object[]> data() {
		return Arrays
				.asList(new Object[][] { 
						{ Arrays.asList(
								new Card(Suit.DIAMOND, 	Rank.ICE),
								new Card(Suit.CLUB, 	Rank.ICE), 
								new Card(Suit.HEART, 	Rank.ICE ),
								new Card(Suit.CLUB, 	Rank.JACK),
								new Card(Suit.SPADE, 	Rank.TEN )
								), 
								PokerCombs.THREE_KIND },
						{ Arrays.asList(
								new Card(Suit.DIAMOND, 	Rank.TEN),
								new Card(Suit.CLUB, 	Rank.SEVEN), 
								new Card(Suit.HEART, 	Rank.TEN ),
								new Card(Suit.CLUB, 	Rank.FIVE),
								new Card(Suit.SPADE, 	Rank.TEN )
								), 
								PokerCombs.THREE_KIND },
						{ Arrays.asList(
								new Card(Suit.DIAMOND, 	Rank.ICE),
								new Card(Suit.CLUB, 	Rank.TWO), 
								new Card(Suit.HEART, 	Rank.TWO),
								new Card(Suit.CLUB, 	Rank.FOUR),
								new Card(Suit.SPADE, 	Rank.TWO )
								), 
								PokerCombs.THREE_KIND },
						{ Arrays.asList(
								new Card(Suit.DIAMOND, Rank.KING),
								new Card(Suit.SPADE, Rank.TWO),
								new Card(Suit.CLUB, Rank.LADY),
								new Card(Suit.HEART, Rank.SIX),
								new Card(Suit.HEART, Rank.TEN )
								), PokerCombs.HIGH_HAND },
			});
	}

	public CombsCheckTest2ThreeKind(final List<Card> in, final PokerCombs out) {
		_in = in;
		_out = out;
	}

	@Test
	public void test() {
		CombsCheck2 cc2 = new CombsCheck2();
		PokerCombs res = cc2.check(_in);
		
		for (Card card : cc2._sort_rank) {
			System.out.print(card + ", ");
		}
		System.out.println();
		assertEquals(_out, res);
	}


}
