package org.cheeberts.service;

import org.cheeberts.model.Card;
import org.cheeberts.model.GameState;
import org.cheeberts.model.Spells.BuffSpells.BuffSpell;
import org.cheeberts.model.Spells.Misc.MightOfTheMeek;
import org.cheeberts.model.Spells.Spell;

import java.util.*;

//TODO: IMPLEMENT LEYLINE
public class GoldfishSimulator {
    public static int turnsToWin(List<Card> deck) {
        List<Card> currDeck = new LinkedList<>(deck);

        GameState startingState = new GameState(currDeck);
        List<GameState> frontier = new LinkedList<>();

        frontier.add(startingState);

        while(true) {
            Set<GameState> seen = new HashSet<>();
            frontier = new LinkedList<>(frontier.stream().filter(g -> !g.deck.isEmpty()).toList());
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
                toAdd.addAll(playEachSpell(popped));

                frontier.addAll(toAdd);
            }
            frontier = new LinkedList<>(seen);
        }
    }

    private static Set<GameState> playEachSpell(GameState gameState) {
        Set<GameState> toReturn = new HashSet<>();

        for(int i = 0;  i<gameState.hand.size(); i++) {
            Spell toPlay = gameState.hand.get(i).spell;
            if(toPlay != null) {
                GameState playedCard = new GameState(gameState);
                playedCard.hand.remove(i);

                toReturn.addAll(toPlay.getMutatedGameStates(playedCard));

                if(toPlay instanceof BuffSpell || toPlay instanceof MightOfTheMeek) {
                    Spell freeSpell = toPlay.deepCopy();
                    freeSpell.manaCost = 0;

                    for (int j = 0; j < playedCard.leylines; j++) {
                        Set<GameState> temp = new HashSet<>();
                        for (GameState g : toReturn) {
                            temp.addAll(freeSpell.getMutatedGameStates(g));
                        }
                        toReturn = temp;
                    }
                }
            }
        }

        return toReturn;
    }
}


