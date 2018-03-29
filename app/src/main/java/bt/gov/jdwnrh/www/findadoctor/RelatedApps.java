package bt.gov.jdwnrh.www.findadoctor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class RelatedApps extends AppCompatActivity {

    String [] related_apps=
            {
                    "mhGAP",
                    "Doctor's Appointment",
                    "queue_app"
            };

    String [] description=
            {
                    "description1",
                    "description2",
                    "description3"
            };

    Integer[] imageid =
            {
                    R.drawable.thimphu,
                    R.drawable.jdwnrh_logo,
                    R.drawable.app_logo,
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_related_apps);

        CustomAdapter relatedAppAdapter= new CustomAdapter(this,related_apps,description,imageid);
        ListView relatedListView=(ListView) findViewById(R.id.relateListView);
        relatedListView.setAdapter(relatedAppAdapter);
        relatedListView.setOnItemClickListener(

               new AdapterView.OnItemClickListener(){
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                       String Selecteditem = related_apps[+position];
                       Toast.makeText(RelatedApps.this, Selecteditem,Toast.LENGTH_SHORT).show();
                       startActivity(new Intent (Intent.ACTION_VIEW, Uri.parse(new Links().playstoreLink)));
                   }
               }
     );
    }

}
