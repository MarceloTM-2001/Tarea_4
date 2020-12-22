package com.example.tarea_4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tarea_4.aatree.AATree;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Clase principal de la aplicación
 * @author Marcelo Truque
 */
public class MainActivity extends AppCompatActivity {
    private TextInputLayout textInputInsert;
    private AATree Tree;
    private Button button,reset;

    @Override
    /**
     * Función principal de la aplicación
     * @author Marcelo Truque
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInputInsert = findViewById(R.id.text_input_Key);
        button= findViewById(R.id.Insert_Button);
        reset=findViewById(R.id.Button_reset);
        Tree=new AATree();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert_in_Tree();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    /**
     * Función para que al oprimir el botón se borre el árbol
     * @author Marcelo Truque
     */
    public void ResetTree(){
        this.Tree.clear();
    }

    /**
     * Función para que al estripar el botón insertar, se haga la insersión pertinente en árbol.
     * Además efectúa las vsalidaciónes del dato de entrada
     * @author Marcelo Truque
     */
    public void insert_in_Tree(){
        if (!validate_insertion()){
            return;
        }
        String intinput = textInputInsert.getEditText().getText().toString().trim();
        int Key = Integer.parseInt(intinput);
        Tree.insert(Key);
        Tree.preorden();
    }

    /**
     * Validación que revisa si la entrada es un número entero
     * @return Booleando del cumplimiento de la validación
     * @author Marcelo Truque
     */
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

    /**
     * Validación que revisa si un string contiene un número entero o no
     * @param s String
     * @return Booleano que dice si un número es entero
     * @author Marcelo Truque
     */
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