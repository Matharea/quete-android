package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.wildcodeschool.xmlparser.LayoutManager;

import static android.util.TypedValue.COMPLEX_UNIT_SP;
import static fr.wildcodeschool.xmlparser.LayoutManager.convertToPixel;

public class WildTextView implements WildView {
    // Log TAG definition
    private static final String TAG = "WildTextView";
    private AppCompatTextView compatTextView;
    private int paddingVertical = 0;
    private int paddingHorizontal = 0;
    /**
     * Constructor
     * @param ctx Activity context
     */
    public WildTextView(Context ctx) {
        compatTextView = new AppCompatTextView(ctx);
    }
    /**
     * Populate the view with the attribute value
     * @param key The key of xml attribute
     * @param value The value of xml attribute
     */
    public void setAttribute(String key, String value) {
        switch (key) {
            case "textSize":
                try {
                    compatTextView.setTextSize(COMPLEX_UNIT_SP, 20.00f);
                } catch (NullPointerException e) {
                    Log.e(TAG, e.getMessage());
                }
                break;
            case "text":
                compatTextView.setText(value);
                break;
            case "textColor":
                compatTextView.setTextColor(Color.parseColor(value));
                break;
            case "paddingHorizontal" :
            case "paddingVertical" :
                Pattern pattern = Pattern.compile("([0-9]*)([a-z]*)");
                Matcher matcher = pattern.matcher(value);
                if (matcher.find()) {
                    int px = convertToPixel(matcher.group(1), matcher.group(2));
                    if (key.equals("paddingVertical")) {
                        paddingVertical = px;
                    } else {
                        paddingHorizontal = px;
                    }
                }
                break;
            case "background":
                compatTextView.setBackgroundColor(Color.parseColor(value));
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
        return compatTextView;
    }
}
