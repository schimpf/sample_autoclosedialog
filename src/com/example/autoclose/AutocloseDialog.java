package com.example.autoclose;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demo.R;

public class AutocloseDialog extends DialogFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.autoclose, container);
		getDialog().setTitle("Hello");

		return view;
	}

	@Override
	public void show(FragmentManager manager, String tag) {
		Log.i("sample_autoclosedialog", "showing dialog");
		new CloseThread(this).start();
		super.show(manager, tag);
	}

	@Override
	public int show(FragmentTransaction transaction, String tag) {
		Log.i("sample_autoclosedialog", "showing dialog");
		new CloseThread(this).start();
		return super.show(transaction, tag);
	}

	class CloseThread extends Thread {

		private AutocloseDialog dialog;

		public CloseThread(AutocloseDialog dialog) {
			super();
			this.dialog = dialog;
		}

		@Override
		public void run() {
			try {
				sleep(3000);
				dialog.dismiss();
				Log.i("sample_autoclosedialog", "dialog dismissed");
			} catch (InterruptedException e) {
				Log.e("sample_autoclosedialog", "exception", e);
			}
		}

	}
}
