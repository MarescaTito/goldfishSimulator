package org.cheeberts.model.Spells.BuffSpells;

import org.cheeberts.model.Creatures.Creature;
import org.cheeberts.model.GameState;
import org.cheeberts.model.Spells.Spell;

import java.util.HashSet;
import java.util.Set;

public abstract class BuffSpell extends Spell {
    public abstract void buffCreature(Creature toBuff);

    @Override
    public Set<GameState> getMutatedGameStates(GameState gameState) {
        Set<GameState> toReturn = new HashSet<>();
        GameState paid = getGameStateWithPaidCosts(gameState);

        if(paid != null) {
            for(int i = 0; i < paid.creatures.size(); i++) {
                GameState toAdd = new GameState(paid);
                buffCreature(toAdd.creatures.get(i));
                for(Creature c : toAdd.creatures) {
                    c.respondToNonCreatureSpell();
                }
                toReturn.add(toAdd);
            }
        }

        return toReturn;
    }
}
