package com.manifestcorp;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pokerHandDefenitions.HandStrengthUnit;
import pokerHandDefenitions.HasPokerTier;

public class HandTest implements SampleDeck, HasPokerTier{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsStraight() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(TEN_OF_SPADES);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(QUEEN_OF_SPADES);
		orderedCards.add(KING_OF_SPADES);
		orderedCards.add(ACE_OF_SPADES);
		
		Hand hand = new Hand(orderedCards);
		assertTrue(hand.isStraight(orderedCards));
	}
	@Test
	public void testNotStraight() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(TEN_OF_SPADES);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(KING_OF_SPADES);
		orderedCards.add(ACE_OF_SPADES);
		
		Hand hand = new Hand(orderedCards);
		assertFalse(hand.isStraight(orderedCards));
	}
	@Test
	public void testIsFlush() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(TEN_OF_SPADES);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(KING_OF_SPADES);
		orderedCards.add(ACE_OF_SPADES);
		
		Hand hand = new Hand(orderedCards);
		assertTrue(hand.isFlush(orderedCards));
	}
	@Test
	public void testIsNotFlush() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(TEN_OF_SPADES);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(KING_OF_SPADES);
		orderedCards.add(ACE_OF_HEARTS);
		
		Hand hand = new Hand(orderedCards);
		assertFalse(hand.isFlush(orderedCards));
	}
	@Test
	public void testGetHighCardValue() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(TEN_OF_SPADES);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(KING_OF_SPADES);
		orderedCards.add(ACE_OF_SPADES);
		
		Hand hand = new Hand(orderedCards);
		assertEquals(hand.getHighCardValue(orderedCards), 14);
	}
	
	
	@Test
	public void testGetStraightFlushStrengthUnit() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(TEN_OF_SPADES);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(QUEEN_OF_SPADES);
		orderedCards.add(KING_OF_SPADES);
		orderedCards.add(ACE_OF_SPADES);
		
		Hand hand = new Hand(orderedCards);
		ArrayList<HandStrengthUnit> StraightFlushStrength = hand.getStraightFlushStrengths(orderedCards);
		assertEquals(StraightFlushStrength.get(0).pokerTier, STRAIGHT_FLUSH);
		assertEquals(StraightFlushStrength.get(0).level, 14);
	}
	
	@Test
	public void testGetFourOfAKindStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(JACK_OF_CLUBS);
		orderedCards.add(ACE_OF_DIAMONDS);
		orderedCards.add(ACE_OF_SPADES);
		orderedCards.add(ACE_OF_HEARTS);
		orderedCards.add(ACE_OF_CLUBS);
		
		Hand hand = new Hand(orderedCards);
		ArrayList<HandStrengthUnit> fourOfAKindStrength = hand.getFourOfAKindStrengths(orderedCards);
		assertEquals(fourOfAKindStrength.get(0).pokerTier, FOUR_OF_A_KIND);
		assertEquals(fourOfAKindStrength.get(0).level, 14);

	}
	
	@Test
	public void testGetFullHouseStrengthUnit() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(JACK_OF_CLUBS);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(ACE_OF_SPADES);
		orderedCards.add(ACE_OF_HEARTS);
		orderedCards.add(ACE_OF_CLUBS);
		
		Hand hand = new Hand(orderedCards);
		ArrayList<HandStrengthUnit> fullHouseStrength = hand.getFullHouseStrengths(orderedCards);
		assertEquals(fullHouseStrength.get(0).pokerTier, FULL_HOUSE);
		assertEquals(fullHouseStrength.get(0).level, 14);

	}
	

	@Test
	public void testGetFlushStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		
		orderedCards.add(SIX_OF_SPADES);
		orderedCards.add(TEN_OF_SPADES);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(KING_OF_SPADES);
		orderedCards.add(ACE_OF_SPADES);

		Hand hand = new Hand(orderedCards);
		ArrayList<HandStrengthUnit> flushStrength = hand.getFlushStrengths(orderedCards);
		assertEquals(flushStrength.get(0).pokerTier, FLUSH);
		assertEquals(flushStrength.get(0).level, 14);

		
		//TODO: Add additional units to allow for accurate comparison in flush v flush.
	}
	
	@Test
	public void testGetStraightStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		
		orderedCards.add(TEN_OF_SPADES);
		orderedCards.add(JACK_OF_SPADES);
		orderedCards.add(QUEEN_OF_HEARTS);
		orderedCards.add(KING_OF_SPADES);
		orderedCards.add(ACE_OF_SPADES);

		Hand hand = new Hand(orderedCards);
		ArrayList<HandStrengthUnit> straightStrength = hand.getStraightStrengths(orderedCards);
		assertEquals(straightStrength.get(0).pokerTier, STRAIGHT);
		assertEquals(straightStrength.get(0).level, 14);

	
		//TODO: Add additional units to allow for accurate comparison in flush v flush.
	}
	
	@Test
	public void testGetThreeOFAKindStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(JACK_OF_CLUBS);
		orderedCards.add(TEN_OF_DIAMONDS);
		orderedCards.add(TEN_OF_SPADES);
		orderedCards.add(TEN_OF_HEARTS);
		orderedCards.add(ACE_OF_CLUBS);
		
		Hand hand = new Hand(orderedCards);
		ArrayList<HandStrengthUnit> threeOfAKindStrength = hand.getThreeOfAKindStrengths(orderedCards);
		assertEquals(threeOfAKindStrength.get(0).pokerTier, THREE_OF_A_KIND);
		assertEquals(threeOfAKindStrength.get(0).level, 10);
	}
	
	@Test
	public void testGetTwoPairStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(JACK_OF_CLUBS);
		orderedCards.add(TEN_OF_DIAMONDS);
		orderedCards.add(TEN_OF_SPADES);
		orderedCards.add(ACE_OF_HEARTS);
		orderedCards.add(ACE_OF_CLUBS);
		
		Hand hand = new Hand(orderedCards);
		ArrayList<HandStrengthUnit> twoPairStrength = hand.getTwoPairStrengths(orderedCards);
		assertEquals(twoPairStrength.get(0).pokerTier, TWO_PAIR);
		assertEquals(twoPairStrength.get(0).level, 14);
		
		assertEquals(twoPairStrength.get(1).pokerTier, TWO_PAIR);
		assertEquals(twoPairStrength.get(1).level, 10);
		
		assertEquals(twoPairStrength.get(2).pokerTier, HIGH_CARD);
		assertEquals(twoPairStrength.get(2).level, 11);
	}
	
	@Test
	public void testGetPairStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(JACK_OF_CLUBS);
		orderedCards.add(TEN_OF_DIAMONDS);
		orderedCards.add(TEN_OF_SPADES);
		orderedCards.add(FOUR_OF_HEARTS);
		orderedCards.add(ACE_OF_CLUBS);
		
		Hand hand = new Hand(orderedCards);
		ArrayList<HandStrengthUnit> pairStrengthUnits = hand.getPairStrengths(orderedCards);
		assertEquals(pairStrengthUnits.get(0).pokerTier, PAIR);
		assertEquals(pairStrengthUnits.get(0).level, 10);
		
		//TODO: add tests for additional strength units
	}
	
	@Test
	public void testGetHighCardStrengthUnits() {
		ArrayList<Card> orderedCards = new ArrayList<>();
		orderedCards.add(JACK_OF_CLUBS);
		orderedCards.add(TEN_OF_DIAMONDS);
		orderedCards.add(SIX_OF_SPADES);
		orderedCards.add(FOUR_OF_HEARTS);
		orderedCards.add(ACE_OF_CLUBS);
		
		Hand hand = new Hand(orderedCards);
		ArrayList<HandStrengthUnit> highCardStrength = hand.getHighCardStrengths(orderedCards);
		assertEquals(highCardStrength.get(0).pokerTier, HIGH_CARD);
		assertEquals(highCardStrength.get(0).level, 14);
		
		assertEquals(highCardStrength.get(1).pokerTier, HIGH_CARD);
		assertEquals(highCardStrength.get(1).level, 11);
		
		assertEquals(highCardStrength.get(2).pokerTier, HIGH_CARD);
		assertEquals(highCardStrength.get(2).level, 10);
		
		assertEquals(highCardStrength.get(3).pokerTier, HIGH_CARD);
		assertEquals(highCardStrength.get(3).level, 6);
		
		assertEquals(highCardStrength.get(4).pokerTier, HIGH_CARD);
		assertEquals(highCardStrength.get(4).level, 4);		
	}
	
}
