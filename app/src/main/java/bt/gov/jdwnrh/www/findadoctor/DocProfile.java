package bt.gov.jdwnrh.www.findadoctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class DocProfile extends AppCompatActivity {
    Switch aSwitch;
    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_profile);
        aSwitch = (Switch) findViewById(R.id.idSwitch);
        aSwitch.setChecked(true); //retrieve from database
        datePicker=(DatePicker) findViewById(R.id.dp);
        datePicker.setVisibility(View.GONE);
    }
    public void onSwitchClick(View v) {
        if(aSwitch.isChecked()) {
            Toast.makeText(this, "Doctor is IN", Toast.LENGTH_SHORT).show();
            datePicker.setVisibility(View.GONE);
        } else {
            Toast.makeText(this, "Doctor is OUT. Pleasae Select till WHEN", Toast.LENGTH_SHORT).show();
            datePicker.setVisibility(View.VISIBLE);
        }
    }
}