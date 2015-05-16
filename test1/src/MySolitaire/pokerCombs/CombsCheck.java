package MySolitaire.pokerCombs;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import MySolitaire.Card;

public class CombsCheck {
	boolean one_suit = true;
	LinkedList<Card> cards = new LinkedList<>();
	LinkedList<PokerCombs> combs = new LinkedList<>();
	{
		combs.add(PokerCombs.ROYAL_FLUSH);
		combs.add(PokerCombs.STRAIGHT_FLUSH);
		combs.add(PokerCombs.FOUR_KIND);
		combs.add(PokerCombs.FULL_HOUSE);
		combs.add(PokerCombs.FLUSH);
		combs.add(PokerCombs.STRAIGHT);
		combs.add(PokerCombs.TWO_PAIRS);
		combs.add(PokerCombs.ONE_PAIR);
		combs.add(PokerCombs.HIGH_HAND);
	}

	String getCombs() {
		String res = new String();

		for (PokerCombs comb : combs) {
			res += comb.toString() + "\n";
		}

		return res;
	}

	void addCard(final Card card) {
		cards.add(card);

		if (cards.size() == 5) {

			checkRF();
			checkSF();
			checkFK();
			checkF();
			checkS();
			checkTK();
			checkTP();
			checkOP();

		}

	}

	public boolean checkRF() {
		for (int i = 0; i < cards.size(); i++) {
			Card o1 = cards.get(i);
			if (o1.getRank() < Rank.TEN.getRank() && !o1.isAce()) {
				combs.remove(PokerCombs.ROYAL_FLUSH);
			}
			if (i != cards.size() - 1) {
				Card o2 = cards.get(i + 1);
				if (o1.getSuit() != o2.getSuit()) {
					combs.remove(PokerCombs.ROYAL_FLUSH);
				}
			}
		}

		return false;
	}

	public boolean checkSF() {
		Collections.sort(cards, new Comparator<Card>() {
			@Override
			public int compare(final Card o1, final Card o2) {
				if (o1.getRank() > o2.getRank())
					return 1;
				else if (o1.getRank() < o2.getRank()) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		for (int i = 0; i < cards.size() - 1; i++) {
			Card o1 = cards.get(i);
			Card o2 = cards.get(i + 1);
			if (Math.abs(o1.getRank() - o2.getRank()) != 1
					|| o1.getSuit() != o2.getSuit()) {
				combs.remove(PokerCombs.STRAIGHT_FLUSH);
			}
		}

		return false;
	}

	public boolean checkFK() {
		Collections.sort(cards, new Comparator<Card>() {
			@Override
			public int compare(final Card o1, final Card o2) {
				if (o1.getRank() > o2.getRank())
					return 1;
				else if (o1.getRank() < o2.getRank()) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		int same_count = 0;

		for (int i = 0; i < cards.size() - 1; i++) {
			Card o1 = cards.get(i);
			Card o2 = cards.get(i + 1);
			if (o1.getRank() == o2.getRank()) {
				same_count++;
			}
		}

		if (same_count != 3)
			combs.remove(PokerCombs.FOUR_KIND);

		return false;
	}

	public boolean checkFH() {
		return false;
	}

	public boolean checkF() {
		return false;
	}

	public boolean checkS() {
		return false;
	}

	public boolean checkTK() {
		return false;
	}

	public boolean checkTP() {
		return false;
	}

	public boolean checkOP() {
		return false;
	}

	@Override
	public String toString() {
		String res = new String();

		for (Card card : cards) {
			res += card.toString() + "\n";
		}

		return res;
	}

	public static void main(final String[] args) {
		CombsCheck check = new CombsCheck();
		
		check.addCard(new Card(Suit.HEART, Rank.KING));
		check.addCard(new Card(Suit.HEART, Rank.ICE));
		check.addCard(new Card(Suit.HEART, Rank.LADY));
		check.addCard(new Card(Suit.HEART, Rank.JACK));
		check.addCard(new Card(Suit.HEART, Rank.TEN));
		
//		check.addCard(new Card(Suit.HEART, Rank.FOUR));
//		check.addCard(new Card(Suit.DIAMOND, Rank.FOUR));
//		check.addCard(new Card(Suit.SPADE, Rank.FOUR));
//		check.addCard(new Card(Suit.CLUB, Rank.FOUR));
//		check.addCard(new Card(Suit.HEART, Rank.SIX));

		System.out.println(check);
		System.out.println(check.getCombs());
	}
}
