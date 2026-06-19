import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListApp {
    public static void main(String[] args) {
        System.out.println("Create and Print ArrayList");
        List<String> colors = new ArrayList<String>();
        colors.add("Verde");
        colors.add("Amarelo");
        colors.add("Azul");
        colors.add("Branco");
        System.out.println(colors);

        System.out.println("\nIterate ArrayList Elements");
        for (String c : colors) System.out.println(c);

        System.out.println("\nInsert at First Position");
        colors.add(0, "Vermelho");
        System.out.println(colors);

        System.out.println("\nRetrieve Element by Index (2)");
        if (colors.size() > 2) System.out.println(colors.get(2));

        System.out.println("\nUpdate ArrayList Element (replace index 2)");
        if (colors.size() > 2) {
            colors.set(2, "Roxo");
            System.out.println(colors.get(2));
        }

        System.out.println("\nRemove Third Element (index 2)");
        if (colors.size() > 2) colors.remove(2);
        System.out.println(colors);

        System.out.println("\nSearch Element in ArrayList (Azul)");
        System.out.println(colors.contains("Azul"));

        System.out.println("\nSort ArrayList");
        Collections.sort(colors);
        System.out.println(colors);

        System.out.println("\nCopy ArrayList");
        List<String> copy = new ArrayList<String>(colors);
        System.out.println(copy);

        System.out.println("\nShuffle ArrayList");
        Collections.shuffle(copy);
        System.out.println(copy);

        System.out.println("\nReverse ArrayList");
        Collections.reverse(copy);
        System.out.println(copy);

        System.out.println("\nExtract Sublist from ArrayList (0 to min(2,size))");
        int to = Math.min(2, copy.size());
        System.out.println(copy.subList(0, to));

        System.out.println("\nCompare Two ArrayLists");
        System.out.println(colors.equals(copy));

        System.out.println("\nSwap ArrayList Elements (0 and 1)");
        if (colors.size() > 1) Collections.swap(colors, 0, 1);
        System.out.println(colors);

        System.out.println("\nJoin Two ArrayLists");
        List<String> joined = new ArrayList<String>(colors);
        joined.addAll(copy);
        System.out.println(joined);

        System.out.println("\nClone ArrayList");
        @SuppressWarnings("unchecked")
        List<String> cloned = (List<String>) ((ArrayList<String>) colors).clone();
        System.out.println(cloned);

        System.out.println("\nClear ArrayList");
        colors.clear();
        System.out.println(colors);

        System.out.println("\nCheck if ArrayList is Empty");
        System.out.println(colors.isEmpty());

        System.out.println("\nTrim ArrayList Capacity (no-op visible)");
        ((ArrayList<String>) cloned).trimToSize();
        System.out.println(cloned);

        System.out.println("\nIncrease ArrayList Capacity (ensureCapacity)");
        ((ArrayList<String>) cloned).ensureCapacity(50);
        System.out.println("Capacity ensured (no visible output)");

        System.out.println("\nReplace Second Element (index 1) in cloned");
        if (cloned.size() > 1) cloned.set(1, "Ciano");
        System.out.println(cloned);

        System.out.println("\nPrint Elements by Position");
        for (int i = 0; i < cloned.size(); i++) {
            System.out.println(i + " -> " + cloned.get(i));
        }
    }
}
