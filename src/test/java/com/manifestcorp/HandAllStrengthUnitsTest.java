package com.manifestcorp;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import pokerHandDefenitions.HandStrengthUnit;
import pokerHandDefenitions.HasPokerTier;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HandAllStrengthUnitsTest implements SampleDeck, HasPokerTier {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	
	@Test
	public void testRoyalFlushStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(TEN_OF_SPADES);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(QUEEN_OF_SPADES);
		orderedCards.add(KING_OF_SPADES);
		orderedCards.add(ACE_OF_SPADES);
		
		Hand hand = new Hand(orderedCards);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).pokerTier, STRAIGHT_FLUSH);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).level, 14);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(1).pokerTier, FLUSH);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(1).level, 14);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(2).pokerTier, FLUSH);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(2).level, 13);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(3).pokerTier, FLUSH);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(3).level, 12);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(4).pokerTier, FLUSH);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(4).level, 11);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(5).pokerTier, FLUSH);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(5).level, 10);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(6).pokerTier, STRAIGHT);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(6).level, 14);
	}
	
	@Test
	public void testFourOfAKindStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(FIVE_OF_CLUBS);
		orderedCards.add(JACK_OF_HEARTS);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(JACK_OF_CLUBS);
		orderedCards.add(JACK_OF_HEARTS);
		
		Hand hand = new Hand(orderedCards);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).pokerTier, FOUR_OF_A_KIND);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).level, 11);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(1).pokerTier, HIGH_CARD);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(1).level, 5);
		
	}
	
	@Test
	public void testFullHouseStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(FIVE_OF_CLUBS);
		orderedCards.add(FIVE_OF_HEARTS);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(JACK_OF_CLUBS);
		orderedCards.add(JACK_OF_HEARTS);
		
		Hand hand = new Hand(orderedCards);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).pokerTier, FULL_HOUSE);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).level, 11);
	}
	
	@Test
	public void testFlushStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(TWO_OF_CLUBS);
		orderedCards.add(SIX_OF_CLUBS);
		orderedCards.add(NINE_OF_CLUBS);
		orderedCards.add(TEN_OF_CLUBS);
		orderedCards.add(JACK_OF_CLUBS);
		
		Hand hand = new Hand(orderedCards);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).pokerTier, FLUSH);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).level, 11);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(1).pokerTier, FLUSH);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(1).level, 10);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(2).pokerTier, FLUSH);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(2).level, 9);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(3).pokerTier, FLUSH);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(3).level, 6);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(4).pokerTier, FLUSH);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(4).level, 2);
	}
	
	@Test
	public void testStraightStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(SEVEN_OF_CLUBS);
		orderedCards.add(EIGHT_OF_CLUBS);
		orderedCards.add(NINE_OF_CLUBS);
		orderedCards.add(TEN_OF_HEARTS);
		orderedCards.add(JACK_OF_CLUBS);
		
		Hand hand = new Hand(orderedCards);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).pokerTier, STRAIGHT);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).level, 11);
	}
	
	@Test
	public void testThreeOfAKindStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(SEVEN_OF_CLUBS);
		orderedCards.add(EIGHT_OF_DIAMONDS);
		orderedCards.add(EIGHT_OF_CLUBS);
		orderedCards.add(EIGHT_OF_HEARTS);
		orderedCards.add(JACK_OF_CLUBS);
		
		Hand hand = new Hand(orderedCards);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).pokerTier, THREE_OF_A_KIND);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).level, 8);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(1).pokerTier, HIGH_CARD);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(1).level, 11);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(2).pokerTier, HIGH_CARD);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(2).level, 7);
		

	}
	
	@Test
	public void testTwoPairStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(SEVEN_OF_CLUBS);
		orderedCards.add(SEVEN_OF_DIAMONDS);
		orderedCards.add(EIGHT_OF_CLUBS);
		orderedCards.add(EIGHT_OF_HEARTS);
		orderedCards.add(JACK_OF_CLUBS);
		
		Hand hand = new Hand(orderedCards);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).pokerTier, TWO_PAIR);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).level, 8);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(1).pokerTier, TWO_PAIR);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(1).level, 7);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(2).pokerTier, HIGH_CARD);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(2).level, 11);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(2).pokerTier, HIGH_CARD);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(2).level, 11);
	}
	
	@Test
	public void testPairStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		
		orderedCards.add(THREE_OF_DIAMONDS);
		orderedCards.add(SEVEN_OF_CLUBS);
		orderedCards.add(EIGHT_OF_CLUBS);
		orderedCards.add(EIGHT_OF_HEARTS);
		orderedCards.add(JACK_OF_CLUBS);
		
		Hand hand = new Hand(orderedCards);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).pokerTier, PAIR);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).level, 8);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(1).pokerTier, HIGH_CARD);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(1).level, 11);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(2).pokerTier, HIGH_CARD);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(2).level, 7);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(3).pokerTier, HIGH_CARD);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(3).level, 3);
	}
	

	@Test
	public void testHighCardStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		
		orderedCards.add(THREE_OF_DIAMONDS);
		orderedCards.add(FOUR_OF_CLUBS);
		orderedCards.add(FIVE_OF_CLUBS);
		orderedCards.add(EIGHT_OF_HEARTS);
		orderedCards.add(ACE_OF_CLUBS);
		
		Hand hand = new Hand(orderedCards);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).pokerTier, HIGH_CARD);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(0).level, 14);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(1).pokerTier, HIGH_CARD);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(1).level, 8);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(2).pokerTier, HIGH_CARD);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(2).level, 5);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(3).pokerTier, HIGH_CARD);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(3).level, 4);
		
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(4).pokerTier, HIGH_CARD);
		assertEquals(hand.getUnitsOfStrength(orderedCards).get(4).level, 3);
	}
	
	
	
	
	
	
	

}
