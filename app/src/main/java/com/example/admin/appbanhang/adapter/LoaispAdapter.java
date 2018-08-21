package com.example.admin.appbanhang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.appbanhang.R;
import com.example.admin.appbanhang.model.Loaisp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Admin on 5/12/2018.
 */

public class LoaispAdapter extends BaseAdapter {
    ArrayList<Loaisp> arrayListloaisp;
    Context context;

    public LoaispAdapter(ArrayList<Loaisp> arrayListloaisp, Context context) {
        this.arrayListloaisp = arrayListloaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListloaisp.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListloaisp.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHoder{
        TextView txttenloaisp;
        ImageView imageloaisp;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoder viewHoder=null;
        if (view == null){
            viewHoder = new ViewHoder();
            LayoutInflater inflater  = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_listview_loaisp,null);
            viewHoder.txttenloaisp = (TextView) view.findViewById(R.id.textviewloaisp);
            viewHoder.imageloaisp = (ImageView) view.findViewById(R.id.imageviewloaisp);
            view.setTag(viewHoder);

        }else {
            viewHoder = (ViewHoder) view.getTag();
        }
        Loaisp loaisp = (Loaisp) getItem(i);
        viewHoder.txttenloaisp.setText(loaisp.getTenloaisp());
        Picasso.with(context).load(loaisp.getHinhanhloaisp())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHoder.imageloaisp);
        return view;
    }
}
