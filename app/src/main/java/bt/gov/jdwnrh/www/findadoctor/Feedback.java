package bt.gov.jdwnrh.www.findadoctor;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;

public class Feedback extends AppCompatActivity {
    EditText editText;
    Context context;
    String url = "http://172.25.33.189/findadocandroid/feedback.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        context = this;
        editText = (EditText) findViewById(R.id.feedbackSpace);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s = editText.getText().toString();
                Toast.makeText(Feedback.this, "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    //Feedback
    public void SubmitFeedback(View view) {
        editText = (EditText) findViewById(R.id.feedbackSpace);
        RequestQueue queue = Volley.newRequestQueue(Feedback.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResp=new JSONObject(response);
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Feedback Status: ");
                    AlertDialog alertdialog;
                    if(jsonResp.getString("resp").equals("1")) {
                        //dialog box
                        builder.setMessage(" Feedback Submitted Successfully.");
                        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(context, "Thank You. Have a nice day.", Toast.LENGTH_SHORT).show();
                            }
                        });
                        alertdialog = builder.create();
                        alertdialog.show();
                    } else {
                        builder.setMessage(" Error: Feedback Could Not Be Submitted. Try Again");
                        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(context, "Thank You. Have a nice day.", Toast.LENGTH_SHORT).show();
                            }
                        });
                        alertdialog = builder.create();
                        alertdialog.show();
                    }

                }  catch (JSONException jsonError) {
                    Toast.makeText(Feedback.this, "Error Submitting Feedback", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Feedback.this, "my error :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> map = new HashMap<String, String>();
                map.put("feedback", editText.getText().toString());

                return map;
            }
        };
        queue.add(request);
    }
}
