import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetApp {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<String>();
        System.out.println("Create and Print TreeSet");
        ts.add("Verde"); ts.add("Amarelo"); ts.add("Azul"); ts.add("Branco");
        System.out.println(ts);

        System.out.println("\nIterate TreeSet Elements");
        for (String s : ts) System.out.println(s);

        System.out.println("\nAdd Elements to Another TreeSet");
        TreeSet<String> other = new TreeSet<String>(ts);
        System.out.println(other);

        System.out.println("\nReverse Order TreeSet");
        System.out.println(ts.descendingSet());

        System.out.println("\nGet First and Last Elements");
        System.out.println(ts.first() + " , " + ts.last());

        System.out.println("\nClone TreeSet");
        TreeSet<String> cloned = (TreeSet<String>) ts.clone();
        System.out.println(cloned);

        System.out.println("\nTreeSet Size");
        System.out.println(ts.size());

        System.out.println("\nCompare TreeSets");
        System.out.println(ts.equals(cloned));

        System.out.println("\nElements Less Than 7 (numbers)");
        TreeSet<Integer> nums = new TreeSet<Integer>(java.util.Arrays.asList(2,4,6,8));
        System.out.println(nums.headSet(7));

        System.out.println("\nCeiling/Floor/Higher/Lower (numbers example)");
        System.out.println(nums.ceiling(5));
        System.out.println(nums.floor(5));
        System.out.println(nums.higher(4));
        System.out.println(nums.lower(4));

        System.out.println("\nPoll First Element");
        System.out.println(nums.pollFirst());
        System.out.println(nums);

        System.out.println("\nPoll Last Element");
        System.out.println(nums.pollLast());
        System.out.println(nums);

        System.out.println("\nRemove Element ('Azul')");
        ts.remove("Azul");
        System.out.println(ts);
    }
}
