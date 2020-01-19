package com.example.jobhunter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class ResumeActivity extends AppCompatActivity {
    EditText name,domain,address,email,expertise1,
            expertise2,expertise3,expertise4,companyname,companyloc,
            jobtitle,exp1,exp2,clgname,clgloc,degree,clgdur,clgpercent,
            clgachieve,schoolname,schoolloc,qual,schooldur,schoolpercent,
            schoolachieve,ach1,ach2,ach3;

    Button submitBT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        initUI();
        submitBT.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(ResumeActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ResumeActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    return;
                } else {
                    createPdf();
                }
            }
        });


    }
    private void initUI() {
        name = findViewById(R.id.nameET);
        domain = findViewById(R.id.domainET);
        address = findViewById(R.id.addressET);
        email = findViewById(R.id.emailET);
        expertise1 = findViewById(R.id.expertise1ET);
        expertise2 = findViewById(R.id.expertise2ET);
        expertise3 = findViewById(R.id.expertise3ET);
        expertise4 = findViewById(R.id.expertise4ET);
        companyname = findViewById(R.id.expcompanyET);
        companyloc = findViewById(R.id.explocationET);
        jobtitle = findViewById(R.id.expjobtitleET);
        exp1 = findViewById(R.id.exp1ET);
        exp2 = findViewById(R.id.exp2ET);
        clgname = findViewById(R.id.clgET);
        clgloc = findViewById(R.id.clglocationET);
        degree = findViewById(R.id.degreeET);
        clgdur = findViewById(R.id.degdurationET);
        clgpercent = findViewById(R.id.clgpercentET);
        clgachieve = findViewById(R.id.clgachievementET);
        schoolname = findViewById(R.id.schoolnameET);
        schoolloc = findViewById(R.id.schoollocET);
        qual = findViewById(R.id.qualET);
        schooldur = findViewById(R.id.schooldurET);
        schoolpercent = findViewById(R.id.schoolpercentET);
        schoolachieve = findViewById(R.id.schoolachievementET);
        ach1 = findViewById(R.id.achievement1ET);
        ach2 = findViewById(R.id.achievement2ET);
        ach3 = findViewById(R.id.achievement3ET);

        submitBT=findViewById(R.id.continueBT);

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void createPdf() {
        // create a new document
        PdfDocument document = new PdfDocument();
        // crate a page description
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(400, 800, 1).create();
        // start a page
        PdfDocument.Page page = document.startPage(pageInfo);
        Canvas canvas = page.getCanvas();

        //Heading Name  paint
        Typeface plainhead = Typeface.createFromAsset(getAssets(), "font/crimson.ttf");
        Typeface Boldhead = Typeface.create(plainhead,Typeface.BOLD);
        Paint paint = new Paint();
        paint.setTypeface(Boldhead);
        paint.setColor(Color.BLACK);
        paint.setTextSize(18);

        //Heading_2 Name  paint
        Typeface plainhead2 = Typeface.createFromAsset(getAssets(), "font/crimson.ttf");
        Typeface Boldhead2 = Typeface.create(plainhead,Typeface.BOLD);
        Paint paint_2 = new Paint();
        paint_2.setTypeface(Boldhead2);
        paint_2.setColor(getResources().getColor(R.color.blue));
        paint_2.setStyle(Paint.Style.FILL);
        paint_2.setTextSize(15);

        //Heading_3 Name  paint
        Typeface plainhead3 = Typeface.createFromAsset(getAssets(), "font/crimson.ttf");
        Paint paint_3 = new Paint();
        paint_3.setTypeface(plainhead3);
        paint_3.setColor(getResources().getColor(R.color.gray));
        paint_3.setStyle(Paint.Style.FILL);
        paint_3.setTextSize(10);

        //Heading Name  paint
        Typeface plainhead4 = Typeface.createFromAsset(getAssets(), "font/crimson.ttf");
        Paint paint4 = new Paint();
        paint4.setTypeface(plainhead4);
        paint4.setColor(Color.BLACK);
        paint4.setTextSize(13);

        //Heading Name  paint
        Typeface plainhead5 = Typeface.createFromAsset(getAssets(), "font/crimson.ttf");
        Paint paint5 = new Paint();
        paint5.setTypeface(plainhead5);
        paint5.setColor(Color.BLACK);
        paint5.setTextSize(15);

        //line paint
        Paint p_line = new Paint();
        p_line.setStyle(Paint.Style.STROKE);
        p_line.setStrokeWidth(6);
        p_line.setColor(getResources().getColor(R.color.blue));

        //para-1
        canvas.drawLine(20,25,380,25,p_line);
        canvas.drawText(name.getText().toString().trim(), 30, 50, paint);
        canvas.drawText(domain.getText().toString().trim(), 30, 65, paint_2);
        canvas.drawText(address.getText().toString().trim(), 30, 80, paint_3);
        canvas.drawText(email.getText().toString().trim(), 30, 95, paint_3);


        //para-2
        canvas.drawText("EXPERTISE  ", 30, 130, paint_2);
        canvas.drawText(expertise1.getText().toString().trim(), 60, 150, paint4);
        canvas.drawText(expertise2.getText().toString().trim(), 60, 170, paint4);
        canvas.drawText(expertise3.getText().toString().trim(), 60, 190, paint4);
        canvas.drawText(expertise4.getText().toString().trim(), 60, 210, paint4);

        //para-3
        canvas.drawText("EXPERIENCE ", 30, 250, paint_2);
        canvas.drawText(companyname.getText().toString().trim()+" , "+companyloc.getText().toString().trim(), 30, 270, paint5);
        canvas.drawText(exp1.getText().toString().trim(), 60, 290, paint4);
        canvas.drawText(exp2.getText().toString().trim(), 60, 310, paint4);

        //para-5
        canvas.drawText("EDUCATION ", 30, 340, paint_2);
        canvas.drawText(clgname.getText().toString().trim()+" , "+clgname.getText().toString().trim(), 30, 360, paint5);
        canvas.drawText(degree.getText().toString().trim(), 30, 380, paint4);
        canvas.drawText("Duration : "+clgdur.getText().toString().trim(), 30, 400, paint_3);
        canvas.drawText(clgpercent.getText().toString().trim(), 60, 420, paint4);
        canvas.drawText(clgachieve.getText().toString().trim(), 60, 440, paint4);

        //para-6
        canvas.drawText(schoolname.getText().toString().trim()+" , "+schoolloc.getText().toString().trim(), 30, 470, paint5);
        canvas.drawText(qual.getText().toString().trim(), 30, 490, paint4);
        canvas.drawText("Duration :"+schooldur.getText().toString().trim(), 30, 510, paint_3);
        canvas.drawText(schoolpercent.getText().toString().trim(), 60, 530, paint4);
        canvas.drawText(schoolpercent.getText().toString().trim(), 60, 550, paint4);

        //para-6
        canvas.drawText("ACHIEVEMENTS ", 30, 580, paint_2);
        canvas.drawText(ach1.getText().toString().trim(), 60, 600, paint4);
        canvas.drawText(ach2.getText().toString().trim(), 60, 620, paint4);
        canvas.drawText(ach3.getText().toString().trim(), 60, 640, paint4);
        //canvas.drawt
        // finish the page
        document.finishPage(page);
        // write the document content
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/JOBHUNTER_RESUME/";
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String targetPdf = directory_path + Calendar.getInstance().get(Calendar.MINUTE)+Calendar.getInstance().get(Calendar.SECOND)+".pdf";
        File filePath = new File(targetPdf);
        try {
            document.writeTo(new FileOutputStream(filePath));
            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.e("main", "error " + e.toString());
            Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
        }
        // close the document
        document.close();
    }
}
