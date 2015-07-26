package edu.upc.fib.inlab.kata.yatzy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Yatzy {

	protected int[] dice;
    protected int[] numberOfDiceWith;    

    public Yatzy(int d1, int d2, int d3, int d4, int d5)
    {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
        numberOfDiceWith=new int[7];
        for (int d:dice) numberOfDiceWith[d]++;
    }

    public int chance()
    {
    	int score=0;
        for (int d:dice) score+=d;	
    	return score;
    }

    public int yatzy()
    {
    	int first=dice[0];
        for (int d:dice) if (d!=first) return 0;
        return 50;
    }

    public int ones() {
    	return sameNumber(1);
    }

    public int twos() {
    	return sameNumber(2);
    }

    public int threes() {
    	return sameNumber(3);
    }

    public int fours()
    {
    	return sameNumber(4);
    }

    public int fives()
    {
    	return sameNumber(5);
    }

    public int sixes()
    {
    	return sameNumber(6);
    }

    public int sameNumber(int n)
    {
    	return numberOfDiceWith[n]*n;
    }
    
    
    public int onePair()
    {
    	List<Integer> aux=listNumberOfDicesOfAKind(2);
    	if (aux.size()<1) return 0;
    	return Collections.max(aux)*2;
    }
    
    public int twoPairs()
    {
    	List<Integer> aux=listNumberOfDicesOfAKind(2);
    	if (aux.size()<2) return 0;
    	return aux.get(0)*2+aux.get(1)*2;
    }
    
    private List<Integer> listNumberOfDicesOfAKind(int n)
    {
    	List<Integer> aux=new ArrayList<Integer>();
        for (int i=1;i<=6;i++) {
    		if (numberOfDiceWith[i]>=n) aux.add(i);
    	}
        return aux;
    }

    public int fourOfAKind() {
    	return nOfAKind(4);
    }

    public int threeOfAKind()
    {
    	return nOfAKind(3);
    }

    public int nOfAKind(int n)
    {
    	int score=0;
    	for (int i:listNumberOfDicesOfAKind(n)) score=i*n;
    	return score;
    }

    public int smallStraight()
    {
    	if (!straightStartingAt(1)) return 0;
    	return 15;
    }

    public int largeStraight()
    {
    	if (!straightStartingAt(2)) return 0;
    	return 20;
    }

    private boolean straightStartingAt(int n)
    {
    	for (int i=0;i<5;i++) {
    		if (numberOfDiceWith[i+n]!=1) return false;
    	}
    	return true;
    }
    
    public int fullHouse()
    {
    	List<Integer> pair=listNumberOfDicesOfAKind(2);
    	List<Integer> trio=listNumberOfDicesOfAKind(3);
    	pair.removeAll(trio);
    	if (pair.size()!=1) return 0;
    	if (trio.size()!=1) return 0;
    	return pair.get(0)*2+trio.get(0)*3;
    }
}



