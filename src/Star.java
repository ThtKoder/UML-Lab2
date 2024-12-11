public class Star {
    private String actorName;
    private String characterPlayed;

    public Star(String actorName, String characterPlayed) {
        this.actorName = actorName;
        this.characterPlayed = characterPlayed;
    }

    public String getActorName() {
        return actorName;
    }
    public String getCharacterPlayed() {
        return characterPlayed;
    }

    @Override
    public String toString() {
        return "\nStar: " +
                "actorName = " + actorName + '\'' +
                ", characterPlayed = " + characterPlayed + '\'';
    }
}
