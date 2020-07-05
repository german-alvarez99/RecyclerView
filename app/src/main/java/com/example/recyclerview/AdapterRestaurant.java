package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.Model.Restaurant;

import java.util.List;

public class AdapterRestaurant extends RecyclerView.Adapter<AdapterRestaurant.ViewHolderRestaurant> {

    List<Restaurant> listaRestaurants;

    public AdapterRestaurant(List<Restaurant> listaRestaurants) {
        this.listaRestaurants = listaRestaurants;
    }

    @NonNull
    @Override
    public ViewHolderRestaurant onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlist,null,false);
        return new ViewHolderRestaurant(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRestaurant holder, int position) {
        holder.nombre.setText(listaRestaurants.get(position).getNombre());
        holder.horario.setText(listaRestaurants.get(position).getHorarios());
        holder.telefono.setText(listaRestaurants.get(position).getTelefono());
        holder.direccion.setText(listaRestaurants.get(position).getDireccion());
        holder.categoria.setText(listaRestaurants.get(position).getCategoria());
       Glide.with(holder.itemView)
                .load(listaRestaurants.get(position).getFoto())
                .into(holder.imagen);
    }

    @Override
    public int getItemCount() {
        return listaRestaurants.size();
    }

    public class ViewHolderRestaurant extends RecyclerView.ViewHolder {

        TextView nombre, horario, telefono, direccion,categoria;
        ImageView imagen;
        public ViewHolderRestaurant(@NonNull View itemView) {
            super(itemView);
            nombre=(TextView) itemView.findViewById(R.id.lblNombre);
            horario=(TextView) itemView.findViewById(R.id.lblHorario);
            telefono=(TextView) itemView.findViewById(R.id.lblTelefono);
            direccion=(TextView) itemView.findViewById(R.id.lblDireccion);
            categoria=(TextView) itemView.findViewById(R.id.lblCategoria);
            imagen= (ImageView) itemView.findViewById(R.id.imgRestaurant);
        }
    }
}
