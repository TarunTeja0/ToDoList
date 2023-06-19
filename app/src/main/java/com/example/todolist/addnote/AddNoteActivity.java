package com.example.todolist.addnote;

import static com.example.todolist.MyApp.appContext;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todolist.MainActivity;
import com.example.todolist.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextImp,editTextTitle, editTextContent;
    private Button buttonSave;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
    
        editTextImp = findViewById(R.id.editTextImp);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });

    }

    private void saveNote() {
        String important = editTextImp.getText().toString();
        String title = editTextTitle.getText().toString();
        String content = editTextContent.getText().toString();

        // Create a new file name for the note using a timestamp or any unique identifier
        String fileName = generateFileName();

        // Save the note to internal storage
        saveToFile(important, fileName, title, content);

        // Finish the activity and return to the previous screen
        finish();

    }

    private void saveToFile(String important, String fileName, String title, String content) {
        try {
            // Create a new file in the app's internal storage directory
            File file = new File(appContext.getFilesDir(), fileName);

            // Write the note data to the file
            FileWriter writer = new FileWriter(file);
            writer.append(important).append("\n");
            writer.append("Title: ").append(title).append("\n");
            writer.append("Content: ").append(content);
            writer.flush();
            writer.close();

//      Debugging the file content;
//            FileReader fileReader =new FileReader(file);
//            BufferedReader br = new BufferedReader(fileReader);
//            String line;
//            while((line=br.readLine()) != null){
//                Log.d("file", line);
//            }


            // Show a Toast message indicating the note has been saved
            Toast.makeText(this, "Note saved successfully", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            // Show a Toast message indicating the note couldn't be saved
            Toast.makeText(this, "Failed to save note", Toast.LENGTH_SHORT).show();
        }

    }

    private String generateFileName() {
        // Generate a unique file name for the note using a timestamp or any unique identifier
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        String timestamp = dateFormat.format(new Date());
        return "note_" + timestamp + ".txt";
    }
}