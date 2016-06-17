package com.manifestcorp;

import java.util.ArrayList;
import java.util.Collections;

import pokerHandDefenitions.HandStrengthUnit;
import pokerHandDefenitions.HasPokerTier;
import pokerHandDefenitions.PokerTier;

public class Hand implements HasPokerTier{
	//THIS IS MY COOL NEW CHANGE
	
	public ArrayList<HandStrengthUnit> handStrengths = new ArrayList<>();
	
	public Hand(ArrayList<Card> unorderedCards){
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards = unorderedCards;
		Collections.sort(orderedCards);	
		setHandStrength(orderedCards);
	}
	
	public void setHandStrength(ArrayList<Card> orderedCards){
		handStrengths = getUnitsOfStrength(orderedCards);
	}
	public ArrayList<HandStrengthUnit> getUnitsOfStrength(ArrayList<Card> orderedCards){
		ArrayList<HandStrengthUnit> handStrengths = new ArrayList<>();
		
			if(getStraightFlushStrengths(orderedCards)!=null){handStrengths.addAll(getStraightFlushStrengths(orderedCards));}
			if(getFourOfAKindStrengths(orderedCards)!=null){handStrengths.addAll(getFourOfAKindStrengths(orderedCards));}
			if(getFullHouseStrengths(orderedCards)!=null)handStrengths.addAll(getFullHouseStrengths(orderedCards));
			if(getFlushStrengths(orderedCards)!=null)handStrengths.addAll(getFlushStrengths(orderedCards));
			if(getStraightStrengths(orderedCards)!=null)handStrengths.addAll(getStraightStrengths(orderedCards));
			if(getThreeOfAKindStrengths(orderedCards)!=null)handStrengths.addAll(getThreeOfAKindStrengths(orderedCards));
			if(getTwoPairStrengths(orderedCards)!=null)handStrengths.addAll(getTwoPairStrengths(orderedCards));
			if(getPairStrengths(orderedCards)!=null)handStrengths.addAll(getPairStrengths(orderedCards));
			if(getHighCardStrengths(orderedCards)!=null)handStrengths.addAll(getHighCardStrengths(orderedCards));
		
			return handStrengths;
	}
	
	public ArrayList<HandStrengthUnit> getStraightFlushStrengths(ArrayList<Card> orderedCards){
		ArrayList<HandStrengthUnit> straightFlushStrengthUnits = new ArrayList<>();
		if(isFlush(orderedCards) && isStraight(orderedCards)){		
			PokerTier tier = STRAIGHT_FLUSH;
			int rank = getHighCardValue(orderedCards);
			HandStrengthUnit straightFlushStrength = new HandStrengthUnit(tier, rank);
			straightFlushStrengthUnits.add(straightFlushStrength);
		}
		System.out.println("SF: " + orderedCards.size());

		return straightFlushStrengthUnits;	
	}
	
	public ArrayList<HandStrengthUnit> getFourOfAKindStrengths(ArrayList<Card> orderedCards){
		ArrayList<HandStrengthUnit> fourOfAKindStrengthUnits = new ArrayList<>();
		int cardsOfAKind = 0;
		int fourOfAKindValue = 0;
		int testCardsOfAKind = 0;
		int testFourOfAKindValue = 0;
		
		for(int i = 0; i < orderedCards.size(); i++){
			testCardsOfAKind = 0;
			testFourOfAKindValue = 0;
			for(int b = 0; b < orderedCards.size(); b++){
				if(orderedCards.get(i).cardValue == orderedCards.get(b).cardValue){
					testCardsOfAKind++;
					testFourOfAKindValue = orderedCards.get(i).cardValue;
				}
			}
			if(testCardsOfAKind >= cardsOfAKind){
				cardsOfAKind = testCardsOfAKind;
				fourOfAKindValue = testFourOfAKindValue;
			}
		}
		
		if(cardsOfAKind == 4){
			PokerTier tier = FOUR_OF_A_KIND;
			HandStrengthUnit fourOfAKindStrengthUnit = new HandStrengthUnit(tier, fourOfAKindValue);
			fourOfAKindStrengthUnits.add(fourOfAKindStrengthUnit); 
			
			for(int i = 0; i < orderedCards.size(); i++){
				if(orderedCards.get(i).cardValue != fourOfAKindValue){
					int highCardRank = orderedCards.get(i).cardValue;
					PokerTier highCardTier = HIGH_CARD;
					HandStrengthUnit fourOfAKindHighCardStrengthUnit = new HandStrengthUnit(highCardTier, highCardRank);
					fourOfAKindStrengthUnits.add(fourOfAKindHighCardStrengthUnit); 
				}
			}
		}
		System.out.println("4X: " + orderedCards.size());
		
		return fourOfAKindStrengthUnits;
	}
	
	//Hashset might work better for duplicates
	public ArrayList<HandStrengthUnit> getFullHouseStrengths(ArrayList<Card> orderedCards){
		ArrayList<HandStrengthUnit > fullHouseStrengthUnits = new ArrayList<>();	
		ArrayList<Card> currentCards = new ArrayList<>();
		currentCards.addAll(orderedCards);

		
		int firstCountOfEqualCards = 1;
		int secondCountOfEqualCards = 1 ;
		int firstSetValue = 0;
		int secondSetValue = 0;
		int currentCountOfEqualCards = 0;
		int currentSetValue = 0;
		
		for(int i = 0; i + 1 < currentCards.size(); i++){
			
			if((currentCards.get(i).cardValue == currentCards.get(i + 1).cardValue)){
				currentCountOfEqualCards ++;
				currentSetValue = currentCards.get(i).cardValue;
			}
		}
		if(currentCountOfEqualCards >= 2){
			firstCountOfEqualCards = currentCountOfEqualCards;
			firstSetValue = currentSetValue;
		}
		if(currentSetValue > 0){
			for(int i = 0; i < currentCards.size(); i++){
				if(currentCards.get(i).cardValue == currentSetValue){
					currentCards.remove(i);
					i--;
				}
			}
		}
		
		currentCountOfEqualCards = 1;
		for(int i = 0; i + 1 < currentCards.size(); i++){	
			if((currentCards.get(i).cardValue == currentCards.get(i + 1).cardValue)){
				currentCountOfEqualCards ++;
				currentSetValue = currentCards.get(i).cardValue;
			}
		}
		if(((currentCountOfEqualCards >= 2) && (firstCountOfEqualCards >= 2)) && currentCountOfEqualCards + firstCountOfEqualCards == 5){
			secondCountOfEqualCards = currentCountOfEqualCards;
			secondSetValue = currentSetValue;
			//TODO: address confusion between "rank" and "level"
			int rank;
			if(firstCountOfEqualCards > secondCountOfEqualCards){
				rank = firstSetValue;
			} else {
				rank = secondSetValue;
			}
			HandStrengthUnit fullHouseStrength = new HandStrengthUnit(FULL_HOUSE, rank);
			fullHouseStrengthUnits.add(fullHouseStrength);
		}
		System.out.println("4X: " + orderedCards.size());

		return fullHouseStrengthUnits;	
	}
	
	public ArrayList<HandStrengthUnit> getFlushStrengths(ArrayList<Card> orderedCards){
		ArrayList<HandStrengthUnit> flushStrengthUnits = new ArrayList<>();
//		
//		System.out.println("ONE:" + orderedCards.get(0).cardValue);
//		System.out.println("TWO:" + orderedCards.get(1).cardValue);
//		System.out.println("THREE:" + orderedCards.get(2).cardValue);
//		System.out.println("FOUR:" + orderedCards.get(3).cardValue);
//		System.out.println("FIVE:" + orderedCards.get(4).cardValue);

		
		if(isFlush(orderedCards)){
			for(int i = 4; i >= 0; i--){
				PokerTier tier = FLUSH;
				int rank = orderedCards.get(i).cardValue;
				HandStrengthUnit flushStrengthUnit = new HandStrengthUnit(tier, rank);
				flushStrengthUnits.add(flushStrengthUnit);
//				System.out.println("CardValue: " + rank);
			}
		}
		
		System.out.println("FH: " + orderedCards.size());

		return flushStrengthUnits;	
	}
	
	public ArrayList<HandStrengthUnit> getStraightStrengths(ArrayList<Card> orderedCards){
		ArrayList<HandStrengthUnit> straightStrengthUnits = new ArrayList<>();
		if(isStraight(orderedCards)){		
			PokerTier tier = STRAIGHT;
			int rank = getHighCardValue(orderedCards);
			HandStrengthUnit straightStrengthUnit = new HandStrengthUnit(tier, rank);
			straightStrengthUnits.add(straightStrengthUnit);
		}
		System.out.println("ST: " + orderedCards.size());

		return straightStrengthUnits;	
	}
	
	public ArrayList<HandStrengthUnit> getThreeOfAKindStrengths(ArrayList<Card> orderedCards){
		ArrayList<HandStrengthUnit> threeOfAKindStrengthUnits = new ArrayList<>();
		int cardsOfAKind = 0;
		int threeOfAKindValue = 0;
		int testCardsOfAKind = 0;
		int testThreeOfAKindValue = 0;
		
		for(int i = 0; i < orderedCards.size(); i++){
			for(int b = 0; b < orderedCards.size(); b++){
				if(orderedCards.get(i).cardValue == orderedCards.get(b).cardValue){
					testCardsOfAKind++;
					testThreeOfAKindValue = orderedCards.get(i).cardValue;
				}
			}
			if(testCardsOfAKind >= cardsOfAKind){
				cardsOfAKind = testCardsOfAKind;
				threeOfAKindValue = testThreeOfAKindValue;
			}
			testCardsOfAKind = 0;
			testThreeOfAKindValue = 0;
		}
		
		if(cardsOfAKind == 3){
			HandStrengthUnit threeOfAKindStrengthUnit = new HandStrengthUnit(THREE_OF_A_KIND, threeOfAKindValue);
			threeOfAKindStrengthUnits.add(threeOfAKindStrengthUnit); 
			for(int i = 4 ; i >= 0; i--){
				if(orderedCards.get(i).cardValue != threeOfAKindValue){
					PokerTier tier = HIGH_CARD;
					int rank = orderedCards.get(i).cardValue;
					HandStrengthUnit threeOfAKindHighCardStrengthUnit = new HandStrengthUnit(tier, rank);
					threeOfAKindStrengthUnits.add(threeOfAKindHighCardStrengthUnit);
				}	
			}
		}
		System.out.println("3X: " + orderedCards.size());

		
		return threeOfAKindStrengthUnits;
	}
	
	//TODO: make twopair work
	public ArrayList<HandStrengthUnit> getTwoPairStrengths(ArrayList<Card> orderedCards){
		ArrayList<HandStrengthUnit > twoPairStrengthUnits = new ArrayList<>();	
		ArrayList<Card> currentCards = new ArrayList<>();
		currentCards.addAll(orderedCards);

		
		int firstCountOfEqualCards = 1;
		int secondCountOfEqualCards = 1 ;
		int firstSetValue = 0;
		int secondSetValue = 0;
		int currentCountOfEqualCards = 0;
		int currentSetValue = 0;
		
		for(int i = 0; i + 1 < currentCards.size(); i++){
			
			if((currentCards.get(i).cardValue == currentCards.get(i + 1).cardValue)){
				currentCountOfEqualCards ++;
				currentSetValue = currentCards.get(i).cardValue;
			}
		}
		if(currentCountOfEqualCards == 2){
			firstCountOfEqualCards = currentCountOfEqualCards;
			firstSetValue = currentSetValue;
		}
		if(currentSetValue > 0){
			for(int i = 0; i < currentCards.size(); i++){
				if(currentCards.get(i).cardValue == currentSetValue){
					currentCards.remove(i);
					i--;
				}
			}
		}
		
		currentCountOfEqualCards = 1;
		for(int i = 0; i + 1 < currentCards.size(); i++){	
			if((currentCards.get(i).cardValue == currentCards.get(i + 1).cardValue)){
				currentCountOfEqualCards ++;
				currentSetValue = currentCards.get(i).cardValue;
			}
		}
		if(((currentCountOfEqualCards == 2) && (firstCountOfEqualCards == 2)) ){
			secondCountOfEqualCards = currentCountOfEqualCards;
			secondSetValue = currentSetValue;
			//TODO: address confusion between "rank" and "level"
			int primaryRank = 0;
			int secondaryRank = 0;
			int remainingHighCard = 0;
			
			if((firstCountOfEqualCards == 2) && (secondCountOfEqualCards == 2)){
				if(firstSetValue > secondSetValue){
					primaryRank = firstSetValue;
					secondaryRank = secondSetValue;
				} else {
					primaryRank = secondSetValue;
					secondaryRank = firstSetValue;
				}
				for(int i = 0; i < orderedCards.size(); i++){
					if((orderedCards.get(i).cardValue != secondSetValue) && (orderedCards.get(i).cardValue != firstSetValue)){
						remainingHighCard = orderedCards.get(i).cardValue;
					}
				}
			
			}
			HandStrengthUnit primaryTwoPairStrength = new HandStrengthUnit(TWO_PAIR, primaryRank);
			twoPairStrengthUnits.add(primaryTwoPairStrength);
			HandStrengthUnit secondaryTwoPairStrength = new HandStrengthUnit(TWO_PAIR, secondaryRank);
			twoPairStrengthUnits.add(secondaryTwoPairStrength);
			HandStrengthUnit twoPairHighCardStrength = new HandStrengthUnit(HIGH_CARD, remainingHighCard);
			twoPairStrengthUnits.add(twoPairHighCardStrength);
			
		}
		
//		System.out.println("First Set Count:" + firstCountOfEqualCards);
//		System.out.println("First Set value:" + firstSetValue);
//		System.out.println("Second Set Count:" + secondCountOfEqualCards);
//		System.out.println("Second Set value:" + secondSetValue);

		System.out.println("2X2X: " + orderedCards.size());

		return twoPairStrengthUnits;
	}
	
	public ArrayList<HandStrengthUnit> getPairStrengths(ArrayList<Card> orderedCards){
		ArrayList<HandStrengthUnit> pairStrengthUnits = new ArrayList<>();
		int cardsOfAKind = 1;
		int pairValue = 0;
		int testCardsOfAKind = 0;
		int testPairValue = 0;
		
		for(int i = 0; i < orderedCards.size(); i++){
			for(int b = 0; b < orderedCards.size(); b++){
				if(orderedCards.get(i).cardValue == orderedCards.get(b).cardValue){
					testCardsOfAKind++;
					testPairValue = orderedCards.get(i).cardValue;
				}
			}
			if(testCardsOfAKind >= cardsOfAKind){
				cardsOfAKind = testCardsOfAKind;
				pairValue = testPairValue;
			}
			testCardsOfAKind = 0;
			testPairValue = 0;
		}
		

		
		if(cardsOfAKind == 2){
			HandStrengthUnit pairStrengthUnit = new HandStrengthUnit(PAIR, pairValue);
			pairStrengthUnits.add(pairStrengthUnit); 
			for(int i = 4 ; i >= 0; i--){
				if(orderedCards.get(i).cardValue != pairValue){
					PokerTier tier = HIGH_CARD;
					int rank = orderedCards.get(i).cardValue;
					HandStrengthUnit pairHighCardStrengthUnit = new HandStrengthUnit(tier, rank);
					pairStrengthUnits.add(pairHighCardStrengthUnit);
				}	
			}
		}
		
		System.out.println("2X: " + orderedCards.size());

		
		return pairStrengthUnits;
		}
	
	
	public ArrayList<HandStrengthUnit> getHighCardStrengths(ArrayList<Card> orderedCards){
		ArrayList<HandStrengthUnit> highCardStrengthUnits = new ArrayList<>();
		
		System.out.println("!" + orderedCards.get(0).cardValue);
		System.out.println("!" + orderedCards.get(1).cardValue);
		System.out.println("!" + orderedCards.get(2).cardValue);
		System.out.println("!" + orderedCards.get(3).cardValue);
		System.out.println("!" + orderedCards.get(4).cardValue);
		System.out.println("---");

		


		
		
		
		for(int i = 4 ; i >= 0; i--){
		
			PokerTier tier = HIGH_CARD;
			int rank = orderedCards.get(i).cardValue;
			HandStrengthUnit highCardStrengthUnit = new HandStrengthUnit(tier, rank);
			highCardStrengthUnits.add(highCardStrengthUnit);	
		}
		
		System.out.println("HC: " + orderedCards.size());

		return highCardStrengthUnits;	
	}
	
	
	
	
	public boolean isStraight(ArrayList<Card> orderedCards){
		boolean isStraight = true;
		for(int i = 0; i < orderedCards.size() - 1; i++){
			if(orderedCards.get(i).cardValue != orderedCards.get(i + 1).cardValue - 1){
				isStraight = false;
			}
		}
		return isStraight;
	}
	
	public boolean isFlush(ArrayList<Card> orderedCards){
		boolean isFlush = true;
		for(int i = 0; i < orderedCards.size() - 1; i ++){
			if(orderedCards.get(i).cardSuit != orderedCards.get(i + 1).cardSuit){
				isFlush = false;
			}
		}
		return isFlush;
	}
	public int getHighCardValue(ArrayList<Card> orderedCards){
		ArrayList<Card> getHighCardValue = new ArrayList<>();
		getHighCardValue.addAll(orderedCards);
		
		System.out.println("HighCard: " + orderedCards.size());

		
		return getHighCardValue.get(getHighCardValue.size() - 1).cardValue;
	}
	
	
}
