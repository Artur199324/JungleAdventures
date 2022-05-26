package com.joycity.pot.actJA;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

import com.joycity.pot.R;
import com.joycity.pot.modJA.ImgCl;
import com.joycity.pot.modJA.SwipJA;
import com.joycity.pot.viewModJA.ViewJA;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Display displayJA;
    ConstraintLayout cooooJa;
    ImageView immm;
    public static ViewJA viewJA;

    ArrayList<ImgCl> arrayListJAV;
    ArrayList<ImgCl> arrayListImgCl;
    ArrayList<ImgCl> arrayList1;
    ArrayList<ImgCl> arrayList2;
    ArrayList<ImgCl> arrayList3;
    ArrayList<ImgCl> arrayList4;
    boolean startMovJA = false;
    Handler handler;
    ImgCl imgCl;
    int gg;
    public static int d = 0;
    int counterJA = 0;
    boolean ii = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(1024);
        displayJA = getWindowManager().getDefaultDisplay();
        handler = new Handler();
        cooooJa = findViewById(R.id.cooooJa);
        viewJA = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewJA.class);
        arrayListImgCl = new ArrayList<>();
        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>();
        arrayList3 = new ArrayList<>();
        arrayList4 = new ArrayList<>();
        arrayListJAV = new ArrayList<>();
        coo();
        mmm();
        jh();
        sww();
        od();
        oos();
        pp();
        gg = (displayJA.getWidth() / 4) - immm.getWidth() / 2;


    }

    public void sww() {
        cooooJa.setOnTouchListener(new SwipJA(this) {
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();

                if (imgCl.getCoaX() == 2) {
                    immm.setX(0);
                    imgCl.setCoaX(1);

                } else if (imgCl.getCoaX() == 3) {

                    immm.setX(gg);
                    imgCl.setCoaX(2);

                } else if (imgCl.getCoaX() == 4) {

                    immm.setX(gg + gg);
                    imgCl.setCoaX(3);

                }
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();


                if (imgCl.getCoaX() == 1) {

                    immm.setX(gg);
                    imgCl.setCoaX(2);

                } else if (imgCl.getCoaX() == 2) {

                    immm.setX(gg + gg);
                    imgCl.setCoaX(3);

                } else if (imgCl.getCoaX() == 3) {

                    immm.setX(gg + gg + gg);
                    imgCl.setCoaX(4);

                }
            }
        });


    }

    public void coo() {
        immm = new ImageView(this);
        ConstraintLayout.LayoutParams cooooJaLayout = new ConstraintLayout.LayoutParams(displayJA.getWidth() / 4, displayJA.getWidth() / 4);
        cooooJa.addView(immm);
        immm.setLayoutParams(cooooJaLayout);
        imgCl = viewJA.createJA(displayJA, immm);
        viewJA.moveJA(displayJA, immm, imgCl);
        immm.setBackgroundColor(Color.WHITE);
        Log.d("wwww", "rrr");

    }

    public void ij(ArrayList<ImgCl> arrayList) {
        if (arrayList.size() == 2) {
            counterJA++;
            cooooJa.removeView(arrayList.get(0).getImageView());
            cooooJa.removeView(arrayList.get(1).getImageView());
        }
    }

    public void mmm() {

        handler.post(new Runnable() {
            @Override
            public void run() {
                if (viewJA.getStart()) {
                    startMovJA = false;
                    arrayListImgCl.add(imgCl);
                    arrayListJAV.add(imgCl);
                    coo();
                    viewJA.startingMoveJA(false);
                }

                if (ii) {
                    handler.postDelayed(this::run, 10);
                }
            }
        });
    }

    ImageView imageView = null;
    ImageView imageView2 = null;
    ImageView imageView3 = null;
    ImageView imageView4 = null;



    public void  pp(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (arrayListJAV.size() > 2) {

                    for (int i = 0; i < arrayListJAV.size(); i++) {
                        if (arrayListJAV.get(i).getCoaX() == 1) {
                            imageView = arrayListJAV.get(i).getImageView();

                            Log.d("qqq", "1");
                        }
                        if (arrayListJAV.get(i).getCoaX() == 2) {
                            imageView2 = arrayListJAV.get(i).getImageView();
                            Log.d("qqq", "2");

                        }
                        if (arrayListJAV.get(i).getCoaX() == 3) {
                            imageView3 = arrayListJAV.get(i).getImageView();
                            Log.d("qqq", "3");

                        }
                        if (arrayListJAV.get(i).getCoaX() == 4) {
                            imageView4 = arrayListJAV.get(i).getImageView();
                            Log.d("qqq", "4");

                        }

                        if (imageView4 !=null && imageView3 !=null && imageView2 !=null){
                            Log.d("eee", "1");
                            if (imageView2.getY() == imageView4.getY() && imageView2.getY() == imageView3.getY()){
                                Log.d("eee", "2");
                                if (imageView2.getTag() == imageView4.getTag() && imageView2.getTag() == imageView3.getTag()){
                                    Log.d("eee", "3");
                                    imageView4.setVisibility(View.INVISIBLE);
                                    imageView3.setVisibility(View.INVISIBLE);
                                    imageView2.setVisibility(View.INVISIBLE);
                                    Log.d("eee","11");

                                }
                            }
                        }
                        if (arrayListJAV.get(i).getImageView().getVisibility() == View.INVISIBLE){
                            cooooJa.removeView(arrayListJAV.get(i).getImageView());
                            arrayListJAV.remove(i);


                        }
                    }


                }
                if (ii) {
                    handler.postDelayed(this::run, 10);
                }
            }
        });

    }

    public void oos() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (arrayListJAV.size() > 2) {

                    for (int i = 0; i < arrayListJAV.size(); i++) {
                        if (arrayListJAV.get(i).getCoaX() == 1) {
                            imageView = arrayListJAV.get(i).getImageView();

                            Log.d("qqq", "1");
                        }
                        if (arrayListJAV.get(i).getCoaX() == 2) {
                            imageView2 = arrayListJAV.get(i).getImageView();
                            Log.d("qqq", "2");

                        }
                        if (arrayListJAV.get(i).getCoaX() == 3) {
                            imageView3 = arrayListJAV.get(i).getImageView();
                            Log.d("qqq", "3");

                        }
                        if (arrayListJAV.get(i).getCoaX() == 4) {
                            imageView4 = arrayListJAV.get(i).getImageView();
                            Log.d("qqq", "4");

                        }

                        if (imageView != null && imageView2 != null && imageView3 != null) {
                            Log.d("eee", "1");
                            if (imageView.getY() == imageView2.getY() && imageView3.getY() == imageView2.getY()) {
                                Log.d("eee", "2");
                                if (imageView.getTag() == imageView2.getTag() && imageView.getTag() == imageView3.getTag()) {
                                    imageView.setVisibility(View.INVISIBLE);
                                    imageView2.setVisibility(View.INVISIBLE);
                                    imageView3.setVisibility(View.INVISIBLE);
                                    Log.d("eee", "3");
                                }
                            }

                        }



                        if (arrayListJAV.get(i).getImageView().getVisibility() == View.INVISIBLE){
                            cooooJa.removeView(arrayListJAV.get(i).getImageView());
                            arrayListJAV.remove(i);
                            Log.d("qqq", "6");

                        }


                    }




                }
                if (ii) {
                    handler.postDelayed(this::run, 10);
                }
            }
        });
    }






    public void jh() {

        handler.post(new Runnable() {
            @Override
            public void run() {
                if (arrayListImgCl.size() > 0) {
                    for (int i = 0; i < arrayListImgCl.size(); i++) {
                        ImageView imageViewff = arrayListImgCl.get(i).getImageView();
                        ImgCl imgCl1 = arrayListImgCl.get(i);
                        Rect myViewRect = new Rect();
                        imageViewff.getHitRect(myViewRect);

                        Rect otherViewRect1 = new Rect();
                        immm.getHitRect(otherViewRect1);

                        if (Rect.intersects(myViewRect, otherViewRect1)) {

                            if (imgCl.getCoaX() == 1) {
                                if (imageViewff.getVisibility() == View.INVISIBLE) {
                                    Log.d("ttt", "111");
                                    cooooJa.removeView(imageViewff);
                                    arrayListImgCl.remove(imgCl1);
                                    arrayListImgCl.remove(imgCl1);
                                } else {
                                    if (imgCl1.getImageView().getTag() == imgCl.getImageView().getTag()) {
                                        arrayList1.add(imgCl1);

                                        if (arrayList1.size() == 2) {
                                            ij(arrayList1);
                                            arrayList1 = new ArrayList<>();
                                            imgCl.getImageView().setVisibility(View.INVISIBLE);
                                        } else {
                                            if (arrayList1.size() > 1) {
                                                arrayList1.remove(i);
                                            }
                                            viewJA.stopMove(false);

                                        }


                                        arrayListImgCl.remove(imgCl1);
                                        arrayListImgCl.remove(imgCl);
                                    } else {
                                        if (imgCl1.getImageView().getX() == immm.getX()) {
                                            if (imgCl1.getImageView().getY() <= immm.getY()) {
                                                ff = false;
                                            }

                                        } else {

                                        }
                                        arrayList1 = new ArrayList<>();
                                        viewJA.stopMove(false);
                                    }
                                }
                            }


                            if (imgCl.getCoaX() == 2) {
                                if (imageViewff.getVisibility() == View.INVISIBLE) {
                                    Log.d("ttt", "111");
                                    cooooJa.removeView(imgCl1.getImageView());
                                    arrayListImgCl.remove(imgCl1);
                                } else {
                                    if (imgCl1.getImageView().getTag() == imgCl.getImageView().getTag()) {
                                        arrayList2.add(imgCl1);
                                        if (arrayList2.size() == 2) {
                                            ij(arrayList2);

                                            arrayList2 = new ArrayList<>();
                                            imgCl.getImageView().setVisibility(View.INVISIBLE);
                                        } else {
                                            if (arrayList1.size() > 1) {
                                                arrayList1.remove(i);
                                            }
                                            viewJA.stopMove(false);

                                        }
                                        arrayListImgCl.remove(imgCl1);
                                        arrayListImgCl.remove(imgCl);
                                    } else {
                                        if (imgCl1.getImageView().getX() == immm.getX()) {
                                            if (imgCl1.getImageView().getY() <= immm.getY()) {
                                                ff = false;
                                            }
                                        } else {

                                        }
                                        arrayList2 = new ArrayList<>();
                                        viewJA.stopMove(false);
                                    }
                                }

                            }


                            if (imgCl.getCoaX() == 3) {
                                if (imageViewff.getVisibility() == View.INVISIBLE) {
                                    Log.d("ttt", "111");
                                    cooooJa.removeView(imgCl1.getImageView());
                                    arrayListImgCl.remove(imgCl1);
                                } else {
                                    if (imgCl1.getImageView().getTag() == imgCl.getImageView().getTag()) {
                                        arrayList3.add(imgCl1);
                                        if (arrayList3.size() == 2) {
                                            if (arrayList1.size() > 1) {
                                                arrayList1.remove(i);
                                            }
                                            ij(arrayList3);

                                            arrayList3 = new ArrayList<>();
                                            imgCl.getImageView().setVisibility(View.INVISIBLE);

                                        } else {
                                            viewJA.stopMove(false);

                                        }
                                        arrayListImgCl.remove(imgCl1);

                                    } else {
                                        if (imgCl1.getImageView().getX() == immm.getX()) {
                                            if (imgCl1.getImageView().getY() <= immm.getY()) {
                                                ff = false;
                                            }
                                        } else {

                                        }
                                        arrayList3 = new ArrayList<>();
                                        viewJA.stopMove(false);

                                    }
                                }

                            }


                            if (imgCl.getCoaX() == 4) {
                                if (imageViewff.getVisibility() == View.INVISIBLE) {
                                    Log.d("ttt", "111");
                                    cooooJa.removeView(imgCl1.getImageView());
                                    arrayListImgCl.remove(imgCl1);
                                    ;
                                } else {
                                    if (imgCl1.getImageView().getTag() == imgCl.getImageView().getTag()) {
                                        arrayList4.add(imgCl1);
                                        if (arrayList4.size() == 2) {
                                            ij(arrayList4);
                                            arrayList4 = new ArrayList<>();
                                            imgCl.getImageView().setVisibility(View.INVISIBLE);

                                        } else {
                                            if (arrayList1.size() > 1) {
                                                arrayList1.remove(i);
                                            }
                                            viewJA.stopMove(false);

                                        }
                                        arrayListImgCl.remove(imgCl1);
                                        arrayListImgCl.remove(imgCl);
                                    } else {


                                        Log.d("weq", "tt");
                                        arrayList4 = new ArrayList<>();
                                        viewJA.stopMove(false);
                                        if (imgCl1.getImageView().getX() == immm.getX()) {

                                            if (imgCl1.getImageView().getY() <= immm.getY()) {
                                                ff = false;
                                            }
                                        } else {

                                        }
                                    }
                                }

                            }


                        }
                    }


                    if (arrayListImgCl.size() > 2) {
                        for (int i = 0; i < arrayListImgCl.size(); i++) {

                            if (arrayListImgCl.get(i).getImageView().getY() == 10) {
                                ff = false;
                            }
                        }
                    }
                }

                if (ii) {
                    handler.postDelayed(this::run, 10);
                }
            }
        });
    }

    boolean ff = true;

    public void od() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (ff) {
                    handler.postDelayed(this::run, 10);
                } else {

                    Intent intent = new Intent(getApplicationContext(), FinACt.class);
                    intent.putExtra("c", counterJA + "");
                    startActivity(intent);
                    finishAffinity();
                    ii = false;
                }

            }
        });
    }


    @Override
    public void onBackPressed() {
        ii = false;
        startActivity(new Intent(getApplicationContext(), SBJA.class));
        finishAffinity();

    }
}