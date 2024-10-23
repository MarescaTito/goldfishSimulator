package org.cheeberts.model.Spells.CreatureSpells;

import org.cheeberts.model.Creatures.Creature;
import org.cheeberts.model.GameState;
import org.cheeberts.model.Spells.Spell;

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
