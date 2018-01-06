package bt.gov.jdwnrh.www.findadoctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.util.HashMap;
import java.util.Map;

public class CatTarget extends AppCompatActivity {
    TextView titleStr,nm_t,st_t;
    String passTitle;
    private RequestQueue requestQueue;
    private static final String URL = "http://172.25.33.57/fadapp/mirror.php";
    private StringRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_target);
        titleStr=(TextView)findViewById(R.id.speTitle);
        passTitle=getIntent().getExtras().getString("Value");
        titleStr.setText(passTitle);

        nm_t=(TextView)findViewById(R.id.nm);
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
    }
}
