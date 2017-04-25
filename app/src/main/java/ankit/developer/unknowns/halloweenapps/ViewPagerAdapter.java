package ankit.developer.unknowns.halloweenapps;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ankitsharma on 4/25/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {
    Activity activity;
    List<String> images;
    LayoutInflater inflater;

    public ViewPagerAdapter(Activity activity, List<String> images) {
        this.activity = activity;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override

    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item,container,false);
        final ImageView img;
        img = (ImageView)itemView.findViewById(R.id.imageView);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        img.setMinimumWidth(width);
        img.setMinimumHeight(height);
        try{
            int imageId = activity.getResources().getIdentifier(images.get(position),"mipmap",activity.getPackageName());
            Picasso.with(activity.getApplicationContext())
                    .load(imageId)
                    .into(img);
        }
        catch (Exception ex){
        }
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }
}
