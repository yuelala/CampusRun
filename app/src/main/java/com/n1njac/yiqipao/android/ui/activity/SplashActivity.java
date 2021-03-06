package com.n1njac.yiqipao.android.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.n1njac.yiqipao.android.R;
import com.n1njac.yiqipao.android.bmobObject.UserInfoBmob;
import com.n1njac.yiqipao.android.login.NewLoginActivity;

import butterknife.ButterKnife;
import cn.bmob.v3.BmobUser;

/**
 * Created by huanglei on 2017/2/14.
 */

public class SplashActivity extends Activity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    Handler handler = new Handler();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        ButterKnife.bind(this);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                UserInfoBmob userInfoBmob = BmobUser.getCurrentUser(UserInfoBmob.class);
                if (userInfoBmob != null) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, NewLoginActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, 1500);

//        splashVv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.guide_1));
//        splashVv.start();
//        splashVv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                splashVv.start();
//            }
//        });
//
//        splashVv.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.i(TAG,"clicked");
//                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                startActivity(intent);
//
//
//                return true;
//            }
//        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);

        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
