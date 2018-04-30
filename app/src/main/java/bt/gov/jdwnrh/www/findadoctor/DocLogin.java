package bt.gov.jdwnrh.www.findadoctor;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A login screen that offers login via username/password.
 */
public class DocLogin extends AppCompatActivity {

    AutoCompleteTextView user;
    EditText pass;
    Button login;
    String id,passwd;
    ProgressBar pb;
    String url = "http://findadoc.dx.am/findadocandroid/login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_login);
        user=(AutoCompleteTextView)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.password);
        pb=(ProgressBar)findViewById(R.id.login_progress);
        login=(Button)findViewById(R.id.email_sign_in_button);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                verifyCredentials();
            }
        });
    }

    public void verifyCredentials() {
        View focusView = null, focusPass = null;
        user.setError(null);
        pass.setError(null);
        boolean cancel=false,cancelPass=false;
        id=user.getText().toString();
        passwd=pass.getText().toString();
        if (id.equals("")) {
            user.setError(getString(R.string.error_field_required));
            focusView = user;
            cancel=true;
        }
        if (passwd.equals("")) {
            pass.setError(getString(R.string.error_field_required));
            focusPass = pass;
            cancelPass=true;
        }
        if(cancel) {
            focusView.requestFocus();
        } else if (cancelPass) {
            focusPass.requestFocus();
        } else {
            attemptLogin();
        }
    }

    public void attemptLogin() {
        pb.setVisibility(View.VISIBLE);
        login.setVisibility(View.GONE);
        RequestQueue queue = Volley.newRequestQueue(DocLogin.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResp = new JSONObject(response);
                    if (jsonResp.getString("resp").equals("1")) {
                        Intent i=new Intent(getApplication(),DocProfile.class);
                        i.putExtra("empid",id);
                        startActivity(i);
                        Toast.makeText(DocLogin.this, "Logging In...", Toast.LENGTH_SHORT).show();
                    } else  {
                        Toast.makeText(DocLogin.this, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
                    }
                    pb.setVisibility(View.GONE);
                    login.setVisibility(View.VISIBLE);
                } catch (JSONException jsonError) {
                    pb.setVisibility(View.GONE);
                    login.setVisibility(View.VISIBLE);
                    Toast.makeText(DocLogin.this, "Error Parsing JSON: "+jsonError, Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pb.setVisibility(View.GONE);
                login.setVisibility(View.VISIBLE);
                Toast.makeText(DocLogin.this, "Error connecting to Server", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> map = new HashMap<String, String>();
                map.put("user", id);
                map.put("pass", passwd);
                return map;
            }
        };
        queue.add(request);
    }
}