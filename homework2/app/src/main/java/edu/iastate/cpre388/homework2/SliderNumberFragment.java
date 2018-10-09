package edu.iastate.cpre388.homework2;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;


public class SliderNumberFragment extends Fragment {

    // MainActivity or ColorActivity
    private INumberChosenWatcher context;

    public SliderNumberFragment() {
        // Required empty public constructor
    }

    // override onAttach to store the instance of MainActivity or ColorActivity for later
    // raising events on it.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = (INumberChosenWatcher) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_slider_number, container, false);
        SeekBar sb = v.findViewById(R.id.fragSliderSeekBar);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // raise a number chosen event to the watcher based on the progress value.
                context.numberChosen(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });
        return v;
    }
}
