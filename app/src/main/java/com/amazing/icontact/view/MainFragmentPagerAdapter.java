package com.amazing.icontact.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MainFragmentPagerAdapter extends FragmentStateAdapter {

    public MainFragmentPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return RecordsFragment.newInstance(1);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
