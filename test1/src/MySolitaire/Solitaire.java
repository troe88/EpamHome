package MySolitaire;

/*
 Simple Solitaire Card Game in Java
 Written by Tim Budd, Oregon State University, 1996
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
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

	@Override
	public void init() {
		setSize(400, 500);
		selected_cards = new LinkedList<Card>();
		have_select = false;
		flag_do = false;
		_is_win = false;
		_myFont = new Font("TimesRoman", Font.BOLD, 30);
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

	private void drawWinMsg(final Graphics g) {

		Rectangle2D box = g.getClip().getBounds2D();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, (int) box.getWidth(), (int) box.getHeight());

		g.setFont(_myFont);

		g.setColor(Color.black);
		String msg = "You're a winner!";
		int text_size = msg.length() * 10;
		g.drawString(msg, (int) box.getWidth() / 2 - text_size,
				(int) box.getHeight() / 2);
	}

	@Override
	public void update(final Graphics g) {
		Graphics offgc;
		Image offscreen = null;
		Rectangle2D box = g.getClip().getBounds2D();
		offscreen = createImage((int) box.getWidth(), (int) box.getHeight());
		offgc = offscreen.getGraphics();
		offgc.setColor(getBackground());
		offgc.fillRect(0, 0, (int) box.getWidth(), (int) box.getHeight());
		offgc.setColor(getForeground());
		offgc.translate(-(int) box.getX(), -(int) box.getY());
		paint(offgc);
		g.drawImage(offscreen, (int) box.getX(), (int) box.getY(), this);
	}

	boolean pos_flag = true;
	int dx = 0;
	int dy = 0;
	private Font _myFont;

	public void calcDifXY() {
		if (pos_flag) {
			dx = _X - selected_pile.x;
			if (selected_pile instanceof DiscardPile)
				dy = _Y - (selected_pile.y);
			else
				dy = _Y - (selected_pile.y + 35 * (selected_pile._card_count));
			pos_flag = false;
		}
	}

	@Override
	public void paint(final Graphics g) {

		if (_is_win) {
			drawWinMsg(g);
			return;
		}

		for (int i = 0; i < 13; i++)
			allPiles[i].display(g);

		if (!selected_cards.isEmpty()) {
			calcDifXY();
			int i = 0;
			for (Card card : selected_cards) {
				card.draw(g, _X - dx, _Y + (i * 35) - dy);
				i++;
			}
		}

	}
}