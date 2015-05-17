package MySolitaire.pokerCombs;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import MySolitaire.Card;

public class CombsCheck2 {
	LinkedList<Card> _sort_rank;
	LinkedList<Card> _sort_suit;

	PokerCombs check(final List<Card> in) {

		sortRank(in);
		sortSuit(in);

		if (royalFlush())
			return PokerCombs.ROYAL_FLUSH;
		if (straightFlush())
			return PokerCombs.STRAIGHT_FLUSH;
		if (fourKind())
			return PokerCombs.FOUR_KIND;
		if (fullHouse())
			return PokerCombs.FULL_HOUSE;
		if (flush())
			return PokerCombs.FLUSH;
		if (straight())
			return PokerCombs.STRAIGHT;
		if (threeKind())
			return PokerCombs.THREE_KIND;
		if (twoPair())
			return PokerCombs.TWO_PAIRS;
		if (onePair())
			return PokerCombs.ONE_PAIR;

		return PokerCombs.HIGH_HAND;

		// PokerCombs result = PokerCombs.HIGH_HAND;
		//
		// if (twoPair())
		// result = PokerCombs.TWO_PAIRS;
		// if (onePair())
		// result = PokerCombs.ONE_PAIR;
		// if (threeKind())
		// result = PokerCombs.THREE_KIND;
		// if (straight())
		// result = PokerCombs.STRAIGHT;
		// if (flush())
		// result = PokerCombs.FLUSH;
		// if (fullHouse())
		// result = PokerCombs.FULL_HOUSE;
		// if (fourKind())
		// result = PokerCombs.FOUR_KIND;
		// if (straightFlush())
		// result = PokerCombs.STRAIGHT_FLUSH;
		// if (royalFlush())
		// result = PokerCombs.ROYAL_FLUSH;
		//
		// return result;
	}

	private boolean somePair(final int some_card_kind) {
		int kind = 1;
		int rank = _sort_rank.getFirst().getRank();
		for (Card card : _sort_rank) {
			if (card.getRank() != rank) {
				kind++;
				rank = card.getRank();
			}
		}
		if (kind == some_card_kind)
			return true;
		return false;
	}

	private boolean twoPair() {
		return somePair(3);
	}

	private boolean onePair() {
		return somePair(4);
	}

	private boolean threeKind() {
		return someKind(3);
	}

	private boolean isNextMoreOne(final LinkedList<Card> data) {
		for (int i = 0; i < data.size() - 1; i++) {
			if ((data.get(i).getRank() + 1) - data.get(i + 1).getRank() != 0)
				return false;
		}
		return true;
	}

	private boolean straight() {
		if (!_sort_rank.getFirst().isAce()) {
			return isNextMoreOne(_sort_rank);
		} else {
			LinkedList<Card> temp = new LinkedList<Card>(_sort_rank);
			Collections.copy(temp, _sort_rank);
			temp.removeFirst();
			if (isNextMoreOne(temp)) {
				if (_sort_rank.getLast().getRank() != Rank.KING.getRank()
						&& _sort_rank.get(1).getRank() != Rank.TWO.getRank())
					return false;
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean flush() {
		if (_sort_suit.getFirst().getSuit() != _sort_suit.getLast().getSuit())
			return false;
		return true;
	}

	private boolean fullHouse() {
		Card left = _sort_rank.getFirst();
		Card right = _sort_rank.getLast();

		if (left.getRank() == _sort_rank.get(2).getRank()
				&& right.getRank() == _sort_rank.get(3).getRank()) {
			return true;
		} else if (left.getRank() == _sort_rank.get(1).getRank()
				&& right.getRank() == _sort_rank.get(2).getRank()) {
			return true;
		}

		return false;
	}

	private boolean fourKind() {
		return someKind(4);
	}

	private boolean someKind(final int some) {
		int temp_rank = _sort_rank.get(0).getRank();
		int count = 1;
		for (int i = 1; i < _sort_rank.size(); i++) {
			if (temp_rank == _sort_rank.get(i).getRank()) {
				count++;
			} else {
				temp_rank = _sort_rank.get(i).getRank();
				count = 1;
			}
			if (count == some) {
				return true;
			}
		}
		return false;
	}

	private boolean straightFlush() {
		int d_rank = Math.abs(_sort_rank.getFirst().getRank()
				- _sort_rank.getLast().getRank());
		if (_sort_suit.getFirst().getSuit() != _sort_suit.getLast().getSuit()
				|| d_rank != 4)
			return false;
		return true;
	}

	private boolean royalFlush() {
		if (_sort_suit.getFirst().getSuit() != _sort_suit.getLast().getSuit())
			return false;

		for (int i = 0; i < _sort_rank.size(); i++) {
			Card o1 = _sort_rank.get(i);
			if (o1.getRank() < Rank.TEN.getRank() && !o1.isAce()) {
				return false;
			}
		}
		return true;
	}

	private void sortSuit(final List<Card> in) {
		_sort_suit = new LinkedList<Card>(in);
		Collections.copy(_sort_suit, in);
		Collections.sort(_sort_suit, new Comparator<Card>() {
			@Override
			public int compare(final Card o1, final Card o2) {
				if (o1.getSuit() > o2.getSuit())
					return 1;
				else if (o1.getSuit() < o2.getSuit()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}

	private void sortRank(final List<Card> in) {
		_sort_rank = new LinkedList<Card>(in);
		Collections.copy(_sort_rank, in);
		Collections.sort(_sort_rank, new Comparator<Card>() {
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
	}
}
