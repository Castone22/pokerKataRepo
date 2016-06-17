package com.manifestcorp;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import playingCardDefinition.CardSuit;
import playingCardDefinition.CardValue;

public class CardTest {
	CardSuit suits;
	CardValue values;
	Card ACE_OF_SPADES;

	@Before
	public void setUp() throws Exception {
		ACE_OF_SPADES = new Card(CardValue.ACE, CardSuit.SPADES);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAceValue() {
		ACE_OF_SPADES = new Card(CardValue.ACE, CardSuit.SPADES);
		assertEquals(14,ACE_OF_SPADES.cardValue);
	}
	
	@Test
	public void testSpadeSuit() {
		ACE_OF_SPADES = new Card(CardValue.ACE, CardSuit.SPADES);
		assertEquals(1,ACE_OF_SPADES.cardSuit);
	}

}
