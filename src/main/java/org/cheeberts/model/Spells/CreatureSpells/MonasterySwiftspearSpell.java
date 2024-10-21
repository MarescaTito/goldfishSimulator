package org.cheeberts.model.Spells.CreatureSpells;

import org.cheeberts.model.Creatures.Creature;
import org.cheeberts.model.Creatures.MonasterySwiftspear;

public class MonasterySwiftspearSpell extends CreatureSpell {

    public MonasterySwiftspearSpell() {
        this.manaCost = 1;
    }

    @Override
    public Creature summonCreature() {
        return new MonasterySwiftspear();
    }
}
