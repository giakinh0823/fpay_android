package fpt.edu.pay.adepter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fpt.edu.pay.fragment.AllCateHistoryFragment;
import fpt.edu.pay.fragment.PhoneCateHistory;

public class HistoryAdapter extends FragmentStateAdapter {


    public HistoryAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public HistoryAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public HistoryAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
            return new AllCateHistoryFragment();
            case 1:
                return new PhoneCateHistory();
            default:
                return  new AllCateHistoryFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }


}
