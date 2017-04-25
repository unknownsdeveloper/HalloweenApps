package ankit.developer.unknowns.halloweenapps;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankitsharma on 4/25/2017.
 *
 */

public class HalloweenFoodIdeas extends AppCompatActivity implements View.OnClickListener  {
    List<String> lstSource = new ArrayList<String>();
    ViewPager pager;
    Button btnPre,btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.DarkTheme);
        setContentView(R.layout.activity_halloween_food_ideas);
        loadImageSource();
        pager=(ViewPager)findViewById(R.id.pager);
        ViewPagerAdapter adapter=  new ViewPagerAdapter(this,lstSource);
        pager.setAdapter(adapter);
        btnPre = (Button)findViewById(R.id.btnPre);
        btnNext = (Button)findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
        btnPre.setOnClickListener(this);
    }



    private void loadImageSource() {
        for(int i=1;i<=76;i++){
            String str;
            str="ic_launcher";
            lstSource.add(str);
        }
    }



    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnPre){
            if(pager.getCurrentItem() == 0)
                pager.setCurrentItem(lstSource.size(),true);
            else
                pager.setCurrentItem(getItem(-1),true);
        }
        else if(v.getId() == R.id.btnNext){
            if(pager.getCurrentItem() == lstSource.size()-1)
                pager.setCurrentItem(0,true);
            else
                pager.setCurrentItem(getItem(1),true);
        }
    }

    private int getItem(int i) {
        return pager.getCurrentItem()+i;
    }
}
