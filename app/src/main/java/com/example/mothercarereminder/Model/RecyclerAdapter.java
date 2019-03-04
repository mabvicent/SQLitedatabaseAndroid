package com.example.mothercarereminder.Model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mothercarereminder.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myholder> {
    List<NoteHelper> dataModelArrayList;

    public RecyclerAdapter(List<NoteHelper> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView date,title,body;

        public Myholder(View itemView) {
            super(itemView);

            title =  itemView.findViewById(R.id.tittle);
            body = itemView.findViewById(R.id.body);
            date = itemView.findViewById(R.id.date);
        }
    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,null);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        NoteHelper dataModel=dataModelArrayList.get(position);
        holder.title.setText(dataModel.getNoteTittle());
        holder.body.setText(dataModel.getDate());
        holder.date.setText(dataModel.noteBoddy);

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
}