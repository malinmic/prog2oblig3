package idatx2001.oblig3.cardgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.util.ArrayList;

public class App extends Application {

    private Label faceSumResult = new Label("");
    private Label heartsSumResult = new Label("");
    private Label queenOfSpadesResult = new Label("");
    private Label flushSumResult = new Label("");
    private final Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    private static final DeckOfCards cardDeck = new DeckOfCards();
    private HandOfCards handOfCards = null;

    Stage stage;
    Scene scene;



    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("Card Game");


        //right side
        VBox rightSide = new VBox(20);
        Button dealHand = new Button("Deal Hand");
        Button checkHand = new Button("Check hand");
        rightSide.getChildren().addAll(dealHand, checkHand);
        //rightSide.setPadding(new Insets(20,20,20,20));


        //cards with hearts box
        HBox cardInfoBoxHearts = new HBox(20);
        cardInfoBoxHearts.setBorder(border);
        cardInfoBoxHearts.setSpacing(15);
        Label cardsWithHearts = new Label("Cards With Hearts: ");
        cardInfoBoxHearts.getChildren().addAll(cardsWithHearts, heartsSumResult);


        //sum of faces box
        HBox cardInfoBoxSumOfFaces = new HBox(20);
        cardInfoBoxSumOfFaces.setBorder(border);
        cardInfoBoxSumOfFaces.setSpacing(15);
        Label cardsFacesSum = new Label("Sum of Faces: ");
        cardInfoBoxSumOfFaces.getChildren().addAll(cardsFacesSum, faceSumResult);

        //queen of spades box
        HBox cardInfoBoxQueenOfSpades = new HBox(20);
        cardInfoBoxQueenOfSpades.setBorder(border);
        cardInfoBoxQueenOfSpades.setSpacing(15);
        Label cardQueenOfSpades = new Label("Queen of Spades: ");
        cardInfoBoxQueenOfSpades.getChildren().addAll(cardQueenOfSpades, queenOfSpadesResult);

        //flush box
        HBox cardInfoBoxFlush = new HBox(20);
        cardInfoBoxFlush.setBorder(border);
        cardInfoBoxFlush.setSpacing(20);
        Label cardsFlush = new Label("Flush: ");
        cardInfoBoxFlush.getChildren().addAll(cardsFlush, flushSumResult);


        FlowPane bottom = new FlowPane();
        bottom.setVgap(20);
        bottom.setHgap(25);
        bottom.getChildren().addAll(cardInfoBoxHearts, cardInfoBoxSumOfFaces, cardInfoBoxQueenOfSpades, cardInfoBoxFlush);


        //LEFT SIDE
        StackPane leftSide = new StackPane();
        leftSide.setPadding(new Insets(10, 10, 10, 10));
        leftSide.setBorder(border);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(4);

        GridPane.setConstraints(bottom, 0, 15);
        GridPane.setConstraints(leftSide, 4, 10);
        GridPane.setConstraints(rightSide, 0, 3);

        gridPane.getChildren().addAll(bottom, leftSide, rightSide);


        dealHand.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            leftSide.getChildren().clear();
            handOfCards = cardDeck.dealHand(10);
            leftSide.getChildren().add(showCardsMethod(handOfCards));
        });

        checkHand.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (handOfCards == null) {
                throw new IllegalArgumentException("Deal hand first!");
            } else {
                checkHandMethod(handOfCards);
            }
        });


        scene = new Scene(leftSide);
        stage.setScene(scene);
        stage.show();
    }


    private void getSumOfFacesMethod(HandOfCards handOfCards){
        faceSumResult.setText(String.valueOf(handOfCards.getSumOfCardFaces()));
    }


    private void getQueenOfSpadesMethod(HandOfCards handOfCards){
        if(handOfCards.getQueenOfSpades()){
            queenOfSpadesResult.setText("You have the Queen of Spades!");
        }else{
            queenOfSpadesResult.setText("You do not have the Queen of Spades");
        }
    }


    private void getCardsWithHeartsMethod(HandOfCards handOfCards){
        if(handOfCards.getHeartCards().isEmpty()){
            heartsSumResult.setText("Heartless...");
        }else{
            heartsSumResult.setText(printAllHeartsOnHand(handOfCards.getHeartCards()));
        }
    }


    //handOfCards?????????
    private String printAllHeartsOnHand(ArrayList<PlayingCard> handOfCards){
        StringBuilder stringBuilder = new StringBuilder();
        handOfCards.forEach(playingCard -> stringBuilder.append(playingCard.toString()).append("\n"));

        return stringBuilder.toString();
    }




    private void getFlushMethod(HandOfCards handOfCards){
        if(handOfCards.getFlush()){
            flushSumResult.setText("YES!!!");
        }else{
            flushSumResult.setText("Nope...");
        }

    }



    private void checkHandMethod(HandOfCards handOfCards){
        getFlushMethod(handOfCards);
        getCardsWithHeartsMethod(handOfCards);
        getQueenOfSpadesMethod(handOfCards);
        getSumOfFacesMethod(handOfCards);
    }



    public Node showCardsMethod(HandOfCards handOfCards){

        FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL);


        for(PlayingCard c : handOfCards.getHandOfCards()){
            Label handLabel = new Label(Character.toString(c.getFace() + c.getSuit()));
            handLabel.setFont(Font.font(20));
            flowPane.getChildren().addAll(handLabel);
        }

        return flowPane;
    }



    @Override
    public void init() throws Exception{
        super.init();
    }

    @Override
    public void stop() throws Exception{
        super.stop();
    }

}
