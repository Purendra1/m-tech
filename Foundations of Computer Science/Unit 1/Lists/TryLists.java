import java.util.Iterator;
import java.util.NoSuchElementException;

public class TryLists {
    public static void main(String args[]) {
        IList<String> list = new SimpleList<String>();
        list.add("element1");
        list.add("element2");

        printList(list);

        list.delete(1);

        printList(list);

        try {
            list.get(1);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        try {
            list.delete(1);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
        

    }

    private static void printList(IList<String> list) {
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
