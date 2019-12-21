package com.example.swipe_wipepager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model>models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.brochure,"Bronchure", "Brochure is an information paper doucment"));
        models.add(new Model(R.drawable.sticker,"Sticker", "Sticker is a type of label: a piece of printed paper"));
        models.add(new Model(R.drawable.poster,"Poster", "Poster is my place of printed paper of printed paper designed"));
        models.add(new Model(R.drawable.namecard,"NameCard", "Business cards are cards bearing business information"));

        adapter = new Adapter(models,this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1 ),
                getResources().getColor(R.color.color2 ),
                getResources().getColor(R.color.color3 ),
                getResources().getColor(R.color.color4 )
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() -1) && position < (colors.length -1)){
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                        colors[position],
                                        colors[position + 1])
                    );
                }else  {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
