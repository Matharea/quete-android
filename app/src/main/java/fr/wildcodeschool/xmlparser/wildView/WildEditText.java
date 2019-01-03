package fr.wildcodeschool.xmlparser.wildView;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.util.Log;
import android.view.View;

import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;

import fr.wildcodeschool.xmlparser.LayoutManager;

public class WildEditText implements WildView {
  // Log TAG definition
  private static final String TAG = "WildEditText";
private AppCompatEditText compatEditText;
  /**
   * Constructor
   * @param ctx Activity context
   */
  public WildEditText(Context ctx) {
    compatEditText = new AppCompatEditText(ctx);
  }


  /**
   * Populate the view with the attribute value
   * @param key The key of xml attribute
   * @param value The value of xml attribute
   */
  public void setAttribute(String key, String value) {
    switch (key) {
      case "inputType":
        this.setInputType(value);
        break;
      case "ems":
        try {
          compatEditText.setEms(Integer.getInteger(value));
        } catch (NullPointerException e) {
          Log.e(TAG, e.getMessage());
        }
        break;
      case "text":
        compatEditText.setText(value);
        break;
      case "hint":
        compatEditText.setHint(value);
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
    return compatEditText;
  }

  /**
   *
   * @param pInputType
   */
  private void setInputType(String pInputType) {
    switch (pInputType) {
      case "textPersonName":
        compatEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        break;
      default:
        // Log it
        break;
    }
  }
}
