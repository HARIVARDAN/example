package com.example.hari.fragment;

/**
 * Created by Hari on 3/18/2016.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import static android.widget.Toast.LENGTH_LONG;




//import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by Hari on 3/10/2016.
 */
public class Background extends AsyncTask<String,Void,String> {

    AlertDialog alertDialog;
    Context ctx;
    Background(Context ctx){
        this.ctx=ctx;
    }



    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information");
    }


    @Override
    protected String doInBackground(String... params) {


        String reg_url="http://10.0.2.2/android/register.php";
        String login_url="http://10.0.2.2/android/login.php";

        String method=params[0];
        if(method.equals("register")) {

            String name=params[1];
            String password=params[2];
            String city=params[3];
            String phone=params[4];
            String email=params[5];


            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));

                String data= URLEncoder.encode("name", "UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password, "UTF-8")+"&"+
                        URLEncoder.encode("city","UTF-8")+"="+URLEncoder.encode(city,"UTF-8")+"&"+
                        URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS=httpURLConnection.getInputStream();
                IS.close();
                return "Registration successful";

            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (Exception e) {
                e.printStackTrace();
            }


        }

        else if(method.equals("login")) {

            String luser=params[1];
            String lpassword=params[2];
            try {
                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String data= URLEncoder.encode("luser","UTF-8")+"="+URLEncoder.encode(luser,"UTF-8")+"&"+
                        URLEncoder.encode("lpassword","UTF-8")+"="+URLEncoder.encode(lpassword,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";

                while((line=bufferedReader.readLine())!=null) {
                    response+=line;

                }



                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return null;
    }


    @Override

    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


    @Override
    protected void onPostExecute(String result) {







        if(result.equals("Registration successful"))
        {
            Toast.makeText(ctx, result, LENGTH_LONG).show();
        }

        else
        {
            alertDialog.setMessage(result);
            alertDialog.show();

            Intent intent = new Intent("com.example.hari.fragment.head");
            ctx.startActivity(intent);


        }



    }






}

