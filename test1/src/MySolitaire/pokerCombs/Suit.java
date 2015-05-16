package MySolitaire.pokerCombs;

//final static int heart = 0; 	червы 
//final static int spade = 1; 	пики
//final static int diamond = 2; бубны
//final static int club = 3; 	трефы

public enum Suit {
	
	HEART(0), SPADE(1), DIAMOND(2), CLUB(3);
	
	private int  _suit;
	private Suit(final int suit) {
		this.setSuit(suit);
	}
	
	public int getSuit() {
		return _suit;
	}
	
	private void setSuit(final int rank) {
		_suit = rank;
	}
}
