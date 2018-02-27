package bt.gov.jdwnrh.www.findadoctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;

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
    String passTitle; //make this final if nth works
    String url = "http://172.25.33.189/findadocandroid/mirror.php";
    ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
    HashMap<String,String> item;
    ListView listView;
    private ArrayList<String> nameArr=new ArrayList<String>();
    private ArrayList<String> statusArr=new ArrayList<String>();
    private ArrayList<String> desigArr=new ArrayList<String>();
    private ArrayList<String> dateArr=new ArrayList<String>();
    String name="Khusant",desig="Dev",stat="IN";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_target);
        titleStr=(TextView)findViewById(R.id.speTitle);
        //passTitle=getIntent().getExtras().getString("Value");
        passTitle="Pharmacology";
        titleStr.setText(passTitle);

        listView=(ListView)findViewById(R.id.list);

        RequestQueue queue = Volley.newRequestQueue(CatTarget.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResp=new JSONObject(response);
                    //o.setText(jsonResp.getString("respOne"));
                    nameArr.add(jsonResp.getString("name"));
                    statusArr.add(jsonResp.getString("status"));
                    desigArr.add(jsonResp.getString("designation"));
                    dateArr.add(jsonResp.getString("till"));
                    //name=jsonResp.getString("name");
                    Toast.makeText(CatTarget.this, ""+nameArr.get(0), Toast.LENGTH_SHORT).show();

                }  catch (JSONException jsonError) {
                    Toast.makeText(CatTarget.this, "Error Fetching Data", Toast.LENGTH_SHORT).show();
                }
                //o.setText("Success");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(CatTarget.this, "my error :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> map = new HashMap<String, String>();
                map.put("name", passTitle);

                return map;
            }
        };
        queue.add(request);

        for(int i=0;i<15;i++) {
            item = new HashMap<String, String>();
            item.put("doc_name", name);
            item.put("doc_designation", desig);
            item.put("doc_status", stat);
            list.add(item);
        }

        String[] from={"doc_name","doc_designation","doc_status"};//string array
        int[] to={R.id.docName, R.id.docDesig, R.id.status};//int array of views id's
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.doc_display_textview_resource,from,to);
        listView.setAdapter(simpleAdapter);
    }


    //This array will be updated by the entry from the database.
    //The database connection functionn from the above wilgl add 3 values to the list array i.e. Name, Designation, Status, and 4 values with added date_till vaue if the doctor is out of station.
    // Reference Array... Delete this after the implementation of arraylist...
    // private String[][] nameAndDesig={{"Khusant Chhetri","Developer","IN"},{"Karma Dorji","Analyst","OUT"},{"Tula Ram","Technical Writer","IN"},{"Deepika Suberi","Designer","IN"},{"Meg Nath Sharma","Analyst","IN"},{"Tshering Penjore","Developer","IN"},{"Kinzang Pelden","Analyst","OUT"},{"Gagen Ghalley","Developer","IN"},{"Sangay Lhaden","Developer","OUT"}};

}
