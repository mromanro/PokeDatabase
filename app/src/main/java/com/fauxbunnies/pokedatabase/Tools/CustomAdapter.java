package com.fauxbunnies.pokedatabase.Tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fauxbunnies.pokedatabase.R;

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

            if(item instanceof Card) {
                Card card = (Card) item;
                ImageView isEX = (ImageView) view.findViewById(R.id.isEX_image);
                System.out.println("IS EX: " + Card.isEX);

                if(card.isEX == true) {
                    isEX.setImageDrawable(Manager.getImageFromSrc("Pokemon/Pokemon_EX.png",
                                                                    parent.getContext()));
                }
            }
        }

        return view;
    }
}
