package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;

public class WildButton implements WildView {
  // Log TAG definition
  private static final String TAG = "WildButton";

  private AppCompatButton compatButton;
  /**
   * Constructor
   * @param ctx Activity context
   */
  public WildButton(Context ctx) {
    compatButton = new AppCompatButton(ctx);
  }

  /**
   * Populate the view with the attribute value
   * @param key The key of xml attribute
   * @param value The value of xml attribute
   */
  public void setAttribute(String key, String value) {
    switch (key) {
      case "text":
        compatButton.setText(value);
        break;
      case "gravity":
        compatButton.setGravity(Integer.parseInt(value));
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
    return compatButton;
  }
}