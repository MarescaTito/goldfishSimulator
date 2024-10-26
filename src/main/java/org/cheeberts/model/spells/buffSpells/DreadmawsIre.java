package org.cheeberts.model.spells.buffSpells;

import org.cheeberts.model.creatures.Creature;

public class DreadmawsIre extends BuffSpell {

    public DreadmawsIre() {
        this.manaCost = 1;
    }

    @Override
    public void buffCreature(Creature toBuff) {
        toBuff.oneTurnBuffs += 2;
    }

    @Override
    public DreadmawsIre deepCopy() {
        return new DreadmawsIre();
    }
}
