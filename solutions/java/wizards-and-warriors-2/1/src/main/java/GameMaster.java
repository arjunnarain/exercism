public class GameMaster {

    public String describe(Character character) {
        return String.format(
            "You're a level %d %s with %d hit points.",
            character.getLevel(),
            character.getCharacterClass(),
            character.getHitPoints()
        );
    }

    public String describe(Destination destination) {
        return String.format(
            "You've arrived at %s, which has %d inhabitants.",
            destination.getName(),
            destination.getInhabitants()
        );
    }

    public String describe(TravelMethod method) {
        switch (method) {
            case HORSEBACK:
                return "You're traveling to your destination on horseback.";
            case WALKING:
                return "You're traveling to your destination by walking.";
            default:
                throw new IllegalArgumentException("Unknown travel method");
        }
    }

    public String describe(Character character, Destination destination) {
        return describe(character) + " " + describe(TravelMethod.WALKING) + " " + describe(destination);
    }

    public String describe(Character character, Destination destination, TravelMethod method) {
        return describe(character) + " " + describe(method) + " " + describe(destination);
    }
}
