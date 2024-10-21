package org.cheeberts.model.Spells.BuffSpells;

import org.cheeberts.model.Creatures.Creature;

public class MonstrousRage extends BuffSpell {

    public MonstrousRage() {
        this.manaCost = 1;
    }

    @Override
    public void buffCreature(Creature toBuff) {
        toBuff.hasMonsterRole = true;
        toBuff.oneTurnBuffs += 2;
        toBuff.respondToTarget();
    }
}
