package com.shenkar.animation;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Ball {
    private Bitmap ball_bm;
    private float pos_x;
    private float pos_y;
    private int dir_x;
    private int dir_y;

    public Ball(Bitmap ball_bm,float x ,float y) {
        this.ball_bm = ball_bm;
        this.pos_x = x;
        this.pos_y = y;
        this.dir_x = 5;
        this.dir_y = 5;
    }

    public void check_bounds(Canvas c){

        if(pos_x >= c.getWidth() - 100){
            dir_x = -5;
        }

        if(pos_x <= 0) {
            dir_x = 5;
        }

        if(pos_y >= c.getHeight()- 100){
            dir_y = -5;
        }

        if(pos_y <= 0) {
            dir_y = 5;
        }

        if((pos_x >= 395 && pos_x <= 1005) && ((pos_y >= 650 && pos_y <=1250)))
        {
            dir_x*=-1;
        }

        if((pos_x >= 400 && pos_x <= 1000) && ((pos_y >= 645 && pos_y <=1255)))
        {

            dir_y*=-1;
        }

        pos_x += dir_x;
        pos_y += dir_y;


    }

    public void draw(Canvas c){
        c.drawBitmap(ball_bm,pos_x,pos_y,null);
    }
}
