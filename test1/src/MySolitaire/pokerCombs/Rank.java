package MySolitaire.pokerCombs;

public enum Rank {
	ICE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
	NINE(9), TEN(10), JACK(11), LADY(12), KING(13);
	
	private int  _rank;
	private Rank(final int rank) {
		this.setRank(rank);
	}
	
	public int getRank() {
		return _rank;
	}
	
	
	public void setRank(final int rank) {
		_rank = rank;
	}
}
