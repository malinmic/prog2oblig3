package idatx2001.oblig3.cardgame;

import java.util.ArrayList;


/**
 * class DeckOfCards represents a deck of cards
 *
 */
public class DeckOfCards {

    private char[] suit = {'H','D','C','S'};
    private int[] face = {1,2,3,4,5,6,7,8,9,10,11,12,13};

    /**
     * arraylist that represents a deck of cards
     */
    private ArrayList<PlayingCard> deckOfCards = new ArrayList<>();


    /**
     * constructor
     *
     * makes a deck of cards
     */
    public DeckOfCards(){
        this.deckOfCards = new ArrayList<PlayingCard>();
        this.suit = suit;

        for(int i = 1; i<14; i++)
            for(char s : suit) {
                PlayingCard card = new PlayingCard(s, i);
                deckOfCards.add(card);
        }
    }


    /**
     * get method for getting the deck of cards
     * @return
     */
    public ArrayList<PlayingCard> getDeckOfCards() {
        return deckOfCards;
    }

    /**
     * get method for getting the suit of a card
     * @return
     */
    public char[] getSuit() {
        return suit;
    }

    /**
     * set method for setting the deck of cards
     * @param deckOfCards
     */
    public void setDeckOfCards(ArrayList<PlayingCard> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    /**
     * set method for setting the suit of a card
     * @param suit
     */
    public void setSuit(char[] suit) {
        this.suit = suit;
    }


    /**
     * dealHand
     *
     * method for dealing a hand of cards
     * @param n cards
     * @return cards
     */
    public HandOfCards dealHand(int n){
        return new HandOfCards(n);
    }


    /**
     * toString
     *
     * @return card info
     */
    @Override
    public String toString(){
        String s = " ";

        for(int i = 0; i < deckOfCards.size(); i++){
            s += "\n" + deckOfCards.get(i).toString();
        }
        return s;
    }
}
