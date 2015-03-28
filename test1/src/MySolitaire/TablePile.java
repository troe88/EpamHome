package MySolitaire;

import java.awt.Graphics;

class TablePile extends CardPile {

	TablePile(final int x, final int y, final int c) {
		// initialize the parent class
		super(x, y);
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
		return x <= tx && tx <= x + Card.width && y <= ty
				&& ty <= y + 35 * (_card_count + 1);
	}

	@Override
	public void select(final int tx, final int ty) {

		Card card = top();

		if (!card.isFaceUp()) {
			top().flip();
			return;
		}

		int count = _card_count - 1;

		TOP: while (card != null) {
			int bot = (y + Card.height + count * 35);
			int top = (y + count * 35);
			if (top <= ty && ty <= bot) {
				break TOP;
			}
			card = card.link;
			count--;
		}

		if (!card.isFaceUp())
			return;

		int s = _card_count - count;

		for (int i = 0; i < s; i++) {
			top().setSelected(true);
			Solitaire.selected_cards.addFirst(pop());
		}

		Solitaire.selected_pile = this;
		Solitaire.have_select = true;

	}

	@Override
	public void mark() {
		top().setCanGet(true);
	}
	
	@Override
	public void unMark() {
		top().setCanGet(false);
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