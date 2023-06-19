package com.example.todolist.fragment;

import static com.example.todolist.MyApp.appContext;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todolist.CommonRecyclerViewAdapter;
import com.example.todolist.R;
import com.example.todolist.modelnote.Note;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ImportantFragment extends Fragment {
  private RecyclerView recyclerView;
  public static ArrayList<Note> notes;


  public ImportantFragment(){
  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_important, container, false);
      notes = new ArrayList<>();
      recyclerView = view.findViewById(R.id.imp_recyclerView);
      readNoteFiles();

      recyclerView = view.findViewById(R.id.imp_recyclerView);
      CommonRecyclerViewAdapter crva = new CommonRecyclerViewAdapter(requireContext(), notes);
      recyclerView.setAdapter(crva);
      crva.notifyDataSetChanged();
      recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
      return view;
    }




  private void readNoteFiles() {
//    try {
//
//      File file = new File(appContext.getFilesDir(), "fileName");
//
//      // Write the note data to the file
//      FileWriter writer = new FileWriter(file);
//      writer.append("important").append("\n");
//      writer.append("Title: ").append("\n");
//      writer.append("Content: ");
//      writer.flush();
//      writer.close();
//      readFile(file);
//    }
//    catch (Exception e){

//    }
    File directory = appContext.getFilesDir();
    File[] files = directory.listFiles();
    Log.d("file",String.valueOf(files.length));
    if (files != null) {
      for (File file : files) {
        if (file.isFile() && file.getName().startsWith("imp")) {
          readFile( file);
        }
      }
    }
  }

  public void readFile(File filee){
    Note note = new Note();
    try {
      File file = new File(appContext.getFilesDir(),filee.getName()); // Replace "example.txt" with your file name
      FileInputStream fis = new FileInputStream(file);
      BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

      StringBuilder stringBuilder = new StringBuilder();
      String line;
      String content = "";
      int count=0;
      while ((line = reader.readLine()) != null) {
        if(line.startsWith("imp") && count==0){
          note.setImportant("important");
          count++;
        }
        else if(count==0){
          break;
        }
        if(line.startsWith("Title:")){
          note.setTitle(line.substring(7));
        }
        else{
          content += line.toString() + "\n";
        }
        note.setContent(content);
      }

      // Use the file contents as needed

      reader.close();
      fis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}