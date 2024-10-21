package org.cheeberts.model.Spells.CreatureSpells;

import org.cheeberts.model.Creatures.Creature;
import org.cheeberts.model.Creatures.SlickshotShowoff;

public class SlickshotShowoffSpell extends CreatureSpell {

    public SlickshotShowoffSpell() {
        this.manaCost = 2;
    }

    @Override
    public Creature summonCreature() {
        return new SlickshotShowoff();
    }
}
