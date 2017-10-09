package saim.com.ocrreader;

import android.support.v7.widget.RecyclerView;
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
        }

    }
}
