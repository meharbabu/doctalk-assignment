package com.csg.app.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.csg.app.DetailsActivity;
import com.csg.app.R;
import com.csg.app.models.Items;
import com.csg.app.models.Mediator;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>  {

    private List<Items.Item> itemList;
    public ItemsAdapter(List<Items.Item> itemArrayList) {
        this.itemList = itemArrayList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Mediator.getInstance().getMainActivityContext()).inflate(R.layout.list_item_layout, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        try {

            holder.login.setText("Name : " + itemList.get(position).getLogin());
            holder.type.setText("Type :" + itemList.get(position).getType());
            holder.score.setText("Score : " + itemList.get(position).getScore());
            if(itemList.get(position).getAvatarurl() != null && !itemList.get(position).getAvatarurl().isEmpty())
            Picasso.with(Mediator.getInstance().getMainActivityContext()).load(itemList.get(position).getAvatarurl())
                   .resize(200,200).into(holder.imgView);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView login,type,score;
        ImageView imgView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            login = (TextView) itemView.findViewById(R.id.login);
            type = (TextView) itemView.findViewById(R.id.type);
            score = (TextView) itemView.findViewById(R.id.score);
            imgView = (ImageView)itemView.findViewById(R.id.imgView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent detailsIntent = new Intent(Mediator.getInstance().getMainActivityContext(), DetailsActivity.class);
                    detailsIntent.putExtra("position", getAdapterPosition());
                    detailsIntent.putExtra("details", itemList.get(getAdapterPosition()));
                    Mediator.getInstance().getMainActivityContext().startActivity(detailsIntent);
                }
            });
        }
    }
}
