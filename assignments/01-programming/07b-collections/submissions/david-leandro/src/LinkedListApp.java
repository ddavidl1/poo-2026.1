import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        System.out.println("Append Element");
        list.add("Azul");
        list.add("Verde");
        list.add("Amarelo");
        System.out.println(list);

        System.out.println("\nIterate LinkedList Elements");
        for (String s : list) System.out.println(s);

        System.out.println("\nIterate from Position (index 1)");
        ListIterator<String> it = list.listIterator(1);
        while (it.hasNext()) System.out.println(it.next());

        System.out.println("\nIterate in Reverse Order");
        ListIterator<String> rit = list.listIterator(list.size());
        while (rit.hasPrevious()) System.out.println(rit.previous());

        System.out.println("\nInsert at Position (1)");
        list.add(1, "Roxo");
        System.out.println(list);

        System.out.println("\nInsert First and Last");
        list.addFirst("Preto");
        list.addLast("Branco");
        System.out.println(list);

        System.out.println("\nInsert at Front");
        list.addFirst("Laranja");
        System.out.println(list);

        System.out.println("\nInsert at End");
        list.addLast("Marrom");
        System.out.println(list);

        System.out.println("\nInsert Multiple at Position (2)");
        list.addAll(2, java.util.Arrays.asList("Cinza","Ciano"));
        System.out.println(list);

        System.out.println("\nFirst and Last Occurrence of 'Azul'");
        System.out.println(list.indexOf("Azul") + " , " + list.lastIndexOf("Azul"));

        System.out.println("\nPrint Elements with Positions");
        for (int i = 0; i < list.size(); i++) System.out.println(i + " -> " + list.get(i));

        System.out.println("\nRemove Element ('Ciano')");
        list.remove("Ciano");
        System.out.println(list);

        System.out.println("\nRemove First and Last");
        if (!list.isEmpty()) list.removeFirst();
        if (!list.isEmpty()) list.removeLast();
        System.out.println(list);

        System.out.println("\nClear LinkedList");
        LinkedList<String> copy = new LinkedList<String>(list);
        list.clear();
        System.out.println(list);

        System.out.println("\nSwap Elements in copy (0 and 1)");
        if (copy.size() > 1) Collections.swap(copy, 0, 1);
        System.out.println(copy);

        System.out.println("\nShuffle LinkedList");
        Collections.shuffle(copy);
        System.out.println(copy);

        System.out.println("\nJoin LinkedLists");
        LinkedList<String> other = new LinkedList<String>(java.util.Arrays.asList("X","Y"));
        LinkedList<String> joined = new LinkedList<String>(copy);
        joined.addAll(other);
        System.out.println(joined);

        System.out.println("\nCopy LinkedList");
        LinkedList<String> copied = new LinkedList<String>(joined);
        System.out.println(copied);

        System.out.println("\nPoll First Element");
        System.out.println(copied.pollFirst());
        System.out.println(copied);

        System.out.println("\nPeek First Element");
        System.out.println(copied.peekFirst());

        System.out.println("\nPeek Last Element");
        System.out.println(copied.peekLast());

        System.out.println("\nContains Element ('Y')");
        System.out.println(copied.contains("Y"));

        System.out.println("\nConvert to ArrayList");
        System.out.println(new java.util.ArrayList<String>(copied));

        System.out.println("\nCompare LinkedLists with copy");
        System.out.println(joined.equals(copied));

        System.out.println("\nCheck if Empty");
        System.out.println(copied.isEmpty());

        System.out.println("\nReplace Element at (0)");
        if (!copied.isEmpty()) copied.set(0, "Novo");
        System.out.println(copied);
    }
}
