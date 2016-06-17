package com.manifestcorp;

import playingCardDefinition.CardSuit;
import playingCardDefinition.CardValue;
//TODO: Switch to Package visibility, once testing is finished.
public class Card implements Comparable<Card> {
	public final int cardValue;
	public final int cardSuit;
	
	public Card(CardValue value, CardSuit suit){
		switch(value){
			case TWO: this.cardValue = 2; break;
			case THREE: this.cardValue = 3; break;
			case FOUR: this.cardValue = 4; break;
			case FIVE: this.cardValue = 5; break;
			case SIX: this.cardValue = 6; break;
			case SEVEN: this.cardValue = 7; break;
			case EIGHT: this.cardValue = 8; break;
			case NINE: this.cardValue = 9; break;
			case TEN: this.cardValue = 10; break;
			case JACK: this.cardValue = 11; break;
			case QUEEN: this.cardValue = 12; break;
			case KING: this.cardValue = 13; break;
			case ACE: this.cardValue = 14; break;
			default: this.cardValue = 0;
		}
		switch(suit){
			case SPADES: this.cardSuit = 1; break;
			case CLUBS: this.cardSuit = 2; break;
			case DIAMONDS: this.cardSuit = 3; break;
			case HEARTS: this.cardSuit = 4; break;
			default: this.cardSuit = 0;
		}		
	}

	public int compareTo(Card card) {
		if(this.cardValue < card.cardValue){
			return -1;
		}
		if(this.cardValue == (card.cardValue)){
			return 0;
		}
		return 1;	
	}	
}
