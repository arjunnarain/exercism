class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder output = new StringBuilder();
        boolean makeNextUpperCase = false;

        for (char ch : identifier.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                output.append('_');
            }

            if (ch == '-') {
                makeNextUpperCase = true;
                continue;
            }

             ch = switch (ch) {
                case '4' -> 'a';
                case '3' -> 'e';
                case '0' -> 'o';
                case '1' -> 'l';
                case '7' -> 't';
                default -> ch;
            };

            
            if (Character.isLetter(ch) || ch == '_') {
                if (makeNextUpperCase) {
                    output.append(Character.toUpperCase(ch));
                    makeNextUpperCase = false;
                } else {
                    output.append(ch);
                }
            }
        }
        
        return output.toString();
    }
}
