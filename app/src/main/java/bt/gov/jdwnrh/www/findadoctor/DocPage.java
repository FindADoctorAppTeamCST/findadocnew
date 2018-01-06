package bt.gov.jdwnrh.www.findadoctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

public class DocPage extends AppCompatActivity {
    String doc_id;
    TextView doc_name_target;
    private RequestQueue requestQueue;
    private static final String URL = "http://172.23.23.86/fadapp/profile.php";
    private StringRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_page);
        doc_id=getIntent().getExtras().getString("doc_emp_id");
        requestQueue = Volley.newRequestQueue(this);
        doc_name_target=(TextView)findViewById(R.id.doc_name);

        request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonobject = new JSONObject(response);
                    if (jsonobject.names().get(0).equals("name")) {
                        doc_name_target.setText(jsonobject.getString("name"));
                        //Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
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
                hashMap.put("docid", doc_id);
                return hashMap;
            }
        };
        requestQueue.add(request);
    }
}
