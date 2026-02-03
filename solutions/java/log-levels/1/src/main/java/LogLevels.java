public class LogLevels {
    
    public static String message(String logLine) {
        return parse(logLine).message;
    }

    public static String logLevel(String logLine) {
        return parse(logLine).level.toLowerCase();
    }

    public static String reformat(String logLine) {
        ParsedLog parsed = parse(logLine);
        return parsed.message + " (" + parsed.level.toLowerCase() + ')';
    }

     private enum State {
        START,
        LEVEL,
        AFTER_LEVEL,
        MESSAGE
    }

     private static ParsedLog parse(String logLine) {
        if (logLine == null) {
            throw new IllegalArgumentException("logLine must not be null");
        }

        StringBuilder level = new StringBuilder();
        StringBuilder message = new StringBuilder();

        State state = State.START;

        for (int i = 0; i < logLine.length(); i++) {
            char c = logLine.charAt(i);

            switch (state) {

                case START:
                    if (c != '[') {
                        throw new IllegalArgumentException("Expected '[' at start");
                    }
                    state = State.LEVEL;
                    break;

                case LEVEL:
                    if (c == ']') {
                        state = State.AFTER_LEVEL;
                    } else {
                        level.append(c);
                    }
                    break;

                case AFTER_LEVEL:
                    if (c == ':') {
                        state = State.MESSAGE;
                    }
                    break;

                case MESSAGE:
                    message.append(c);
                    break;
            }
        }

        if (state != State.MESSAGE) {
            throw new IllegalArgumentException("Incomplete log line: " + logLine);
        }

        return new ParsedLog(
            level.toString().trim(),
            message.toString().trim()
        );
    }
    
    private static final class ParsedLog {
        private final String level;
        private final String message;

        private ParsedLog(String level, String message) {
            this.level = level;
            this.message = message;
        }
    }
}
