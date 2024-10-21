package org.cheeberts.service;

import org.cheeberts.model.Card;
import org.cheeberts.model.GameState;

import java.util.*;

//TODO: IMPLEMENT LEYLINE
public class GoldfishSimulator {
    List<Card> deck;

    public GoldfishSimulator(List<Card> deck) {
        this.deck = deck;
    }

    public int turnsToWin() {
        List<Card> currDeck = new LinkedList<Card>(deck);
        Collections.shuffle(currDeck);

        GameState startingState = new GameState(currDeck);
        List<GameState> frontier = new LinkedList<>();

        frontier.add(startingState);

        while(true) {
            Set<GameState> seen = new HashSet<>();
            for(GameState s : frontier) {
                s.startTurn();
            }

            while(!frontier.isEmpty()) {
                GameState popped = frontier.removeLast();
                if(popped.lifetotal < 0) {
                    return popped.turn;
                }
                if(seen.contains(popped)) {
                    continue;
                }
                seen.add(popped);

                Set<GameState> toAdd = new HashSet<>();

                if(!popped.attacked) {
                    toAdd.addAll(popped.attack());
                }

                for(int i = 0;  i<popped.hand.size(); i++) {
                    if(popped.hand.get(i).spell != null) {
                        GameState playedCard = new GameState(popped);
                        playedCard.hand.remove(i);
                        toAdd.addAll(popped.hand.get(i).spell.getMutatedGameStates(playedCard));
                    }
                }

                frontier.addAll(toAdd);
            }

            frontier = new LinkedList<>(seen);
        }
    }
}
