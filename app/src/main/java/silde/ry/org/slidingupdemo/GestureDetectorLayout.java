package silde.ry.org.slidingupdemo;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by renyang on 16/2/23.
 */
public class GestureDetectorLayout extends FrameLayout{

    private GestureDetectorCompat gestureDetectorCompat;
    private DirectionListener directionListener;

    public GestureDetectorLayout(Context context) {
        super(context);
        init(context);
    }

    public GestureDetectorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GestureDetectorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        gestureDetectorCompat = new GestureDetectorCompat(context,new GestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            float x = e2.getX() - e1.getX();
            float y = e2.getY() - e1.getY();

            if(Math.abs(y) - Math.abs(x) > 0){
                if(y > 0){
                    directionListener.down();
                }else if(y < 0){
                    directionListener.up();
                }
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    public interface DirectionListener{
        void up();
        void down();
    }

    public void setDirectionListener(DirectionListener directionListener){
        this.directionListener = directionListener;
    }
}
