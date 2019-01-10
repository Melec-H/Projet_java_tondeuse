package Game.Tools;

public class Parameters {

    public static enum Orientation {
        NORD("N", "Nord"),
        SUD("S", "Sud"),
        OUEST("O", "Ouest"),
        EST("E", "Est");

        private String lettreOrientation;
        private String intituleOrientation;

        Orientation(String e, String est) {
            this.lettreOrientation = e;
            this.intituleOrientation = est;

        }

        public String getLettreOrientation() {
            return lettreOrientation;
        }

        public String getIntituleOrientation() {
            return intituleOrientation;
        }
    }

    public static enum InstructionTondeuse {
        DROITE("D", "Pivoter à droite"),
        GAUCHE("G", "Pivoter à gauche"),
        AVANCER("A", "Avancer");

        private String lettreInstruction;
        private String intituleInstruction;

        InstructionTondeuse(String e, String est) {
            this.lettreInstruction = e;
            this.intituleInstruction = est;
        }

        public String getLettreInstruction() {
            return lettreInstruction;
        }

        public String getIntituleInstruction() {
            return intituleInstruction;
        }
    }

}
