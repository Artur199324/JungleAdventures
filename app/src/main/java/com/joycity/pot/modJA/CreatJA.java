package com.joycity.pot.modJA;

import android.view.Display;
import android.widget.ImageView;

import com.joycity.pot.R;

import java.util.Random;

public class CreatJA {

    ImageView imageView ;
    Random random;
    ImgCl imgCl;

    public CreatJA(ImageView imageView) {
        this.imageView = imageView;
    }

    public ImgCl createJA(Display display){
        random = new Random();
        int h = random.nextInt(6);
        int n = random.nextInt(4);

        if (h == 0){
            imageView.setImageResource(R.drawable.nnn1);
            imageView.setTag(1);
            imageView.setY(0);
        }
        if (h == 1){

            imageView.setImageResource(R.drawable.nnn2);
            imageView.setTag(2);
            imageView.setY(0);

        }
        if (h == 2){

            imageView.setImageResource(R.drawable.nnn3);
            imageView.setTag(3);
            imageView.setY(0);

        }
        if (h == 3){

            imageView.setImageResource(R.drawable.nnn4);
            imageView.setTag(4);
            imageView.setY(0);
        }

        if (h == 4){

            imageView.setImageResource(R.drawable.nnn5);
            imageView.setTag(5);
            imageView.setY(0);
        }

        if (h == 5){

            imageView.setImageResource(R.drawable.nnn6);
            imageView.setTag(6);
            imageView.setY(0);
        }





        int gg = (display.getWidth()/4) - imageView.getWidth()/2;

        switch (n){
            case 0:
                imageView.setX(gg);
                imgCl = new ImgCl();
                imgCl.setImageView(imageView);
                imgCl.setCoaX(2);

                break;
            case 1:
                imageView.setX(gg+gg);
                imgCl = new ImgCl();
                imgCl.setImageView(imageView);
                imgCl.setCoaX(3);

                break;
            case 2:
                imageView.setX(gg+ gg+ gg);
                imgCl = new ImgCl();
                imgCl.setImageView(imageView);
                imgCl.setCoaX(4);

                break;
            case 3:
                imageView.setX(imageView.getWidth());
                imgCl = new ImgCl();
                imgCl.setImageView(imageView);
                imgCl.setCoaX(1);

                break;


        }

        return imgCl;
    }
}
