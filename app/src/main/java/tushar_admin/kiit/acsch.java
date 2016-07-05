package tushar_admin.kiit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by 1305108 on 18-09-2015.
 */
public class acsch extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_only);
        ImageView iv=(ImageView)findViewById(R.id.iv);
        iv.setImageResource(R.drawable.academiccalendar2015);
    }
}
