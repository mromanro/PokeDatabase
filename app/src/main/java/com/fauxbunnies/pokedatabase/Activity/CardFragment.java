package com.fauxbunnies.pokedatabase.Activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fauxbunnies.pokedatabase.Tools.Manager;
import com.fauxbunnies.pokedatabase.R;

/**
 * Created by Miguel on 9/7/2015.
 */
public class CardFragment extends Fragment {

    private ImageView imageView;
    private String title;
    private String imgSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_layout, container, false);

        imageView = (ImageView) view.findViewById(R.id.imageView);

        Bundle bundle = getArguments();
        title = bundle.getString("Title");
        imgSource = bundle.getString("ImageSource");


        if(!imgSource.isEmpty()) {
            imageView.setImageDrawable(Manager.getImageFromSrc(imgSource, inflater.getContext()));
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {


        super.onActivityCreated(savedInstanceState);
    }

}
