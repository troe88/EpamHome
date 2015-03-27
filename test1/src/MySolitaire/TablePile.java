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
		return x <= tx && tx <= x + Card.width && y <= ty;
	}

	@SuppressWarnings("unused")
	@Override
	public void whatCard(final int tx, final int ty) {

		if (top() == null)
			return;

		if (!top().isFaceUp()) {
			top().flip();
			return;
		}

		int count = _card_count - 1;

		Card card = top();
		TOP: while (card != null) {
			int bot = (y + Card.height + count * 35);
			int top = (y + count * 35);
			if (top <= ty && ty <= bot) {
				System.out.println(card.getRank() + 1);
				break TOP;
			}

			card = card.link;
			count--;
		}
		
		if (card == null) {
			System.out.println("err");
			return;
		}
		
		if (card.isFaceUp() == false) {
			return;
		}



		card.setSelected(true);
		Solitaire.selected_card = card;
		Solitaire.have_select = true;

		Card temp = top();
		int card_to_drop = 1;
		while (temp != card) {
			card_to_drop++;
			temp.setSelected(true);
			temp = temp.link;
		}

		Solitaire.select_count.put(card_to_drop, this);

	}

	@Override
	public void select(final int tx, final int ty) {
		whatCard(tx, ty);
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