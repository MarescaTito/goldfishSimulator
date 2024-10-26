package org.cheeberts.model.spells.creatureSpells;

import org.cheeberts.model.creatures.Creature;
import org.cheeberts.model.creatures.MonasterySwiftspear;

public class MonasterySwiftspearSpell extends CreatureSpell {

    public MonasterySwiftspearSpell() {
        this.manaCost = 1;
    }

    @Override
    public Creature summonCreature() {
        return new MonasterySwiftspear();
    }

    @Override
    public MonasterySwiftspearSpell deepCopy() {
        return new MonasterySwiftspearSpell();
    }
}
