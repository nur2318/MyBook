package com.example.imran.mybook;

import android.content.res.Configuration;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity implements Chepters.OnItemSelectedListener  {

    /** Called when the activity is first created. */

    @Override

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Debug",getResources().getConfiguration().orientation +"");
        //Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if (savedInstanceState==null){
            // Create an instance of ExampleFragment

            Chepters firstFragment=new Chepters();
            // Add the fragment to the 'fragment_container' FrameLayout

            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.add(R.id.flContainer, firstFragment);
            ft.commit();
        }
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            Details secondfragment =new Details();
            Bundle args=new Bundle();
            args.putInt("Position",0);
            secondfragment.setArguments(args);
            FragmentTransaction ft2=getSupportFragmentManager().beginTransaction();
            ft2.add(R.id.flContainer2, secondfragment);
            ft2.commit();

        }
    }

    @Override
    public  void Ons(int position){
        // The user selected the headline of an article from the HeadlinesFragment

        // Capture the article fragment from the activity layout
        Toast.makeText(this,"called by fragment A:position - " +position, Toast.LENGTH_SHORT).show();
        Details secondfragment=new Details();
        Bundle args=new Bundle();
        args.putInt("position",position);
        secondfragment.setArguments(args);

        // Create fragment and give it an argument for the selected article

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager().beginTransaction().replace(R.id.flContainer2,secondfragment).commit();

        }else {



            getSupportFragmentManager()
                    .beginTransaction().
                    replace(R.id.flContainer,secondfragment).
                    addToBackStack(null)
                    .commit();

        }
        }
}