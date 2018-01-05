package bt.gov.jdwnrh.www.findadoctor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RelatedApps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_related_apps);
    }
    public void onImageClick(View v){
        Toast.makeText(this,"View this app on Playstore",Toast.LENGTH_SHORT).show();
        startActivity(new Intent (Intent.ACTION_VIEW, Uri.parse(new Links().playstoreLink)));
    }
    public void onImageClickError(View v){
        Toast.makeText(this,"App development is under process by CST",Toast.LENGTH_SHORT).show();
    }
}
