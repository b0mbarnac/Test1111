package com.example.test.ui.main;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.R;
import com.example.test.databinding.MainFragmentBinding;

import java.util.Locale;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private MainFragmentBinding binding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MainFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mViewModel.setQuestion();


        binding.button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mViewModel.addScore(binding.message.getText().toString());
                if (mViewModel.getRound() < 5) {
                    mViewModel.setQuestion();

                }else{
                    getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, SecondFragment.newInstance())
                        .commitNow();
                }
                binding.message.getText();
                binding.message.setText("");
            }
        });

        binding.buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                HelpDialog dialogFragment = new HelpDialog();
                dialogFragment.show(manager, "myDialog");
            }
        });

        // TODO: Use the ViewModel
        mViewModel.question.observe(this.getViewLifecycleOwner(), value -> {
            binding.textView.setText(String.format(Locale.getDefault(), "%s", value));
        });
    }
}