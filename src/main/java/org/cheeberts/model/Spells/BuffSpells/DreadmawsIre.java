package org.cheeberts.model.Spells.BuffSpells;

import org.cheeberts.model.Creatures.Creature;

public class DreadmawsIre extends BuffSpell {

    public DreadmawsIre() {
        this.manaCost = 1;
    }

    @Override
    public void buffCreature(Creature toBuff) {
        toBuff.oneTurnBuffs += 2;
        toBuff.respondToTarget();
    }

    @Override
    public DreadmawsIre deepCopy() {
        return new DreadmawsIre();
    }
}
