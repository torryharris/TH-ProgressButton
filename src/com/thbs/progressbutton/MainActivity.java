package com.thbs.progressbutton;

import com.example.progressframework.R;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {


	static MasterLayout masterLayout;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		masterLayout = (MasterLayout) findViewById(R.id.MasterLayout01);

		//Onclick listener of the progress button
		masterLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				masterLayout.animation(); //Need to call this method for animation and progression
				
				if (masterLayout.flg_frmwrk_mode == 1) { 
					
					//Start state. Call any method that you want to execute
					
					runOnUiThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,
									"Starting download", Toast.LENGTH_SHORT)
									.show();
						}
					});
					new DownLoadSigTask().execute();
				}
				if (masterLayout.flg_frmwrk_mode == 2) {
					
					//Running state. Call any method that you want to execute
					
					new DownLoadSigTask().cancel(true);
					masterLayout.reset();
					runOnUiThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,
									"Download stopped", Toast.LENGTH_SHORT)
									.show();
						}
					});
				}
				if (masterLayout.flg_frmwrk_mode == 3) {
					
					//End state. Call any method that you want to execute.
					
					runOnUiThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,
									"Download complete", Toast.LENGTH_SHORT)
									.show();
						}
					});
				}
			}
		});

	}

	static class DownLoadSigTask extends AsyncTask<String, Integer, String> {

		
		@Override
		protected void onPreExecute() {

		}

		
		@Override
		protected String doInBackground(final String... args) {
			
			//Creating dummy task and updating progress
			
			for (int i = 0; i <= 100; i++) {
				try {
					Thread.sleep(50);
					
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
				publishProgress(i);

			}

		
			return null;
		}

	
		@Override
		protected void onProgressUpdate(Integer... progress) {
			
			//publishing progress to progress arc
			
			masterLayout.cusview.setupprogress(progress[0]);
		}

	

	}

}
