package bt.gov.jdwnrh.www.findadoctor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class RelatedApps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_related_apps);

        final String[] related_apps={"mhGAP","Child_screening","queue_app"};
        ListAdapter relatedAppAdapter= new CustomAdapter(this,related_apps);
        ListView relatedListView=(ListView) findViewById(R.id.relateListView);
        relatedListView.setAdapter(relatedAppAdapter);
        relatedListView.setOnItemClickListener(

               new AdapterView.OnItemClickListener(){
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                       String related_app = String.valueOf(parent.getItemIdAtPosition(position));
                       Toast.makeText(RelatedApps.this, related_app,Toast.LENGTH_SHORT).show();
                   }
               }
        );

    }
    public void onImageClick(View v){
        Toast.makeText(this,"View this app on Playstore",Toast.LENGTH_SHORT).show();
        startActivity(new Intent (Intent.ACTION_VIEW, Uri.parse(new Links().playstoreLink)));
    }
    public void onImageClickError(View v){
        Toast.makeText(this,"App development is under process by CST",Toast.LENGTH_SHORT).show();
    }
}
