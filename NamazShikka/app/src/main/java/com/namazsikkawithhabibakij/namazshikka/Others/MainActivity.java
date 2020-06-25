package com.namazsikkawithhabibakij.namazshikka.Others;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Advanceable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.navigation.NavigationView;
import com.namazsikkawithhabibakij.namazshikka.About.About;
import com.namazsikkawithhabibakij.namazshikka.Activity.ActivityHazz;
import com.namazsikkawithhabibakij.namazshikka.Activity.ActivityRoja;
import com.namazsikkawithhabibakij.namazshikka.Activity.ActivityJakat;
import com.namazsikkawithhabibakij.namazshikka.Activity.ActivityNamaz;
import com.namazsikkawithhabibakij.namazshikka.Activity.ActivityOthers;
import com.namazsikkawithhabibakij.namazshikka.Activity.ActivityIman;
import com.namazsikkawithhabibakij.namazshikka.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private ImageView imageViewIman, imageViewNamaz, imageViewRuja, imageViewHazz, imageViewJakat, imageViewOthers;
    private DrawerLayout drawer;

    private AdView adView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer= findViewById(R.id.drawer_layout);
        NavigationView navigationView= findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        InitialView();

        ClickListener();

        AdvertiseMent();

    }

    private void AdvertiseMent() {
        MobileAds.initialize(this, getString(R.string.APP_ID));
        AdRequest adRequest= new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    private void ClickListener() {

        imageViewIman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityIman.class));
            }
        });

        imageViewNamaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityNamaz.class));
            }
        });

        imageViewRuja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityRoja.class));
            }
        });

        imageViewHazz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityHazz.class));
            }
        });

        imageViewJakat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityJakat.class));
            }
        });

        imageViewOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityOthers.class));
            }
        });
    }

    private void InitialView() {
        imageViewIman= findViewById(R.id.card_iman);
        imageViewNamaz= findViewById(R.id.card_namaz);
        imageViewRuja= findViewById(R.id.card_ruja);
        imageViewHazz= findViewById(R.id.card_hazz);
        imageViewJakat= findViewById(R.id.card_jakat);
        imageViewOthers= findViewById(R.id.card_others);

        adView= findViewById(R.id.activity_content_ad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Button btnDialogCommentSubmit;
        final EditText edIssue, edIssueDetails;
        final String issue, issueDtls;
        int id= item.getItemId();
        if (id== R.id.notification){
            final Dialog dialog= new Dialog(this);
            dialog.setContentView(R.layout.commest_submit);
            //dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            btnDialogCommentSubmit= dialog.findViewById(R.id.submit_comment);
            edIssue= dialog.findViewById(R.id.ed_issue);
            edIssueDetails= dialog.findViewById(R.id.ed_issue_details);
            issue= edIssue.getText().toString();
            issueDtls= edIssueDetails.getText().toString();

            btnDialogCommentSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences preferences= getSharedPreferences(TAG, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("issueTitle",issue);
                    editor.putString("issueDetails",issueDtls);
                    editor.apply();
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Comment submited", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                dialog.create();
            }
            dialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id == R.id.nav_about){
            startActivity(new Intent(this, About.class));
        } else if (id == R.id.nav_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, "Share With"));
        } else if (id == R.id.nav_more_apps){
            Toast.makeText(this, "More Apps", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_rate_us){
            Toast.makeText(this, "Rate us", Toast.LENGTH_SHORT).show();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder builder= new AlertDialog.Builder(this);
                    builder.setTitle("Exiting this App")
                    .setMessage("Are you sure?");
                    AdvertiseMent();
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            dialog.dismiss();
                        }
                    }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();
        }
    }
}
