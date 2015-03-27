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

	@Override
	public boolean mouseDown(final Event evt, final int x, final int y) {
		// if (have_select) {
		// for (Map.Entry<Card, CardPile> entry : select_card.entrySet()) {
		// for (int i = 0; i < 13; i++) {
		// if (allPiles[i].includes(x, y)) {
		// if (allPiles[i].canTake(entry.getKey())) {
		// allPiles[i].addCard(entry.getValue().pop());
		// }
		// }
		// }
		// entry.getKey().setSelected(false);
		// have_select = false;
		// select_card.clear();
		// repaint();
		// return true;
		// }
		// return true;
		// }
		//
		// for (int i = 0; i < 13; i++) {
		// if (allPiles[i].includes(x, y)) {
		// allPiles[i].select(x, y);
		// repaint();
		// return true;
		// }
		// }
		// return true;

		// / NEW

		if (have_select) {
			for (Map.Entry<Integer, CardPile> entry : select_count.entrySet()) {
				entry.getValue().dropSelect();
				
//				for (int i = 0; i < 13; i++) {
//					if (allPiles[i].includes(x, y)) {
//						if (allPiles[i].canTake(selected_card)) {
//							Card tmp[] = new Card[entry.getKey()];
//							int count = 0;
//							while (count != entry.getKey()) {
//								tmp[count] = entry.getValue().pop();
//								count++;
//							}
//							for (int j = tmp.length - 1; j >= 0; j--) {
//								allPiles[i].addCard(tmp[j]);
//							}
//						}
//					}
//				}
				
			}

			select_card = null;
			have_select = false;
			select_count.clear();
			repaint();
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
			
//			for (int i = 0; i < 13; i++) {
//				allPiles[i].whatCard(x, y);
//				repaint();
//			}
//			return true;
		}
	}

	@Override
	public void paint(final Graphics g) {
		for (int i = 0; i < 13; i++) {
			allPiles[i].display(g);
		}
	}
}