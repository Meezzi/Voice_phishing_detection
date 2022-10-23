package com.example.YourVoice.ui.CallLog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.YourVoice.databinding.FragmentCalllogBinding;

public class CallLogFragment extends Fragment {

    private FragmentCalllogBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CallLogViewModel callLogViewModel =
                new ViewModelProvider(this).get(CallLogViewModel.class);

        binding = FragmentCalllogBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCallLog;
        callLogViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}