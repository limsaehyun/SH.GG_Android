package com.example.shgg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    Context Ctx;

    ArrayList<MainData> arraylist;
    public static String editWinLose;
    public static String editRedName;
    public static String editBlueName;

    public static boolean editStatus = false;


    public MainAdapter(ArrayList<MainData> arraylist, Context Ctx) { // 생성자
        this.arraylist = arraylist;
        this.Ctx = Ctx;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view); // View를 가져온다.

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.CustomViewHolder holder, int position) {

        // 승패 색
        if (NoteActivity.colorValue[position]) {
            holder.frameLayout.setBackgroundResource(R.color.myBlueColor);
        } else {
            holder.frameLayout.setBackgroundResource(R.color.myRedColor);
        }

        holder.tv_winLose.setText(arraylist.get(position).getTv_winLose());
        holder.tv_redName.setText(arraylist.get(position).getTv_redName());
        holder.tv_blueName.setText(arraylist.get(position).getTv_blueName());


        holder.ib_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ctx.startActivity(new Intent(Ctx.getApplicationContext(), EditNoteActivity.class));
            }
        });

        holder.ib_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(Ctx, view);
                popupMenu.inflate(R.menu.menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.action_delete) {
                            remove(holder.getAdapterPosition());
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arraylist ? arraylist.size() : 0);
    }

    public void remove(int position) {
        try { // 예외사항이 생겨도 강제실행
            arraylist.remove(position);
            notifyItemRemoved(position); // 새로고침
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tv_winLose;
        protected TextView tv_redName;
        protected TextView tv_blueName;

        protected ImageButton ib_edit;
        protected FrameLayout frameLayout;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_winLose = (TextView) itemView.findViewById(R.id.tv_winLose);
            this.tv_redName = (TextView) itemView.findViewById(R.id.tv_redName);
            this.tv_blueName = (TextView) itemView.findViewById(R.id.tv_blueName);

            this.ib_edit = (ImageButton) itemView.findViewById(R.id.ib_edit);
            this.frameLayout = (FrameLayout) itemView.findViewById(R.id.frame);
        }
    }

}
