package com.fauxbunnies.pokedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Miguel on 9/12/2015.
 */
public class CustomAdapter extends ArrayAdapter<ListItem> {

    public CustomAdapter(Context context, int resource) {
        super(context, resource);
    }

    public CustomAdapter(Context context, int resource, List items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.poke_list_item_1, null);
        }

        ListItem item = getItem(position);

        if(item != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.list_item_image);
            TextView textView = (TextView) view.findViewById(R.id.list_item_title);

            if(imageView != null) {
                imageView.setImageDrawable(Manager.getImageFromSrc(item.imageSrc,
                                                                    parent.getContext()));
            }

            if(textView != null) {
                textView.setText(item.title);
            }
        }

        return view;
    }
}
