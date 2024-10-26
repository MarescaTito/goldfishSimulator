package org.cheeberts.model.spells.creatureSpells;

import org.cheeberts.model.creatures.Creature;
import org.cheeberts.model.creatures.HeartfireHero;

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
