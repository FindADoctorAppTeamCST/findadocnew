package bt.gov.jdwnrh.www.findadoctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.graphics.Color;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CatTarget extends AppCompatActivity {
    TextView titleStr,nm_t,st_t;
    String passTitle;
    private RequestQueue requestQueue;
    private static final String URL = "http://172.25.33.57/fadapp/mirror.php";
    private StringRequest request;
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
    private SimpleAdapter simpAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_target);
        titleStr=(TextView)findViewById(R.id.speTitle);
        passTitle=getIntent().getExtras().getString("Value");
        titleStr.setText(passTitle);


        HashMap<String,String> item;
        for(int i=0;i<nameAndDesig.length;i++) {
            item = new HashMap<String,String>();
            item.put("doc_name", nameAndDesig[i][0]);
            item.put("doc_designation", nameAndDesig[i][1]);
            item.put("doc_status", nameAndDesig[i][2]);
            list.add(item);
        }

        simpAdap = new SimpleAdapter(this, list,
                R.layout.doc_display_textview_resource,
                new String[] { "doc_name","doc_designation","doc_status" },
                new int[] {R.id.docName, R.id.docDesig, R.id.status});

        ((ListView)findViewById(R.id.list)).setAdapter(simpAdap);
    }

    //This array will be updated by the entry from the database.
    //The database connection functionn from the above wilgl add 3 values to the list array i.e. Name, Designation, Status, and 4 values with added date_till vaue if the doctor is out of station.
    private String[][] nameAndDesig={{"Khusant Chhetri","Developer","IN"},{"Karma Dorji","Analyst","OUT"},{"Tula Ram","Technical Writer","IN"},{"Deepika Suberi","Designer","IN"},{"Meg Nath Sharma","Analyst","IN"},{"Tshering Penjore","Developer","IN"},{"Kinzang Pelden","Analyst","OUT"},{"Gagen Ghalley","Developer","IN"},{"Sangay Lhaden","Developer","OUT"}};

}
