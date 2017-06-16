import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Grzegorz on 2017-06-09.
 */
public abstract class DiskElement implements Comparable{
    enum Abbreviation {F,K}
    protected File file;
    protected Abbreviation abbreviation;
    protected Date dateLastModified;
    protected String dateString;
    protected abstract void print(int depth);
    protected void setAbbreviation(){
        if(file.isFile()){
            this.abbreviation=Abbreviation.F;
        }
        else if(file.isDirectory()){
            this.abbreviation=Abbreviation.K;
        }
    }
    protected Abbreviation getAbbreviation() {
        return abbreviation;
    }
    protected void setDateLastModified(){
        long date=file.lastModified();
        dateLastModified=new Date(date);
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("YYYY-MM-dd");
        dateString = simpleDateFormat.format(dateLastModified);
    }
    protected abstract String getName();

    @Override
    public int compareTo(Object o) {
        DiskElement diskElement=(DiskElement) o;
        if(diskElement.getAbbreviation()==this.getAbbreviation()){
            return 1; //porzadek leksykograficzny
        }
        else if(diskElement.getAbbreviation()==Abbreviation.K){
            return 1;
        }
        else if(diskElement.getAbbreviation()==Abbreviation.F){
            return -1;
        }
        else{
            return 0;
        }
    }
}
