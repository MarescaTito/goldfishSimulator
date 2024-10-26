package org.cheeberts.model.spells.creatureSpells;

import org.cheeberts.model.creatures.Creature;
import org.cheeberts.model.GameState;
import org.cheeberts.model.spells.Spell;

import java.util.HashSet;
import java.util.Set;

public abstract class CreatureSpell extends Spell {
    public abstract Creature summonCreature();

    @Override
    public Set<GameState> getMutatedGameStates(GameState gameState) {
        Set<GameState> toReturn = new HashSet<>();
        GameState paid = new GameState(gameState);

        paid.creatures.add(summonCreature());
        toReturn.add(paid);

        return toReturn;
    }
}
