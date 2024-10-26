package org.cheeberts.model.spells.creatureSpells;

import org.cheeberts.model.creatures.CacophonyScamp;
import org.cheeberts.model.creatures.Creature;

public class CacophonyScampSpell extends CreatureSpell {

    @Override
    public CacophonyScampSpell deepCopy() {
        return new CacophonyScampSpell();
    }

    public CacophonyScampSpell() {
        this.manaCost = 1;
    }

    @Override
    public Creature summonCreature() {
        return new CacophonyScamp();
    }
}
