package com.phongth163965.ex5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EX5BaseAdapter extends BaseAdapter {
    private List<Product> mlist;

    private Context context;

    public EX5BaseAdapter(List<Product> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EX5ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.ex5_item_view,parent,false);
            holder = new EX5ViewHolder();
            holder.img = convertView.findViewById(R.id.ex5_item_view_img);
            holder.id = convertView.findViewById(R.id.ex5_item_view_tvId);
            holder.name = convertView.findViewById(R.id.ex5_item_view_tvName);
            holder.price = convertView.findViewById(R.id.ex5_item_view_tvPrice);
            convertView.setTag(holder);
        }else{
            holder = (EX5ViewHolder) convertView.getTag();
        }
        Product product = mlist.get(position);
        if(product != null){
            holder.img.setImageResource(R.drawable.hancock);
            holder.id.setText(product.getId());
            holder.name.setText(product.getName());
            holder.price.setText(String.valueOf(product.getPrice()));
        }
        return convertView;
    }
    static class EX5ViewHolder{
        ImageView img;
        TextView id, name, price;
    }
}
