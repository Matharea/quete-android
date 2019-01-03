package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Space;

import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;

import fr.wildcodeschool.xmlparser.LayoutManager;

public class WildSpace implements WildView {
    private static final String TAG = "WildSpace";
    private Space compatSpace;
    /**
     * Constructor
     * @param ctx Activity context
     */
    public WildSpace(Context ctx) {
        compatSpace = new Space(ctx);
    }

    /**
     * Populate the view with the attribute value
     * @param key The key of xml attribute
     * @param value The value of xml attribute
     */
    public void setAttribute(String key, String value) {
        switch (key) {
            case "id":
                /* Nothing to do */
                break;
            case "gravity":
               // this.setGravity(Integer.parseInt(value));
                break;
            default:
                Log.i(TAG, "Unknown Attribute ["+key+"]");
                break;
        }
    }

    @Override
    public View getBuildView() {
        return compatSpace;
    }
}
