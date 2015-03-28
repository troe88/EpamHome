package MySolitaire;

/*
 Simple Solitaire Card Game in Java
 Written by Tim Budd, Oregon State University, 1996
 */

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.util.Deque;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class Solitaire extends Applet {
	static CardPile allPiles[];
	static DeckPile deckPile;
	static DiscardPile discardPile;
	static SuitPile suitPile[];
	static CardPile tableau[];

	static boolean have_select;
	public static int _X;
	public static int _Y;
	public static Deque<Card> st_cards;
	public static CardPile s_pile;

	@Override
	public void init() {
		setSize(400, 380);
		st_cards = new LinkedList<Card>();
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
		for (int i = 0; i < 13; i++) {
			if (allPiles[i].includes(x, y)) {
				if (allPiles[i].canTake(st_cards.getFirst())) {
					while (!st_cards.isEmpty()) {
						allPiles[i].addCard(st_cards.removeFirst());
					}
				}
			}
		}

		while (!st_cards.isEmpty()) {
			s_pile.addCard(st_cards.removeFirst());
		}

		repaint();
		s_pile = null;
		have_select = false;

	}

	public static int getSelectedCount() {
		return st_cards.size();
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
		repaint();
		return true;
	}

	@Override
	public boolean mouseUp(final Event evt, final int x, final int y) {
		if (have_select) {
			tryToTransfer(x, y);

			have_select = false;
			st_cards.clear();
			repaint();
		}
		pos_flag = true;
		return true;
	}

	@Override
	public boolean mouseDown(final Event evt, final int x, final int y) {
		
		if(evt.clickCount == 2){
			System.out.println("QWE");
		}
		
		if (have_select) {
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

	
	boolean pos_flag = true;
	int dx = 0;
	int dy = 0;
	@Override
	public void paint(final Graphics g) {
		for (int i = 0; i < 13; i++)
			allPiles[i].display(g);

		if (!st_cards.isEmpty()) {
			if (pos_flag) {
				dx = _X - s_pile.x;
				if (s_pile instanceof DiscardPile)
					dy = _Y - (s_pile.y);
				else
					dy = _Y - (s_pile.y + 35 * (s_pile._card_count));
				pos_flag = false;
			}

			int i = 0;
			for (Card card : st_cards) {
				card.draw(g, _X - dx, _Y + (i * 35) - dy);
				i++;
			}
		}
	}
}