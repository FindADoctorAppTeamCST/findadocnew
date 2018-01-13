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

        /*nm_t=(TextView)findViewById(R.id.nm);
        st_t=(TextView)findViewById(R.id.st);
        requestQueue = Volley.newRequestQueue(this);
        request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonobject = new JSONObject(response);
                    if (jsonobject.names().get(0).equals("name")) {
                        nm_t.setText(jsonobject.getString("name"));
                        if(jsonobject.getString("stat").equals("1")) {
                            st_t.setText("IN");
                            st_t.setTextColor(Color.parseColor("#00FF00"));
                        } else {
                            st_t.setText("OUT");
                            st_t.setTextColor(Color.parseColor("#00FF00"));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("speid", passTitle);
                return hashMap;
            }
        };
        requestQueue.add(request);
*/
        HashMap<String,String> item;
        for(int i=0;i<nameAndDesig.length;i++){
            item = new HashMap<String,String>();
            item.put("doc_name", nameAndDesig[i][0]);
            item.put("doc_designation", nameAndDesig[i][1]);
            list.add(item);
        }

        simpAdap = new SimpleAdapter(this, list,
                R.layout.doc_display_textview_resource,
                new String[] { "doc_name","doc_designation" },
                new int[] {R.id.docName, R.id.docDesig});

        ((ListView)findViewById(R.id.list)).setAdapter(simpAdap);
    }

    private String[][] nameAndDesig={{"Khusant Chhetri","Developer / Leader"},{"Karma Dorji","Analyst"},{"Tula Ram","Technical Writer"},{"Deepika Suberi","Designer"},{"Meg Nath Sharma","Analyst"},{"Tshering Penjore","Developer"},{"Kinzang Pelden","Analyst"},{"Gagen Ghalley","Developer"},{"Sangay Lhaden","Developer"}};
}
