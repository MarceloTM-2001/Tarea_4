package com.example.tarea_4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tarea_4.aatree.AATree;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout textInputInsert;
    private AATree Tree;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInputInsert = findViewById(R.id.text_input_Key);
        button= findViewById(R.id.Insert_Button);
        Tree=new AATree();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert_in_Tree();
            }
        });
    }
    public void insert_in_Tree(){
        if (!validate_insertion()){
            return;
        }
        String intinput = textInputInsert.getEditText().getText().toString().trim();
        int Key = Integer.parseInt(intinput);
        Tree.insert(Key);
        Tree.preorden();
    }
    public boolean validate_insertion(){
        String intinput = textInputInsert.getEditText().getText().toString().trim();

        if (intinput.isEmpty()){
            textInputInsert.setError("Debe de insertarse un número entero");
            return false;
        } else if(!isInteger(intinput)){
            textInputInsert.setError("Debe de insertarse un número entero");
            return false;
        }else{
            textInputInsert.setError(null);
        }
        return true;
    }
    public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try{
            Integer.parseInt(s);
            // s is a valid integer
            isValidInteger = true;
        } catch (NumberFormatException ex) {
            // s is not an integer
        }
        return isValidInteger;
    }
}