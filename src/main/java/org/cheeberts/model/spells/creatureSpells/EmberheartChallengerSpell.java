package org.cheeberts.model.spells.creatureSpells;

import org.cheeberts.model.creatures.Creature;
import org.cheeberts.model.creatures.EmberheartChallenger;

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
