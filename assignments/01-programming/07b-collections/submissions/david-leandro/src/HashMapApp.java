import java.util.HashMap;
import java.util.Map;

public class HashMapApp {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        System.out.println("Associate Key with Value");
        map.put(1, "Azul"); map.put(2, "Verde"); map.put(3, "Amarelo");
        System.out.println(map);

        System.out.println("\nCount Key-Value Mappings");
        System.out.println(map.size());

        System.out.println("\nCopy Mappings to Another Map");
        Map<Integer,String> copy = new HashMap<Integer,String>(map);
        System.out.println(copy);

        System.out.println("\nRemove All Mappings");
        map.clear();
        System.out.println(map);

        System.out.println("\nCheck If Map is Empty");
        System.out.println(map.isEmpty());

        System.out.println("\nGet Shallow Copy");
        System.out.println(copy);

        System.out.println("\nCheck If Key Exists (2)");
        System.out.println(copy.containsKey(2));

        System.out.println("\nCheck If Value Exists ('Azul')");
        System.out.println(copy.containsValue("Azul"));

        System.out.println("\nGet Entry Set View");
        System.out.println(copy.entrySet());

        System.out.println("\nGet Value by Key (1)");
        System.out.println(copy.get(1));

        System.out.println("\nGet Key Set");
        System.out.println(copy.keySet());

        System.out.println("\nGet Values Collection");
        System.out.println(copy.values());
    }
}
