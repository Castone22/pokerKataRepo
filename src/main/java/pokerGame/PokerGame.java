package pokerGame;
import java.util.ArrayList;

import com.manifestcorp.Hand;

import pokerHandDefenitions.HandStrengthUnit;

public class PokerGame implements WinConditions {
	
	Hand playerOneHand;
	Hand playerTwoHand;
	
	public String getWinningPlayer(Hand playerOneHand, Hand playerTwoHand){
		ArrayList<HandStrengthUnit> playerOneStrength = playerOneHand.handStrengths;
		ArrayList<HandStrengthUnit> playerTwoStrength = playerTwoHand.handStrengths;
		
		for(int i = 0; i < 2; i++){
			System.out.println("Tier:" + playerOneStrength.get(i).pokerTier);
			System.out.println("Tier:" + playerTwoStrength.get(i).pokerTier);
		}
		
		//String winner = calculateWinner(playerOneStrength, playerTwoStrength);
		
		return calculateWinner(playerOneStrength, playerTwoStrength);

	}

	private String calculateWinner(ArrayList<HandStrengthUnit> playerOneStrength,
			ArrayList<HandStrengthUnit> playerTwoStrength) {
		boolean foundWinner = false;
		String winner = TIE_GAME;
		int index = 0;
		while(!foundWinner){
			if(playerOneStrength.get(index).pokerTier.tier > playerTwoStrength.get(index).pokerTier.tier){
				winner = PLAYER_ONE_WIN;
				foundWinner = true;
			}
			
			if(playerOneStrength.get(index).pokerTier.tier < playerTwoStrength.get(index).pokerTier.tier){
				winner = PLAYER_TWO_WIN;
				foundWinner = true;
			}
			
			if(playerOneStrength.get(index).pokerTier.tier == playerTwoStrength.get(index).pokerTier.tier){
				if(playerOneStrength.get(index).level > playerTwoStrength.get(index).level){
					winner = PLAYER_ONE_WIN;
					foundWinner = true;
				}
				if(playerOneStrength.get(index).level < playerTwoStrength.get(index).level){
					winner = PLAYER_TWO_WIN;
					foundWinner = true;
				}
			}
			index++;
		}
		return winner;
	}

}
