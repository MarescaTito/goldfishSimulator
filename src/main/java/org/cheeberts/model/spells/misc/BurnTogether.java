package org.cheeberts.model.spells.misc;

import org.cheeberts.model.creatures.Bear;
import org.cheeberts.model.creatures.CacophonyScamp;
import org.cheeberts.model.creatures.Creature;
import org.cheeberts.model.creatures.HeartfireHero;
import org.cheeberts.model.GameState;
import org.cheeberts.model.spells.Spell;

import java.util.HashSet;
import java.util.Set;

//TODO ACTUALLY MAKE AN ADVENTURE
public class BurnTogether extends Spell {
    public BurnTogether() {
        this.manaCost = 1;
    }

    public BurnTogether deepCopy() {
        return new BurnTogether();
    }

    @Override
    public Set<GameState> getMutatedGameStates(GameState gameState) {
        Set<GameState> toReturn = new HashSet<>();
        GameState paid = new GameState(gameState);

        for(int i = 0; i < paid.creatures.size(); i++) {
            GameState toAdd = new GameState(paid);
            for(Creature c : toAdd.creatures) {
                c.respondToNonCreatureSpell();
            }

            Creature toFling = toAdd.creatures.get(i);
            toFling.respondToTarget(toAdd);

            if(toFling instanceof CacophonyScamp || toFling instanceof HeartfireHero) {
                toAdd.lifetotal -= 2 * toFling.getTotalPower();
            } else {
                toAdd.lifetotal -= toFling.getTotalPower();
            }

            toAdd.creatures.remove(toFling);
            for(int j = 0; j < toFling.bearsToProduce; j++) {
                toAdd.creatures.add(new Bear());
            }

            toReturn.add(toAdd);
        }

        return toReturn;
    }
}
