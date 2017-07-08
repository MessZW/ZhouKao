package bwie.com.zhoukao;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private CircleProgressBar circleProgressBar;
    private int count=0;
      private Handler handler=new Handler(){
             @Override
             public void handleMessage(Message msg) {
                 circleProgressBar.setPercent(count);
                 if (count==100){
                     count=0;
                 }
             }
         };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleProgressBar= (CircleProgressBar) findViewById(R.id.pro);
        button= (Button) findViewById(R.id.but);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        count++;
                        handler.sendEmptyMessage(0);
                    }
                },200,100);
            }
        });
    }
}
