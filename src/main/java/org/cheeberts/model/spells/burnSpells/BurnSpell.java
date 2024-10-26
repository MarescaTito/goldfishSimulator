package org.cheeberts.model.spells.burnSpells;

import org.cheeberts.model.creatures.Creature;
import org.cheeberts.model.GameState;
import org.cheeberts.model.spells.Spell;

import java.util.HashSet;
import java.util.Set;

public abstract class BurnSpell extends Spell {
    public int damage;

    @Override
    public Set<GameState> getMutatedGameStates(GameState gameState) {
        Set<GameState> toReturn = new HashSet<>();
        GameState paid = new GameState(gameState);

        paid.lifetotal -= damage;
        for(Creature c : paid.creatures) {
            c.respondToNonCreatureSpell();
        }
        toReturn.add(paid);

        return toReturn;
    }
}
