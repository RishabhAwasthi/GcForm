package com.gadgetscure.gadgetscureform;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by ROHIT on 30-03-2018.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(250, 250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(26, 26, 26, 26);
            imageView.setBackgroundDrawable(new Border(0xff00ff00, 10));
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.invoice, R.drawable.info,
            R.drawable.history, R.drawable.pay,

    };
    public class Border
  extends android.graphics.drawable.Drawable
  {
           public android.graphics.Paint paint;
            public android.graphics.Rect bounds_rect;
           public Border(int colour, int width)
           {
              this.paint = new android.graphics.Paint();
             this.paint.setColor(colour);
             this.paint.setStrokeWidth(width);
             this.paint.setStyle(android.graphics.Paint.Style.STROKE);
           }

           @Override
           public void onBoundsChange(android.graphics.Rect bounds)
           {
             this.bounds_rect = bounds;
           }

           public void draw(android.graphics.Canvas c)
           {
             c.drawRect(this.bounds_rect, this.paint);
           }

           public void setAlpha(int a)
           {
             // TODO: Implement this method
          }

           public void setColorFilter(android.graphics.ColorFilter cf)
          {
             // TODO: Implement this method
           }

           public int getOpacity()
           {
            // TODO: Implement this method
                 return 0;
              }
         }
}