package driver;

public interface Console {
    // ANSI colors from https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    static enum Color {
        RESET("\u001B[0m", "\u001B[0m"),
        BLACK("\u001B[30m", "\033[40m"),
        RED("\u001B[31m", "\u001B[41m"),
        GREEN("\u001B[32m", "\u001B[42m"),
        YELLOW("\u001B[33m", "\u001B[43m"),
        BLUE("\u001B[34m", "\u001B[44m"),
        PURPLE("\u001B[35m", "\u001B[45m"),
        CYAN("\u001B[36m", "\u001B[46m"),
        WHITE("\u001B[37m", "\u001B[47m");

        final String textColor;
        final String backgroundColor;

        private Color(String textColor, String backgroundColor) {
            this.textColor = textColor;
            this.backgroundColor = backgroundColor;
        }
    }
}
