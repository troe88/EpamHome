package MySolitaire;

import java.awt.Graphics;

class TablePile extends CardPile {

	private int _index;
	
	TablePile(final int x, final int y, final int c, final int index) {
		// initialize the parent class
		super(x, y);
		_index = index;
		// then initialize our pile of cards
		for (int i = 0; i < c; i++) {
			addCard(Solitaire.deckPile.pop());
		}
		// flip topmost card face up
		top().flip();
	}

	@Override
	public boolean canTake(final Card aCard) {
		if (empty()) {
			return aCard.isKing();
		}
		Card topCard = top();
		return (aCard.color() != topCard.color())
				&& (aCard.getRank() == topCard.getRank() - 1);
	}

	@Override
	public void display(final Graphics g) {
		stackDisplay(g, top());
	}

	@Override
	public boolean includes(final int tx, final int ty) {
		// don't test bottom of card
		boolean is_inc = false;
		if(x <= tx && tx <= x + Card.width && y <= ty){
			is_inc = true;
			System.out.println(_index + " : " + top().getRank());
		}
		
		return is_inc;
	}

	@Override
	public void select(final int tx, final int ty) {
		if (empty()) {
			return;
		}

		// if face down, then flip
		Card topCard = top();
		if (!topCard.isFaceUp()) {
			topCard.flip();
			return;
		}

		suitTakeCard();
	}

	private int stackDisplay(final Graphics g, final Card aCard) {
		int localy;
		if (aCard == null) {
			return y;
		}
		localy = stackDisplay(g, aCard.link);
		aCard.draw(g, x, localy);
		return localy + 35;
	}

}