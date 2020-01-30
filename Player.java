public class Player extends Poker {
	private int cardOne;
	private int cardTwo;
	private String valueCardOne;
	private String valueCardTwo;
	private int chips;
	private int id;
	private String name;
	private int isSmallBlind;
	private int isBigBlind;
	private int isFirstToAct;
	private int isBetting = 1;
	private int isHuman = 0;
	
	public Player (int id) {
		this.setId(id);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getChips() {
		return chips;
	}
	public void setChips(int chips) {
		this.chips = chips;
	}
	public int getCardOne() {
		return cardOne;
	}
	public void setCardOne(int cardOne) {
		this.cardOne = cardOne;
	}
	public int getCardTwo() {
		return cardTwo;
	}
	public void setCardTwo(int cardTwo) {
		this.cardTwo = cardTwo;
	}
	public void assignSmallBlind (int smallBlind) {
		this.isSmallBlind = smallBlind;
	}
	public boolean isSmallBlind () {
		return this.isSmallBlind > 0;		
	}
	public void assignFirstToAct (int firstToAct) {
		this.isFirstToAct = firstToAct;
	}
	public boolean isFirstToAct() {
		return this.isFirstToAct > 0;
	}
	public void assignBigBlind (int bigBlind) {
		this.isBigBlind = bigBlind;
	}
	public boolean isBigBlind() {
		return this.isBigBlind > 0;
	}
	public void assignBetting (int betting) {
		this.isBetting = betting;
	}
	public boolean isBetting() {
		return this.isBetting > 0;
	}
	public void assignHuman (int human) {
		this.isHuman = human;
	}
	public boolean isHuman() {
		return this.isHuman > 0;
	}
	public void getValueOne () {
		String suitOne = new String();
		
		switch (this.cardOne) {
		case 1 : case 14 : case 27 : case 40 :
			valueCardOne = "Ace";
			break;
		case 2 : case 15 : case 28 : case 41 :
			valueCardOne = "2";
			break;
		case 3 : case 16 : case 29 : case 42 :
			valueCardOne = "3";
			break;
		case 4 : case 17 : case 30 : case 43 :
			valueCardOne = "4";
			break;
		case 5 : case 18 : case 31 : case 44 :
			valueCardOne = "5";
			break;
		case 6 : case 19 : case 32 : case 45 :
			valueCardOne = "6";
			break;
		case 7 : case 20 : case 33 : case 46 :
			valueCardOne = "7";
			break;
		case 8 : case 21 : case 34 : case 47 :
			valueCardOne = "8";
			break;
		case 9 : case 22 : case 35 : case 48 :
			valueCardOne = "9";
			break;
		case 10 : case 23 : case 36 : case 49 :
			valueCardOne = "10";
			break;
		case 11 : case 24 : case 37 : case 50 :
			valueCardOne = "Jack";
			break;
		case 12 : case 25 : case 38 : case 51 :
			valueCardOne = "Queen";
			break;
		case 13 : case 26 : case 39 : case 52 :
			valueCardOne = "King";
			break;
		}
		if (cardOne >= 1 && cardOne < 14)
			suitOne = "Spades";
		else if (cardOne >= 14 && cardOne < 27)
			suitOne = "Diamonds";
		else if (cardOne >= 27 && cardOne < 40)
			suitOne = "Clubs";
		else if (cardOne >= 40 && cardOne < 53)
			suitOne = "Hearts";		
		System.out.println("" + valueCardOne + " of " + suitOne);
	}
	public void getValueTwo () {
		String suitTwo = new String();
		
		switch (this.cardTwo) {
		case 1 : case 14 : case 27 : case 40 :
			valueCardTwo = "Ace";
			break;
		case 2 : case 15 : case 28 : case 41 :
			valueCardTwo = "2";
			break;
		case 3 : case 16 : case 29 : case 42 :
			valueCardTwo = "3";
			break;
		case 4 : case 17 : case 30 : case 43 :
			valueCardTwo = "4";
			break;
		case 5 : case 18 : case 31 : case 44 :
			valueCardTwo = "5";
			break;
		case 6 : case 19 : case 32 : case 45 :
			valueCardTwo = "6";
			break;
		case 7 : case 20 : case 33 : case 46 :
			valueCardTwo = "7";
			break;
		case 8 : case 21 : case 34 : case 47 :
			valueCardTwo = "8";
			break;
		case 9 : case 22 : case 35 : case 48 :
			valueCardTwo = "9";
			break;
		case 10 : case 23 : case 36 : case 49 :
			valueCardTwo = "10";
			break;
		case 11 : case 24 : case 37 : case 50 :
			valueCardTwo = "Jack";
			break;
		case 12 : case 25 : case 38 : case 51 :
			valueCardTwo = "Queen";
			break;
		case 13 : case 26 : case 39 : case 52 :
			valueCardTwo = "King";
			break;
		}
		
		if (cardTwo >= 1 && cardTwo < 14)
			suitTwo = "Spades";
		else if (cardTwo >= 14 && cardTwo < 27)
			suitTwo = "Diamonds";
		else if (cardTwo >= 27 && cardTwo < 40)
			suitTwo = "Clubs";
		else if (cardTwo >= 40 && cardTwo < 53)
			suitTwo = "Hearts";
		
		System.out.println("" + valueCardTwo + " of " + suitTwo);
	}
}
