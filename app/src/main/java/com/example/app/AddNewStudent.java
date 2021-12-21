package com.example.app;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.app.Model;
import com.example.app.Student;


public class AddNewStudent extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_new_student, container, false);

        EditText nameEt = view.findViewById(R.id.edit_name_et);
        EditText idEt = view.findViewById(R.id.edit_id_et);
        EditText addressEt = view.findViewById(R.id.edit_address_et);
        EditText phoneEt = view.findViewById(R.id.new_phone_et);
        CheckBox cb = view.findViewById(R.id.edit_cb);
        Button saveBtn = view.findViewById(R.id.edit_save_btn);
        Button cancelBtn = view.findViewById(R.id.edit_cancel_btn);

        saveBtn.setOnClickListener((v)->{
            Student student = new Student();
            student.setName(nameEt.getText().toString());
            student.setId(idEt.getText().toString());
            student.setAddress(addressEt.getText().toString());
            student.setPhone(phoneEt.getText().toString());
            student.setFlag(cb.isChecked());
            Model.instance.addStudent(student);
            Navigation.findNavController(v).navigateUp();
        });

        cancelBtn.setOnClickListener((v)->{
            Navigation.findNavController(v).navigateUp();
        });

        return view;
    }

}