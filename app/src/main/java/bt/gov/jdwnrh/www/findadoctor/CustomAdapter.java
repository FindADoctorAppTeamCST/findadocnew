package bt.gov.jdwnrh.www.findadoctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.view.View;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    String [] related_apps=
            {
                    "mhGAP",
                    "Doctor's Appointment",
                    "queue_app"
            };

    String [] description =
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

    CustomAdapter(Context context, String[] related_apps, String[] description, Integer[] imageid)
    {
        super(context,R.layout.custom_row, related_apps );

    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater relatedInflater = LayoutInflater.from(getContext());
        View rowView=relatedInflater.inflate(R.layout.custom_row, null, true);

        String relatedItems= getItem(position);
        TextView textviewid =(TextView) rowView.findViewById(R.id.textviewid);
        TextView descriptionid =(TextView) rowView.findViewById(R.id.textviewid1);
        ImageView imageViewid =(ImageView) rowView.findViewById(R.id.imageViewid);

        textviewid.setText(related_apps[position]);
        descriptionid.setText(description[position]);
        imageViewid.setImageResource(imageid[position]);
        return rowView;
    }
}
