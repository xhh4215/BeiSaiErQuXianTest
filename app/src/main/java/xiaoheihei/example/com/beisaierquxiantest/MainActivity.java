package xiaoheihei.example.com.beisaierquxiantest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button ;
    private MyPaintView myview;
    private MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (MyView) findViewById(R.id.myviewid);
        myView.startAnimation();
//        button  = (Button) findViewById(R.id.buttonid);
//        button.setText("清除");
//        myview = (MyPaintView) findViewById(R.id.myviewId);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//              myview.reset();
//            }
//        });
   }
}
