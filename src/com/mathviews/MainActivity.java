package com.mathviews;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        findViewById(R.id.sinview).setOnClickListener(this);
        findViewById(R.id.erjie).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = null;
        switch (id) {
        case R.id.sinview:
            intent = new Intent(mContext, SinActivity.class);
            startActivity(intent);
            break;
        case R.id.erjie:
            intent = new Intent(mContext, QuadraticActivity.class);
            startActivity(intent);
            break;
        default:
            break;
        }
    }

}
