package com.gadgetscure.gadgetscureform;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button send;
    ScrollView scrollView;
    LinearLayout lin;
    public static int REQUEST_PERMISSIONS = 1;
    boolean boolean_permission;
    boolean boolean_save;
    private String[] info=InfoActivity.Information();
    private String[] recipients={" sysadmin@gadgetscure.com","rishabh7awasthi@gmail.com"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_main);

        TextView name=(TextView)findViewById(R.id.name);
        TextView email=(TextView)findViewById(R.id.mail);
        TextView address=(TextView)findViewById(R.id.address);
        TextView phone=(TextView)findViewById(R.id.phone);
        TextView date=(TextView)findViewById(R.id.date);
        TextView time=(TextView)findViewById(R.id.time);
        TextView brand=(TextView)findViewById(R.id.brand);
        TextView device_type=(TextView)findViewById(R.id.type);
        TextView model=(TextView)findViewById(R.id.model);
        TextView serial=(TextView)findViewById(R.id.serial);
        TextView warranty=(TextView)findViewById(R.id.warranty);
        TextView custreqdate=(TextView)findViewById(R.id.req_date);
        TextView damage=(TextView)findViewById(R.id.damaged);
        TextView passcode=(TextView)findViewById(R.id.password);
        TextView problem=(TextView)findViewById(R.id.problem);
        TextView diag_res=(TextView)findViewById(R.id.result);
        TextView ac_taken=(TextView)findViewById(R.id.actions);
        TextView hdd=(TextView)findViewById(R.id.hdd);
        TextView ram=(TextView)findViewById(R.id.ram);
        TextView adapter=(TextView)findViewById(R.id.adapter);
        TextView rdvd=(TextView)findViewById(R.id.rdvd);
        TextView hdno=(TextView)findViewById(R.id.hdd_sno);
        TextView ramno=(TextView)findViewById(R.id.ram_sno);
        TextView adano=(TextView)findViewById(R.id.adapter_no);
        TextView datadel=(TextView)findViewById(R.id.data);

        name.setText(info[0]);
         email.setText(info[1]);
      address.setText(info[2]);
        phone.setText(info[3]);
       date.setText(info[4]);
        time.setText(info[5]);
         brand.setText(info[6]);
         device_type.setText(info[7]);
         model.setText(info[8]);
        serial.setText(info[9]);
        warranty.setText(info[10]);
         custreqdate.setText(info[11]);
         damage.setText(info[12]);
        passcode.setText(info[13]);
         problem.setText(info[14]);
        diag_res.setText(info[15]);
        ac_taken.setText(info[16]);
         hdd.setText(info[17]);
         ram.setText(info[18]);
         adapter.setText(info[19]);
        rdvd.setText(info[20]);
         hdno.setText(info[21]);
         ramno.setText(info[22]);
         adano.setText(info[23]);
         datadel.setText(info[24]);


        init();
        fn_permission();

    }
    private void init() {
       send = (Button) findViewById(R.id.share);
        scrollView = (ScrollView)findViewById(R.id.scrollView);
        lin = (LinearLayout) findViewById(R.id.linmain);

      send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (boolean_save) {





                }else {
                    if (boolean_permission) {
                        Bitmap bitmap1 = loadBitmapFromView(lin, lin.getWidth(), lin.getHeight());
                        saveBitmap(bitmap1);
                    } else {

                    }
                }

            }
        });
    }
    public void saveBitmap(Bitmap bitmap) {

        File imagePath = new File(Environment.getExternalStorageDirectory() + "/" + "screenshotdemo.png");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            Toast.makeText(getApplicationContext(),imagePath.getAbsolutePath()+"", Toast.LENGTH_SHORT).show();
            boolean_save = true;
            composeEmail(recipients,"testing");

            Log.e("ImageSave", "Saveimage");
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }
    }

    public static Bitmap loadBitmapFromView(View v, int width, int height) {
        Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.draw(c);

        return b;
    }

    private void fn_permission() {
        if ((ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)||
                (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)) {

            if ((ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE))) {
            } else {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_PERMISSIONS);

            }

            if ((ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE))) {
            } else {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_PERMISSIONS);

            }
        } else {
            boolean_permission = true;


        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSIONS) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                boolean_permission = true;


            } else {
                Toast.makeText(getApplicationContext(), "Please allow the permission", Toast.LENGTH_LONG).show();

            }
        }
    }

    public void composeEmail(String[] addresses, String subject) {

        File filelocation = new File(Environment.getExternalStorageDirectory() + "/" + "screenshotdemo.png");
        Uri path = Uri.fromFile(filelocation);
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
// set the type to 'email'
        emailIntent .setType("vnd.android.cursor.dir/email");
        emailIntent .putExtra(Intent.EXTRA_EMAIL, addresses);
// the attachment
        emailIntent .putExtra(Intent.EXTRA_STREAM, path);
// the mail subject
        emailIntent .putExtra(Intent.EXTRA_SUBJECT,subject);
        startActivity(Intent.createChooser(emailIntent , "Send email..."));

    }



}



