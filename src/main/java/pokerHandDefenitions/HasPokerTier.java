package pokerHandDefenitions;

public interface HasPokerTier {
	public PokerTier STRAIGHT_FLUSH = new PokerTier(8);
	public PokerTier FOUR_OF_A_KIND = new PokerTier(7);
	public PokerTier FULL_HOUSE = new PokerTier(6);
	public PokerTier FLUSH = new PokerTier(5);
	public PokerTier STRAIGHT = new PokerTier(4);

	public PokerTier THREE_OF_A_KIND= new PokerTier(3);
	public PokerTier TWO_PAIR = new PokerTier(2);
	public PokerTier PAIR = new PokerTier(1);
	public PokerTier HIGH_CARD = new PokerTier(0);
}
