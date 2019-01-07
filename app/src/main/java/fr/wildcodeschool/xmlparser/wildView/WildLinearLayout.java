package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.wildcodeschool.xmlparser.LayoutManager;

import static fr.wildcodeschool.xmlparser.LayoutManager.convertToPixel;

public class WildLinearLayout implements WildView {
  // Log TAG definition
  private static final String TAG = "WildLinearLayout";
  private LinearLayout compatLayout;
  /**
   * Constructor
   * @param ctx   Activity context
   */
  public WildLinearLayout(Context ctx) {
    compatLayout = new LinearLayout(ctx);
  }


  /**
   * Populate the view with the attribute value
   * @param key The key of xml attribute
   * @param value The value of xml attribute
   */
  public void setAttribute(String key, String value) {
    int marginH = 0;
    int marginV = 0;
    switch (key) {
      case "orientation":
        compatLayout.setOrientation( value.equals("horizontal") ?
          LinearLayout.HORIZONTAL : LinearLayout.VERTICAL );
        break;
      case "weightSum":
        compatLayout.setWeightSum(Float.parseFloat(value));
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
    return compatLayout;
  }

  public LinearLayout getLayout(){
    return compatLayout;
  }
}
