package com.example.androidcombo;



import java.util.Locale;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        String idioma = getResources().getConfiguration().locale.getLanguage();
        String locale = java.util.Locale.getDefault().getDisplayName();
        String localea_OSOA = Locale.getDefault().toString();
        String HizkuntzaISO = Locale.getDefault().getISO3Language();
        
        TextView t = (TextView) findViewById(R.id.textView2);
        TextView t2 = (TextView) findViewById(R.id.textView3);

        t.setText("Hizkuntza Mugikorra : " + locale);
        t2.setText("Hizkuntza Aplikazioa : " +idioma);
		
        Button b =(Button) findViewById(R.id.botoia);
        b.setOnClickListener(this);
        
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Resources res = this.getResources();
		DisplayMetrics dm = res.getDisplayMetrics();
		android.content.res.Configuration conf = res.getConfiguration();
		conf.locale = new Locale("eu");
		res.updateConfiguration(conf, dm);
		finish();startActivity(getIntent());
	}

}
