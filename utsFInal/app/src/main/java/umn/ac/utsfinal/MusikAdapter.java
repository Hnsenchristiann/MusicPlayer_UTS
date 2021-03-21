package umn.ac.utsfinal;

import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MusikAdapter extends RecyclerView.Adapter<MusikAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<DataMusik> mData;

    MusikAdapter(Context mContext, ArrayList<DataMusik> mData){
        this.mData = mData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.listmusik, parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nama_file.setText(mData.get(position).getTitle());
        byte[] image = getAlbumArt(mData.get(position).getPath());
        if (image != null){
            Glide.with(mContext).asBitmap()
                    .load(image)
                    .into(holder.albumart);
        }else {
            Glide.with(mContext)
                    .load(R.drawable.logo)
                    .into(holder.albumart);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(mContext, MusicPlayer.class);
                intent.putExtra("position", position);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nama_file;
        ImageView albumart;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_file = itemView.findViewById(R.id.Nama_list_musik);
            albumart = itemView.findViewById(R.id.musikimg);
        }
    }

    private byte[] getAlbumArt(String uri){
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(uri);
        byte[] art = retriever.getEmbeddedPicture();
        retriever.release();
        return art;
    }
}
