package com.joycity.pot.modJA;

import static com.joycity.pot.actJA.MainActivity.d;

import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;

public class MoveJA {

    ImageView imageView;
    ImgCl imgCl;
    Display display;
    boolean moveStopAJ = true;
    boolean moveStartAJ = false;

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public void setMoveStartAJ(boolean moveStartAJ) {
        this.moveStartAJ = moveStartAJ;
    }

    public boolean isMoveStartAJ() {
        return moveStartAJ;
    }

    public void setMoveStopAJ(boolean moveStopAJ) {
        this.moveStopAJ = moveStopAJ;
    }

    public ImgCl getImgCl() {
        return imgCl;
    }

    public void setImgCl(ImgCl imgCl) {
        this.imgCl = imgCl;
    }

    public void moveJA(){
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                imageView.setY(imageView.getY() + 5);

                if (imageView.getY() >= display.getHeight()-imageView.getHeight()){
                    moveStopAJ = false;
                }
                d++;

                if (moveStopAJ){
                    handler.postDelayed(this::run,10);
                }else {
                    imgCl.setCoaY(d);

                    d = 0;
                    moveStopAJ = true;
                    moveStartAJ = true;


                }
            }
        });


    }
}
