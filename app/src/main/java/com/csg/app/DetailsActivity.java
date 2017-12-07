package com.csg.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.csg.app.models.Items;

public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity_layout);
        try {

            Items.Item item = (Items.Item ) getIntent().getSerializableExtra("details");
            TextView login_name = (TextView)findViewById(R.id.login_name);
            TextView score = (TextView)findViewById(R.id.score);
            TextView followers_url = (TextView)findViewById(R.id.followers_url);
            TextView type = (TextView)findViewById(R.id.type);
            TextView site_admin = (TextView)findViewById(R.id.site_admin);

            login_name.setText(item.getLogin());
            score.setText(item.getScore());
            type.setText(item.getType());
            site_admin.setText(item.getSiteadmin());
            followers_url.setText(item.getFollowersurl());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
