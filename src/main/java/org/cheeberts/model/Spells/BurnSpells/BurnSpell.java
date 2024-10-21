package org.cheeberts.model.Spells.BurnSpells;

import org.cheeberts.model.Creatures.Creature;
import org.cheeberts.model.GameState;
import org.cheeberts.model.Spells.Spell;

import java.util.HashSet;
import java.util.Set;

public abstract class BurnSpell extends Spell {
    public int damage;

    @Override
    public Set<GameState> getMutatedGameStates(GameState gameState) {
        Set<GameState> toReturn = new HashSet<>();
        GameState paid = getGameStateWithPaidCosts(gameState);

        if(paid != null) {
            paid.lifetotal -= damage;
            for(Creature c : paid.creatures) {
                c.respondToNonCreatureSpell();
            }
            toReturn.add(paid);
        }

        return toReturn;
    }
}
