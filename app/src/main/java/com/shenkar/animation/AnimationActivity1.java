package com.shenkar.animation;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.shenkar.calculator.R;

import java.util.ArrayList;

public class AnimationActivity1 extends AppCompatActivity implements View.OnTouchListener {
        OurView o;
        Canvas c;
    Paint green_paintbrush_fill;
    private ArrayList<Ball> balls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        o = new OurView(this);
        o.setOnTouchListener(this);
        setContentView(o);
        green_paintbrush_fill = new Paint();
        green_paintbrush_fill.setColor(Color.GREEN);
        green_paintbrush_fill.setStyle(Paint.Style.FILL);


    }

    @Override
    protected void onPause() {
        super.onPause();
        o.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        o.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN :{
                if((event.getX() >= 400 && event.getX() <= 1100) && (event.getY() >= 650 && event.getY() <= 1350))
                    break;
                if(balls.size() < 10)
                    balls.add(new Ball(BitmapFactory.decodeResource(getResources(), R.drawable.ball),event.getX(),event.getY()));
                else {
                    balls.remove(0);
                    balls.add(new Ball(BitmapFactory.decodeResource(getResources(), R.drawable.ball),event.getX(),event.getY()));
                }
                break;
            }
        }

        return false;
    }

    public class OurView extends SurfaceView implements Runnable {

        Thread t= null;
        SurfaceHolder holder;
        boolean canPlay = false;

        public OurView(Context context) {
            super(context);
            holder = getHolder();
        }

        @Override
        public void run() {
            while(canPlay == true){
                if(!holder.getSurface().isValid()){
                    continue;
                }
                c = holder.lockCanvas();
                c.drawARGB(255,0,0,0);
                for(Ball ball : balls){
                    ball.check_bounds(c);
                    ball.draw(c);
                }
                Rect rectangle = new Rect();
                rectangle.set(500,750,1000,1250);
                c.drawRect(rectangle,green_paintbrush_fill);
                holder.unlockCanvasAndPost(c);
            }
        }

        public void pause(){
            canPlay = false;
            while(true){
                try{
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            t = null;
        }

        public void resume(){
            canPlay = true;
            t = new Thread(this);
            t.start();
        }
    }


}
