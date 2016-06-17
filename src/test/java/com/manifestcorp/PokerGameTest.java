package com.manifestcorp;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pokerGame.PokerGame;
import pokerGame.WinConditions;

public class PokerGameTest implements SampleDeck, WinConditions {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	//TODO: game breaks with four of a kind followed by single card

	@Test
	public void playerOneHandVsFourOfAKindTest() {
		ArrayList<Card> playerOneHandCards = new ArrayList<>();
		playerOneHandCards.add(TEN_OF_SPADES);
		playerOneHandCards.add(JACK_OF_SPADES);
		playerOneHandCards.add(QUEEN_OF_SPADES);
		playerOneHandCards.add(KING_OF_SPADES);
		playerOneHandCards.add(ACE_OF_SPADES);
		
		ArrayList<Card> playerTwoHandCards = new ArrayList<>();
		playerTwoHandCards.add(KING_OF_SPADES);
		playerTwoHandCards.add(ACE_OF_DIAMONDS);
		playerTwoHandCards.add(ACE_OF_CLUBS);
		playerTwoHandCards.add(ACE_OF_HEARTS);
		playerTwoHandCards.add(ACE_OF_SPADES);
		
		PokerGame pokerGame = new PokerGame();
		
		Hand playerOneHand = new Hand(playerOneHandCards);
		Hand playerTwoHand = new Hand(playerTwoHandCards);
		
		String winnerString = pokerGame.getWinningPlayer(playerOneHand, playerTwoHand);
		System.out.println("Royal Flush vs Four of a Kind");
		System.out.println(winnerString);
		assertEquals(winnerString,PLAYER_ONE_WIN);
	}
	

	@Test
	public void pairVsPairTest() {
		ArrayList<Card> playerOneHandCards = new ArrayList<>();
		playerOneHandCards.add(TEN_OF_SPADES);
		playerOneHandCards.add(TEN_OF_HEARTS);
		playerOneHandCards.add(QUEEN_OF_SPADES);
		playerOneHandCards.add(KING_OF_SPADES);
		playerOneHandCards.add(ACE_OF_SPADES);
		
		ArrayList<Card> playerTwoHandCards = new ArrayList<>();
		playerTwoHandCards.add(TWO_OF_SPADES);
		playerTwoHandCards.add(TWO_OF_DIAMONDS);
		playerTwoHandCards.add(JACK_OF_CLUBS);
		playerTwoHandCards.add(QUEEN_OF_HEARTS);
		playerTwoHandCards.add(ACE_OF_SPADES);
		
		PokerGame pokerGame = new PokerGame();
		
		Hand playerOneHand = new Hand(playerOneHandCards);
		Hand playerTwoHand = new Hand(playerTwoHandCards);
		
		String winnerString = pokerGame.getWinningPlayer(playerOneHand, playerTwoHand);
		
		System.out.println("Small pair vs Bigger pair");
		System.out.println(winnerString);
		assertEquals(winnerString,PLAYER_ONE_WIN);
	}
	
	@Test
	public void twoPairVsTwoPairTest() {
		ArrayList<Card> pairCards = new ArrayList<>();
		pairCards.add(TEN_OF_SPADES);
		pairCards.add(TEN_OF_HEARTS);
		pairCards.add(KING_OF_SPADES);
		pairCards.add(KING_OF_HEARTS);
		pairCards.add(QUEEN_OF_SPADES);
		
		ArrayList<Card> pairTwoCards = new ArrayList<>();
		pairTwoCards.add(TEN_OF_SPADES);
		pairTwoCards.add(TEN_OF_HEARTS);
		pairTwoCards.add(KING_OF_SPADES);
		pairTwoCards.add(KING_OF_HEARTS);
		pairTwoCards.add(ACE_OF_SPADES);
		
		PokerGame pokerGame = new PokerGame();
		
		Hand playerOneHand = new Hand(pairCards);
		Hand playerTwoHand = new Hand(pairTwoCards);
		
		String winnerString = pokerGame.getWinningPlayer(playerOneHand, playerTwoHand);
		System.out.println("Smaller Two Pair vs Bigger Two Pair");
		System.out.println(winnerString);
		assertEquals(winnerString,PLAYER_TWO_WIN);
		
	}
	
	@Test
	public void flushVsFlushTest() {
		ArrayList<Card> playerOneCards = new ArrayList<>();
		playerOneCards.add(FOUR_OF_SPADES);
		playerOneCards.add(SIX_OF_SPADES);
		playerOneCards.add(NINE_OF_SPADES);
		playerOneCards.add(KING_OF_SPADES);
		playerOneCards.add(QUEEN_OF_SPADES);
		
		ArrayList<Card> playerTwoCards = new ArrayList<>();
		playerTwoCards.add(FIVE_OF_HEARTS);
		playerTwoCards.add(SIX_OF_HEARTS);
		playerTwoCards.add(NINE_OF_HEARTS);
		playerTwoCards.add(KING_OF_HEARTS);
		playerTwoCards.add(QUEEN_OF_HEARTS);
		
		PokerGame pokerGame = new PokerGame();
		
		Hand playerOneHand = new Hand(playerOneCards);
		Hand playerTwoHand = new Hand(playerTwoCards);
		
		String winnerString = pokerGame.getWinningPlayer(playerOneHand, playerTwoHand);
		System.out.println("Flush vs Slightly Bigger Flush");
		System.out.println(winnerString);
		assertEquals(winnerString,PLAYER_TWO_WIN);
	}
	
	@Test
	public void threeOfAKindVsBetterThreeOfAKind() {
		ArrayList<Card> playerOneCards = new ArrayList<>();
		playerOneCards.add(FOUR_OF_SPADES);
		playerOneCards.add(FOUR_OF_CLUBS);
		playerOneCards.add(FOUR_OF_HEARTS);
		playerOneCards.add(KING_OF_SPADES);
		playerOneCards.add(JACK_OF_CLUBS);
		
		ArrayList<Card> playerTwoCards = new ArrayList<>();
		playerTwoCards.add(FOUR_OF_SPADES);
		playerTwoCards.add(FOUR_OF_SPADES);
		playerTwoCards.add(FOUR_OF_HEARTS);
		playerTwoCards.add(KING_OF_DIAMONDS);
		playerTwoCards.add(QUEEN_OF_HEARTS);
		
		PokerGame pokerGame = new PokerGame();
		
		Hand playerOneHand = new Hand(playerOneCards);
		Hand playerTwoHand = new Hand(playerTwoCards);
		
		String winnerString = pokerGame.getWinningPlayer(playerOneHand, playerTwoHand);
		System.out.println("Thee of a kind vs better three of a kind");
		System.out.println(winnerString);
		assertEquals(winnerString,PLAYER_TWO_WIN);
	}
	
	public void threeOfAKindVsWorseThreeOfAKind() {
		ArrayList<Card> playerOneCards = new ArrayList<>();
		playerOneCards.add(FOUR_OF_SPADES);
		playerOneCards.add(FOUR_OF_CLUBS);
		playerOneCards.add(FOUR_OF_HEARTS);
		playerOneCards.add(KING_OF_SPADES);
		playerOneCards.add(JACK_OF_CLUBS);
		
		ArrayList<Card> playerTwoCards = new ArrayList<>();
		playerTwoCards.add(FOUR_OF_SPADES);
		playerTwoCards.add(FOUR_OF_SPADES);
		playerTwoCards.add(FOUR_OF_HEARTS);
		playerTwoCards.add(KING_OF_DIAMONDS);
		playerTwoCards.add(THREE_OF_HEARTS);
		
		PokerGame pokerGame = new PokerGame();
		
		Hand playerOneHand = new Hand(playerOneCards);
		Hand playerTwoHand = new Hand(playerTwoCards);
		
		String winnerString = pokerGame.getWinningPlayer(playerOneHand, playerTwoHand);
		System.out.println("Thee of a kind vs better three of a kind");
		System.out.println(winnerString);
		assertEquals(winnerString,PLAYER_TWO_WIN);
	}
	//Tie Cases  
	
	public void testCloseOutOfOrderHighCard() {
		ArrayList<Card> playerOneCards = new ArrayList<>();
		playerOneCards.add(TWO_OF_SPADES);
		playerOneCards.add(EIGHT_OF_CLUBS);
		playerOneCards.add(TEN_OF_HEARTS);
		playerOneCards.add(KING_OF_SPADES);
		playerOneCards.add(QUEEN_OF_CLUBS);
		
		ArrayList<Card> playerTwoCards = new ArrayList<>();
		playerTwoCards.add(TWO_OF_SPADES);
		playerTwoCards.add(EIGHT_OF_SPADES);
		playerTwoCards.add(TEN_OF_HEARTS);
		playerTwoCards.add(KING_OF_DIAMONDS);
		playerTwoCards.add(QUEEN_OF_HEARTS);
		
		PokerGame pokerGame = new PokerGame();
		
		Hand playerOneHand = new Hand(playerOneCards);
		Hand playerTwoHand = new Hand(playerTwoCards);
		
		String winnerString = pokerGame.getWinningPlayer(playerOneHand, playerTwoHand);
		System.out.println("Thee of a kind vs better three of a kind");
		System.out.println(winnerString);
		assertEquals(winnerString,TIE_GAME);
	}
	

	
	


}
