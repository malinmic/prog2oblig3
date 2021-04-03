package idatx2001.oblig3.cardgame;

public class DeckOfCards {

    private final char suit; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
    private final int face; // a number between 1 and 13

    public DeckOfCards(char suit, int face){
        this.suit = suit;
        this.face = face;

    }
}
