package mn.moco.music.gogo.Utils;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;

public class Utils {

    private Context context;

    public Utils(Context context) {
        this.context = context;
    }

    public Point getDisplayPoints() {
        Display display = ((AppCompatActivity) context).getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        return point;
    }
}
