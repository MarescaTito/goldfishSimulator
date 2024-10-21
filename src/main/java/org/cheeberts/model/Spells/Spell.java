package org.cheeberts.model.Spells;

import org.cheeberts.model.GameState;

import java.util.Set;

public abstract class Spell {
    public int manaCost;

    public abstract Set<GameState> getMutatedGameStates(GameState gameState);

    public GameState getGameStateWithPaidCosts(GameState gameState) {
        GameState toReturn = new GameState(gameState);

        if(toReturn.untappedLands >= manaCost) {
            toReturn.untappedLands -= manaCost;
            toReturn.tappedLands += manaCost;

            return toReturn;
        } else {
            return null;
        }
    }
}
