package com.example.imran.mybook;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by imran on 3/24/2017.
 */

public class Chepters extends Fragment {

    ArrayAdapter<String> itemsAdapter;
    private OnItemSelectedListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create an array adapter for the list view, using the Ipsum headlines array

        itemsAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, AllDetails.menu);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_menu, parent, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ListView IvItems = (ListView) view.findViewById(R.id.lvItems);
        IvItems.setAdapter(itemsAdapter);

        IvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.Ons(position);
                // Notify the parent activity of selected item

            }
        });

    }

    @Override
    public void onAttach(Context context) {
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            this.listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString() + "must implement onmenuItemSelected");
        }
    }
    // Define the events that the fragment will use to communicate
    public interface OnItemSelectedListener {
        /** Called by HeadlinesFragment when a list item is selected */

        void Ons(int Position);
    }


}
