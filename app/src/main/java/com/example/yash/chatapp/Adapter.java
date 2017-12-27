package com.example.yash.chatapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yash on 22/12/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {
    Context context;
    Message messages;

    public Adapter(Context context, Message messages){
        this.context = context;
        this.messages= new Message(messages);
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.messagelayout, parent, false);
        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.message.setText(messages.message.get(position));
        if(messages.inout.get(position).equals(1)) {
            holder.stat.setImageResource(R.drawable.outbound_message);
        }
        else {
            holder.stat.setImageResource(R.drawable.inbound_message);
        }
    }

    @Override
    public int getItemCount() {
        return messages.returnSize();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView message;
        ImageView stat;
        public CustomViewHolder(View itemView) {
            super (itemView);
            message = (TextView) itemView.findViewById(R.id.message);
            stat = (ImageView) itemView.findViewById(R.id.status);
        }
    }
}
