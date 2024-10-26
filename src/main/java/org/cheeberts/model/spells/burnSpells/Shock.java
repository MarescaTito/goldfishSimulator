package org.cheeberts.model.spells.burnSpells;

public class Shock extends BurnSpell {
    public Shock() {
        this.damage = 2;
        this.manaCost = 1;
    }

    @Override
    public Shock deepCopy() {
        return new Shock();
    }
}
