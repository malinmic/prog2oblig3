package idatx2001.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HandOfCards {

    private ArrayList<PlayingCard> handOfCards;
    private char[] suit = {'H','D','C','S'};
    Random random = new Random();


    /**
     * Constructor
     * @param n cards
     */
    public HandOfCards(int n) {
        DeckOfCards deck = new DeckOfCards();
        this.suit = suit;
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
     * @param cards cards
     */
    public HandOfCards(List<PlayingCard> cards){
        this.handOfCards = new ArrayList<>(cards);
    }


    /**
     * get method
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
     *
     * @return
     */
    public boolean getQueenOfSpades(){
        PlayingCard queenS = new PlayingCard('S',12);
        return handOfCards.contains(queenS);
    }

    /**
     *
     * @return
     */
    public boolean getFlush(){
        int sameSuitCards = 0;
        for(char s : suit)
            sameSuitCards = (int) handOfCards.stream().
                    filter(playingCard -> playingCard.getSuit() == s).count();
        return (sameSuitCards == 5);
    }



}
