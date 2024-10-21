package org.cheeberts.model.Spells.BuffSpells;

import org.cheeberts.model.Creatures.Creature;
import org.cheeberts.model.GameState;

import java.util.HashSet;
import java.util.Set;

public class FeloniousRage extends BuffSpell {

    public FeloniousRage() {
        this.manaCost = 1;
    }

    @Override
    public void buffCreature(Creature toBuff) {
        toBuff.haste = true;
        toBuff.oneTurnBuffs += 2;
        toBuff.bearsToProduce++;
        toBuff.respondToTarget();
    }
}
