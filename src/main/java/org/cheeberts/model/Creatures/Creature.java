package org.cheeberts.model.Creatures;

public abstract class Creature {
    public int basePower;
    public boolean haste;
    public int oneTurnBuffs;
    public int plusOneCounters;
    public int bearsToProduce;
    public boolean hasMonsterRole;
    public boolean enteredThisTurn;
    public boolean valiantTriggeredThisTurn;
    public String creatureName;

    public Creature() {
        enteredThisTurn = true;
        creatureName = this.getClass().toString();
    }

    public Creature(Creature c) {
        this.basePower = c.basePower;
        this.haste = c.haste;
        this.oneTurnBuffs = c.oneTurnBuffs;
        this.plusOneCounters = c.plusOneCounters;
        this.bearsToProduce = c.bearsToProduce;
        this.hasMonsterRole = c.hasMonsterRole;
        this.enteredThisTurn = c.enteredThisTurn;
        this.valiantTriggeredThisTurn = c.valiantTriggeredThisTurn;
        this.creatureName = c.creatureName;
    }

    public abstract void respondToNonCreatureSpell();
    public abstract void respondToTarget();
    public abstract Creature deepCopy();

    public void cleanup() {
        bearsToProduce = 0;
        enteredThisTurn = false;
        valiantTriggeredThisTurn = false;
        oneTurnBuffs = 0;
    }

    public int getTotalPower() {
        return basePower + oneTurnBuffs + plusOneCounters + (hasMonsterRole ? 1 : 0);
    }
}
