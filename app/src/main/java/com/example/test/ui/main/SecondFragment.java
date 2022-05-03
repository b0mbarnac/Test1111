package com.example.test.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.test.R;
import com.example.test.databinding.SecondFragmentBinding;

public class SecondFragment extends Fragment {
    public static SecondFragment newInstance() {
        return new SecondFragment();
    }
    private SecondViewModel sViewModel;
    private SecondFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        sViewModel = new ViewModelProvider(this).get(SecondViewModel.class);
        binding = SecondFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.editText.setText(getResources().getString(R.string.result) + Integer.toString(sViewModel.CheckAnswer()));
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sViewModel.restart();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, MainFragment.newInstance())
                        .commitNow();
            }
        });

    }

}
