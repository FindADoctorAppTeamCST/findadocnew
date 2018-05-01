package bt.gov.jdwnrh.www.findadoctor;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DocProfile extends AppCompatActivity {
    Switch aSwitch;
    DatePicker datePicker;
    Button update;
    TextView l1,l2,l3,l4,load;
    ImageView dp;
    public static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    ProgressBar progressBar,pbload;
    String passEmp, dateTill="",url="http://findadoc.dx.am/findadocandroid/profile.php",urlUpdate="http://findadoc.dx.am/findadocandroid/updateProfile.php",displayname,statStr="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_profile);
        update=(Button)findViewById(R.id.updt);
        aSwitch = (Switch) findViewById(R.id.idSwitch);
        progressBar=(ProgressBar)findViewById(R.id.updateprogressBar);
        pbload=(ProgressBar)findViewById(R.id.progressBar2);
        load=(TextView)findViewById(R.id.textView2);
        dp=(ImageView)findViewById(R.id.imageid1);
        aSwitch.setChecked(true); //retrieve from database
        datePicker=(DatePicker) findViewById(R.id.dp);
        Calendar cal=Calendar.getInstance();
        datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                dateTill=datePicker.getDayOfMonth()+"-"+MONTHS[datePicker.getMonth()]+"-"+datePicker.getYear();
                Toast.makeText(DocProfile.this, "OUT till "+dateTill, Toast.LENGTH_SHORT).show();
            }
        });
        datePicker.setVisibility(View.GONE);
        passEmp=getIntent().getExtras().getString("empid");
        getDetails();
        update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateStatus();
            }
        });
    }
    public void onSwitchClick(View v) {
        if(aSwitch.isChecked()) {
            Toast.makeText(this, "Doctor is IN", Toast.LENGTH_SHORT).show();
            datePicker.setVisibility(View.GONE);
            statStr="1";
        } else {
            Toast.makeText(this, "Doctor is OUT. Please Select till WHEN", Toast.LENGTH_SHORT).show();
            datePicker.setVisibility(View.VISIBLE);
            statStr="0";
        }
    }

    public void updateStatus() {
        update.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(DocProfile.this);
        StringRequest request = new StringRequest(Request.Method.POST, urlUpdate, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResp = new JSONObject(response);
                    if(jsonResp.getString("resp").equals("1")) {
                        Toast.makeText(DocProfile.this, "Update Successfully\nLogging Out...", Toast.LENGTH_SHORT).show();
                        update.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                        startActivity(new Intent(getApplication(),MainActivity.class));
                    } else {
                        Toast.makeText(DocProfile.this, "Error Updating Status. Try Again", Toast.LENGTH_SHORT).show();
                        update.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                    }
                } catch (JSONException jsonError) {
                    Toast.makeText(DocProfile.this, "Error Response From Server. Try Again.", Toast.LENGTH_SHORT).show();
                    update.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DocProfile.this, "Network Error"+error, Toast.LENGTH_LONG).show();
                update.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("stat", statStr);
                map.put("emid", passEmp);
                map.put("date", dateTill);
                return map;
            }
        };
        queue.add(request);
    }

    public void getDetails() {
        l1=(TextView)findViewById(R.id.empid);
        l2=(TextView)findViewById(R.id.name);
        l3=(TextView)findViewById(R.id.desig);
        l4=(TextView)findViewById(R.id.dept);
        RequestQueue queue = Volley.newRequestQueue(DocProfile.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResp = new JSONObject(response);
                    pbload.setVisibility(View.GONE);
                    load.setVisibility(View.GONE);
                    dp.setVisibility(View.VISIBLE);
                    displayname="Dr. "+jsonResp.getString("nam");
                    l1.setText(jsonResp.getString("emp"));
                    l2.setText(displayname);
                    l3.setText(jsonResp.getString("des"));
                    l4.setText(jsonResp.getString("dep"));
                    if(jsonResp.getString("sta").equals("0")) {
                        aSwitch.setChecked(false);
                        datePicker.setVisibility(View.VISIBLE);
                    } else {
                        aSwitch.setChecked(true);
                    }
                } catch (JSONException jsonError) {
                    Toast.makeText(DocProfile.this, "Error Loading Profile "+jsonError, Toast.LENGTH_SHORT).show();
                    pbload.setVisibility(View.GONE);
                    load.setText("Error Loading Profile. Try Again.");
                    dp.setVisibility(View.VISIBLE);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DocProfile.this, "Volley Error"+error, Toast.LENGTH_LONG).show();
                pbload.setVisibility(View.GONE);
                load.setText("Error Loading Profile. Try Again.");
                dp.setVisibility(View.VISIBLE);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("empid", passEmp);

                return map;
            }
        };
        queue.add(request);
    }
}