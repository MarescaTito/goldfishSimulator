package org.cheeberts.model.spells.burnSpells;

public class LightningBolt extends BurnSpell {
    public LightningBolt() {
        this.damage = 3;
        this.manaCost = 1;
    }

    @Override
    public LightningBolt deepCopy() {
        return new LightningBolt();
    }
}
