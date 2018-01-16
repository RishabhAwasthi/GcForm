package com.gadgetscure.gadgetscureform;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class InfoActivity extends AppCompatActivity {
    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID=1;

    private EditText date,custreqdate,name,email,address,phone,brand,model;

    private int mYear;
    private int mMonth;
    private int mDay;
    private int hr,min;
    private  int dd,mm,yy;




   private static String mname,memail, maddress, mphone, mdate, mtime, mbrand, mdevice_type,ampm;
    private static  String mmodel,mserial, mwarranty, mcustreqdate, mdamage, mpasscode, mproblem, mdiag_res, mac_taken, mhdd, mram;
    private static  String madapter, mrdvd, mhdno, mramno, madano, mdatadel;
   private static String[] info;


    private EditText time,device_type,serial,warranty,damage,passcode,problem,diag_res,ac_taken,hdd,ram,adapter,rdvd,hdno;
   private EditText ramno,adano,datadel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
         name=(EditText)findViewById(R.id.user_name);
        email=(EditText)findViewById(R.id.user_email);
        address=(EditText)findViewById(R.id.address_et);
         phone=(EditText)findViewById(R.id.phone_num);
         date=(EditText)findViewById(R.id.mPickDate);
        time=(EditText)findViewById(R.id.time_et);
        brand=(EditText)findViewById(R.id.brand_name);
       device_type=(EditText)findViewById(R.id.device_type);
        model=(EditText)findViewById(R.id.mno);
        serial=(EditText)findViewById(R.id.sno);
         warranty=(EditText)findViewById(R.id.warranty_type);
         custreqdate=(EditText)findViewById(R.id.reqdate);
        damage=(EditText)findViewById(R.id.damage);
         passcode=(EditText)findViewById(R.id.passcode);
         problem=(EditText)findViewById(R.id.issue);
         diag_res=(EditText)findViewById(R.id.diag_res);
        ac_taken=(EditText)findViewById(R.id.ac);
        hdd=(EditText)findViewById(R.id.hd);
         ram=(EditText)findViewById(R.id.ra);
        adapter=(EditText)findViewById(R.id.ada);
        rdvd=(EditText)findViewById(R.id.rd);
         hdno=(EditText)findViewById(R.id.hdno);
         ramno=(EditText)findViewById(R.id.ramno);
         adano=(EditText)findViewById(R.id.adano);
        datadel=(EditText)findViewById(R.id.datadel);






Button preview=(Button)findViewById(R.id.preview);
        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mname =name.getText().toString();

                memail =email.getText().toString();
                maddress= address.getText().toString();

                mphone = phone.getText().toString();
                mdate= date.getText().toString();
                mtime=time.getText().toString();

                mbrand = brand.getText().toString();
                mdevice_type  = device_type.getText().toString();
                mmodel=  model.getText().toString();

                mserial =serial.getText().toString();
                mwarranty = warranty.getText().toString();
                mcustreqdate =custreqdate.getText().toString();
                mdamage =damage.getText().toString();
                mpasscode =passcode.getText().toString();
                mproblem = problem.getText().toString();
                mdiag_res =diag_res.getText().toString();
                mac_taken =ac_taken.getText().toString();
                mhdd = hdd.getText().toString();
                mram =ram.getText().toString();
                madapter =adapter.getText().toString();
                mrdvd =rdvd.getText().toString();
                mhdno = hdno.getText().toString();
                mramno =ramno.getText().toString();
                madano =adano.getText().toString();
                mdatadel =datadel.getText().toString();


                startActivity(new Intent(InfoActivity.this,MainActivity.class));
            }
        });

  //button for showing date picker dialog
        date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { showDialog(DATE_DIALOG_ID); }
        });

        // get the current date
        final Calendar c = Calendar.getInstance();
       mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
         mDay = c.get(Calendar.DAY_OF_MONTH);
        date.setText(//this is the edit text where you want to show the selected date
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(mDay).append("-")
                        .append(mMonth + 1).append("-")
                        .append(mYear).append(""));
        dd=mDay;
        mm=mMonth;
        yy=mYear;


        // display the current date



        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // showTimePickerDialog(view);
                showDialog(TIME_DIALOG_ID);
            }
        });
        Calendar initialTime = Calendar.getInstance();

        hr = initialTime.get(Calendar.HOUR_OF_DAY);
         min= initialTime.get(Calendar.MINUTE);
        updateDisplayTime();
        custreqdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);
            }
        });
        updateDisplay();

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id== DATE_DIALOG_ID)
            return new DatePickerDialog(this, mDateSetListener, mYear, mMonth, mDay);
        else if(id==TIME_DIALOG_ID) {
            return new TimePickerDialog(this, mTimeSetListener, hr, min,false);
        }

        return null;
    }


    private void updateDisplay() {
        if(mYear>yy)
        {
            if(mYear==yy+1) {

                custreqdate.setText(//this is the edit text where you want to show the selected date
                        new StringBuilder()
                                // Month is 0 based so add 1
                                .append(mDay).append("-")
                                .append(mMonth + 1).append("-")
                                .append(mYear).append(""));
            }
            else {

                custreqdate.setText("Enter a valid Date");
                Toast.makeText(this, "Unfortunately we don't have a time machine !!", Toast.LENGTH_SHORT).show();

            }

        }
        else {
            if (mDay < dd || mMonth < mm || mYear < yy) {

                custreqdate.setText("Enter a valid Date");
                Toast.makeText(this, "Unfortunately we don't have a time machine !!", Toast.LENGTH_SHORT).show();
            } else {

                custreqdate.setText(//this is the edit text where you want to show the selected date
                        new StringBuilder()
                                // Month is 0 based so add 1
                                .append(mDay).append("-")
                                .append(mMonth + 1).append("-")
                                .append(mYear).append(""));
            }
        }

    }


    private void updateDisplayTime() {
        String newtime;
        if(hr< 12) {
            ampm = "AM";
        } else {
            ampm = "PM";
        }
        if(min<10)
            newtime= "0"+String.valueOf(min);
        else
            newtime=String.valueOf(min);

            time.setText(//this is the edit text where you want to show the selected date
                    new StringBuilder()
                            // Month is 0 based so add 1
                            .append(hr).append(":")
                            .append(newtime).append(" ")
                            .append(ampm));
        }

    // the call back received when the user "sets" the date in the dialog
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();
                }
            };

    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int i, int i1) {
                    hr=i;
                    min=i1;
                    updateDisplayTime();
                }

            };



    public static String[] Information()
    {
        info= new String[]{mname, memail, maddress, mphone, mdate, mtime, mbrand, mdevice_type
                , mmodel, mserial, mwarranty, mcustreqdate, mdamage, mpasscode, mproblem, mdiag_res, mac_taken, mhdd, mram,
                madapter, mrdvd, mhdno, mramno, madano, mdatadel};
        return info;
    }
}
