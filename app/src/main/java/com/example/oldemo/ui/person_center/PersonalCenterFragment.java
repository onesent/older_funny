package com.example.oldemo.ui.person_center;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.oldemo.R;

public class PersonalCenterFragment extends Fragment {

    private PersonalCenterViewModel personalcenterViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        personalcenterViewModel =
                ViewModelProviders.of(this).get(PersonalCenterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_personal_center, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        personalcenterViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}