package bj2;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Interface extends Application {

    public Deck deck = new Deck();
    public Hand dealer, player;
    public Text message = new Text();

    public HBox hand_dealer = new HBox(5);
    public HBox hand_player = new HBox(5);

    public Parent makeGame() 
    {
        dealer = new Hand(hand_dealer.getChildren());
        player = new Hand(hand_player.getChildren());

        Pane root = new Pane();

        Region background = new Region();

        HBox rootLayout = new HBox(5);
        //rootLayout.setPadding(new Insets(5, 5, 5, 5));
        Rectangle leftBG = new Rectangle(720, 400);
        leftBG.setFill(Color.FORESTGREEN);

        //Orienting the Board
        VBox leftVBox = new VBox(50);
        leftVBox.setAlignment(Pos.TOP_CENTER);

        Text dealerScore = new Text("Dealer: ");
        Text playerScore = new Text("Player: ");

        //bank goes here-- TODO://

        Button btnPlay = new Button("Start Playing");
        Button btnHit = new Button("HIT");
        Button btnStand = new Button("STAY");
        Button btnQuit = new Button("Quit Playing");
        
        leftVBox.getChildren().addAll(dealerScore, hand_dealer, message, playerScore, hand_player);
        HBox bottom = new HBox(20);
        bottom.setAlignment(Pos.BOTTOM_RIGHT);
        bottom.getChildren().addAll(btnPlay, btnHit, btnStand, btnQuit);

        // ADD BOTH STACKS TO ROOT LAYOUT
        rootLayout.getChildren().addAll(new StackPane(leftBG, leftVBox, bottom));
        root.getChildren().addAll(background, rootLayout);


        playerScore.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.valueProperty().asString()));
        dealerScore.textProperty().bind(new SimpleStringProperty("Dealer: ").concat(dealer.valueProperty().asString()));

        player.valueProperty().addListener((obs, old, score) -> {
            if (score.intValue() >= 21) {
            	resolution();
            }
        });

        dealer.valueProperty().addListener((obs, old, score) -> {
            if (score.intValue() >= 21) {
            	resolution();
            }
        });

        //Defining the Button Actions
        btnPlay.setOnAction(event -> {startNewGame(); });

        btnHit.setOnAction(event -> {player.hitMe(deck.drawCard()); });

        btnStand.setOnAction(event -> {
        	//According to Google, blackjack dealers must hit until they are over 17 so...
            while (dealer.valueProperty().get() < 17) {
                dealer.hitMe(deck.drawCard());
            }

            resolution();
        });
        btnQuit.setOnAction(event -> {System.exit(0);});

        return root;
    }

    public void startNewGame() {
        deck.shuffle();

        dealer.resetScore();
        player.resetScore();

        dealer.hitMe(deck.drawCard());
        dealer.hitMe(deck.drawCard());
        player.hitMe(deck.drawCard());
        player.hitMe(deck.drawCard());
    }

    public void resolution() {

        int dScore = dealer.valueProperty().get();
        int pScore = player.valueProperty().get();
        String winner = "Exceptional case: d: " + dScore + " p: " + pScore;

        //checking order since dealer wins when tie
        if (dScore == 21 || pScore > 21 || dScore == pScore
                || (dScore < 21 && dScore > pScore)) {
            winner = "Dealer";
        }
        else if (pScore == 21 || dScore > 21 || pScore > dScore) {
            winner = "You";
        }
       
        message.setText(winner + " Win");
    }

    @Override
    public void start(Stage one) throws Exception {
    	one.setScene(new Scene(makeGame()));
    	one.setWidth(900);
    	one.setHeight(640);
    	one.setResizable(false);
    	one.setTitle("BlackJack -- Courtesy of Group 10 (ASU SER215)");
    	one.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}