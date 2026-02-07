import java.util.Map;
import java.util.HashMap;

public class DialingCodes {

    private Map<Integer, String> dialingCodes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return Map.copyOf(dialingCodes);
    }

    public void setDialingCode(Integer code, String country) {
        dialingCodes.put(code, country);
    }

    public String getCountry(Integer code) {
        return dialingCodes.getOrDefault(code, "");
    }

    public void addNewDialingCode(Integer code, String country) {
        if (!dialingCodes.containsValue(country) && !dialingCodes.containsKey(code)) {
            dialingCodes.put(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        for (Map.Entry<Integer, String> entry : dialingCodes.entrySet()) {
            if (entry.getValue().equals(country)) {
                return entry.getKey();
            }
        }
        return null;
    }
    
    public void updateCountryDialingCode(Integer code, String country) {
        Integer existingCode = findDialingCode(country);

        if (existingCode != null) {
            dialingCodes.remove(existingCode);
            dialingCodes.put(code, country);
        }
}
}
