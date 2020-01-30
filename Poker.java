
import java.util.*;
import java.io.*;
public class Poker {
	public static int numOfPlayers = 0;
	public static int chipsInput = 0;
	public static int blinds = 0;
	public static Scanner keyboard = new Scanner(System.in);
	public static int newBlind = blinds;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> cardArray = new ArrayList<Integer>();
		
		newGame();
		callAmount(blinds);
		
		Player [] playerArray = new Player[numOfPlayers];
		int [] tableSettingArray = new int [numOfPlayers];

		
		assignChips(chipsInput, numOfPlayers, playerArray);
		newDeck(cardArray);
		table(numOfPlayers, playerArray, tableSettingArray);
		dealCards(numOfPlayers, playerArray, cardArray);
		
		assignStartingPositions(tableSettingArray, playerArray);
		
		
		
		System.out.println("" + tableSettingArray.length);
		System.out.println("People seated at table (including dealer) " + tableSettingArray.length);
		
		for (int i = 0; i < numOfPlayers; i++) {
		System.out.println("Player " + Integer.toString(playerArray[i].getId()) + " has " + Integer.toString(playerArray[i].getChips()) + " Chips available.");
		System.out.println("Is Big Blind: " + playerArray[i].isBigBlind());
		System.out.println("Is Small Blind: " + playerArray[i].isSmallBlind());
		System.out.println("Is First to Act: " + playerArray[i].isFirstToAct());
		}
		
		System.out.println("Cards left: " + cardArray);
		System.out.println("" + cardArray.size() + " cards remaining");
		System.out.println("Array length : " + playerArray.length);
		
		playerArray[0].getValueOne();
		playerArray[0].getValueTwo();
		
		bettingRoundHuman(playerArray);

		System.out.println("Player 1 has " + playerArray[0].getChips() + " chips left after the wager and the new call amount is: " + getCallAmount());
		
		
		
		
	}
	
	public static void newGame () {
		System.out.println("How many players? (Greater than 2 and less than 10) ");
		numOfPlayers=keyboard.nextInt();
		
		System.out.println("How many chips to start with? ");
		chipsInput = keyboard.nextInt();
		
		System.out.println("What are the blinds? (Must be in multiples of 10): ");
		blinds = keyboard.nextInt();
	}
	
	public static void dealCards (int player, Player [] playerArray, ArrayList <Integer> cardArray) {//gives out the deck of cards and assigns it to the player
		int players = player;
		int cardOne = 0;
		int cardTwo = 0;
		int min = 1;
		int max = 52;
		Random randOne = new Random();
		ArrayList<Integer> cards = cardArray;
		
		for (int j = 0; j < players; j++) {
			int x = 0;
			
			while (x == 0) {
				cardOne = randOne.nextInt((max - min) + 1) + min; //random number between 1 and 52 
			
				if (cards.contains(cardOne)) {// check to see if card is still available in the deck (cards.)
					cards.remove(cards.indexOf(cardOne)); //If it is there, then it removes the card from the deck 
					playerArray[j].setCardOne(cardOne); // assign the card to the player
					//System.out.println("" + playerArray[j].getCardOne() + " ");  test to see if random card is assigned to player
					x++; //counter to get out of loop after it is done finding and assigning the card
				}//end if
			}//end while
			int y = 0;
			
			while (y == 0) {//same program as above but for card 2
			
				cardTwo = randOne.nextInt((max - min) + 1) + min;
								
				if (cards.contains(cardTwo)){
					cards.remove(cards.indexOf(cardTwo));
					playerArray[j].setCardTwo(cardTwo);
					//System.out.println("" + playerArray[j].getCardTwo() + " ");
					y++;
				} //end if
			} // end while
			
			//System.out.println(cards.toString());test to see the deck of cards being reduced
		}// end for loop
	}// end dealCards class
	
	public static void table (int players, Player[] playerArray, int[] tableSettingArray) {// sets the table position for the players with position 
		int playersAtTable = players;
		
		for (int i = 0; i < playersAtTable; i++) {
			tableSettingArray [i] = playerArray[i].getId();
			//System.out.println("Player at position " + i + " : " + tableSettingArray[i]);
		}
	}
	
	public static void newDeck (ArrayList <Integer> cardArray) {// method to renew the deck to 52 cards
		for (int i = 0; i < 52; i++) {
			cardArray.add(i, (i+1));
		}
	}// end newDeck method
	
	public static void assignChips (int chipsInput, int numOfPlayers, Player [] playerArray) {//method to assign the chips to the players
		
		for (int i = 0; i < numOfPlayers; i++) {
			playerArray[i] = new Player(i+1);
			playerArray[i].setChips(chipsInput);
		}// end for loop
	}// end assignChips method
	
	public static void assignStartingPositions (int [] tableSettingArray, Player[] playerArray) {
		int bigBlind = 1;
		int smallBlind = 1;
		int firstToAct = 1;
		
		for (int i = tableSettingArray.length - 1; i < tableSettingArray.length; i++) { //Big Blind is last player to bet
			playerArray[i].assignBigBlind(bigBlind);
		}
		for (int i = tableSettingArray.length - 2; i < tableSettingArray.length - 1; i++) { //Small Blind is second to last player to bet
			playerArray[i].assignSmallBlind(smallBlind);
		}

		playerArray[0].assignFirstToAct(firstToAct);//first round of play, human player at pos 0 is first to bet
	
	}// end for loop

	public static void bettingRoundHuman (Player[] playerArray) {
		
		int round = 0;
		int bet = 0;
		String decision = new String();
		
		do {
			System.out.println("(R)aise, (F)old, or (C)all (" + getCallAmount() + ")? ");
			decision = keyboard.next();
				if (decision.contains("r") || decision.contains("R")) {
					System.out.println("Please enter amount to raise (Must be greater than " + getCallAmount() + ") : ");
					bet = keyboard.nextInt();
					if (playerArray[0].getChips() > bet){
					playerArray[0].setChips(playerArray[0].getChips() - bet);//reduces the person's chips by the raise amount
					callAmount(bet);
					round++;
						}
					else {
					System.out.println("Not enough chips");
					}
				}//end Raise if
				else if (decision.contains("f") || decision.contains("F")) {
					System.out.println("You folded");
					playerArray[0].assignBetting(-1); //folds the player and shows they are no longer betting
					round++;
				}//end fold if
				else if (decision.contains("c") || decision.contains("C")) {
					System.out.println("You called " + getCallAmount() + " chips.");
					playerArray[0].setChips(playerArray[0].getChips() - getCallAmount());// reduces the players chips by the callAmount
					round++;
				}//end call if
		}while (round == 0);

	}//end bettingRoundHuman
	
	public static int callAmount(int call) {
		
		if (call > newBlind)
			newBlind = call;
			return newBlind;
	}
	public static int getCallAmount() {
		return newBlind;
	}
}

