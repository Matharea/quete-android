package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.Log;
import android.view.View;

import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;

import fr.wildcodeschool.xmlparser.LayoutManager;

public class WildCheckBox implements WildView {
    private static final String TAG = "WildCheckBox";

    private AppCompatCheckBox compatCheckBox;
    /**
     * Constructor
     * @param ctx Activity context
     */
    public WildCheckBox(Context ctx) {
        compatCheckBox = new AppCompatCheckBox(ctx);
    }

    /**
     * Populate the view with the attribute value
     * @param key The key of xml attribute
     * @param value The value of xml attribute
     */
    public void setAttribute(String key, String value) {
        switch (key) {
            case "text":
                compatCheckBox.setText(value);
                break;
            case "id":
                /* Nothing to do */
                break;
            default:
                Log.i(TAG, "Unknown Attribute ["+key+"]");
                break;
        }
    }

    @Override
    public View getBuildView() {
        return compatCheckBox;
    }
}
