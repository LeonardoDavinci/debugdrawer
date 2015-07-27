package com.jug6ernaut.debugdrawer.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.jug6ernaut.debugdrawer.DebugDrawer;
import com.jug6ernaut.debugdrawer.views.SpinnerElement;
import com.jug6ernaut.debugdrawer.views.elements.AnimationSpeedElement;
import com.jug6ernaut.debugdrawer.views.elements.LeakCanaryElement;
import com.jug6ernaut.debugdrawer.views.elements.RiseAndShineElement;
import com.jug6ernaut.debugdrawer.views.modules.BuildModule;
import com.jug6ernaut.debugdrawer.views.modules.DeviceInfoModule;
import com.jug6ernaut.debugdrawer.views.modules.MadgeModule;
import com.jug6ernaut.debugdrawer.views.modules.ScalpelModule;

public class DemoActivity extends AppCompatActivity {

	private static String TAG = "demo";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main);

		new DebugDrawer()
				.elements("UI",
						new AnimationSpeedElement(),
						new LeakCanaryElement(),
						new RiseAndShineElement(),
						new aElement())
				.modules(
						new BuildModule(),
						new DeviceInfoModule(),
						new MadgeModule(),
						new ScalpelModule())
				.bind(this);
	}

	public void onClick1(View v) {
		Log.v(TAG, "verbose");
		Log.i(TAG, "info");
		Log.d(TAG, "debug");
		Log.w(TAG, "warning");
		Log.e(TAG, "error");
		Log.wtf(TAG, "wtf");
	}

	public void onClick2(View v) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int x = 0; x < 5; x++) {
					Log.i(TAG, x + "");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		}).start();

	}

	private class aElement extends SpinnerElement {

		public aElement() {
			super("", new String[]{"1", "2"});
		}

		@Override
		public void onItemSelect(String item) {

		}
	}

}
