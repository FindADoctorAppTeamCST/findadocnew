package bt.gov.jdwnrh.www.findadoctor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView ane,com,den,der,eme,ents,fon,gop,gyn,med,opt,ort,pat,ped,pha,psy,rad,sur;
    TextView anet,comt,dent,dert,emet,entst,font,gopt,gynt,medt,optt,ortt,patt,pedt,phat,psyt,radt,surt;
    String passValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(),Notification.class));
            }
        });

        //Getting Images
        ane=(ImageView)findViewById(R.id.anes);
        com=(ImageView)findViewById(R.id.comm);
        den=(ImageView)findViewById(R.id.dent);
        der=(ImageView)findViewById(R.id.derm);
        eme=(ImageView)findViewById(R.id.emer);
        ents=(ImageView)findViewById(R.id.ent);
        fon=(ImageView)findViewById(R.id.fore);
        gop=(ImageView)findViewById(R.id.gopd);
        gyn=(ImageView)findViewById(R.id.gyna);
        med=(ImageView)findViewById(R.id.medc);
        opt=(ImageView)findViewById(R.id.opth);
        ort=(ImageView)findViewById(R.id.ortp);
        pat=(ImageView)findViewById(R.id.path);
        ped=(ImageView)findViewById(R.id.pedt);
        pha=(ImageView)findViewById(R.id.phar);
        psy=(ImageView)findViewById(R.id.psyc);
        rad=(ImageView)findViewById(R.id.radi);
        sur=(ImageView)findViewById(R.id.surg);

        //Getting Textview Values
        anet=(TextView)findViewById(R.id.l1);
        comt=(TextView)findViewById(R.id.l2);
        dent=(TextView)findViewById(R.id.l3);
        dert=(TextView)findViewById(R.id.l4);
        emet=(TextView)findViewById(R.id.l5);
        entst=(TextView)findViewById(R.id.l6);
        font=(TextView)findViewById(R.id.l7);
        gopt=(TextView)findViewById(R.id.l8);
        gynt=(TextView)findViewById(R.id.l9);
        medt=(TextView)findViewById(R.id.l10);
        optt=(TextView)findViewById(R.id.l11);
        ortt=(TextView)findViewById(R.id.l12);
        patt=(TextView)findViewById(R.id.l13);
        pedt=(TextView)findViewById(R.id.l14);
        phat=(TextView)findViewById(R.id.l15);
        psyt=(TextView)findViewById(R.id.l16);
        radt=(TextView)findViewById(R.id.l17);
        surt=(TextView)findViewById(R.id.l18);

        /*
            *Remove Intent Object  Creation from each OnClickListener if not needed, to decrease the LOC and Garbage
         */
        ane.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=anet.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        com.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=comt.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        den.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=dent.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        der.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=dert.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        eme.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=emet.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        ents.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=entst.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        fon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=font.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        gop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=gopt.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        gyn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=gynt.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        med.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=medt.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        opt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=optt.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        ort.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=ortt.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        pat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=patt.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        ped.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=pedt.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        pha.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=phat.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        psy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=psyt.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        rad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=radt.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });
        sur.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),CatTarget.class);
                passValue=surt.getText().toString();
                i.putExtra("Value",passValue);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //This Method Maybe Obselete. Verify and Remove if it is obselete.
    //* The Code to Extend the Search Bar on Touch, will maybe work, if the inflation ode is written here...
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search_but) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_notif) {
            startActivity(new Intent(getApplication(), Notification.class));
            return true;
        } else if (id == R.id.nav_login) {
            startActivity(new Intent(getApplication(), DocLogin.class));
            return true;
        } else if (id == R.id.nav_feedback) {
            startActivity(new Intent(getApplication(), Feedback.class));
            return true;
        } else if (id == R.id.nav_share) {
            Intent share=new Intent(Intent.ACTION_SEND);
            share.setType("text/*");
            share.putExtra(Intent.EXTRA_TEXT,new Links().playstoreLink);
            startActivity(Intent.createChooser(share,"Share Using"));
            return true;
        } else if (id == R.id.nav_rate) {
            startActivity(new Intent (Intent.ACTION_VIEW, Uri.parse(new Links().playstoreLink)));
            Toast.makeText(getApplicationContext(),"Please Rate this app on Playstore",Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(getApplication(), About.class));
            return true;
        } else if (id == R.id.nav_help) {
            startActivity(new Intent(getApplication(), HelpA.class));
            return true;
        } else if (id == R.id.nav_related) {
            startActivity(new Intent(getApplication(), RelatedApps.class));
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}