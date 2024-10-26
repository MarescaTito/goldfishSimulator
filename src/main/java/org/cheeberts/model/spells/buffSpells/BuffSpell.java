package org.cheeberts.model.spells.buffSpells;

import org.cheeberts.model.creatures.Creature;
import org.cheeberts.model.GameState;
import org.cheeberts.model.spells.Spell;

import java.util.HashSet;
import java.util.Set;

public abstract class BuffSpell extends Spell {
    public abstract void buffCreature(Creature toBuff);

    @Override
    public Set<GameState> getMutatedGameStates(GameState gameState) {
        Set<GameState> toReturn = new HashSet<>();
        GameState paid = new GameState(gameState);

        for(int i = 0; i < paid.creatures.size(); i++) {
            GameState toAdd = new GameState(paid);
            buffCreature(toAdd.creatures.get(i));
            toAdd.creatures.get(i).respondToTarget(toAdd);
            for(Creature c : toAdd.creatures) {
                //We spoof leyline by "casting" a free version of the spell, will need to change if there is a free spell later
                if(this.manaCost != 0) {
                    c.respondToNonCreatureSpell();
                }
            }
            toReturn.add(toAdd);
        }


        return toReturn;
    }
}
