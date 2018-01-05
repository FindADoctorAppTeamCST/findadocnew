package bt.gov.jdwnrh.www.findadoctor;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {
    EditText editText;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        context=this;
        editText=(EditText) findViewById(R.id.feedbackSpace);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s= editText.getText().toString();
                Toast.makeText(Feedback.this, "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    //Feedback
    public void SubmitFeedback(View view){
        //dialog box
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("Feedback Status: ");
        builder.setMessage(" Feedback Submitted Successfully.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Thank You. Have a nice day.", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertdialog = builder.create();
        alertdialog.show();
    }
}
