import sun.java2d.pipe.SpanShapeRenderer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Grzegorz on 2017-06-09.
 */
public class DiskFile extends DiskElement {

    public DiskFile(File file) {
        this.file=file;
        setAbbreviation();
        setDateLastModified();
    }

    @Override
    public void print(int depth) {
        for(int i=0;i<depth;i++) {
            System.out.print("-");
        }
        System.out.println(this.file.getName()+" "+this.abbreviation+" "+this.dateString);
    }


    public String getName(){
        return this.file.getName();
    }

}
