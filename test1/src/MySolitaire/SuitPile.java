package MySolitaire;

import java.awt.Graphics;

class SuitPile extends CardPile {

	SuitPile(final int x, final int y) {
		super(x, y);
		is_mark = false;
	}

	@Override
	public boolean canTake(final Card aCard) {

		if (Solitaire.getSelectedCount() != 1) {
			return false;
		}

		if (empty()) {
			return aCard.isAce();
		}

		Card topCard = top();
		return (aCard.getSuit() == topCard.getSuit())
				&& (aCard.getRank() == 1 + topCard.getRank());
	}
	
	@Override
	public void display(final Graphics g) {

		
		if(top() != null && is_mark)
			top().setCanGet(true);
		
		super.display(g);
	}
	
	

	
}