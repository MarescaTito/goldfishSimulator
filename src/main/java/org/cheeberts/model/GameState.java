package org.cheeberts.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cheeberts.model.Creatures.Creature;
import org.cheeberts.model.Spells.NonCreaturePermanents.LeylineOfResonance;
import org.cheeberts.util.CardComparator;
import org.cheeberts.util.CreatureComparator;

import java.util.*;

public class GameState {
    public int turn;
    public int lifetotal;
    public int leylines;
    public int untappedLands;
    public int tappedLands;
    public boolean playedLandForTurn;
    public boolean attacked;
    public List<Creature> creatures;
    public List<Card> hand;
    public List<Card> deck;

    public GameState(List<Card> deck) {
        turn = 0;
        lifetotal=20;
        leylines=0;
        untappedLands=0;
        tappedLands=0;
        playedLandForTurn=false;
        attacked=false;
        this.deck = new LinkedList<>(deck);
        hand = new LinkedList<>();
        creatures = new ArrayList<>();

        //We start on turn 0 so we are only drawing 6
        for(int i = 0; i < 6; i++) {
            Card toAdd = this.deck.removeLast();
            if(toAdd.spell instanceof LeylineOfResonance) {
                leylines+=1;
            } else {
                hand.add(toAdd);
            }
        }
    }

    public GameState(GameState gameState) {
        this.turn = gameState.turn;
        this.lifetotal = gameState.lifetotal;
        this.leylines = gameState.leylines;
        this.untappedLands = gameState.untappedLands;
        this.tappedLands = gameState.tappedLands;
        this.playedLandForTurn = gameState.playedLandForTurn;
        this.attacked = gameState.attacked;
        this.creatures = new ArrayList<>();
        for(Creature c : gameState.creatures) {
            creatures.add(c.deepCopy());
        }
        this.deck = new LinkedList<>(gameState.deck);
        this.hand = new LinkedList<>(gameState.hand);
    }

    public void startTurn() {
        turn+=1;
        untappedLands = untappedLands + tappedLands;
        tappedLands = 0;
        playedLandForTurn = false;
        attacked = false;

        hand.add(deck.removeLast());

        for(Card c : hand) {
            if(c.spell == null) {
                hand.remove(c);
                playedLandForTurn=true;
                untappedLands++;
                break;
            }
        }

        for(Creature c : creatures) {
            c.cleanup();
        }
    }


    public Set<GameState> attack() {
        HashSet<GameState> toReturn = new HashSet<>();
        GameState g = new GameState(this);
        g.attacked = true;

        for(Creature c : g.creatures) {
            if(!c.enteredThisTurn || c.haste) {
                g.lifetotal -= c.getTotalPower();
            }
        }

        toReturn.add(g);

        return toReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GameState)) {
            return false;
        }

        return o.toString().equals(this.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        creatures.sort(new CreatureComparator());
        hand.sort(new CardComparator());

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
