package edu.iastate.cpre388.homework2;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BasicNumberFragment extends Fragment {

    // MainActivity or ColorActivity
    private INumberChosenWatcher context;

    public BasicNumberFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // store the context as an instance variable.  Note that the context is MainActivity or
        // ColorActivity.  This is the object you will call number chosen events on.
        this.context = (INumberChosenWatcher) context;
    }

    /**
     * A helper function that raises an event on the class watching this fragment for number chosen
     * events.
     * @param chosenNumber the number chosen in this fragment
     */
    private void raiseEvent(int chosenNumber) {
        // call the callback on the instance of MainActivity or ColorActivity.
        context.numberChosen(chosenNumber);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_basic_number, container, false);
        // Hook up button click handlers to the helper function above.
        v.findViewById(R.id.fragBasicButton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                raiseEvent(1);
            }
        });
        v.findViewById(R.id.fragBasicButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                raiseEvent(2);
            }
        });
        v.findViewById(R.id.fragBasicButton3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                raiseEvent(3);
            }
        });
        v.findViewById(R.id.fragBasicButton4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                raiseEvent(4);
            }
        });
        v.findViewById(R.id.fragBasicButton5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                raiseEvent(5);
            }
        });
        return v;
    }
}
