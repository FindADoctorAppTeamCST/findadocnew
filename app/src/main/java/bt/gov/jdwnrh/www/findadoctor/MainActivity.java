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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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
                startActivity(new Intent(getApplication(),Dialler.class));
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
    //Demo Halfway

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_notif) {
            startActivity(new Intent(getApplication(), Notification.class));
            return true;
        } else if (id == R.id.nav_login) {
            startActivity(new Intent(getApplication(), DoctorLogin.class));
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