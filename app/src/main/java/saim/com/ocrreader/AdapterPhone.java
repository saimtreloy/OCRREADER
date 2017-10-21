package saim.com.ocrreader;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by NREL on 10/9/17.
 */

public class AdapterPhone extends RecyclerView.Adapter<AdapterPhone.AdapterPhoneViewHolder>{

    ArrayList<ModelPhone> adapterList = new ArrayList<>();

    public AdapterPhone() {

    }

    public AdapterPhone(ArrayList<ModelPhone> adapterList) {
        this.adapterList = adapterList;
    }

    @Override
    public AdapterPhoneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_phone, parent, false);
        AdapterPhoneViewHolder adapterPhoneViewHolder = new AdapterPhoneViewHolder(view, adapterList);
        return adapterPhoneViewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterPhoneViewHolder holder, int position) {
        holder.txtListPhone.setText(adapterList.get(position).getPhoneName());
    }

    @Override
    public int getItemCount() {
        return adapterList.size();
    }

    public class AdapterPhoneViewHolder extends RecyclerView.ViewHolder{

        TextView txtListPhone;
        ArrayList<ModelPhone> SuperArrayList = new ArrayList<ModelPhone>();

        public AdapterPhoneViewHolder(View itemView, ArrayList<ModelPhone> pList) {

            super(itemView);
            txtListPhone = (TextView) itemView.findViewById(R.id.txtListPhone);
            SuperArrayList = pList;

            Log.d("ADAPTER LIST", getItemCount() + "");

            /*Intent intent = new Intent(itemView.getContext(), PhoneDetail.class);
            intent.putExtra("NAME", adapterList.get(0).getPhoneName());
            intent.putExtra("RAD1", adapterList.get(0).getFirstRadiation());
            intent.putExtra("RAD2", adapterList.get(0).getSecondRediation());
            itemView.getContext().startActivity(intent);*/

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), PhoneDetail.class);
                    intent.putExtra("NAME", adapterList.get(getAdapterPosition()).getPhoneName());
                    intent.putExtra("RAD1", adapterList.get(getAdapterPosition()).getFirstRadiation());
                    intent.putExtra("RAD2", adapterList.get(getAdapterPosition()).getSecondRediation());
                    v.getContext().startActivity(intent);
                }
            });
        }

    }

    public void updateList(ArrayList<ModelPhone> list){
        adapterList = list;
        notifyDataSetChanged();
    }
}
