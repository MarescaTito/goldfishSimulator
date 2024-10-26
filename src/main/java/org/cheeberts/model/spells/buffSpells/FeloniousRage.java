package org.cheeberts.model.spells.buffSpells;

import org.cheeberts.model.creatures.Creature;

public class FeloniousRage extends BuffSpell {

    public FeloniousRage() {
        this.manaCost = 1;
    }

    @Override
    public void buffCreature(Creature toBuff) {
        toBuff.haste = true;
        toBuff.oneTurnBuffs += 2;
        toBuff.bearsToProduce++;
    }

    @Override
    public FeloniousRage deepCopy() {
        return new FeloniousRage();
    }
}
