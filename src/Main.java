import java.io.File;
import java.util.Comparator;

/**
 * Created by Grzegorz on 2017-06-09.
 */
public class Main {
    public static void main(String... args) {
        System.out.println("Platformy technologiczne lab nr 1:");
        Reader reader=new Reader("C:\\Users\\Grzegorz\\Documents\\PTlab1");
        System.out.println("---------------------------------:");
        System.out.println("1.Wykorzystanie interfejsu Comparable:");
        System.out.println("---------------------------------:");
        reader.read();
        System.out.println("1.Wykorzystanie interfejsu Comparator:");
        System.out.println("---------------------------------:");
        Comparator<DiskElement> comparator=new MyComparator();
        reader.read(comparator);

    }
}
