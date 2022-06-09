package tw.edu.pu.csce.endreport;

import android.app.Application;
import android.content.SharedPreferences;

public class MainApp extends Application{
    SharedPreferences spf;
    SharedPreferences.Editor editor ;
    @Override
    public void onCreate() {
        super.onCreate();
        spf  = getSharedPreferences("my_data.log",MODE_APPEND);
        editor = spf.edit();
    }
    public String getData(){
        return spf.getString("user","");
    }

    public void setData(String user){
        editor.putString("user",user);
        editor.commit();
    }

    public String getMoney()
    {
        return spf.getString("pwd","");
    }
    public void setMoney(String pwd){
        editor.putString("pwd",pwd);
        editor.commit();
    }
}
