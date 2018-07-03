package bt.gov.jdwnrh.www.findadoctor;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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

import java.util.HashMap;
import java.util.Map;

public class Feedback extends AppCompatActivity {
    EditText editText;
    Context context;
    ProgressBar progressBar;
    Button subBut;
    String url = "http://findadoc.dx.am/findadocandroid/feedback.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        context = this;
        progressBar=(ProgressBar)findViewById(R.id.progressBar1);
        editText = (EditText) findViewById(R.id.feedbackSpace);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s = editText.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    //Feedback
    public void SubmitFeedback(View view) {
        editText = (EditText) findViewById(R.id.feedbackSpace);
        if(editText.getText().toString().length()==0) {
            Toast.makeText(context, "Empty Feedback cannot be sent!", Toast.LENGTH_SHORT).show();

        } else {
            progressBar.setVisibility(View.VISIBLE);
            subBut.setVisibility(View.GONE);
            RequestQueue queue = Volley.newRequestQueue(Feedback.this);
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResp = new JSONObject(response);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Feedback Status: ");
                        AlertDialog alertdialog;
                        if (jsonResp.getString("resp").equals("1")) {
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
                            subBut.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                            editText.setText("");
                        } else {
                            builder.setMessage(" Error: Feedback Could Not Be Submitted. Try Again");
                            builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(context, "Have a nice day.", Toast.LENGTH_SHORT).show();
                                }
                            });
                            alertdialog = builder.create();
                            alertdialog.show();
                            subBut.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                        }

                    } catch (JSONException jsonError) {
                        Toast.makeText(Feedback.this, "Error Submitting Feedback "+jsonError, Toast.LENGTH_SHORT).show();
                        subBut.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(Feedback.this, "No Internet Connection\nYou need an Active Internet Connection to send Feedback", Toast.LENGTH_LONG).show();
                    subBut.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }
            }) { //$feed=$_POST['feedback'];
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
}
