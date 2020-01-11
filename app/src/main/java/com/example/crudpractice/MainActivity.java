package com.example.crudpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nametxt, emailtxt, cnametxt;
    Function fun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fun = new Function(this);
    }


    public void addRecord(View view) {
        nametxt = findViewById(R.id.name);
        emailtxt = findViewById(R.id.email);
        cnametxt = findViewById(R.id.cname);

        String name = nametxt.getText().toString();
        String email = emailtxt.getText().toString();
        String cname = cnametxt.getText().toString();

        if (name.isEmpty() || email.isEmpty() || cname.isEmpty()) {
            Toast.makeText(this, "Please Fill all the Fields", Toast.LENGTH_SHORT).show();
        } else {
            long retid = fun.insertData(name, email, cname);
            if (retid > 0) {
                Toast.makeText(this, "Insertation is Success ful ", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Insertation is Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void viewdata_new(View view) {
        String data = fun.viewData();
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    public void updaterec(View view) {
        EditText editId, editName;
        editId = findViewById(R.id.editId);
        editName = findViewById(R.id.edit_name);
        String id = editId.getText().toString();
        String name = editName.getText().toString();

        if (id.isEmpty() || name.isEmpty()) {
            Toast.makeText(this, "Please Id and the Name", Toast.LENGTH_SHORT).show();
        } else {
            long retid = fun.edit(id, name);
            if (retid >= 1) {
                Toast.makeText(this, "Update Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Update failed !", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void delrec(View view) {
        EditText del_id;
        del_id = findViewById(R.id.del_id);
        String data = del_id.getText().toString();
        if (data.isEmpty()) {
            Toast.makeText(this, "Please enter the Id", Toast.LENGTH_SHORT).show();
        } else {
            int retid = fun.delete(data);
            if (retid >= 1) {
                Toast.makeText(this, "Your data is deleted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No such record exist in the data base", Toast.LENGTH_SHORT).show();
            }
        }

    }

}
