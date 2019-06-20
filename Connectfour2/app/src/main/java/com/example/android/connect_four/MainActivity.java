package com.example.android.connect_four;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout body;
    private int bodyX,bodyY;
    RelativeLayout.LayoutParams lp;
    private Button button;
    public int draw;
    private Paint paint;
    private int score1,score2;
    private TextView player1,player2;
    ImageView iv[][]=new ImageView[6][7];
    View view;
    Drawable drawable1;
    private int k,p,q,m,va,v, r,t,w,h;
    private boolean check=true;
    int[][] planeArray = new int[6][7];
    String[][] charArray=new String[6][7];
    private Button undo,enter;
    private EditText height,width;
    private String   buttonId, gnheight,gnwidth;
    private int cellWidth,cellHeight;
    private int a, b,c,d,e,f,g,z;
    private MediaPlayer mmediaPlayer;
    private MediaPlayer.OnCompletionListener media=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        body = findViewById(R.id.body);

        mmediaPlayer = MediaPlayer.create(this, R.raw.song1);
        final int p = 20;
        final int q = 630;
        cellHeight = cellWidth = 150;
        r=t=0;
        h=5;w=6;
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        drawable1 = getDrawable(R.drawable.background);
        body.setBackground(drawable1);
        m=0;
        view = new SketchSheetView(MainActivity.this);
        body.addView(view, new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        button = findViewById(R.id.button);
        a = b = c = d = e = f = g = 5;
        body.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                bodyX = (int) event.getX();
                bodyY = (int) event.getY();
               drawable1 = getDrawable(R.drawable.background);
                body.setBackground(drawable1);
                mmediaPlayer.start();
                mmediaPlayer.setOnCompletionListener(media);
                lp = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                for (k = 0; k < 7; k++) {
                    if ((bodyX >= k * cellWidth && bodyX < (k + 1) * cellWidth)) {
                        if ((k == 0) && (a >= 0)) {
                            lp = new RelativeLayout.LayoutParams(
                                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                                    RelativeLayout.LayoutParams.WRAP_CONTENT);
                            iv[a][k] = new ImageView(getApplicationContext());
                            draw=draw+1;
                            buttonId = "button" + a + k;
                            charArray[r][t]=buttonId;
                            if(r<5){
                                r=r+1;
                            }else if(r==5){
                                m=m+1;
                                r=0;
                                t=m;
                            }

                            lp.setMargins(k * cellWidth + p, q + a * cellHeight, 0, 0);
                            iv[a][k].setLayoutParams(lp);

                            if (check) {
                                iv[a][k].setImageDrawable(getResources().getDrawable(
                                        R.drawable.bluestone));
                                drawable1 = getDrawable(R.drawable.yellow);
                                body.setBackground(drawable1);
                                z = 0;
                                ((ViewGroup) v).addView(iv[a][k]);
                                check = false;
                            } else {
                                iv[a][k].setImageDrawable(getResources().getDrawable(
                                        R.drawable.yellowstone));
                                drawable1 = getDrawable(R.drawable.blue);
                                body.setBackground(drawable1);
                                z = 1;
                                ((ViewGroup) v).addView(iv[a][k]);
                                check = true;
                            }
                            a = a - 1;
                        } else if ((k == 1) && (b >= 0)) {
                            lp = new RelativeLayout.LayoutParams(
                                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                                    RelativeLayout.LayoutParams.WRAP_CONTENT);
                            iv[b][k] = new ImageView(getApplicationContext());
                            lp.setMargins(k * cellWidth + p, q + b * cellHeight, 0, 0);
                            iv[b][k].setLayoutParams(lp);
                            buttonId = "button" + b + k;
                            draw=draw+1;
                            charArray[r][t]=buttonId;
                            if(r<5){
                                r=r+1;
                            }else if(r==5){
                                m=m+1;
                                r=0;
                                t=m;
                            }
                            if (check) {
                                iv[b][k].setImageDrawable(getResources().getDrawable(
                                        R.drawable.bluestone));
                                z = 0;
                                drawable1 = getDrawable(R.drawable.yellow);
                                body.setBackground(drawable1);
                                ((ViewGroup) v).addView(iv[b][k]);
                                check = false;
                            } else {
                                iv[b][k].setImageDrawable(getResources().getDrawable(
                                        R.drawable.yellowstone));
                                z = 1;
                                drawable1 = getDrawable(R.drawable.blue);
                                body.setBackground(drawable1);
                                ((ViewGroup) v).addView(iv[b][k]);
                                check = true;
                            }
                            b = b - 1;
                        } else if ((k == 2) && (c >= 0)) {
                            lp = new RelativeLayout.LayoutParams(
                                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                                    RelativeLayout.LayoutParams.WRAP_CONTENT);
                            iv[c][k] = new ImageView(getApplicationContext());
                            lp.setMargins(k * cellWidth + p, q + c * cellHeight, 0, 0);
                            iv[c][k].setLayoutParams(lp);
                            buttonId = "button" + c + k;
                            charArray[r][t]=buttonId;
                            draw=draw+1;
                            if(r< 5){
                                r=r+1;
                            }else if(r==5){
                                m=m+1;
                                r=0;
                                t=m;
                            }
                            if (check) {
                                iv[c][k].setImageDrawable(getResources().getDrawable(
                                        R.drawable.bluestone));
                                drawable1 = getDrawable(R.drawable.yellow);
                                body.setBackground(drawable1);
                                z = 0;
                                ((ViewGroup) v).addView(iv[c][k]);
                                check = false;
                            } else {
                                iv[c][k].setImageDrawable(getResources().getDrawable(
                                        R.drawable.yellowstone));
                                z = 1;
                                drawable1 = getDrawable(R.drawable.blue);
                                body.setBackground(drawable1);
                                ((ViewGroup) v).addView(iv[c][k]);
                                check = true;
                            }
                            c=c-1;

                        } else if ((k == 3) && (d >= 0)) {
                            lp = new RelativeLayout.LayoutParams(
                                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                                    RelativeLayout.LayoutParams.WRAP_CONTENT);
                            iv[d][k] = new ImageView(getApplicationContext());
                            lp.setMargins(k * cellWidth + p, q + d * cellHeight, 0, 0);
                            iv[d][k].setLayoutParams(lp);
                            draw=draw+1;
                            buttonId = "button" + d + k;
                            charArray[r][t]=buttonId;
                            if(r< 5){
                                r=r+1;
                            }else if(r==5){
                                m=m+1;
                                r=0;
                                t=m;
                            }
                            if (check) {
                                iv[d][k].setImageDrawable(getResources().getDrawable(
                                        R.drawable.bluestone));
                                drawable1 = getDrawable(R.drawable.yellow);
                                body.setBackground(drawable1);
                                z = 0;
                                ((ViewGroup) v).addView(iv[d][k]);
                                check = false;
                            } else {
                                iv[d][k].setImageDrawable(getResources().getDrawable(
                                        R.drawable.yellowstone));
                                z = 1;
                                drawable1 = getDrawable(R.drawable.blue);
                                body.setBackground(drawable1);
                                ((ViewGroup) v).addView(iv[d][k]);
                                check = true;
                            }
                            d = d - 1;

                        } else if ((k == 4) && (e >= 0)) {
                            lp = new RelativeLayout.LayoutParams(
                                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                                    RelativeLayout.LayoutParams.WRAP_CONTENT);
                            iv[e][k] = new ImageView(getApplicationContext());
                            draw=draw+1;
                            lp.setMargins(k * cellWidth + p, q + e * cellHeight, 0, 0);
                            iv[e][k].setLayoutParams(lp);
                            buttonId = "button" + e + k;
                            charArray[r][t]=buttonId;
                            drawable1 = getDrawable(R.drawable.yellow);
                            body.setBackground(drawable1);
                            if(r<5){
                                r=r+1;
                            }else if(r==5){
                                m=m+1;
                                r=0;
                                t=m;
                            }
                            if (check) {
                                iv[e][k].setImageDrawable(getResources().getDrawable(
                                        R.drawable.bluestone));
                                z = 0;
                                ((ViewGroup) v).addView(iv[e][k]);
                                check = false;
                            } else {
                                iv[e][k].setImageDrawable(getResources().getDrawable(
                                        R.drawable.yellowstone));
                                z = 1;
                                drawable1 = getDrawable(R.drawable.blue);
                                body.setBackground(drawable1);
                                ((ViewGroup) v).addView(iv[e][k]);
                                check = true;
                            }
                            e = e - 1;
                        } else if ((k == 5) && (f >= 0)) {
                            lp = new RelativeLayout.LayoutParams(
                                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                                    RelativeLayout.LayoutParams.WRAP_CONTENT);
                            iv[f][k] = new ImageView(getApplicationContext());
                            lp.setMargins(k * cellWidth + p, q + f * cellHeight, 0, 0);
                            iv[f][k].setLayoutParams(lp);
                            draw=draw+1;
                            buttonId = "button" + f + k;
                            charArray[r][t]=buttonId;
                            if(r< 5){
                                r=r+1;
                            }else if(r==5){
                                m=m+1;
                                r=0;
                                t=m;
                            }
                            if (check) {
                                iv[f][k].setImageDrawable(getResources().getDrawable(
                                        R.drawable.bluestone));
                                z = 0;
                                drawable1 = getDrawable(R.drawable.yellow);
                                body.setBackground(drawable1);
                                ((ViewGroup) v).addView(iv[f][k]);
                                check = false;
                            } else {
                                iv[f][k].setImageDrawable(getResources().getDrawable(
                                        R.drawable.yellowstone));
                                z = 1;
                                drawable1 = getDrawable(R.drawable.blue);
                                body.setBackground(drawable1);
                                ((ViewGroup) v).addView(iv[f][k]);
                                check = true;
                            }
                            f = f - 1;
                        } else if ((k == 6) && (g >= 0)) {
                            lp = new RelativeLayout.LayoutParams(
                                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                                    RelativeLayout.LayoutParams.WRAP_CONTENT);
                            iv[g][k] = new ImageView(getApplicationContext());
                            lp.setMargins(k * cellWidth + p, q + g * cellHeight, 0, 0);
                            iv[g][k].setLayoutParams(lp);
                            buttonId = "button" + g + k;
                            draw=draw+1;
                            charArray[r][t]=buttonId;
                            if(r< 5){
                                r=r+1;
                            }else if(r==5){
                                m=m+1;
                                r=0;
                                t=m;
                            }
                            if (check) {
                                iv[g][k].setImageDrawable(getResources().getDrawable(
                                        R.drawable.bluestone));
                                z = 0;
                                drawable1 = getDrawable(R.drawable.yellow);
                                body.setBackground(drawable1);
                                ((ViewGroup) v).addView(iv[g][k]);
                                check = false;
                            } else {
                                iv[g][k].setImageDrawable(getResources().getDrawable(
                                        R.drawable.yellowstone));
                                drawable1 = getDrawable(R.drawable.blue);
                                body.setBackground(drawable1);
                                z = 1;
                                ((ViewGroup) v).addView(iv[g][k]);
                                check = true;
                            }
                            g = g - 1;
                        }


                    }
                }



                for (int i = 5; i >= 0; i--) {
                    for (int j = 0; j < 7; j++) {
                        if (buttonId.equals("button" + i + j)) {

                            if (z == 0) {
                                planeArray[i][j] = 7;


                            } else if (z == 1) {
                                planeArray[i][j] = 8;



                            }
                        }

                    }
                }


                for (int i = 5; i >= 0; i--) {
                    for (int j = 0; j < 4; j++) {
                        if (planeArray[i][j] != 0) {
                            if ((planeArray[i][j] == planeArray[i][j + 1]) && (planeArray[i][j] == planeArray[i][j + 2]) && (planeArray[i][j] == planeArray[i][j + 3])) {
                                Toast.makeText(MainActivity.this, "win", Toast.LENGTH_SHORT).show();

                                reset();
                                update();
                            }
                        }
                    }
                }
                for (int j = 0; j < 7; j++) {
                    for (int i = 5; i > 2; i--) {
                        if (planeArray[i][j] != 0) {
                            if ((planeArray[i][j] == planeArray[i - 1][j]) && (planeArray[i][j] == planeArray[i - 2][j]) && (planeArray[i][j] == planeArray[i - 3][j])) {
                                Toast.makeText(MainActivity.this, "win", Toast.LENGTH_SHORT).show();

                                reset();
                                update();
                            }
                        }
                    }
                }

                for (int i = 5; i > 2; i--) {
                    for (int j = 0; j < 4; j++) {
                        if (planeArray[i][j] != 0) {
                            if ((planeArray[i][j] == planeArray[i - 1][j + 1]) && (planeArray[i][j] == planeArray[i - 2][j + 2]) && (planeArray[i][j] == planeArray[i - 3][j + 3])) {
                                Toast.makeText(MainActivity.this, "win", Toast.LENGTH_SHORT).show();

                                reset();
                                update();
                            }
                        }
                    }
                }

                for (int i = 5; i > 2; i--) {
                    for (int j = 6; j > 2; j--) {
                        if (planeArray[i][j] != 0) {
                            if ((planeArray[i][j] == planeArray[i - 1][j - 1]) && (planeArray[i][j] == planeArray[i - 2][j - 2]) && (planeArray[i][j] == planeArray[i - 3][j - 3])) {
                                Toast.makeText(MainActivity.this, "win", Toast.LENGTH_SHORT).show();
                                reset();
                                update();

                            }
                        }
                    }
                }
           if(draw==63){
    Toast.makeText(MainActivity.this,"Game drawn",Toast.LENGTH_SHORT).show();
}

                return false;
            }

        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1.setText("");
                player2.setText("");
                reset();
            }
        });

    }
    public void reset(){
        drawable1 = getDrawable(R.drawable.background);
        body.setBackground(drawable1);
        for(int i=5;i>=0;i--){
            for(int j=0;j<7;j++){
                if((planeArray[i][j]!=0)){
                    iv[i][j].setImageDrawable (getResources ().getDrawable (
                            R.drawable.empty));
                    draw=0;
                    planeArray[i][j]=0;
                    a=b=c=d=e=f=g=5;

                }
            }
        }
    }
    class SketchSheetView extends View {
        public SketchSheetView(Context context) {
            super(context);
            paint = new Paint();
            paint.setColor (Color.DKGRAY);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw (canvas);
            for (int i = 0; i < (h+2); i++) {
                for (int j = 0; j < (w+1); j++) {
                    canvas.drawLine((i+1) * cellWidth, 600,
                            (i+1) * cellWidth, (j  * cellHeight) + 600,
                            paint);
                    canvas.drawLine(i * cellWidth, (j * cellHeight) + 600,
                            (i + 1) * cellWidth, (j * cellHeight) + 600,
                            paint);

                }
            }
        }
    } private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mmediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mmediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mmediaPlayer = null;
        }
    }
    private void update(){
        if(check){
            score1++;
            player1.setText(Integer.toString(score1));
            check=false;
        }
        else{
            score2++;
            player2.setText(Integer.toString(score2));
            check=true;

        }
    }

}