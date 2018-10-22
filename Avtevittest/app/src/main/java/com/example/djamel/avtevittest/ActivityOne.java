package com.example.djamel.avtevittest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityOne extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";
	
	// Lifecycle counters

	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
	int mCreate = 0;
	int mRestart = 0;
	int mStart = 0;	
	int mResume = 0;
	
	// TODO: Create variables for each of the TextViews, called
        // mTvCreate, etc. 
	TextView mTvCreate;
	TextView mTvStart;
	TextView mTvResume;
	TextView mTvRestart;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
		mTvCreate = (TextView) findViewById(R.id.create);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);
		mTvRestart = (TextView) findViewById(R.id.restart);

		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo); 
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO:
				// Launch Activity Two
				// Hint: use Context's startActivity() method
				Toast.makeText(ActivityOne.this,"yesss",Toast.LENGTH_LONG).show();

				// Create an intent stating which Activity you would like to start
				Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
				
				// Launch the Activity using the intent
			 startActivity(intent);
			}
		});
		
		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable

			 mCreate = savedInstanceState.getInt(CREATE_KEY);
			 mRestart = savedInstanceState.getInt(RESTART_KEY);
			 mStart = savedInstanceState.getInt(START_KEY);
			 mResume = savedInstanceState.getInt(RESUME_KEY);		
		}
		
		// Update the appropriate count variable
		mCreate++;

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered the onCreate() method");


		// TODO:
		// Update the user interface via the displayCounts() method		
		displayCounts();
	}

	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();

		// Update the appropriate count variable
		mStart++;
		
		// TODO: Emit LogCat message
		Log.i(TAG, "Entered the onStart() method");		

		// TODO:
		// Update the user interface
		displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();

		// Update the appropriate count variable
		mResume++;
		
		// TODO: Emit LogCat message
		Log.i(TAG, "Entered the onResume() method");
		
		// TODO:
		// Update the user interface
		displayCounts();

	}

	@Override
	public void onPause() {
		super.onPause();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered the onPause() method");

	}

	@Override
	public void onStop() {
		super.onStop();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered the onStop() method");

	}

	@Override
	public void onRestart() {
		super.onRestart();

		// Update the appropriate count variable
		mRestart++;
		
		// TODO: Emit LogCat message
		Log.i(TAG, "Entered the onRestart() method");

		// TODO:
		// Update the user interface	
		displayCounts();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TODO: Emit LogCat message
		Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// TODO:
		// Save state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		super.onSaveInstanceState(savedInstanceState);
		 savedInstanceState.putInt(CREATE_KEY, mCreate);
		 savedInstanceState.putInt(RESTART_KEY, mRestart);
		 savedInstanceState.putInt(START_KEY, mStart);
		 savedInstanceState.putInt(RESUME_KEY, mResume);
	}
	
	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
		Toast.makeText(this,"",Toast.LENGTH_LONG).show();

	}
}
