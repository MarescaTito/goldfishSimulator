package org.cheeberts.model.Spells.CreatureSpells;

import org.cheeberts.model.Creatures.Creature;
import org.cheeberts.model.Creatures.HeartfireHero;

public class HeartfireHeroSpell extends CreatureSpell {

    public HeartfireHeroSpell() {
        this.manaCost = 1;
    }

    @Override
    public Creature summonCreature() {
        return new HeartfireHero();
    }

    @Override
    public HeartfireHeroSpell deepCopy() {
        return new HeartfireHeroSpell();
    }
}
