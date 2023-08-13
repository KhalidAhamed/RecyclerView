package com.example.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
    Context context;
    ArrayList<Contact_Model> arrContacts;
    public RecyclerContactAdapter(Context context,ArrayList<Contact_Model> arrContacts){
        this.context = context;
        this.arrContacts = arrContacts;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.img.setImageResource(arrContacts.get(position).img);
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumer.setText(arrContacts.get(position).number);

        holder.llView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_layout);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button acbtn = dialog.findViewById(R.id.acbtn);

                TextView txtTitle = dialog.findViewById(R.id.head);

                txtTitle.setText("Update Contact");
                acbtn.setText("Update");

                acbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "",number = "";
                        if(!edtName.getText().toString().equals("") && !edtNumber.getText().toString().equals("")){
                            name = edtName.getText().toString();
                            number = edtNumber.getText().toString();

                            arrContacts.set(position,new Contact_Model(name,number));
                            notifyItemChanged(position);
                            dialog.dismiss();
                        }
                        else {
                            Toast.makeText(context, "Please enter to update", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();

                holder.del.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                                .setTitle("Delete Contact")
                                .setMessage("Are you Sure want to delete")
                                .setIcon(R.drawable.baseline_folder_delete_24)
                                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        arrContacts.remove(position);
                                        notifyItemRemoved(position);
                                    }
                                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
                        builder.show();

                        return true;
                    }
                });


            }
        });


    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtNumer;
        ImageView img;
        LinearLayout llView;
        LinearLayout del;
        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtname);
            txtNumer = itemView.findViewById(R.id.txtNumber);
            img = itemView.findViewById(R.id.img);
            llView = itemView.findViewById(R.id.llView);
            del = itemView.findViewById(R.id.del);


        }
    }
}
