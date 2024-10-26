package org.cheeberts.model.spells.creatureSpells;

import org.cheeberts.model.creatures.Creature;
import org.cheeberts.model.creatures.SlickshotShowoff;

public class SlickshotShowoffSpell extends CreatureSpell {

    public SlickshotShowoffSpell() {
        this.manaCost = 2;
    }

    @Override
    public Creature summonCreature() {
        return new SlickshotShowoff();
    }

    @Override
    public SlickshotShowoffSpell deepCopy() {
        return new SlickshotShowoffSpell();
    }
}
