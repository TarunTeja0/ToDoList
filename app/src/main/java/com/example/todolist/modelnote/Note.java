package com.example.todolist.modelnote;

public class Note {
    String important;
    String title;
    String content;
    public Note(){

    }

    public void setImportant(String important) {
        this.important = important;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImportant() {
        return important;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Note(String important, String title, String content) {
        this.important = important;
        this.title = title;
        this.content = content;
    }
}
