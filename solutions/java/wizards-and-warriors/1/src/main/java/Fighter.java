class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter {

    @Override
    boolean isVulnerable() {
        return false;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        if(fighter.isVulnerable()) {
            return 10;
        }

        return 6;
    }

    public String toString() {
        return "Fighter is a Warrior";
    }
}

class Wizard extends Fighter {
    private boolean isSpellReady = false;
    
    public String toString() {
        return "Fighter is a Wizard";
    }

    void prepareSpell() {
        isSpellReady = true;
    }

    @Override
    boolean isVulnerable() {
        return !isSpellReady;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        if(isSpellReady) {
            return 12;
        }

        return 3;
    }
}