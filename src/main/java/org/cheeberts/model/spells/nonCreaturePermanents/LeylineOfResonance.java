package org.cheeberts.model.spells.nonCreaturePermanents;

import org.cheeberts.model.creatures.Creature;
import org.cheeberts.model.GameState;
import org.cheeberts.model.spells.Spell;

import java.util.HashSet;
import java.util.Set;

public class LeylineOfResonance extends Spell {
    public LeylineOfResonance() {
        this.manaCost = 4;
    }

    public LeylineOfResonance deepCopy() {
        return new LeylineOfResonance();
    }

    @Override
    public Set<GameState> getMutatedGameStates(GameState gameState) {
        Set<GameState> toReturn = new HashSet<>();
        GameState paid = new GameState(gameState);

        for (Creature c : paid.creatures) {
            c.respondToNonCreatureSpell();
        }
        paid.leylines+=1;
        toReturn.add(paid);

        return toReturn;
    }
}
