package org.cheeberts.spells;

import org.cheeberts.model.spells.burnSpells.BurnSpell;

public class TwentyDamageForOneMana extends BurnSpell {
    public TwentyDamageForOneMana() {
        this.damage = 20;
        this.manaCost = 1;
    }

    @Override
    public TwentyDamageForOneMana deepCopy() {
        return new TwentyDamageForOneMana();
    }
}
