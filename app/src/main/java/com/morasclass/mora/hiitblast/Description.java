package com.morasclass.mora.hiitblast;

import android.widget.TextView;

/**
 * Created by n080873 on 5/24/2017.
 */

public class Description {

    TextView title;
    TextView descritption;
    float originalSize;

    boolean isExpanded;

    public Description(TextView t , TextView d) {
        descritption = d;
        title = t;
        isExpanded = true;
        originalSize = descritption.getTextSize();
    }

    public void change() {
        if(isExpanded) {
            descritption.setTextSize(0);
            isExpanded = false;
        }
        else {
            descritption.setTextSize(originalSize);
            isExpanded = true;
        }
    }

}
