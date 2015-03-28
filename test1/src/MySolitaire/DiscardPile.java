package MySolitaire;

class DiscardPile extends CardPile {

	DiscardPile(final int x, final int y) {
		super(x, y);
	}

	@Override
	public void addCard(final Card aCard) {
		if (!aCard.isFaceUp()) {
			aCard.flip();
		}
		super.addCard(aCard);
	}

	@Override
	public void select(final int tx, final int ty) {
		if (empty()) {
			return;
		}
		
		Solitaire.selected_pile = this;
		top().setSelected(true);
		Solitaire.selected_cards .addFirst(pop());
		Solitaire.have_select = true;		
	}
}