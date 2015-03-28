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
		
		Solitaire.s_pile = this;
		top().setSelected(true);
		Solitaire.st_cards.addFirst(pop());
		Solitaire.have_select = true;		
	}
}

// Выбрать карту по маусДаун() pop()
// Перемещать карту вслед за курсором
// По маусАП() вернуть карту на место.