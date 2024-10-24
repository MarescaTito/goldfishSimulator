package org.cheeberts.service;

import org.cheeberts.model.Card;
import org.cheeberts.model.GameState;
import org.cheeberts.model.Spells.BuffSpells.BuffSpell;
import org.cheeberts.model.Spells.CreatureSpells.CreatureSpell;
import org.cheeberts.model.Spells.Misc.BurnTogether;
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

            //Main Phase 1
            while(!frontier.isEmpty()) {
                GameState popped = frontier.removeLast();
                if(popped.lifetotal <= 0) {
                    return popped.turn;
                }
                if(seen.contains(popped)) {
                    continue;
                }
                seen.add(popped);
                frontier.addAll(playEachSpell(popped));
            }

            //Attack
            Set<GameState> attacked = new HashSet<>();
            for(GameState g : seen) {
                Set<GameState> toAdd = g.attack();
                for(GameState a : toAdd) {
                    if(a.lifetotal <= 0) {
                        return a.turn;
                    }
                }
                attacked.addAll(toAdd);
            }
            frontier = new LinkedList<>(attacked);
            seen = new HashSet<>();

            //Main Phase 2
            while(!frontier.isEmpty()) {
                GameState popped = frontier.removeLast();
                if(popped.lifetotal <= 0) {
                    return popped.turn;
                }
                if(seen.contains(popped)) {
                    continue;
                }
                seen.add(popped);
                frontier.addAll(onlyPlayFling(popped));
            }

            frontier = new LinkedList<>(seen.stream().filter(g -> !isEndStateSilly(g)).toList());
        }
    }

    private static Set<GameState> playEachSpell(GameState gameState) {
        Set<GameState> toReturn = new HashSet<>();

        for(int i = 0;  i<gameState.hand.size(); i++) {
            Set<GameState> toAdd = new HashSet<>();
            Spell toPlay = gameState.hand.get(i).spell;
            if(toPlay != null && toPlay.manaCost <= gameState.untappedLands) {
                GameState playedCard = new GameState(gameState);
                playedCard.hand.remove(i);
                playedCard = playedCard.getGameStateWithPaidCosts(playedCard, toPlay.manaCost);

                toAdd.addAll(toPlay.getMutatedGameStates(playedCard));

                if(toPlay instanceof BuffSpell || toPlay instanceof MightOfTheMeek) {
                    Spell freeSpell = toPlay.deepCopy();
                    freeSpell.manaCost = 0;

                    for (int j = 0; j < playedCard.leylines; j++) {
                        Set<GameState> temp = new HashSet<>();
                        for (GameState g : toAdd) {
                            temp.addAll(freeSpell.getMutatedGameStates(g));
                        }
                        toAdd = temp;
                    }
                }
            }
            toReturn.addAll(toAdd);
        }

        return toReturn;
    }

    private static Set<GameState> onlyPlayFling(GameState gameState) {
        Set<GameState> toReturn = new HashSet<>();

        for(int i = 0;  i<gameState.hand.size(); i++) {
            Set<GameState> toAdd = new HashSet<>();
            Spell toPlay = gameState.hand.get(i).spell;
            if(toPlay != null && toPlay instanceof BurnTogether && toPlay.manaCost <= gameState.untappedLands) {
                GameState playedCard = new GameState(gameState);
                playedCard.hand.remove(i);
                playedCard = playedCard.getGameStateWithPaidCosts(playedCard, toPlay.manaCost);

                toAdd.addAll(toPlay.getMutatedGameStates(playedCard));
            }
            toReturn.addAll(toAdd);
        }

        return toReturn;
    }

    //If we have enough untapped lands to play a creature in our hand we shouldn't end the turn before playing it
    private static boolean isEndStateSilly(GameState gameState) {
        for(Card c : gameState.hand) {
            if(c.spell instanceof CreatureSpell && c.spell.manaCost <= gameState.untappedLands) {
                return true;
            }
        }

        return false;
    }
}


