package tushar_admin.kiit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by 1305381 on 16-10-2015.
 */
public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

    private Context context;
    private LayoutInflater inflator;
    List<Info> data = Collections.emptyList();
    public myAdapter(Context context,List<Info> data){
        this.context = context;
        inflator = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.custom_row, parent , false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
        Info current = data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0){
                    context.startActivity(new Intent(context,sg_cg_tab.class));
                }
                if(position==1){
                    context.startActivity(new Intent(context,cgpatracker.class));
                }
                if(position==2){
                    context.startActivity(new Intent(context,SAP.class));
                }
                if(position==3){
                    context.startActivity(new Intent(context,KiitPortal.class));
                }
                if(position==4){
                    context.startActivity(new Intent(context,AboutUs.class));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;

        public myViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
        }
    }
}
