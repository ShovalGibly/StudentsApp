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


public class EditStudentFragment extends Fragment {



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment

            View view = inflater.inflate(R.layout.fragment_edit_student, container, false);

            String stId = EditStudentFragmentArgs.fromBundle(getArguments()).getStudentid();
            Student student = Model.instance.getStudentById(stId);

            EditText nameEt = view.findViewById(R.id.edit_name_et);
            EditText idEt = view.findViewById(R.id.edit_id_et);
            EditText addressEt = view.findViewById(R.id.edit_address_et);
            EditText phoneEt = view.findViewById(R.id.edit_phone_et);
            CheckBox cb = view.findViewById(R.id.edit_cb);
            Button saveBtn = view.findViewById(R.id.edit_save_btn);
            Button cancelBtn = view.findViewById(R.id.edit_cancel_btn);
            Button deleteBtn = view.findViewById(R.id.edit_delete_btn);

            nameEt.setText(student.getName());
            idEt.setText(student.getId());
            addressEt.setText(student.getAddress());
            phoneEt.setText(student.getPhone());
            cb.setChecked(student.isFlag());

            saveBtn.setOnClickListener((v)->{
                student.setName(nameEt.getText().toString());
                student.setId(idEt.getText().toString());
                student.setAddress(addressEt.getText().toString());
                student.setPhone(phoneEt.getText().toString());
                student.setFlag(cb.isChecked());
                Navigation.findNavController(v).navigate(EditStudentFragmentDirections.actionEditStudentFragmentToStudentListFragment(student.id));
            });

            cancelBtn.setOnClickListener((v)->{
                Navigation.findNavController(v).navigateUp();
            });

            deleteBtn.setOnClickListener((v)->{
                Model.instance.RemoveStudent(student);
                Navigation.findNavController(v).navigate(EditStudentFragmentDirections.actionEditStudentFragmentToStudentListFragment(student.id));
            });


            return view;
        }
    }