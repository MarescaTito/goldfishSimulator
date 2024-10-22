package org.cheeberts.model.Spells.BuffSpells;

import org.cheeberts.model.Creatures.Creature;

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

    @Override
    public FeloniousRage deepCopy() {
        return new FeloniousRage();
    }
}
