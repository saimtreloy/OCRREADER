package saim.com.ocrreader;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Splash extends AppCompatActivity {

    ProgressDialog progressDialog;
    AssetManager assetManager;
    public static int searchCount = 0;

    public static ArrayList<ModelPhone> modelPhonesArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        assetManager = getAssets();
        readExcelFileFromAssets();
    }

    public void readExcelFileFromAssets() {


        Thread background = new Thread(new Runnable() {

            public void run() {
                try {
                    InputStream myInput;
                    myInput = assetManager.open("mobile_list.xls");
                    POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
                    HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
                    HSSFSheet mySheet = myWorkBook.getSheetAt(0);
                    Iterator<Row> rowIter = mySheet.rowIterator();

                    String name = null, rad1 = null, rad2 = null;
                    while (rowIter.hasNext()) {
                        HSSFRow myRow = (HSSFRow) rowIter.next();
                        Iterator<Cell> cellIter = myRow.cellIterator();
                        while (cellIter.hasNext()) {
                            HSSFCell myCell = (HSSFCell) cellIter.next();
                            if (myCell.getColumnIndex() == 0){
                                name = myCell.toString();
                            }else if (myCell.getColumnIndex() == 1){
                                rad1  = myCell.toString();
                            }else if (myCell.getColumnIndex() == 2){
                                rad2 = myCell.toString();
                            }
                        }
                        ModelPhone modelPhone = new ModelPhone(name, rad1, rad2);
                        modelPhonesArrayList.add(modelPhone);
                    }
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
        background.start();
    }
}
