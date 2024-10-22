package org.cheeberts.model.Spells.CreatureSpells;

import org.cheeberts.model.Creatures.Creature;
import org.cheeberts.model.Creatures.EmberheartChallenger;

public class EmberheartChallengerSpell extends CreatureSpell {

    public EmberheartChallengerSpell() {
        this.manaCost = 2;
    }

    @Override
    public Creature summonCreature() {
        return new EmberheartChallenger();
    }

    @Override
    public EmberheartChallengerSpell deepCopy() {
        return new EmberheartChallengerSpell();
    }
}
