package org.cheeberts.model.spells.buffSpells;

import org.cheeberts.model.creatures.Creature;

public class MonstrousRage extends BuffSpell {

    public MonstrousRage() {
        this.manaCost = 1;
    }

    @Override
    public void buffCreature(Creature toBuff) {
        toBuff.hasMonsterRole = true;
        toBuff.oneTurnBuffs += 2;
    }

    @Override
    public MonstrousRage deepCopy() {
        return new MonstrousRage();
    }
}
