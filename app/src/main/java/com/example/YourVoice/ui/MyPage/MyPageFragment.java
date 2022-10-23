package com.example.YourVoice.ui.MyPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.YourVoice.databinding.FragmentListBinding;
import com.example.YourVoice.databinding.FragmentMypageBinding;

public class MyPageFragment extends Fragment {

    private FragmentMypageBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MyPageViewModel myPageViewModelViewModel =
                new ViewModelProvider(this).get(MyPageViewModel.class);

        binding = FragmentMypageBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMyPage;
        myPageViewModelViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}