package org.cheeberts.model.Spells;

import org.cheeberts.model.GameState;

import java.util.Set;

public abstract class Spell {
    public int manaCost;

    public abstract Set<GameState> getMutatedGameStates(GameState gameState);
    public abstract Spell deepCopy();
}
