package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PlanetAdapter extends ArrayAdapter<Planet> {
    public PlanetAdapter(Context context, List<Planet> planets) {
        super(context, 0, planets);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.template_item, parent, false);
        }

        ImageView img = convertView.findViewById(R.id.imgPlanet);
        TextView name = convertView.findViewById(R.id.namePlanet);

        Planet planet = getItem(position);

        if(planet != null) {
            img.setImageResource(planet.image);
            name.setText(planet.name);
        }

        return convertView;
    }
}
