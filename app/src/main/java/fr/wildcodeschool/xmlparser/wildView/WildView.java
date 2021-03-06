package fr.wildcodeschool.xmlparser.wildView;

import android.os.Build;
import android.view.View;

import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;

import fr.wildcodeschool.xmlparser.LayoutManager;

public interface WildView {
    void setAttribute(String key, String value);

    View getBuildView();

    /**
     * Parse the @param XML node
     * @param pParser
     */
    default void parseXmlNode(XmlPullParser pParser) {
        HashMap<String, String> items;
        items = LayoutManager.setLayoutParams(this.getBuildView(), pParser);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {

            // This is a loop on a HashMap without lambda expression
            for (HashMap.Entry<String, String> entry : items.entrySet()) {
                this.setAttribute(entry.getKey(), entry.getValue());
            }
        } else {
            // This is a loop on a HashMap with lambda expression
            items.forEach( this::setAttribute );
        }
    }
}
