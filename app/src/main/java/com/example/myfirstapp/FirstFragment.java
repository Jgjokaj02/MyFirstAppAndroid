package com.example.myfirstapp;
import static android.util.Log.*;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myfirstapp.databinding.FragmentFirstBinding;


//import com.example.myfirstapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {


    private FragmentFirstBinding binding;
    Integer counter = 0;
    TextView showCountTextView;

    View fragmentFirstLayout;
    public void countMe(View view){
        String countString = showCountTextView.getText().toString();
        counter = Integer.parseInt(countString);
        counter++;
        showCountTextView.setText(counter.toString());
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        View fragmentFirstLayout = binding.getRoot();
        // Get the count text view
        showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);

        return fragmentFirstLayout;
    }




    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast myToast = Toast.makeText(getActivity(), "Hello toast!", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });


        view.findViewById(R.id.count_button_text).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //showCountTextView.findViewById(R.id.textview_first);
                countMe(view);
            }
        });


        binding.randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}