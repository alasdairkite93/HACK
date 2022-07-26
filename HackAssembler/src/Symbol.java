import java.util.HashMap;

public class Symbol {

    private HashMap<String, Integer> table = new HashMap<>();

    public Symbol(){
        table.put("SCREEN", 16384);
        table.put("KBD", 24576);
        table.put("OUTPUT_FIRST", 10);
        table.put("OUTPUT_D", 12);
        table.put("INFINITE_LOOP", 14);
    }

    public void addEntry(String symbol, int address){
        table.put(symbol, address);
        address++;
    }

    public boolean contains(String symbol){
        if (table.containsKey(symbol)) {
            return true;
        }
        else return false;
    }

    public String returnAddress(String symbol){
        int address = table.get(symbol);
        String addressreturn = String.valueOf(address);
        return addressreturn;
    }

}
