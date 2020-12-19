package com.example.mobileassignment3;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.Context.CONTEXT_RESTRICTED;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder>{

        private String[] captions;
        private int[] imgIds;
        Context context ;

    public ImageAdapter(Context context , String[] captions, int[] imgIds) {
            this.captions = captions;
            this.imgIds = imgIds;
            this.context =context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_image, parent, false);
            return new ViewHolder(v);
        }

        @Override
    public void onBindViewHolder(ViewHolder holder, int position){
            CardView cardView = holder.cardView;
            ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
            Drawable dr = ContextCompat.getDrawable(cardView.getContext(), imgIds[position]);

            imageView.setImageDrawable(dr);

            TextView txt = (TextView) cardView.findViewById(R.id.txtName);
            txt.setText(captions[position]);
            cardView.setOnClickListener(goToDetails(position));

        }

    private View.OnClickListener goToDetails(final int position) {
      return  new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(context,GameDetails.class);
              intent.putExtra("ID",position+"");
              context.startActivity(intent);
          }
      };
        }

    @Override
    public int getItemCount(){
            return captions.length;
        }

        public static class ViewHolder  extends RecyclerView.ViewHolder{
            private CardView cardView;

            public ViewHolder(CardView cardView){
                super(cardView);
                this.cardView = cardView;
            }
        }

}
