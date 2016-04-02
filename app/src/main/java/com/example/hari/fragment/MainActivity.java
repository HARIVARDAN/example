package com.example.hari.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hari.fragment.tabs.SlidingTabLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText ET_NAME,ET_CITY,ET_PHONE,ET_EMAIL,ET_PASSWORD;
    String name,city,password,email,phone;

    WebView mwebview,web;
    //ProgressBar progressBar;
   public ImageView imageViews,image;



    private ViewPager mpager;
    private SlidingTabLayout mtabs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.tlogo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        mpager=(ViewPager)findViewById(R.id.pager);
        mtabs=(SlidingTabLayout)findViewById(R.id.tabs);
        mtabs.setViewPager(mpager);

       /* mwebview = (WebView) findViewById(R.id.webView);
        //progressBar = (ProgressBar) findViewById(R.id.progressbar);

        mwebview.setWebViewClient(new myWebClient());
        WebSettings websettings = mwebview.getSettings();
        websettings.setJavaScriptEnabled(true);
        mwebview.loadUrl("http://www.thinkmerit.in");
*/

       /* web = (WebView) findViewById(R.id.WebView);
        //progressBar = (ProgressBar) findViewById(R.id.progressbar);
        image= (ImageView) findViewById(R.id.ImageView);
        web.setWebViewClient(new WebClient());
        WebSettings websetting = web.getSettings();
        websetting.setJavaScriptEnabled(true);
        web.loadUrl("http://www.thinkmerit.in/#catalogue");
*/




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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment=null;


        if (id == R.id.signin) {


            fragment = new login();


            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            fragment =new rate();

        } else if (id == R.id.about) {

            fragment = new about();


        } else if (id == R.id.nav_manage) {


            fragment= new register();

        } else if (id == R.id.nav_share) {


        } else if (id == R.id.catalogue) {
            fragment = new catalogue();

        }



        FragmentManager fragmentManager = getFragmentManager();


        fragmentManager.beginTransaction().replace(R.id.container, fragment)
                .commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        return true;
    }




    public void Register(View view){


        startActivity(new Intent(this,MainActivity.class));


        ET_NAME =(EditText)findViewById(R.id.name);
        ET_CITY =(EditText)findViewById(R.id.city);
        ET_PASSWORD =(EditText)findViewById(R.id.passsword);
        ET_PHONE =(EditText)findViewById(R.id.phone);
        ET_EMAIL =(EditText)findViewById(R.id.email);
        name=ET_NAME.getText().toString();
        city=ET_CITY.getText().toString();
        password=ET_PASSWORD.getText().toString();
        phone=ET_PHONE.getText().toString();
        email=ET_EMAIL.getText().toString();

        if(name.equals("") || city.equals("") || password.equals("") || phone.equals("") || email.equals("")){
            Toast.makeText(getApplicationContext(), "Please enter valid details", Toast.LENGTH_LONG).show();
        }

        else {
            String method = "register";
            Background background = new Background(this);
            background.execute(method, name, password,city,phone,email);



        }
    }



    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        String[] tabs;

        public SectionsPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends android.support.v4.app.Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.head, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.position);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }
}


 /*  class MyPagerAdapter extends FragmentPagerAdapter{


        public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
           super(fm);
       }

       @Override
       public android.support.v4.app.Fragment getItem(int position) {
           MyFragment myFragment=MyFragment.getInstance(position);
           return myFragment;
       }

       @Override
       public int getCount() {
           return 3;
       }
   }











    public static class MyFragment extends Fragment{

        private TextView textView;

        public static MyFragment getInstance(int position){

            MyFragment myFragment=new MyFragment();
            Bundle args=new Bundle();
            args.putInt("position",position);
            myFragment.setArguments(args);

            return myFragment;
        }

        @Override

        public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstance){

            View layout=inflater.inflate(R.layout.head,container,false);
            textView=(TextView)layout.findViewById(R.id.position);
            Bundle bundle=getArguments();
            if(bundle!=null){

               textView.setText("Selected page is "+bundle.getInt("position"));

            }

            return layout;
        }

    }



    public class myWebClient extends WebViewClient {


        @Override
        public void onPageFinished(WebView view, String url) {
            //super.onPageFinished(view, url);
            // progressBar.setVisibility(View.GONE);

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);



        }


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //return super.shouldOverrideUrlLoading(view, url);
            view.loadUrl(url);
            return true;
        }
    }




  /*  public class WebClient extends WebViewClient {


        @Override
        public void onPageFinished(WebView view, String url) {
            //super.onPageFinished(view, url);
            // progressBar.setVisibility(View.GONE);
            image.setVisibility(View.GONE);

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);



        }


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //return super.shouldOverrideUrlLoading(view, url);
            view.loadUrl(url);
            return true;
        }
    }

*/















