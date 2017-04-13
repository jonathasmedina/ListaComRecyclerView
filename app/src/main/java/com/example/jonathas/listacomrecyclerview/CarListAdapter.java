package com.example.jonathas.listacomrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jonathas on 13/04/2017.
 */

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.ViewHolder> {

    private List<Car> cars;
    private Context context;
    private OnDataSelected  onDataSelected;

    public CarListAdapter(Context context, OnDataSelected onDataSelected, List<Car> cars) {
        this.context = context;
        this.onDataSelected = onDataSelected;
        this.cars = cars;
    }

    @Override
    public CarListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_itens, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.textViewTitleCar.setText(car.getName());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static interface OnDataSelected {

        public void onDataSelected(View view, int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewTitleCar;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    treatOnDataSelectedIfNecessary(v,getAdapterPosition());
                }
            });

            textViewTitleCar = (TextView)view.findViewById(R.id.info_text);
        }
    }

    private void treatOnDataSelectedIfNecessary(View view, int position) {
        if(onDataSelected != null) {
            onDataSelected.onDataSelected(view, position);
        }
    }
}