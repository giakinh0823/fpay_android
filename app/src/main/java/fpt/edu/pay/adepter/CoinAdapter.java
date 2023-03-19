package fpt.edu.pay.adepter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.model.coin.Coin;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.CoinHolder>{

    List<Coin> coins;

    public CoinAdapter (List<Coin> li) {
        this.coins = li;
    }

    @NonNull
    @Override
    public CoinHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.coin_item, parent, false);
        return new CoinHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinHolder holder, int position) {
        holder.img.setBackgroundResource(coins.get(position).getImage());
        holder.app.setText(coins.get(position).getName_app());
        holder.discount.setText(coins.get(position).getName_discount());
        holder.max.setText(coins.get(position).getName_max());

    }

    @Override
    public int getItemCount() {
        return coins.size();
    }

    class CoinHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView app;
        TextView discount;
        TextView max;
        public CoinHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_app);
            app = itemView.findViewById(R.id.text_app);
            discount = itemView.findViewById(R.id.text_discount);
            max = itemView.findViewById(R.id.text_max);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                }
            });

        }
    }
}
