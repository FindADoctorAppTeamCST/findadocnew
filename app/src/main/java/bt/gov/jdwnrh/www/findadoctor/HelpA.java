package bt.gov.jdwnrh.www.findadoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HelpA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_a);
    }
    public void onClick(View view){
        startActivity(new Intent(HelpA.this, HelpB.class));
    }
}
