/**
 *  Program 1d
 *  FiveCards creates a hand of five cards from a traditional deck of cards.
 *  CS108-3
 *  September 5,2018
 *  Drake Nguyen
  */
import java.util.Random;
import java.util.Arrays;

public class FiveCards {
	public static void main (String[] args)
	{
		int[] hand = initHand(52,5,1111);
		showHand(hand);
		sameSuit(hand);
	}
	/**
	 * 
	 * @return
	 */
	public static String getIdentificationString()
	{
		return "Program 1, Drake Nguyen";
	}
	/**
	 * 
	 * @param cardNumber
	 * @returns the suit the card value is located in
	 */
	public static String getSuit(int cardNumber)
	{	
		// # = 0-51, #/13 = 0-3(suits)
		int newVal = cardNumber/13;
		if(newVal == 0){
			return "Clubs";}
		else if(newVal == 1){
			return "Diamonds";}
		else if(newVal == 2){
			return "Hearts";}
		else{
			return "Spades";}
	}
	/**
	 * 
	 * @param cardNumber
	 * @returns the rank of the card based on it's number
	 */
	public static String getRank(int cardNumber)
	{
		// # = 0-51, #%13 = 0-12(rank)
		int newVal = cardNumber%13;
		if(newVal == 0) {
			return "Ace";}
		else if(newVal == 1) {
			return "Two";}
		else if(newVal == 2) {
			return "Three";}
		else if(newVal == 3) {
			return "Four";}
		else if(newVal == 4) {
			return "Five";}
		else if(newVal == 5) {
			return "Six";}
		else if(newVal == 6) {
			return "Seven";}
		else if(newVal == 7) {
			return "Eight";}
		else if(newVal == 8) {
			return "Nine";}
		else if(newVal == 9) {
			return "Ten";}
		else if(newVal == 10) {
			return "Jack";}
		else if(newVal == 11) {
			return "Queen";}
		else {
			return "King";}
	}
	/**
	 * 
	 * @param deckSize
	 * @param handSize
	 * @param randomGeneratorSeed
	 * @returns a random hand of handSize
	 */
	public static int[] initHand(int deckSize, int handSize, long randomGeneratorSeed)
	{
		Random rand = new Random(randomGeneratorSeed);
		int[] hand = new int[handSize];
		boolean hasDuplicate = false;
		for(int i = 0; i < handSize; i++)
			{	
				hand[i] = rand.nextInt(deckSize);
				for(int j = 0; j < handSize; j++)
				{
					if(hand[i] == hand[j] && i !=j) {
						hasDuplicate = true;
					}
				}
				if(hasDuplicate) {
					hasDuplicate = false;
					hand[i] = rand.nextInt(deckSize);
				}
				
				
			}
		return hand;
	}	
	/**
	 * prints each card in the hand in the same order initialized
	 * @param hand
	 */
	public static void showHand(int[] hand)
	{
		for(int i = 0; i < hand.length; i++) {
			System.out.println(getCardValue(hand[i]));
		}
	}
	/**
	 * prints any cards that have the same suit in ascending rank order
	 * @param hand
	 */
	public static void sameSuit(int[] hand)
	{
		//sorts the array ahead of time from ascending numerical order
		Arrays.sort(hand);
		int clubCount = 0;
		int diaCount = 0;
		int heaCount = 0;
		int spaCount = 0;
		//loop to check how many times the same suit appears
		for(int i = 0; i < hand.length; i++)
		{
			String cardVal = getCardValue(hand[i]);
			if(cardVal.contains("Clubs")) {
				clubCount++;
			}
			else if(cardVal.contains("Diamonds")) {
				diaCount++;
			}
			else if(cardVal.contains("Hearts")) {
				heaCount++;
			}
			else if(cardVal.contains("Spades")) {
				spaCount++;
			}
		}
		//print duplicate suits x amount of times
		if(clubCount >= 2) {
			for(int j = 0; j < clubCount; j++) {
				System.out.println(getCardValue(hand[j]));
			}
		}
		if(diaCount >= 2) {
			for(int k = clubCount; k < clubCount+diaCount; k++) {
				System.out.println(getCardValue(hand[k]));
			}
		}
		if(heaCount >= 2) {
			for(int l = clubCount+diaCount; l < clubCount+diaCount+heaCount; l++) {
				System.out.println(getCardValue(hand[l]));
			}
		}
		if(spaCount >= 2) {
			for(int m = clubCount+diaCount+heaCount; m < clubCount+diaCount+heaCount+spaCount; m++) {
				System.out.println(getCardValue(hand[m]));
			}
		}
		
	}
	/**
	 * 
	 * @param cardNumber
	 * @returns suit and rank of a card as a string with " of "
	 */
	public static String getCardValue(int cardNumber)
	{
		return getRank(cardNumber) + " of " + getSuit(cardNumber);
	}
}
