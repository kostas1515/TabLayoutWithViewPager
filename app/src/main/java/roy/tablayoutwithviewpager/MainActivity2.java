package roy.tablayoutwithviewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {
    ViewPager  pager;
    TabLayout tabLayout;

    TextView bac;


    SeekBar custom_vol;
    SeekBar custom_alc;
    SessionManager session;
    CustomFragment fragment_custom;
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        session = new SessionManager(getApplicationContext());


        pager= (ViewPager) findViewById(R.id.view_pager);
        tabLayout= (TabLayout) findViewById(R.id.tab_layout);
        bac=(TextView) findViewById(R.id.BAC_calculator);
        custom_vol = (SeekBar) findViewById(R.id.seekBarPosotita);
        custom_alc = (SeekBar) findViewById(R.id.seekBarAlcohol);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               goback();
            }
        });

        FragmentManager manager=getSupportFragmentManager();

        //fragment.specific_function_name();
        PagerAdapter adapter=new PagerAdapter(manager);
        pager.setAdapter(adapter);


        tabLayout.setupWithViewPager(pager);
        // mTabLayout.setupWithViewPager(mPager1);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        fragment_custom = (CustomFragment) manager.findFragmentById(R.id.fragment_custom);
        tabLayout.setTabsFromPagerAdapter(adapter);

    }

   private void goback(){ startActivity(new Intent(this, MainActivity.class));}


    //public void set(View view) {
    //    bac.setText("pressed");
   // }

    public void set_wine(View view) {
        session.alcoholInGrams(350);
        bac.setText(Float.toString(session.getterRealAlcohol()));
    }

    public void Apotelesma (String text){
        bac.setText(text);
    }




}

