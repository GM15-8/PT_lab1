import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Grzegorz on 2017-06-09.
 */
public class DiskDirectory extends DiskElement {
    Set<DiskElement> children;

    public DiskDirectory(File file){
        this.file=file;
        setAbbreviation();
        setDateLastModified();
        children=new TreeSet<>();
        for(File f: file.listFiles()){
            if(f.isFile()){
                children.add(new DiskFile(f));
            }
            else if(f.isDirectory()){
                children.add(new DiskDirectory(f));
            }
        }
    }

    public DiskDirectory(File file, Comparator comparator){
        this.file=file;
        setAbbreviation();
        setDateLastModified();
        children=new TreeSet<>(comparator);
        for(File f: file.listFiles()){
            if(f.isFile()){
                children.add(new DiskFile(f));
            }
            else if(f.isDirectory()){
                children.add(new DiskDirectory(f));
            }
        }
    }

    @Override
    public void print(int depth) {
        for(int i=0;i<depth;i++) {
            System.out.print("-");
        }
        System.out.println(this.file.getName()+" "+this.abbreviation+" "+this.dateString);
        for(DiskElement diskElement: children){
            int temp=depth+1;
            diskElement.print(temp);
        }
    }


    @Override
    protected String getName() {
        return this.file.getName();
    }
}
