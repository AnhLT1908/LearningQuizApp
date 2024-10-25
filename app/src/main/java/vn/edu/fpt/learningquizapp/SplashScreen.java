package vn.edu.fpt.learningquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity implements Animation.AnimationListener {

    ImageView imageView;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // Tìm ImageView với ID splash_logo từ giao diện
        imageView = findViewById(R.id.splash_logo);
        // Lấy animation từ R.anim.splash_anim ===> gán cho imageView
        animation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.splash_anim);
        // Theo dõi sự kiện của animation qua setAnimationListener
        animation.setAnimationListener(this);
        // Run animation cho imageView
        imageView.startAnimation(animation);

        // Thực hiện tác vụ sau một khoảng thời gian trì hoãn
        Handler handler = new Handler();
        // Trì hoãn tác vụ
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                // Bắt đầu MainActivity
                startActivity(intent);
                // Đóng SplashScreen để user ko quay lại đc
                finish();
            }
        }, 4000); // Thời gian trì hoãn là 4 giây
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
