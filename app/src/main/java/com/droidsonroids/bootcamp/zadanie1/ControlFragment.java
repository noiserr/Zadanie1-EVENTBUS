package com.droidsonroids.bootcamp.zadanie1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import de.greenrobot.event.EventBus;

public class ControlFragment extends Fragment {

	public ControlFragment() { }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_control, container, false);
	}

	@Override
	public void onViewCreated(final View view, final Bundle savedInstanceState) {
		Button addButton = (Button) view.findViewById(R.id.add_button);
		addButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				EventBus.getDefault().post(new ClickEvent(ClickEvent.Action.INCREMENT));
			}
		});

		Button subtractButton = (Button) view.findViewById(R.id.subtract_button);
		subtractButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				EventBus.getDefault().post(new ClickEvent(ClickEvent.Action.DECREMENT));
			}
		});
	}

	@Override
	public void onResume() {
		super.onResume();
	}
}
