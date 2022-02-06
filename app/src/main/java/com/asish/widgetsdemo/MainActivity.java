package com.asish.widgetsdemo;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import java.util.StringJoiner;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;

    private RadioGroup radioGroup;

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

        radioGroup = findViewById(R.id.rg_gender);

        // Button for RadioButton.
        Button btnGender = findViewById(R.id.btn_radiobutton);
        // OnClick Handler for Radio Button.
        btnGender.setOnClickListener(view -> radioButtonHandler());

    }

    /**
     * OnClick Handler implementation for CheckBox Button.
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

    /**
     * OnClick Handler implementation for RadioButton.
     */
    private void radioButtonHandler() {
        // Get the checked radio button ID.
        int radioButtonId = radioGroup.getCheckedRadioButtonId();

        // If radioButtonId = -1. (Means nothing is selected)
        if (radioButtonId == -1) {
            Toast.makeText(this, "Nothing is selected.", Toast.LENGTH_LONG).show();
        } else {
            // Get the selected RadioButton by passing the radioButtonId in the findViewById.
            RadioButton radioButton = findViewById(radioButtonId);
            String gender = radioButton.getText().toString();
            Toast.makeText(this, "You've selected - " + gender, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * This method is used to inflate or display the menu in the UI.
     */
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_example, menu);

        // This condition is used to display Icon in the menu items. (Icon with text in menu)
        if (menu instanceof MenuBuilder) {
            MenuBuilder menuBuilder = (MenuBuilder) menu;
            menuBuilder.setOptionalIconsVisible(true);
        }

        return true;
    }

    /**
     * This method will be called when menu item will be clicked.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_upload) {
            Toast.makeText(getApplicationContext(), "Upload Clicked.", Toast.LENGTH_LONG).show();
            return true;
        } else if (itemId == R.id.menu_download) {
            Toast.makeText(getApplicationContext(), "Download Clicked.", Toast.LENGTH_LONG).show();
            return true;
        } else if (itemId == R.id.menu_share) {
            Toast.makeText(getApplicationContext(), "Share Clicked.", Toast.LENGTH_LONG).show();
            return true;
        } else if (itemId == R.id.menu_save) {
            Toast.makeText(getApplicationContext(), "Save Clicked.", Toast.LENGTH_LONG).show();
            return true;
        } else if (itemId == R.id.menu_mail) {
            Toast.makeText(getApplicationContext(), "Mail Clicked.", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}