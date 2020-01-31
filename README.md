# JavaPoker
Poker Game written in Java
This Game I originally started in late 2017 in order to get back into learning Java programming again.  In the 2 years of off and on
programming, I was finally able to focus on trying to complete this project. In its current state, it is functional in the sense that
the cards are dealt, and the human player can call, raise, or fold.  I am currently in the process of writing out the logic of the 
computer players.

What I Learned
    - Creating Classes and class constructors
    - Creating methods to be used by the Player Class
    - Creating arrays to fit the deck of cards and number of players.
    - Manipulate chip counts based on call or raises
    - Accurately identify who the Big Blind (last person to act) Small Blind (second to last to act) and first position (first person to
    act)
    - For Loops going through an array and assigning cards from a deck of 52 and reducing the deck.
    - Learned how to return Booleans, Strings, Ints, this., and voids
    - Used Switch/Case statements for the assigning of values to the cards
    - created nested If/Else/Else If statements. 
    - Used While and Do-While loops.
    - Encapsulation: made sure that the Player attributes were set to private as to not be modified except for setters/getters.
    - User Inputs: Created a keyboard input to get starting chip counts, big blinds, and players. Also read players decisions to Raise,
    Call, or Fold.

What I can do better
    - Learn how to use the proper access modifiers (Private, Public, Protected)
    - Figure out the redundancies in the code. I feel like CardOne and CardTwo variables can be run on the same logic, just need to look 
    closer and figure out how to combine to improve efficiency.
    - Create the logic to properly have the computer act based on human and computer decisions.
    - Create the logic for determining the winning hand.
    - Create a dealer class to determine winners, when the betting should end/continue, and award chips at the end of hands if won/drawn.
    - Comment more of my logic so as not to lose sight of what it does.
    - Version control can be improved.
    
Next Steps
    - Will continue on the logic of the computer players. I have decided to create player profiles, with each profile having a certain
    percent chance of playing a hand (aggressive, semi aggressive, semi conservative, and conversative).  Depending on the starting hand, 
    the computer will Roll with RNG (between 1 - 100) and depending on the hand percentage + starting hand, will make a bet and either call
    or raise.
    - Cleanup the code a bit and remove some of the testing code I included.
