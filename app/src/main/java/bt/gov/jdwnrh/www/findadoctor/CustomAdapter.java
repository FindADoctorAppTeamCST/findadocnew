package bt.gov.jdwnrh.www.findadoctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.view.View;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    CustomAdapter(Context context, String[] related_apps){
        super(context,R.layout.custom_row, related_apps );
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater relatedInflater = LayoutInflater.from(getContext());
        View customView=relatedInflater.inflate(R.layout.custom_row, parent, false);

        String relatedItems= getItem(position);
        TextView textviewid =(TextView) customView.findViewById(R.id.textviewid);
        ImageView imageViewid =(ImageView) customView.findViewById(R.id.imageViewid);

        textviewid.setText(relatedItems);
        imageViewid.setImageResource(R.drawable.thimphu);
        return customView;
    }
}
