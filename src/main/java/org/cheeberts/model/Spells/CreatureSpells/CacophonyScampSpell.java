package org.cheeberts.model.Spells.CreatureSpells;

import org.cheeberts.model.Creatures.CacophonyScamp;
import org.cheeberts.model.Creatures.Creature;

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
