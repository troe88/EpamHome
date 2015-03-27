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
	static TablePile tableau[];

	static Map<Card, CardPile> select_card;
	static boolean have_select;

	@Override
	public void init() {
		select_card = new HashMap<Card, CardPile>(1);
		have_select = false;
		// first allocate the arrays
		allPiles = new CardPile[13];
		suitPile = new SuitPile[4];
		tableau = new TablePile[7];
		// then fill them in
		allPiles[0] = deckPile = new DeckPile(335, 5);
		allPiles[1] = discardPile = new DiscardPile(268, 5);
		for (int i = 0; i < 4; i++) {
			allPiles[2 + i] = suitPile[i] = new SuitPile(15 + 60 * i, 5);
		}
		for (int i = 0; i < 7; i++) {
			allPiles[6 + i] = tableau[i] = new TablePile(5 + 55 * i, 80, i + 1);
		}

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(500);
						System.out.println(Solitaire.select_card.size());
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread.start();
	}

	@Override
	public boolean mouseDown(final Event evt, final int x, final int y) {
		if (have_select) {
			for (Map.Entry<Card, CardPile> entry : select_card.entrySet()) {
				for (int i = 0; i < 13; i++) {
					if (allPiles[i].includes(x, y)) {
						if (allPiles[i].canTake(entry.getKey())) {
							allPiles[i].addCard(entry.getValue().pop());
						}
					}
				}
				entry.getKey().setSelected(false);
				have_select = false;
				select_card.clear();
				repaint();
				return true;
			}
			return true;
		}

		for (int i = 0; i < 13; i++) {
			if (allPiles[i].includes(x, y)) {
				allPiles[i].select(x, y);
				repaint();
				return true;
			}
		}
		return true;
	}

	@Override
	public void paint(final Graphics g) {
		for (int i = 0; i < 13; i++) {
			allPiles[i].display(g);
		}
	}
}