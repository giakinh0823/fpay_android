package fpt.edu.pay.adepter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpt.edu.pay.R;
import fpt.edu.pay.activity.UserProfileActivity;
import fpt.edu.pay.constant.AccountConstant;
import fpt.edu.pay.model.account.GroupMenuAccount;
import lombok.Getter;
import lombok.Setter;

public class GroupMenuAccountAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<GroupMenuAccount> groupMenuAccounts;
    private Context context;

    private static final int VIEW_TYPE_ACCOUNT_HEADER = 0;
    private static final int VIEW_TYPE_GROUP_ITEM = 1;

    public GroupMenuAccountAdapter(List<GroupMenuAccount> groupMenuAccounts, Context context) {
        this.groupMenuAccounts = groupMenuAccounts;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_ACCOUNT_HEADER;
        } else {
            return VIEW_TYPE_GROUP_ITEM;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == VIEW_TYPE_ACCOUNT_HEADER) {
            View itemView = inflater.inflate(R.layout.common_account_header, parent, false);
            return new CommonAccountHeadHolder(itemView);
        } else {
            View itemView = inflater.inflate(R.layout.common_item_group_recycle_view, parent, false);
            return new GroupMenuAccountViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GroupMenuAccount groupMenuAccount = groupMenuAccounts.get(position);
        if (groupMenuAccount == null) {
            return;
        }
        if (holder instanceof CommonAccountHeadHolder) {
            CommonAccountHeadHolder commonAccountHeadHolder = (CommonAccountHeadHolder) holder;
            commonAccountHeadHolder.imageView.setImageResource(groupMenuAccount.getMenuAccounts().get(0).getImage());
            commonAccountHeadHolder.fullName.setText(groupMenuAccount.getMenuAccounts().get(0).getTitle());
            commonAccountHeadHolder.phoneNumber.setText(groupMenuAccount.getMenuAccounts().get(0).getDesc());

            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, UserProfileActivity.class);
                intent.putExtra("selected_item", groupMenuAccount.getMenuAccounts().get(0).getTitle());
                context.startActivity(intent);
            });
        } else {
            GroupMenuAccountViewHolder groupMenuAccountViewHolder = (GroupMenuAccountViewHolder) holder;
            MenuAccountAdapter menuAccountAdapter = new MenuAccountAdapter(groupMenuAccount.getMenuAccounts(), context);
            groupMenuAccountViewHolder.recyclerView.setAdapter(menuAccountAdapter);
        }

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

        public RecyclerView getRecyclerView() {
            return recyclerView;
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
        }
    }

    @Getter
    @Setter
    public static class CommonAccountHeadHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView fullName;
        private TextView phoneNumber;

        public CommonAccountHeadHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.common_account_header_avatar);
            fullName = itemView.findViewById(R.id.common_account_header_name);
            phoneNumber = itemView.findViewById(R.id.common_account_header_phone_number);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public TextView getFullName() {
            return fullName;
        }

        public void setFullName(TextView fullName) {
            this.fullName = fullName;
        }

        public TextView getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(TextView phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}
