package org.cheeberts.model.Spells.NonCreaturePermanents;

import org.cheeberts.model.Creatures.Creature;
import org.cheeberts.model.GameState;
import org.cheeberts.model.Spells.Spell;

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
        GameState paid = getGameStateWithPaidCosts(gameState);

        if(paid != null) {
            for(Creature c : paid.creatures) {
                c.respondToNonCreatureSpell();
            }
            paid.leylines+=1;
            toReturn.add(paid);
        }

        return toReturn;
    }
}
