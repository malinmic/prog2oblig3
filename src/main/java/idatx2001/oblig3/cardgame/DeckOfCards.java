package idatx2001.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * class DeckOfCards represents a deck of cards
 */
public class DeckOfCards {
    private char[] suit = {'H','D','C','S'};
    private int[] face = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    private ArrayList<PlayingCard> deckOfCards = new ArrayList<>();


    public DeckOfCards(){
        this.deckOfCards = new ArrayList<PlayingCard>();
        this.suit = suit;
        //int i = 0;
        //int j = 0;

        for(int i = 1; i<14; i++)
            for(char s : suit) {
                PlayingCard card = new PlayingCard(s, i);
                deckOfCards.add(card);
        }

        //for(char s : suit)
            //for(j = 0; j < 14; j++) {
                //PlayingCard card = new PlayingCard(s, j);
                //deckOfCards.add(new PlayingCard(s,j));

    }

    public ArrayList<PlayingCard> getDeckOfCards() {
        return deckOfCards;
    }

    public char[] getSuit() {
        return suit;
    }

    public void setDeckOfCards(ArrayList<PlayingCard> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public void setSuit(char[] suit) {
        this.suit = suit;
    }



    public HandOfCards dealHand(int n){
        return new HandOfCards(n);
    }


    @Override
    public String toString(){
        String s = " ";

        for(int i = 0; i < deckOfCards.size(); i++){
            s += "\n" + deckOfCards.get(i).toString();
        }

        return s;





    }





    //public static void main(String[] args) {

        //System.out.println(deckOfCards.size());
    //}


    //private static final List<PlayingCard> prototypeDeck =
            //new ArrayList<PlayingCard>(52);

    //static {

        //for (int i = 1; i < 14; i++)
            //for (char s : suit) {
                //PlayingCard card = new PlayingCard(s, i);
                //prototypeDeck.add(card);
                //for (Suit suit : Suit.values())
                //for (Rank rank : Rank.values())
                //prototypeDeck.add(new Card(rank, suit));
            //}
    //}

    // Returns a new deck
    //public static List<PlayingCard> newDeck() {
        //return new ArrayList<PlayingCard>(prototypeDeck);
    //}


}
