package tw.edu.pu.csce.endreport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileOutputStream;


public class MainActivity extends AppCompatActivity {
    private EditText edData, edMoney;
    private String date,money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edData=findViewById(R.id.edData);
        edMoney=findViewById(R.id.edMoney);


    }

    public void computeLogin(View view) {
        date=edData.getText().toString();
        money=edMoney.getText().toString();
     /*   String s =Environment.getExternalStorageState();
        File file =  Environment.getExternalStorageDirectory();
        Log.v("Jacky",file.getAbsolutePath());*/
        String data = "日期/今日花費";
        data=date+","+money+"。";
        try {
            FileOutputStream out = openFileOutput("my.log",MODE_APPEND);
            out.write(data.getBytes());
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(MainActivity.this, date +":輸入成功",Toast.LENGTH_LONG).show();
    }

    public void computeClear(View view) {
        edData.setText("");
        edMoney.setText("");

    }
}