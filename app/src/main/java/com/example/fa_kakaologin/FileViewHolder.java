package com.example.fa_kakaologin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FileViewHolder extends RecyclerView.ViewHolder {

    public ImageView fileImage;
    public TextView fileName;

    public FileViewHolder(@NonNull View itemView) {
        super(itemView);
        fileImage = itemView.findViewById(R.id.file_image);
        fileName = itemView.findViewById(R.id.file_name);
    }

}
