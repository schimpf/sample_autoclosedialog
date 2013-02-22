package com.example.autoclose;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.demo.R;

public class TestActivity extends FragmentActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.autoclose);
		showEditDialog();
	}

	private void showEditDialog() {
		FragmentManager fm = getSupportFragmentManager();
		AutocloseDialog editNameDialog = new AutocloseDialog();
		editNameDialog.show(fm, "fragment_edit_name");
	}

}
