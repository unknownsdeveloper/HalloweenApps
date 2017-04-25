package ankit.developer.unknowns.halloweenapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SplashScreen
        SplashScreen();
    }

    private void SplashScreen() {
        Thread background = new Thread(){
            public void run(){
                try{
                    sleep(3*1000); // 3 seconds
                    Intent intent = new Intent(getBaseContext(),HalloweenFoodIdeas.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){
                }
            }
        };
        background.start();
    }
}
