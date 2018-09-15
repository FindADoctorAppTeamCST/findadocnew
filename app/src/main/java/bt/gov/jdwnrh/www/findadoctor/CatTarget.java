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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatTarget extends AppCompatActivity {
    TextView titleStr, nm_t, st_t;
    String passTitle, trial; //make this final if nth works
    String url = "http://findadoc.dx.am/findadocandroid/mirror.php";
    ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> item;
    ListView listView;
    List<String> nameArr = new ArrayList<String>();
    String detail[][]= new String[1][4];;
    String name = "Khusant Chhetri", desig = "Developer", stat = "IN";
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_target);
        titleStr = (TextView) findViewById(R.id.speTitle);
        detail[0][0]="Hi";
        detail[0][1]="Y";
        detail[0][2]="Y";
        detail[0][3]="Y";
        passTitle = getIntent().getExtras().getString("Value");
        titleStr.setText(passTitle);
        listView = (ListView) findViewById(R.id.list);

        RequestQueue queue = Volley.newRequestQueue(CatTarget.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResp = new JSONObject(response);
                    for (int i = 0; i < (Integer.parseInt(jsonResp.getString("total"))); i++) {
                        detail=new String[Integer.parseInt(jsonResp.getString("total"))][4];
                        detail[i][0]=jsonResp.getString("name"+i);
                        detail[i][1]=jsonResp.getString("status"+i);
                        detail[i][2]=jsonResp.getString("designation"+i);
                        detail[i][3]=jsonResp.getString("till"+i);
                        /*Toast.makeText(CatTarget.this, jsonResp.getString("name" + i), Toast.LENGTH_SHORT).show();
                        Toast.makeText(CatTarget.this, jsonResp.getString("status" + i), Toast.LENGTH_SHORT).show();
                        Toast.makeText(CatTarget.this, jsonResp.getString("designation" + i), Toast.LENGTH_SHORT).show();
                        Toast.makeText(CatTarget.this, jsonResp.getString("till" + i), Toast.LENGTH_SHORT).show();
                        Toast.makeText(CatTarget.this, jsonResp.getString("till" + i), Toast.LENGTH_SHORT).show();
                    */}
                    Display di=new Display();
                    di.displayDetails();
                    Toast.makeText(CatTarget.this, jsonResp.getString("total"), Toast.LENGTH_SHORT).show();
                } catch (JSONException jsonError) {
                    Toast.makeText(CatTarget.this, "Error Fetching Data" + jsonError, Toast.LENGTH_SHORT).show();
                }
                //o.setText("Success");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(CatTarget.this, "my error :" + error, Toast.LENGTH_LONG).show();
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
        //displayDetails();
    }
}
    class Display extends CatTarget {
        public void displayDetails() {
            for(int i=0;i<super.detail.length;i++) {
                size=nameArr.size();
                //desig=desigArr.get(i);
                //stat=statusArr.get(i);
                item = new HashMap<String, String>();
                item.put("doc_name", super.detail[i][0]);
                item.put("doc_status", super.detail[i][1]);
                item.put("doc_designation", super.detail[i][2]);
                list.add(item);
            }

            String[] from={"doc_name","doc_designation","doc_status"};//string array
            int[] to={R.id.docName, R.id.docDesig, R.id.status};//int array of views id's
            SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.doc_display_textview_resource,from,to);
            listView.setAdapter(simpleAdapter);
        }

    }

    //This array will be updated by the entry from the database.
    //The database connection function from the above wilgl add 3 values to the list array i.e. Name, Designation, Status, and 4 values with added date_till vaue if the doctor is out of station.
    // Reference Array... Delete this after the implementation of arraylist...
    /*private String[][] nameAndDesig={{"Yangchen","Medical Specialist","IN"},{"Yeshi Penjor","Cardiologist","OUT"},{"G.P. Dhakal","Gastroentrologist","IN"},{"Minjur Dorji","Medical Specialist","IN"},{"Sonam Yangchen","Medical Specialist","OUT"},{"Kesang Namgyel","Medical Specialist","IN"},{"Gaki Nima","Chest Specialist","OUT"},{"Mahesh Gurung","Cardiologist","IN"},{"Gary G","Intensive Pulmonologist","OUT"}};
*/