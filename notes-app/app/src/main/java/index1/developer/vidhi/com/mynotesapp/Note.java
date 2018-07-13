package index1.developer.vidhi.com.mynotesapp;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;

import java.util.TimeZone;



public class Note implements Serializable{

    private long Dt;
    private String tl; 
    private String ct1; 

    public Note(long DateTime, String Title, String Content) {
        this.Dt = DateTime;
        this.tl = Title;
        this.ct1 = Content;

    }




    public String gettl() {
        return tl;
    }



    public long getDt() {
        return Dt;
    }

    public void setDt(long Dt)
    {
        this.Dt=Dt;
    }

    public void setct1(String ct1) {
        this.ct1 = ct1;
    }
    public void settl(String tl)
    {
        this.tl=tl;
    }


    public String getct1() {
        return ct1;
    }

    public String getDateTimeFormatted(Context context) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"
                , context.getResources().getConfiguration().locale);
        formatter.setTimeZone(TimeZone.getDefault());
        return formatter.format(new Date(Dt));
    }
}


