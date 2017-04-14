package com.example.imran.mybook;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/**
 * Created by imran on 3/24/2017.
 */

public class Details extends Fragment  {
   public static String ARG_POSITION="position";
    int Position=0;
    TextView tvTitle;
    TextView tvDetails;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if(savedInstanceState==null){

                Position=getArguments().getInt(ARG_POSITION);

            }

        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.activity_details,parent,false);

    }

    // During startup, check if there are arguments passed to the fragment.
    @Override
    public void onStart() {
        super.onStart();
        Bundle args=getArguments();
        if (args!=null){
            // Set article based on argument passed in

            updateviw(args.getInt(ARG_POSITION));

        }
        else if (Position !=0){
            // Set article based on saved instance state defined during onCreateView

            updateviw(Position);

        }
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        tvTitle=(TextView) view.findViewById(R.id.tvTitle);
        tvDetails=(TextView)view.findViewById(R.id.tvDetails);



        tvTitle.setText(AllDetails.menu[Position]);
        tvDetails.setText(AllDetails.Details[Position]);

    }




    public   void updateviw(int position){

          tvTitle.setText(AllDetails.menu[position]);
          tvDetails.setText(AllDetails.Details[position]);
        Position=position;
      }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the current article selection in case we need to recreate the fragment

        outState.putInt(ARG_POSITION,Position);
    }
}
