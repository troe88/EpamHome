package MySolitaire;

import java.awt.Color;
import java.awt.Graphics;

class CardPile {

	private Card firstCard;

	// coordinates of the card pile
	protected int x;
	protected int y;
	
	protected int _card_count;
	
	CardPile(final int xl, final int yl) {
		x = xl;
		y = yl;
		firstCard = null;
		_card_count = 0;
	}

	// the following are sometimes overridden

	public void addCard(final Card aCard) {
		aCard.setSelected(false);
		aCard.link = firstCard;
		firstCard = aCard;
		_card_count++;
	}

	public boolean canTake(final Card aCard) {
		return false;
	}

	public void display(final Graphics g) {
		g.setColor(Color.black);
		if (firstCard == null) {
			g.drawRect(x, y, Card.width, Card.height);
		} else {
			firstCard.draw(g, x, y);
		}
	}

	public boolean empty() {
		return firstCard == null;
	}

	public void suitTakeCard() {
		Card topCard = pop();
		for (int i = 0; i < 4; i++) {
			if (Solitaire.suitPile[i].canTake(topCard)) {
				Solitaire.suitPile[i].addCard(topCard);
				return;
			}
		}
		for (int i = 0; i < 7; i++) {
			if (Solitaire.tableau[i].canTake(topCard)) {
				Solitaire.tableau[i].addCard(topCard);
				return;
			}
		}
		// nobody can use it, put it back on our list
		addCard(topCard);
	}

	public boolean includes(final int tx, final int ty) {
		return x <= tx && tx <= x + Card.width &&
			   y <= ty && ty <= y + Card.height;
	}

	public Card pop() {
		Card result = null;
		if (firstCard != null) {
			result = firstCard;
			firstCard = firstCard.link;
		}
		_card_count--;
		return result;
	}

	public void select(final int tx, final int ty) {
		// do nothing
	}

	public Card top() {
		return firstCard;
	}

	public void whatCard(final int x, final int y) {
		
	}

	public void dropSelect() {
		Card card = top();
		while(card != null){
			card.setSelected(false);
			card = card.link;
		}
	}
}