class LogLine {

    private final String logLine;

    LogLine(String logLine) {
        this.logLine = logLine;
    }

    LogLevel getLogLevel() {
        String code = logLine.substring(1, logLine.indexOf(']'));

        return switch (code) {
            case "TRC" -> LogLevel.TRACE;
            case "DBG" -> LogLevel.DEBUG;
            case "INF" -> LogLevel.INFO;
            case "WRN" -> LogLevel.WARNING;
            case "ERR" -> LogLevel.ERROR;
            case "FTL" -> LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        };
    }

    String getOutputForShortLog() {
        int encodedLevel = getLogLevel().getEncoded();
        String message = logLine.substring(logLine.indexOf(": ") + 2);

        return encodedLevel + ":" + message;
    }
}
