package com.example.layoutsapp.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.layoutsapp.R;
import com.example.layoutsapp.Utils.Place;

import java.util.List;

public class PlaceAdapter extends BaseAdapter {

    private Context context;
    private List<Place> places;

    public PlaceAdapter(Context context, List<Place> places) {
        this.context = context;
        this.places = places;
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int position) {
        return places.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView;
        if (convertView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item_place, parent, false);
        } else {
            itemView = convertView;
        }

        Place place = places.get(position);

        ImageView imgPlacePhoto = itemView.findViewById(R.id.img_place_photo);

        TextView txtPlaceName = itemView.findViewById(R.id.txt_place_name);
        TextView txtPlaceDistance = itemView.findViewById(R.id.txt_place_distance);
        TextView txtPlaceDescription = itemView.findViewById(R.id.txt_place_description);


        imgPlacePhoto.setImageResource(place.getPhotoId());
        txtPlaceName.setText(place.getName());
        txtPlaceDescription.setText("Descrição genérica");
        txtPlaceDistance.setText(String.format("%.1f KM", place.getDistance()));

        return itemView;
    }
}
