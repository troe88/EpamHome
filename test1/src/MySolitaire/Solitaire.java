package MySolitaire;

/*
 Simple Solitaire Card Game in Java
 Written by Tim Budd, Oregon State University, 1996
 */

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class Solitaire extends Applet {
	static CardPile allPiles[];
	static DeckPile deckPile;
	static DiscardPile discardPile;
	static SuitPile suitPile[];
	static CardPile tableau[];

	static Map<Card, CardPile> select_card;
	static Map<Integer, CardPile> select_count;
	static boolean have_select;
	static Card selected_card;
	private int _X;
	private int _Y;

	@Override
	public void init() {
		select_card = new HashMap<Card, CardPile>(1);
		select_count = new HashMap<Integer, CardPile>(1);
		have_select = false;
		// first allocate the arrays
		allPiles = new CardPile[13];
		suitPile = new SuitPile[4];
		tableau = new CardPile[7];
		// then fill them in
		allPiles[0] = deckPile = new DeckPile(335, 5);
		allPiles[1] = discardPile = new DiscardPile(268, 5);
		for (int i = 0; i < 4; i++) {
			allPiles[2 + i] = suitPile[i] = new SuitPile(15 + 60 * i, 5);
		}
		for (int i = 0; i < 7; i++) {
			allPiles[6 + i] = tableau[i] = new TablePile(5 + 55 * i, 80, i + 1);
		}
	}

	private void tryToTransfer(final int x, final int y) {
		Map.Entry<Integer, CardPile> entry = select_count.entrySet().iterator()
				.next();

		entry.getValue().dropSelect();
		for (int i = 0; i < 13; i++) {
			if (allPiles[i].includes(x, y)) {
				if (allPiles[i].canTake(selected_card)) {
					Card tmp[] = new Card[entry.getKey()];
					int count = 0;
					while (count != entry.getKey()) {
						tmp[count] = entry.getValue().pop();
						count++;
					}
					for (int j = tmp.length - 1; j >= 0; j--) {
						allPiles[i].addCard(tmp[j]);
					}
				}
			}
		}

		select_card = null;
		have_select = false;
		select_count.clear();

	}

	public static int getSelectedCount() {
		Map.Entry<Integer, CardPile> entry = select_count.entrySet().iterator()
				.next();
		return entry.getKey();
	}

	@Override
	public boolean mouseMove(final Event evt, final int x, final int y) {
		_X = x;
		_Y = y;
		return true;
	}

	@Override
	public boolean mouseDrag(final Event evt, final int x, final int y) {
		_X = x;
		_Y = y;
		// System.out.println("q");
		repaint();
		return true;
	}

	@Override
	public boolean mouseUp(final Event evt, final int x, final int y) {
		if (have_select) {
			Map.Entry<Integer, CardPile> entry = select_count.entrySet()
					.iterator().next();
			entry.getValue().addCard(selected_card);

			tryToTransfer(x, y);
			
			selected_card.setSelected(false);
			selected_card = null;
			have_select = false;
			select_count.clear();

			repaint();
		}
		return true;
	}

	@Override
	public boolean mouseDown(final Event evt, final int x, final int y) {
		if (have_select) {
			// tryToTransfer(x, y);
			// repaint();
			return true;

		} else {
			for (int i = 0; i < 13; i++) {
				if (allPiles[i].includes(x, y)) {
					allPiles[i].select(x, y);
					repaint();
					return true;
				}
			}
			return true;
		}
	}

	@Override
	public void paint(final Graphics g) {
		for (int i = 0; i < 13; i++) {
			allPiles[i].display(g);
		}
		if (selected_card != null) {
			System.out.println("z");
			selected_card.draw(g, _X, _Y);
		}
	}
}