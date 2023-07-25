package com.example.fa_kakaologin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FileAdapter extends RecyclerView.Adapter<FileViewHolder> {

    private List<String> fileList;

    public FileAdapter(List<String> fileList) { this.fileList = fileList; }

    @NonNull
    @Override
    public FileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file, parent, false);
        FileViewHolder viewHolder = new FileViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FileViewHolder holder, int position) {
        String string = fileList.get(position);
        holder.fileName.setText(string);
    }

    @Override
    public int getItemCount() { return fileList.size(); }
}