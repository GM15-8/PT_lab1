import java.io.File;
import java.util.Comparator;

/**
 * Created by Grzegorz on 2017-06-09.
 */
public class Reader {
    private File file;
    private DiskElement diskElement;
    private String path;

    public Reader(String path){
        this.path=path;
    }

    public void read(){
        try {
            file = new File(path);
        }
        catch(ExceptionInInitializerError e){
            e.printStackTrace();
        }

        diskElement=new DiskDirectory(file);
        diskElement.print(1);

    }
    public void read(Comparator comp){
        try {
            file = new File(path);
        }
        catch(ExceptionInInitializerError e){
            e.printStackTrace();
        }

        diskElement=new DiskDirectory(file,comp);
        diskElement.print(1);
    }
}
