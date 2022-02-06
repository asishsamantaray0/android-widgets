package com.asish.widgetsdemo;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.StringJoiner;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);

        // Button for CheckBox.
        Button btnCheckBox = findViewById(R.id.btn_checkbox);
        // OnClick Handler for CheckBox Button.
        btnCheckBox.setOnClickListener((view -> checkBoxButtonHandler()));

    }

    /**
     * OnClick Handler for CheckBox Button.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void checkBoxButtonHandler() {
        // StringJoiner class (Java 8) is used to Join Strings based the delimiter provided in the Constructor.
        StringJoiner joiner = new StringJoiner(", ");

        if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()) {
            if (checkBox1.isChecked()) {
                joiner.add(checkBox1.getText());
            }
            if (checkBox2.isChecked()) {
                joiner.add(checkBox2.getText());
            }
            if (checkBox3.isChecked()) {
                joiner.add(checkBox3.getText());
            }
            Toast.makeText(this, "Checked - " + joiner, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Please Select any Check Box.", Toast.LENGTH_LONG).show();
        }
    }
}