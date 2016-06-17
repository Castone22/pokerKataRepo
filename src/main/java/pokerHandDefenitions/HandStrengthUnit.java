package pokerHandDefenitions;

public class HandStrengthUnit implements HasPokerTier {
	public final PokerTier pokerTier;
	public final int level;
	public HandStrengthUnit(PokerTier pokerTier, int level){
		this.pokerTier = pokerTier;
		this.level = level;	
	}
}
