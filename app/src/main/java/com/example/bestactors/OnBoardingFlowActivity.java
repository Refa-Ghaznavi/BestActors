package com.example.bestactors;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class OnBoardingFlowActivity extends AppCompatActivity {


    ViewPager vpOnBoardingFlow;

    Button btnVisitMain;
    private int pages[];

    SessionManager sessionManager;
    MyPagesAdapter myPagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sessionManager=new SessionManager(OnBoardingFlowActivity.this);

        if (!sessionManager.getIsOnboardingshown())
        {
            launchMainActivity();
        }



        if (Build.VERSION.SDK_INT>21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }


        setContentView(R.layout.activity_on_boarding_flow);

        Log.i("class","I am inside MainPage");
        btnVisitMain=findViewById(R.id.btVisitApp);
        vpOnBoardingFlow=findViewById(R.id.idViewPager);
        pages=new int[]{R.layout.on_boarding_first_page,R.layout.on_boarding_second,R.layout.on_boarding_third};



        myPagesAdapter=new MyPagesAdapter(this);

        vpOnBoardingFlow.setAdapter(myPagesAdapter);



        vpOnBoardingFlow.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {

                if (position==pages.length-1){
                    btnVisitMain.setVisibility(View.VISIBLE);
                }else {
                    btnVisitMain.setVisibility(View.GONE);
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        vpOnBoardingFlow.setCurrentItem(2);
        btnVisitMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sessionManager.setIsOnboardingshown(false);
                launchMainActivity();
            }
        });



    }

    private void launchMainActivity() {
        Intent intent=new Intent(OnBoardingFlowActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }


    public class MyPagesAdapter extends PagerAdapter {

        Context context;

        public MyPagesAdapter(Context context) {

            this.context=context;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            View view= LayoutInflater.from(context).inflate(pages[position],container,false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return pages.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

            View view= (View) object;
            container.removeView(view);
        }
    }
}
