package fpt.edu.pay.adepter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.model.GroupMenuAccount;
import lombok.Getter;
import lombok.Setter;

public class GroupMenuAccountAdapter extends RecyclerView.Adapter<GroupMenuAccountAdapter.GroupMenuAccountViewHolder> {

    private List<GroupMenuAccount> groupMenuAccounts;

    public GroupMenuAccountAdapter(List<GroupMenuAccount> groupMenuAccounts) {
        this.groupMenuAccounts = groupMenuAccounts;
    }

    @NonNull
    @Override
    public GroupMenuAccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.common_item_group_recycle_view, parent, false);
        return new GroupMenuAccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupMenuAccountViewHolder holder, int position) {
        GroupMenuAccount groupMenuAccount = groupMenuAccounts.get(position);
        if (groupMenuAccount == null) {
            return;
        }
        MenuAccountAdapter menuAccountAdapter = new MenuAccountAdapter(groupMenuAccount.getMenuAccounts());
        holder.recyclerView.setAdapter(menuAccountAdapter);
    }

    @Override
    public int getItemCount() {
        if(groupMenuAccounts != null){
            return groupMenuAccounts.size();
        }
        return 0;
    }

    @Getter
    @Setter
    public static class GroupMenuAccountViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;

        public GroupMenuAccountViewHolder(@NonNull View itemView) {
            super(itemView);
                recyclerView = itemView.findViewById(R.id.common_item_group_recycle_view);
        }
    }
}
