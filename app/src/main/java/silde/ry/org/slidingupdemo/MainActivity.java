package silde.ry.org.slidingupdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SlidingUpLayout slidingUpLayout = (SlidingUpLayout)findViewById(R.id.sliding);
        final GestureDetectorLayout gestureDetectorLayout = (GestureDetectorLayout)findViewById(R.id.content);
        gestureDetectorLayout.setDirectionListener(new GestureDetectorLayout.DirectionListener() {
            @Override
            public void up() {
                slidingUpLayout.slideTop();
            }

            @Override
            public void down() {
                slidingUpLayout.slideBottom();
            }
        });

    }
}
