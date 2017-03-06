package com.example.kalyanramswamy.vibration;

import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    PowerManager.WakeLock wakeLock;
    TextView number_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PowerManager powermanager =(PowerManager) getSystemService(POWER_SERVICE);
        final PowerManager.WakeLock wakelock=powermanager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"kalyan ram");

        number_view = (TextView)findViewById(R.id.number_view);


        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        Button vibration = (Button) findViewById(R.id.button_vibration);

        number_view.setText("click button to start service");
        vibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wakelock.acquire();
                int i=0,p=5;
                number_view.setText("sleep started");

                     if(true){
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                number_view.setText("sleep over");
                                vibe.vibrate(5000);
                            }
                        }, 60000);
                }

                wakelock.release();
            }
        });
    }

}
