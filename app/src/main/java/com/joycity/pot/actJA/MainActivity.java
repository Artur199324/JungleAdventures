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
    ArrayList<ImageView> arrayListJA;
    ArrayList<ImgCl> arrayListImgCl;
    ArrayList<ImgCl> arrayList1;
    ArrayList<ImgCl> arrayList2;
    ArrayList<ImgCl> arrayList3;
    ArrayList<ImgCl> arrayList4;
    ArrayList<ImgCl> arrayList5;
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
        arrayListJA = new ArrayList<>();
        arrayListImgCl = new ArrayList<>();
        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>();
        arrayList3 = new ArrayList<>();
        arrayList4 = new ArrayList<>();
        arrayList5 = new ArrayList<>();
        coo();
        mmm();
        jh();
        sww();
        od();
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
                    coo();
                    viewJA.startingMoveJA(false);
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
                                            arrayList5.add(imgCl);
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
                                            arrayList5.add(imgCl);
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
                                            arrayList5.add(imgCl);
                                            imgCl.getImageView().setVisibility(View.INVISIBLE);

                                        } else {
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
                                            arrayList5.add(imgCl);
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