package org.cheeberts.util;


import org.cheeberts.model.GameState;

import java.util.*;

//This class serves to filter out game states that are the same except for identical like totals
public class LifeTotalFilter {
    public static Set<GameState> lifeTotalFilter(Collection<GameState> gameStates) {
        HashMap<GameState, Integer> stateToTotal = new HashMap<>();

        for(GameState g : gameStates) {
            //A key is a game state with its life set to 100, so they will all be the same
            //We map this to the lowest life total we have seen for a given game state
            GameState key = new GameState(g);
            key.lifetotal=100;

            if(!stateToTotal.containsKey(key) || stateToTotal.get(key) > g.lifetotal) {
                stateToTotal.put(key, g.lifetotal);
            }
        }

        HashSet<GameState> toReturn = new HashSet<>();
        for(Map.Entry<GameState, Integer> e : stateToTotal.entrySet()) {
            GameState toAdd = new GameState(e.getKey());
            toAdd.lifetotal = e.getValue();
            toReturn.add(toAdd);
        }

        return toReturn;
    }
}
