package kr.happydev.screenbrightness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * @author Simple& Happy dev (http://gh0st.tistory.com/)
 * MainActivity.java
 */
public class MainActivity extends AppCompatActivity {
    private static final int BRIGHTNESS_MIN = 0;
    private static final int BRIGHTNESS_MAX = 255;
    private static final int BRIGHTNESS_SYSTEM = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnMinBrightness).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeScreenBrightness(BRIGHTNESS_MIN);
            }
        });

        findViewById(R.id.btnMaxBrightness).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeScreenBrightness(BRIGHTNESS_MAX);
            }
        });

        findViewById(R.id.btnSystemBrightness).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeScreenBrightness(BRIGHTNESS_SYSTEM);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        changeScreenBrightness(BRIGHTNESS_SYSTEM);
    }

    private void changeScreenBrightness(int value) {
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.screenBrightness = value * 1.0f / 255;
        window.setAttributes(layoutParams);
    }
}
