package com.example.todolist.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todolist.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UnimportantFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UnimportantFragment extends Fragment {

    public UnimportantFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_unimportant, container, false);
    }
}