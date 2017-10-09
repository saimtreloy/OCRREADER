package saim.com.ocrreader;

import android.app.ProgressDialog;
import android.content.res.AssetManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class HomeActivity extends AppCompatActivity {


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

        recyclerViewPhoneList = (RecyclerView) findViewById(R.id.recyclerViewPhoneList);
        layoutManagerPhoneList = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPhoneList.setLayoutManager(layoutManagerPhoneList);
        recyclerViewPhoneList.setHasFixedSize(true);

        PhoneListAdapter = new AdapterPhone(MainActivity.modelPhonesArrayList);
        recyclerViewPhoneList.setAdapter(PhoneListAdapter);


    }


}
