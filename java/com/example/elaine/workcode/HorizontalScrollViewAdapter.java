package com.example.elaine.workcode;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
/**
 * Created by Elaine on 2016/10/10.
 */
import java.util.ArrayList;

import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

public class HorizontalScrollViewAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<String> mDatas;
    private int mScreenWitdh;
    private static int ONESCREENNUM = 2;


    public HorizontalScrollViewAdapter(Context context, ArrayList<String> mDatas) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mDatas = mDatas;

    }

    public int getCount() {
        return mDatas.size();
    }

    public Object getItem(int position) {
        return mDatas.get(position);
    }

    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(
                    R.layout.activity_index_gallery_item, parent, false);
            convertView.setMinimumWidth(
                    ((WindowManager)mContext
                            .getSystemService(Context.WINDOW_SERVICE))
                            .getDefaultDisplay().getWidth()/ONESCREENNUM);
            viewHolder.mText = (TextView) convertView
                    .findViewById(R.id.gallery_item);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        System.out.println(position);
        if ("1024".equals(mDatas.get(position))) {
            viewHolder.mText.setText("ND 1000");
        } else if ("2048".equals(mDatas.get(position))) {
            viewHolder.mText.setText("ND 2000");
        } else {
            viewHolder.mText.setText("ND " + mDatas.get(position));
        }
        return convertView;
    }

    private class ViewHolder {
        TextView mText;
    }

}
