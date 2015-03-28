package MySolitaire;

/*
 Simple Solitaire Card Game in Java
 Written by Tim Budd, Oregon State University, 1996
 */

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Deque;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class Solitaire extends Applet {
	static CardPile allPiles[];
	static DeckPile deckPile;
	static DiscardPile discardPile;
	static CardPile suitPile[];
	static CardPile tableau[];

	static boolean have_select;
	public static int _X;
	public static int _Y;
	public static Deque<Card> selected_cards;
	public static CardPile selected_pile;

	public static boolean flag_do;
	private boolean _is_win;

	// BUF
	// The object we will use to write with instead of the standard screen
	// graphics
	Graphics bufferGraphics;
	// The image that will contain everything that has been drawn on
	// bufferGraphics.
	Image offscreen;
	// To get the width and height of the applet.
	Dimension dim;
	int curX, curY;

	// BUF
	@Override
	public void init() {
		setSize(400, 500);
		selected_cards = new LinkedList<Card>();
		have_select = false;
		flag_do = false;
		_is_win = false;

		// BUF
		offscreen = createImage(400,500);
		// by doing this everything that is drawn by bufferGraphics
		// will be written on the offscreen image.
		bufferGraphics = offscreen.getGraphics();
		// BUF

		// first allocate the arrays
		allPiles = new CardPile[13];
		suitPile = new CardPile[4];
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
		System.out.println("tryeToTfansfer()");
		for (int i = 0; i < 13; i++) {
			if (allPiles[i].includes(x, y)) {
				if (allPiles[i].canTake(selected_cards.getFirst())) {
					while (!selected_cards.isEmpty()) {
						allPiles[i].addCard(selected_cards.removeFirst());
					}
				}
			}
		}

		while (!selected_cards.isEmpty()) {
			selected_pile.addCard(selected_cards.removeFirst());
		}

		repaint();
		selected_pile = null;
		have_select = false;

	}

	public static int getSelectedCount() {
		return selected_cards.size();
	}

	@Override
	public boolean mouseMove(final Event evt, final int x, final int y) {
		_X = x;
		_Y = y;
		return true;
	}

	@Override
	public boolean mouseDrag(final Event evt, final int x, final int y) {
		flag_do = true;
		_X = x;
		_Y = y;
		repaint();
		return true;
	}

	@Override
	public boolean mouseUp(final Event evt, final int x, final int y) {
		System.out.println("mouseUp()");
		if (have_select && flag_do) {

			for (int i = 0; i < 13; i++) {
				allPiles[i].unMark();
			}

			tryToTransfer(x, y);

			have_select = false;
			selected_cards.clear();
			repaint();
		}
		pos_flag = true;

		winnerCheck();

		return true;
	}

	public void winnerCheck() {
		_is_win = true;
		for (int i = 0; i < 4; i++) {
			if (!suitPile[i].empty()) {
				if (!suitPile[i].top().isKing())
					_is_win = false;
			} else {
				_is_win = false;
				return;
			}
		}
	}

	@Override
	public boolean mouseDown(final Event evt, final int x, final int y) {
		System.out.println("mouseDown()");
		flag_do = false;

		if (evt.clickCount == 2) {
			for (int i = 0; i < 13; i++) {
				if (selected_cards.isEmpty())
					return true;
				if (allPiles[i].canTake(selected_cards.getFirst())
						&& allPiles[i] != selected_pile) {
					allPiles[i].mark();
				}
			}

			flag_do = false;
			repaint();
			return true;
		}

		if (have_select) {
			flag_do = true;
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

	private void drawWinMsg() {
		// TODO Auto-generated method stub
		System.out.println("WINNER!");
		System.exit(0);
	}

	boolean pos_flag = true;
	int dx = 0;
	int dy = 0;

	@Override
	public void paint(final Graphics g) {
		bufferGraphics.clearRect(0,0,400,500); 
		for (int i = 0; i < 13; i++)
			allPiles[i].display(bufferGraphics);

		if (_is_win)
			drawWinMsg();

		if (!selected_cards.isEmpty()) {
			if (pos_flag) {
				dx = _X - selected_pile.x;
				if (selected_pile instanceof DiscardPile)
					dy = _Y - (selected_pile.y);
				else
					dy = _Y
							- (selected_pile.y + 35 * (selected_pile._card_count));
				pos_flag = false;
			}

			int i = 0;
			for (Card card : selected_cards) {
				card.draw(bufferGraphics, _X - dx, _Y + (i * 35) - dy);
				i++;
			}
		}

		g.drawImage(offscreen, 0, 0, this);
	}
}