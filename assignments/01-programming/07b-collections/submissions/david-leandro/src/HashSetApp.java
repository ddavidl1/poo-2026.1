import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetApp {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        System.out.println("Append Element to HashSet");
        set.add("Azul");
        set.add("Verde");
        set.add("Amarelo");
        System.out.println(set);

        System.out.println("\nIterate HashSet Elements");
        for (String s : set) System.out.println(s);

        System.out.println("\nGet HashSet Size");
        System.out.println(set.size());

        System.out.println("\nClone HashSet");
        @SuppressWarnings("unchecked")
        Set<String> cloned = (Set<String>) ((HashSet<String>) set).clone();
        System.out.println(cloned);

        System.out.println("\nConvert HashSet to Array");
        Object[] arr = set.toArray();
        for (Object o : arr) System.out.println(o);

        System.out.println("\nConvert HashSet to TreeSet");
        TreeSet<String> tree = new TreeSet<String>(set);
        System.out.println(tree);

        System.out.println("\nFind Elements Less Than 7 (TreeSet numbers)");
        TreeSet<Integer> nums = new TreeSet<Integer>(java.util.Arrays.asList(1,3,5,7,9));
        System.out.println(nums.headSet(7));

        System.out.println("\nCompare Two HashSets");
        Set<String> other = new HashSet<String>(java.util.Arrays.asList("Azul","Verde","Amarelo"));
        System.out.println(set.equals(other));

        System.out.println("\nRetain Common Elements");
        set.retainAll(java.util.Arrays.asList("Azul","X"));
        System.out.println(set);

        System.out.println("\nRemove All from HashSet");
        set.removeAll(new java.util.ArrayList<String>(set));
        System.out.println(set);

        System.out.println("\nCheck if HashSet is Empty");
        System.out.println(set.isEmpty());
    }
}
