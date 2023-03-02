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
import fpt.edu.pay.model.account.MenuAccount;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuAccountAdapter extends RecyclerView.Adapter<MenuAccountAdapter.MenuAccountViewHolder> {
    private List<MenuAccount> menus;

    public MenuAccountAdapter(List<MenuAccount> menus) {
        this.menus = menus;
    }

    @NonNull
    @Override
    public MenuAccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.common_item_recycle_view, parent, false);
        return new MenuAccountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAccountViewHolder holder, int position) {
        MenuAccount menuAccount = menus.get(position);
        if (menuAccount == null) {
            return;
        }
        holder.title.setText(menuAccount.getTitle());
        holder.desc.setText(menuAccount.getDesc());
        holder.image.setImageResource(menuAccount.getImage());
    }

    @Override
    public int getItemCount() {
        if (menus != null) {
            return menus.size();
        }
        return 0;
    }

    @Getter
    @Setter
    public static class MenuAccountViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView title;
        private TextView desc;

        public MenuAccountViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.common_item_recycle_view_image);
            title = (TextView) itemView.findViewById(R.id.common_item_recycle_view_title);
            desc = (TextView) itemView.findViewById(R.id.common_item_recycle_view_desc);
        }
    }
}
