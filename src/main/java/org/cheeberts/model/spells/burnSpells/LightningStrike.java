package org.cheeberts.model.spells.burnSpells;

public class LightningStrike extends BurnSpell {
    public LightningStrike() {
        this.damage = 3;
        this.manaCost = 2;
    }

    @Override
    public LightningStrike deepCopy() {
        return new LightningStrike();
    }
}
