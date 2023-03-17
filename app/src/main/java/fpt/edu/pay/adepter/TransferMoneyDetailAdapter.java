package fpt.edu.pay.adepter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.model.Money;

public class TransferMoneyDetailAdapter extends RecyclerView.Adapter<TransferMoneyDetailAdapter.TransferMoneyDetailHolder>{
    List<Money> moneyList;
    public TransferMoneyDetailAdapter (List<Money> li) {
        this.moneyList = li;
    }

    @NonNull
    @Override
    public TransferMoneyDetailAdapter.TransferMoneyDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_transfer_money_detail, parent, false);
        return new TransferMoneyDetailAdapter.TransferMoneyDetailHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TransferMoneyDetailAdapter.TransferMoneyDetailHolder holder, int position) {
        holder.tv_name.setText(moneyList.get(position).getFriendName());
        holder.tv_number.setText(moneyList.get(position).getNumberPhone());


    }

    @Override
    public int getItemCount() {
        return moneyList.size();
    }

    class TransferMoneyDetailHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_number;

        public TransferMoneyDetailHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_number = itemView.findViewById(R.id.tv_number);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                }
            });

        }
    }
}
