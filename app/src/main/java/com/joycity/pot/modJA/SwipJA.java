package com.joycity.pot.modJA;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class SwipJA implements View.OnTouchListener {

    private final GestureDetector gestureDetectorJA;

    public SwipJA (Context ctx){
        gestureDetectorJA = new GestureDetector(ctx, new GestureListenerJA());
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetectorJA.onTouchEvent(motionEvent);
    }

    private final class GestureListenerJA extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLDJA = 100;
        private static final int SWIPE_VELOCITY_THRESHOLDJA = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLDJA && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLDJA) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                        result = true;
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    public void onSwipeRight() {
    }

    public void onSwipeLeft() {
    }


}
