package idatx2001.oblig3.cardgame;

import java.util.*;
import java.util.stream.Collectors;


/**
 * class HandOfCards represents a hand of cards
 * methods for checking for flush, queen of spades, hearts and sum of faces
 */

public class HandOfCards {

    private ArrayList<PlayingCard> handOfCards;
    private char[] suit = {'H','D','C','S'};


    /**
     * Constructor
     * deals random cards from the deck
     * @param n cards
     */
    public HandOfCards(int n) {
        Random random = new Random();
        DeckOfCards deck = new DeckOfCards();
        this.handOfCards = new ArrayList<>();

        while(handOfCards.size() < n){
            PlayingCard newCard = deck.getDeckOfCards().get(random.nextInt(52));
            if(!handOfCards.contains(newCard)){
                handOfCards.add(newCard);
            }
        }
    }


    /**
     * Constructor
     * @param handOfCards cards
     */
    public HandOfCards(List<PlayingCard> handOfCards){
        this.handOfCards = new ArrayList<>(handOfCards);
    }


    /**
     * method for getting hand of cards list
     * @return
     */
    public ArrayList<PlayingCard> getHandOfCards(){
        return handOfCards;
    }


    /**
     * method for getting the sum
     * @return
     */
    public int getSumOfCardFaces(){
        return handOfCards.stream().
                mapToInt(PlayingCard :: getFace).sum();
    }


    /**
     * method for checking for hearts
     * @return
     */
    public ArrayList<PlayingCard> getHeartCards(){
        return (ArrayList<PlayingCard>) handOfCards.stream().
                filter(playingCard -> playingCard.getSuit() == 'H')
                .collect(Collectors.toList());
    }


    /**
     * method for checking for queen of spades
     * @return
     */
    public boolean getQueenOfSpades(){
        PlayingCard queenS = new PlayingCard('S',12);
        return handOfCards.contains(queenS);
    }

    /**
     * method for checking for flush
     * @return
     */
    public boolean getFlush(){
        int sameSuitCards = 0;
        for(char s : suit)
            sameSuitCards = (int) handOfCards.stream().
                    filter(playingCard -> playingCard.getSuit() == s).count();
        return (sameSuitCards == 5);
    }


    @Override
    public String toString(){

        String s = handOfCards.stream().map(Objects::toString).collect(Collectors.joining("      "));


        return s;
    }


}
