import java.util.Comparator;

/**
 * Created by Grzegorz on 2017-06-11.
 */
public class MyComparator implements Comparator<DiskElement> {
    @Override
    public int compare(DiskElement o1, DiskElement o2) {
        if(o1.getName().length()!=o2.getName().length()) {
            return o1.getName().length() - o2.getName().length();
        }
        else{
            return 1;
        }
    }
}
