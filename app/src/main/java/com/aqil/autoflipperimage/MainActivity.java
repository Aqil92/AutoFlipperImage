package com.aqil.autoflipperimage;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import com.sevenrocks.imagflipper.FlipperLayout;
import com.sevenrocks.imagflipper.FlipperView;

public class MainActivity extends AppCompatActivity {

    FlipperLayout flipperLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipperLayout = findViewById(R.id.flipper_layout);

        setLayout();
    }

    private void setLayout() {
       final String url[] = new String[]{
                "http://inventory.sevenrocks.in/files/Product/1/img.jpg?1535697304",
                "http://inventory.sevenrocks.in/files/Product/1/img_1.jpg?1535697304",
                "http://inventory.sevenrocks.in/files/Product/1/img_2.jpg?1535697304",
                "http://inventory.sevenrocks.in/files/Product/1/img_2.jpg?1535697304",
                "http://inventory.sevenrocks.in/files/Product/2/img.jpg?1535697364",
                "http://inventory.sevenrocks.in/files/Product/2/img.jpeg?1535697365",
                "http://inventory.sevenrocks.in/files/Product/2/img_1.jpeg?1535697365",
        };


        for (int i = 0; i < 6; i++) {
            FlipperView view = new FlipperView(getBaseContext());

            view.setImageUrl(url[i])
                    .setDescription("Cool" + (i + 1));
            view.setId(i);
            flipperLayout.addFlipperView(view);

            view.setOnFlipperClickListener(new FlipperView.OnFlipperClickListener() {
                @Override
                public void onFlipperClick(FlipperView flipperView) {

                    Toast.makeText(MainActivity.this
                            , "Here " + (flipperView.getId())
                            , Toast.LENGTH_SHORT).show();

                }
            });


        }

        //you can set current item by its postsition
      //  flipperLayout.setCurrentPage(2);
    }
}
