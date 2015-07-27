package edu.upc.fib.inlab.kata.yatzy;

import org.junit.*;

import edu.upc.fib.inlab.kata.yatzy.Yatzy;
import static org.junit.Assert.*;

public class YatzyTest {

	@Test
	public void chanceScoresSumOfAllDice() {
		assertEquals(15, new Yatzy(2, 3, 4, 5, 1).chance());
		assertEquals(16, new Yatzy(3, 3, 4, 5, 1).chance());
	}

	@Test
	public void yatzyScores50() {
		assertEquals(50, new Yatzy(4, 4, 4, 4, 4).yatzy());
		assertEquals(50, new Yatzy(6, 6, 6, 6, 6).yatzy());
		assertEquals(0, new Yatzy(6, 6, 6, 6, 3).yatzy());
	}

	@Test
	public void onesScoreSumOfOnes() {
		assertEquals(1, new Yatzy(1, 2, 3, 4, 5).ones());
		assertEquals(2, new Yatzy(1, 2, 1, 4, 5).ones());
		assertEquals(0, new Yatzy(6, 2, 2, 4, 5).ones());
		assertEquals(4, new Yatzy(1, 2, 1, 1, 1).ones());
	}

	@Test
	public void twosScoreSumOfTwos() {
		assertEquals(4, new Yatzy(1, 2, 3, 2, 6).twos());
		assertEquals(10, new Yatzy(2, 2, 2, 2, 2).twos());
	}

	@Test
	public void threesScoreSumOfThrees() {
		assertEquals(6, new Yatzy(1, 2, 3, 2, 3).threes());
		assertEquals(12, new Yatzy(2, 3, 3, 3, 3).threes());
	}

	@Test
	public void foursScoreSumOfFours() {
		assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
		assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
		assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
	}

	@Test
	public void fivesScoreSumOfFives() {
		assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
		assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
		assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
	}

	@Test
	public void sixesScoreSumOfSixes() {
		assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
		assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
		assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
	}

	@Test
	public void onePairScoreSumOfGreatestPair() {
		assertEquals(6, new Yatzy(3, 4, 3, 5, 6).onePair());
		assertEquals(10, new Yatzy(5, 3, 3, 3, 5).onePair());
		assertEquals(12, new Yatzy(5, 3, 6, 6, 5).onePair());
	}

	@Test
	public void twoPairScoreSumOfDifferentPairs() {
		assertEquals(16, new Yatzy(3, 3, 5, 4, 5).twoPairs());
		assertEquals(16, new Yatzy(3, 3, 5, 5, 5).twoPairs());
		assertEquals(0, new Yatzy(3, 3, 3, 3, 5).twoPairs());
	}

	@Test
	public void threeOfAKindScoresSum() {
		assertEquals(9, new Yatzy(3, 3, 3, 4, 5).threeOfAKind());
		assertEquals(15, new Yatzy(5, 3, 5, 4, 5).threeOfAKind());
		assertEquals(9, new Yatzy(3, 3, 3, 3, 5).threeOfAKind());
	}

	@Test
	public void fourOfAKindScoresSum() {
		assertEquals(12, new Yatzy(3, 3, 3, 3, 5).fourOfAKind());
		assertEquals(20, new Yatzy(5, 5, 5, 4, 5).fourOfAKind());
		assertEquals(12, new Yatzy(3, 3, 3, 3, 3).fourOfAKind());
	}

	@Test
	public void smallStraightScoresSum() {
		assertEquals(15, new Yatzy(1, 2, 3, 4, 5).smallStraight());
		assertEquals(15, new Yatzy(2, 3, 4, 5, 1).smallStraight());
		assertEquals(0, new Yatzy(1, 2, 2, 4, 5).smallStraight());
	}

	@Test
	public void largeStraightScoresSum() {
		assertEquals(20, new Yatzy(6, 2, 3, 4, 5).largeStraight());
		assertEquals(20, new Yatzy(2, 3, 4, 5, 6).largeStraight());
		assertEquals(0, new Yatzy(1, 2, 2, 4, 5).largeStraight());
	}

	@Test
	public void fullHouseScoresSumOfPairAndThree() {
		assertEquals(18, new Yatzy(6, 2, 2, 2, 6).fullHouse());
		assertEquals(0, new Yatzy(2, 3, 4, 5, 6).fullHouse());
	}
}
