import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapApp {
    public static void main(String[] args) {
        TreeMap<Integer,String> tm = new TreeMap<Integer,String>();
        System.out.println("Associate Value with Key");
        tm.put(3, "Azul"); tm.put(1, "Verde"); tm.put(2, "Amarelo");
        System.out.println(tm);

        System.out.println("\nCopy TreeMap");
        TreeMap<Integer,String> copy = new TreeMap<Integer,String>(tm);
        System.out.println(copy);

        System.out.println("\nSearch Key (2)");
        System.out.println(tm.containsKey(2));

        System.out.println("\nSearch Value ('Azul')");
        System.out.println(tm.containsValue("Azul"));

        System.out.println("\nGet All Keys");
        System.out.println(tm.keySet());

        System.out.println("\nClear TreeMap");
        TreeMap<Integer,String> temp = new TreeMap<Integer,String>(tm);
        tm.clear();
        System.out.println(tm);

        System.out.println("\nSort Keys with Comparator (reverse)");
        TreeMap<Integer,String> reversed = new TreeMap<Integer,String>(Comparator.reverseOrder());
        reversed.putAll(temp);
        System.out.println(reversed.keySet());

        System.out.println("\nGreatest and Least Mapping");
        System.out.println(temp.lastEntry() + " , " + temp.firstEntry());

        System.out.println("\nGet First and Last Key");
        System.out.println(temp.firstKey() + " , " + temp.lastKey());

        System.out.println("\nReverse Key View");
        System.out.println(temp.descendingKeySet());

        System.out.println("\nFloor/Higher/Lower Examples");
        System.out.println(temp.floorEntry(2));
        System.out.println(temp.higherKey(1));
        System.out.println(temp.lowerEntry(2));

        System.out.println("\nNavigableSet View");
        System.out.println(temp.navigableKeySet());

        System.out.println("\nPoll First/Last Entry");
        System.out.println(temp.pollFirstEntry());
        System.out.println(temp.pollLastEntry());
        System.out.println(temp);

        System.out.println("\nSubMap and TailMap Examples");
        TreeMap<Integer,String> sample = new TreeMap<Integer,String>(java.util.Map.of(1,"A",2,"B",3,"C",4,"D"));
        System.out.println(sample.subMap(1,3));
        System.out.println(sample.tailMap(3));

        System.out.println("\nCeiling/CeilingKey");
        System.out.println(sample.ceilingEntry(2));
        System.out.println(sample.ceilingKey(2));
    }
}
