package anuson.komkid.permitgeographypro;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class Menu_farmer_1 extends FragmentActivity {

    //Explicit
    private ImageView imageView;
    private String[] userLoginStrings;


    final Context context = this;
    private Button button;

    //สไลรูปภาพ
    MyPageAdapter adapter;
    ViewPager pager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_farmer_1);

        //Bind Widget
        imageView = (ImageView) findViewById(R.id.imvFarmer);

        //Get Value from Intent
        userLoginStrings = getIntent().getStringArrayExtra("Login");

        //Check userLogin
        for (int i=0;i<userLoginStrings.length;i++) {
            Log.d("4novV2", "userLogin[" + i + "] = " + userLoginStrings[i]);
        }   // for

        //Show Image Farmer
        try {
            Picasso.with(Menu_farmer_1.this).load(userLoginStrings[13]).into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //สไลท์ภาพ
        adapter = new MyPageAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        button = (Button) findViewById(R.id.button_show_alert_dialog);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
//                alert.setTitle("ปลดล็อคชื่อผู้ใช้ที่ติดสถานะ ล็อค");
                alert.setMessage("กรุณาใส่ ชื่อผู้ใช้");

                final EditText input = new EditText(context);
                alert.setView(input);


                alert.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String srt = input.getEditableText().toString();
                        Toast.makeText(context, srt, Toast.LENGTH_LONG).show();
                    }
                });
                alert.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alert.create();
                alertDialog.show();
            }
        });
    }
}



