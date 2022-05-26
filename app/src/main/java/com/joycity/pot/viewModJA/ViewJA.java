package com.joycity.pot.viewModJA;


import android.app.Activity;
import android.app.Application;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.joycity.pot.modJA.CreatJA;
import com.joycity.pot.modJA.ImgCl;
import com.joycity.pot.modJA.MoveJA;
import com.joycity.pot.modJA.SaveJA;

public class ViewJA extends AndroidViewModel {
    MoveJA moveJA;
    SaveJA saveJA;

    public ViewJA(@NonNull Application application) {
        super(application);
        saveJA = new SaveJA();

    }



    public void saveJA(String dd) {
        saveJA.setSaveRec(dd);
    }

    public String saveAJ() {
        return saveJA.getSaveRec();
    }

    public ImgCl createJA(Display display, ImageView imageView) {
        CreatJA creatJA = new CreatJA(imageView);
        return creatJA.createJA(display);
    }

    public void moveJA(Display display, ImageView imageView, ImgCl imgCl) {
        moveJA = new MoveJA();
        moveJA.setDisplay(display);
        moveJA.setImageView(imageView);
        moveJA.moveJA();
        moveJA.setImgCl(imgCl);

    }

    public boolean getStart() {
        return moveJA.isMoveStartAJ();
    }

    public void startingMoveJA(boolean sss) {
        moveJA.setMoveStartAJ(sss);
    }

    public void stopMove(boolean lll) {
        moveJA.setMoveStopAJ(lll);
    }
}
