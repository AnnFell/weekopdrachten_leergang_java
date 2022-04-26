package nl.duo.weekopdrachten.week01.miniweekopdrachten.opdr7;

public enum Ansi {
    ANSI_RESET("\u001B[0m"),
    ANSI_BLACK("\u001B[30m"),
    ANSI_RED("\u001B[31m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_BLUE("\u001B[34m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_CYAN("\u001B[36m"),
    ANSI_WHITE("\u001B[37m"),
    BG_YELLOW("\u001B[43m"),
    BG_PURPLE("\u001B[45m");

    final String colorString;

    Ansi(String color) {
        this.colorString = color;
    }
}
