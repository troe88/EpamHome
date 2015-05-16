package MySolitaire;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import MySolitaire.pokerCombs.Rank;
import MySolitaire.pokerCombs.Suit;

public class Card {
	final static int black = 1;
	final static int red = 0;

	final static int heart = 0;
	final static int spade = 1;
	final static int diamond = 2;
	final static int club = 3;

	final static int width = 50;
	final static int height = 70;

	// data fields for colors and suits
	// private static String names[] = {"A", "2", "3", "4", "5", "6",
	// "7", "8", "9", "10", "J", "Q", "K"};

	// data fields
	private boolean faceup;
	private int rank;
	Rank _rank;
	private int suit;
	Suit _suit;

	private boolean _selected;
	private boolean _can_get;

	public boolean isCanGet() {
		return _can_get;
	}

	public void setCanGet(final boolean can_get) {
		_can_get = can_get;
	}

	Card link;

	public Card(final int a) {
	}
	// constructor
	public Card(final int suitValue, final int rankValue) {
		_can_get = false;
		suit = suitValue;
		rank = rankValue;
		faceup = false;
		_selected = false;
	}

	public Card(final Suit suit, final Rank rank) {
		this(suit.getSuit(), rank.getRank());
		_rank = rank;
		_suit = suit;
	}


	public int color() {
		if (getSuit() == heart || getSuit() == diamond) {
			return red;
		}
		return black;
	}

	public void draw(final Graphics g, final int x, final int y) {
		String names[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"J", "Q", "K" };

		g.clearRect(x, y, width, height);
		if (_can_get) {
			g.setColor(Color.red);
			((Graphics2D)g).setStroke(new BasicStroke(3));

		} else {
			// clear rectangle, draw border
			((Graphics2D)g).setStroke(new BasicStroke(1));
			g.setColor(Color.black);
		}

		g.drawRect(x, y, width, height);
		
		if (_selected) {
			g.setColor(Color.decode("0xD9FCFF"));
			g.fillRect(x + 1, y + 1, width - 1, height - 1);
		} else {
			g.setColor(Color.decode("0xF5F5F5"));
			g.fillRect(x + 1, y + 1, width - 1, height - 1);
		}

		// draw body of card
		if (isFaceUp()) {
			if (color() == red) {
				g.setColor(Color.red);
			} else {
				g.setColor(Color.blue);
			}
			g.drawString(names[getRank()], x + 3, y + 15);
			if (getSuit() == heart) {
				g.drawLine(x + 25, y + 30, x + 35, y + 20);
				g.drawLine(x + 35, y + 20, x + 45, y + 30);
				g.drawLine(x + 45, y + 30, x + 25, y + 60);
				g.drawLine(x + 25, y + 60, x + 5, y + 30);
				g.drawLine(x + 5, y + 30, x + 15, y + 20);
				g.drawLine(x + 15, y + 20, x + 25, y + 30);
			} else if (getSuit() == spade) {
				g.drawLine(x + 25, y + 20, x + 40, y + 50);
				g.drawLine(x + 40, y + 50, x + 10, y + 50);
				g.drawLine(x + 10, y + 50, x + 25, y + 20);
				g.drawLine(x + 23, y + 45, x + 20, y + 60);
				g.drawLine(x + 20, y + 60, x + 30, y + 60);
				g.drawLine(x + 30, y + 60, x + 27, y + 45);
			} else if (getSuit() == diamond) {
				g.drawLine(x + 25, y + 20, x + 40, y + 40);
				g.drawLine(x + 40, y + 40, x + 25, y + 60);
				g.drawLine(x + 25, y + 60, x + 10, y + 40);
				g.drawLine(x + 10, y + 40, x + 25, y + 20);
			} else if (getSuit() == club) {
				g.drawOval(x + 20, y + 25, 10, 10);
				g.drawOval(x + 25, y + 35, 10, 10);
				g.drawOval(x + 15, y + 35, 10, 10);
				g.drawLine(x + 23, y + 45, x + 20, y + 55);
				g.drawLine(x + 20, y + 55, x + 30, y + 55);
				g.drawLine(x + 30, y + 55, x + 27, y + 45);
			}
		} else { // face down
			g.setColor(Color.decode("0xFFD100"));
			g.drawLine(x + 15, y + 5, x + 15, y + 65);
			g.drawLine(x + 35, y + 5, x + 35, y + 65);
			g.drawLine(x + 5, y + 20, x + 45, y + 20);
			g.drawLine(x + 5, y + 35, x + 45, y + 35);
			g.drawLine(x + 5, y + 50, x + 45, y + 50);
		}
	}

	public boolean isFaceUp() {
		return faceup;
	}

	public void flip() {
		faceup = !faceup;
	}

	// access attributes of card
	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

	final public boolean isAce() {
		return getRank() == 1;
	}

	final boolean isKing() {
		return getRank() == 12;
	}

	public boolean isSelected() {
		return _selected;
	}

	public void setSelected(final boolean selected) {
		_selected = selected;
	}
	
	@Override
	public String toString() {
		return _rank.toString() + " " + _suit.toString();
	}
	
}