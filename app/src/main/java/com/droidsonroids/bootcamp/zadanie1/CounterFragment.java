package com.droidsonroids.bootcamp.zadanie1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.greenrobot.event.EventBus;

public class CounterFragment extends Fragment {

	private TextView mCounterTextView;
	int couter = 0;

	public CounterFragment() { }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_counter, container, false);
	}

	@Override
	public void onViewCreated(final View view, final Bundle savedInstanceState) {
		mCounterTextView = (TextView) view.findViewById(R.id.counter_textView);
		setText();

	}

	public void onEvent(ClickEvent event){
		if (event.type == ClickEvent.Action.INCREMENT){
			couter ++;
			setText();
		}else {
			couter --;
			setText();
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		EventBus.getDefault().register(this);
	}

	private void setText() {
		mCounterTextView.setText(couter+"");

	}

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }
}
