package com.example.app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class StudentDetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_details, container, false);

        String stId = StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudentid();
        Student student = Model.instance.getStudentById(stId);

        TextView nameTv = view.findViewById(R.id.details_name_tv);
        TextView idTv = view.findViewById(R.id.details_id_tv);
        TextView addressTv = view.findViewById(R.id.details_address_tv);
        TextView phoneTv = view.findViewById(R.id.details_phone_tv);
        CheckBox cb = view.findViewById(R.id.details_cb);
        Button editBtn = view.findViewById(R.id.details_btn_edit);


        nameTv.setText(student.getName());
        idTv.setText(student.getId());
        nameTv.setText(student.getName());
        idTv.setText(student.getId());
        addressTv.setText(student.getAddress());
        phoneTv.setText(student.getPhone());
        cb.setChecked(student.isFlag());


        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(StudentDetailsFragmentDirections.actionStudentDetailsFragmentToEditStudentFragment(stId));
            }
        });

        return view;
    }
}