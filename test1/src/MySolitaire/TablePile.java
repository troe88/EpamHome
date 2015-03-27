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
		
		if(true){
			return true;
		}
		
		boolean is_inc = false;

		int bot = (y + Card.height + (_card_count - 1) * 35);
		int top = (y + (_card_count - 1) * 35);

		if (x <= tx && tx <= x + Card.width && top <= ty && ty <= bot) {
			is_inc = true;
			System.out.println("yes");
		}

		return is_inc;
	}

	@Override
	public void whatCard(final int tx, final int ty) {

		if (x <= tx && tx <= x + Card.width && y <= ty) {

			int count = _card_count - 1;

			System.out.println();
			Card card = top();
			TOP: while (card != null) {
				int bot = (y + Card.height + count * 35);
				int top = (y + count * 35);
				if (top <= ty && ty <= bot) {
					System.out.println((count + 1) + " : "
							+ (card.getRank() + 1));
					break TOP;
				}

				card = card.link;
				count--;
			}
			
			System.out.println("qwe");
			if (card == null)
				return;

			if (!card.isFaceUp())
				return;
			
			System.out.println("qwe");
			
			Card temp = top();
			card.setSelected(true);
			Solitaire.selected_card = card;
			Solitaire.select_card.put(card, this);
			Solitaire.have_select = true;

			int card_to_drop = 1;
			while (temp != card) {
				card_to_drop++;
				Solitaire.select_card.put(temp, this);
				temp.setSelected(true);
				temp = temp.link;
			}

			Solitaire.select_count.put(card_to_drop, this);
		}
	}

	@Override
	public void select(final int tx, final int ty) {
		whatCard(tx, ty);
		
		
//		if (empty()) {
//			return;
//		}

		// if face down, then flip
//		Card topCard = top();
//		if (!topCard.isFaceUp()) {
//			topCard.flip();
//			return;
//		}
//
//		Card c = top();
//		c.setSelected(true);
//		Solitaire.select_card.put(c, this);
//		Solitaire.have_select = true;

		// suitTakeCard();
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