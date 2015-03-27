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
		
		Card card = pop();
		card.setSelected(true);
		Solitaire.selected_card = card;
		Solitaire.have_select = true;
		Solitaire.select_count.put(1, this);
		
	}
}