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
import fpt.edu.pay.model.TransferMoney;

public class TransferBankRecycleAdapter   extends RecyclerView.Adapter<TransferBankRecycleAdapter.TransferBankRecycleHolder>{
    List<TransferMoney> transferMoneyList;
    public TransferBankRecycleAdapter (List<TransferMoney> li) {
        this.transferMoneyList = li;
    }

    @NonNull
    @Override
    public TransferBankRecycleAdapter.TransferBankRecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_transfer_money, parent, false);
        return new TransferBankRecycleAdapter.TransferBankRecycleHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TransferBankRecycleAdapter.TransferBankRecycleHolder holder, int position) {
        holder.img_main.setBackgroundResource(transferMoneyList.get(position).getImg());
        holder.tv_title.setText(transferMoneyList.get(position).getTitle());
        holder.tv_des.setText(transferMoneyList.get(position).getDes());
        holder.img_icon.setBackgroundResource(transferMoneyList.get(position).getIcon());


    }

    @Override
    public int getItemCount() {
        return transferMoneyList.size();
    }

    class TransferBankRecycleHolder extends RecyclerView.ViewHolder {
        ImageView img_main;
        TextView tv_title;
        TextView tv_des;
        ImageView img_icon;

        public TransferBankRecycleHolder(@NonNull View itemView) {
            super(itemView);
            img_main = itemView.findViewById(R.id.img_main);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_des = itemView.findViewById(R.id.tv_des);
            img_icon = itemView.findViewById(R.id.img_icon);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                }
            });

        }
    }
}
