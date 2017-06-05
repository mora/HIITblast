package com.morasclass.mora.hiitblast;

import android.widget.TextView;

/**
 * Created by n080873 on 5/24/2017.
 */

public class Description {

    TextView title;
    TextView descritption;
    String originalText;

    boolean isExpanded;

    public Description(TextView t , TextView d) {
        descritption = d;
        title = t;
        isExpanded = true;
        originalText = descritption.getText().toString();
    }

    public void change() {
        if(isExpanded) {
            descritption.setText("");
            isExpanded = false;
        }
        else {
            descritption.setText(originalText);
            isExpanded = true;
        }
    }

}
