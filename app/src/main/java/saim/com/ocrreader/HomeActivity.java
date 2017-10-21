package saim.com.ocrreader;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    EditText inputSearch;

    RecyclerView recyclerViewPhoneList;
    RecyclerView.LayoutManager layoutManagerPhoneList;
    RecyclerView.Adapter PhoneListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
    }

    public void init(){

        inputSearch = (EditText) findViewById(R.id.inputSearch);

        recyclerViewPhoneList = (RecyclerView) findViewById(R.id.recyclerViewPhoneList);
        layoutManagerPhoneList = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPhoneList.setLayoutManager(layoutManagerPhoneList);
        recyclerViewPhoneList.setHasFixedSize(true);

        PhoneListAdapter = new AdapterPhone(Splash.modelPhonesArrayList);
        recyclerViewPhoneList.setAdapter(PhoneListAdapter);

        //filter(Build.MANUFACTURER + " " + Build.MODEL);
        filter("adasdasfgllo qWorld");

        String reqString = Build.MANUFACTURER
                + "\n" + Build.MODEL + "\n" + Build.VERSION.RELEASE
                + "\n" + Build.VERSION_CODES.class.getFields()[android.os.Build.VERSION.SDK_INT].getName();

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //filter(s.toString());
            }
        });

    }



    void filter(String text){
        ArrayList<ModelPhone> temp = new ArrayList();
        for(ModelPhone d: Splash.modelPhonesArrayList){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getPhoneName().contains(text)){
                temp.add(d);
            }
        }
        PhoneListAdapter = new AdapterPhone(temp);
        recyclerViewPhoneList.setAdapter(PhoneListAdapter);
    }

}
