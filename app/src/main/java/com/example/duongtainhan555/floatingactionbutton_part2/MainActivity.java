package com.example.duongtainhan555.floatingactionbutton_part2;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fab_app, fab_facebook, fab_chrome,fab_twitch, fab_skype;
    private Animation move_left, move_right, move_top, move_bottom;
    private boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Anh xa
        Init();
        //CreateAnimation
        CreateAnimation();
        //EventClick
        fab_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(status)
                {
                    MoveLeft(move_left);
                    MoveRight(move_right);
                    MoveTop(move_top);
                    MoveBottom(move_bottom);
                    status = false;
                }
                else
                {
                    MoveRight(move_left);
                    MoveLeft(move_right);
                    MoveTop(move_bottom);
                    MoveBottom(move_top);
                    status = true;
                }

            }
        });
        fab_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You selected Facebook!",Toast.LENGTH_SHORT).show();
            }
        });
        fab_chrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You selected Chrome!",Toast.LENGTH_SHORT).show();
            }
        });
        fab_twitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You selected Twitch!",Toast.LENGTH_SHORT).show();
            }
        });
        fab_skype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You selected Skype!",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Init()
    {
        fab_app = findViewById(R.id.fap_app);
        fab_facebook = findViewById(R.id.fab_facebook);
        fab_chrome = findViewById(R.id.fab_chrome);
        fab_skype = findViewById(R.id.fab_skype);
        fab_twitch = findViewById(R.id.fab_twitch);
    }
    private void CreateAnimation()
    {
        move_left = AnimationUtils.loadAnimation(this,R.anim.move_left);
        move_right = AnimationUtils.loadAnimation(this,R.anim.move_right);
        move_top = AnimationUtils.loadAnimation(this,R.anim.move_top);
        move_bottom = AnimationUtils.loadAnimation(this,R.anim.move_bottom);
    }
    private void MoveLeft(Animation animation)
    {
        if(status)
        {
            FrameLayout.LayoutParams params_left = (FrameLayout.LayoutParams) fab_facebook.getLayoutParams();
            params_left.rightMargin = (int)(fab_facebook.getWidth()*1.7);
            fab_facebook.setLayoutParams(params_left);
            fab_facebook.startAnimation(animation);
        }
        else
        {
            FrameLayout.LayoutParams params_left = (FrameLayout.LayoutParams) fab_facebook.getLayoutParams();
            params_left.rightMargin -= (int)(fab_facebook.getWidth()*1.7);
            fab_facebook.setLayoutParams(params_left);
            fab_facebook.startAnimation(animation);
        }
    }
    private void MoveRight(Animation animation)
    {
        if(status)
        {
            FrameLayout.LayoutParams params_right = (FrameLayout.LayoutParams) fab_chrome.getLayoutParams();
            params_right.leftMargin = (int)(fab_chrome.getWidth()*1.7);
            fab_chrome.setLayoutParams(params_right);
            fab_chrome.startAnimation(animation);
        }
        else
        {
            FrameLayout.LayoutParams params_right = (FrameLayout.LayoutParams) fab_chrome.getLayoutParams();
            params_right.leftMargin -= (int)(fab_chrome.getWidth()*1.7);
            fab_chrome.setLayoutParams(params_right);
            fab_chrome.startAnimation(animation);
        }
    }
    private void MoveTop(Animation animation)
    {
        if(status)
        {
            FrameLayout.LayoutParams params_top = (FrameLayout.LayoutParams) fab_twitch.getLayoutParams();
            params_top.bottomMargin = (int)(fab_twitch.getWidth()*1.7);
            fab_twitch.setLayoutParams(params_top);
            fab_twitch.startAnimation(animation);
        }
        else
        {
            FrameLayout.LayoutParams params_top = (FrameLayout.LayoutParams) fab_twitch.getLayoutParams();
            params_top.bottomMargin -= (int)(fab_twitch.getWidth()*1.7);
            fab_twitch.setLayoutParams(params_top);
            fab_twitch.startAnimation(animation);
        }

    }
    private void MoveBottom(Animation animation)
    {
        if(status)
        {
            FrameLayout.LayoutParams params_bottom = (FrameLayout.LayoutParams) fab_skype.getLayoutParams();
            params_bottom.topMargin = (int)(fab_skype.getWidth()*1.7);
            fab_skype.setLayoutParams(params_bottom);
            fab_skype.startAnimation(animation);
        }
        else
        {
            FrameLayout.LayoutParams params_bottom = (FrameLayout.LayoutParams) fab_skype.getLayoutParams();
            params_bottom.topMargin -= (int)(fab_skype.getWidth()*1.7);
            fab_skype.setLayoutParams(params_bottom);
            fab_skype.startAnimation(animation);
        }
    }

}
