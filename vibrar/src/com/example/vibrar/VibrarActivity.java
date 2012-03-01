package com.example.vibrar;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.Vibrator;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class VibrarActivity extends Activity implements OnTouchListener {
	/** Called when the activity is first created. */

	Button vibrateBtn;
	Vibrator vibrator;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button v = (Button) findViewById(R.id.vibrateBtn);
		//v.setText("Hola");
		v.setText(Html.fromHtml("<h2>Hola</h2><br><p>Description here</p>"));
		vibrateBtn = (Button) findViewById(R.id.vibrateBtn);

		vibrateBtn.setOnTouchListener(this);
		vibrator = (Vibrator) getSystemService(VibrarActivity.VIBRATOR_SERVICE);
	}

	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			vibrator.vibrate(10000);
		}
		if (event.getAction() == MotionEvent.ACTION_UP) {
			vibrator.cancel();
		}

		return false;
	}
}