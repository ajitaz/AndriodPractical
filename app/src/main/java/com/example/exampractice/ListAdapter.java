package com.example.exampractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ListData> {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ListData> listData;

  public ListAdapter(@Nullable Context context, @Nullable ArrayList<ListData> listItem){
      super(context, R.layout.list_item_view,listItem);
      this.mContext = context;
      this.mInflater = LayoutInflater.from(mContext);
      this.listData  = listItem;
  }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      ViewHolder viewHolder;
      ListData item = listData.get(position);
      if(convertView == null){
          convertView = mInflater.inflate(R.layout.list_item_view,parent,false);
          viewHolder = new ViewHolder();
          viewHolder.tvName = convertView.findViewById(R.id.tv_name);
          viewHolder.tvAddress = convertView.findViewById(R.id.tv_add);
          convertView.setTag(viewHolder);
      } else {
          viewHolder = (ViewHolder) convertView.getTag();
      }
      viewHolder.tvName.setText(item.getName());
      viewHolder.tvAddress.setText(item.getAddress());

        return convertView;

    }

    @Override
    public int getCount() {
        return listData.size();
    }
}

class ViewHolder{
    public TextView tvName,tvAddress;
}
