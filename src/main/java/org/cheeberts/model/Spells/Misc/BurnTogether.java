package org.cheeberts.model.Spells.Misc;

import org.cheeberts.model.Creatures.Bear;
import org.cheeberts.model.Creatures.CacophonyScamp;
import org.cheeberts.model.Creatures.Creature;
import org.cheeberts.model.Creatures.HeartfireHero;
import org.cheeberts.model.GameState;
import org.cheeberts.model.Spells.Spell;

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
            toFling.respondToTarget();

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
