package bt.gov.jdwnrh.www.findadoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HelpB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_b);
    }
    public void goPrev(View view){
        startActivity(new Intent(HelpB.this, HelpA.class));
    }
    public void goNext(View view){
        startActivity(new Intent(HelpB.this, HelpC.class));
    }
}
