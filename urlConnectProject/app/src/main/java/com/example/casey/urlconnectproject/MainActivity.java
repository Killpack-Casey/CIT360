        package com.example.casey.urlconnectproject;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;


        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.lang.ref.WeakReference;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.logging.Handler;

        import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends AppCompatActivity {

    Button urlButton;
    static TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        urlButton = (Button) findViewById(R.id.btn);
        text = (TextView) findViewById(R.id.text);

        //Nasty Path: Opening HTTP URL connection on the main thread. This can cause an
        //application to freeze or lock up.
        try {
            //URL url = new URL("http://www.measureup.com");

            // Create the http request, and open the connection
            //openConnection = (HttpURLConnection) url.openConnection();
            //openConnection.setRequestMethod("GET");
            //openConnection.setDoOutput(true);
            //openConnection.connect();
        }catch(Exception e){
            System.out.println("Nasty Path: Opening HTTP URL connection on the main thread");
        }

        //Happy Path: You should always create a seperate thread to handle the URL connection
        //in the background
        try {
            threadConnect connect = new threadConnect();
            Thread threadConnection = new Thread(connect);
            threadConnection.start();
            System.out.println("Thread created");
        }
        catch (Exception e){
            System.out.println("Thread not created");
        }

        urlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Nasty Path: Starting thread when button is clicked will make it so you
                //have to click twice to display contents to our TextView
                try {
                    //In order for this to set the text view have to click btn twice
                    //Nasty Path: Creating the thread when button is pressed
                    //threadConnect connect = new threadConnect();
                    //Thread threadConnection = new Thread(connect);
                    //threadConnection.start();

                    //Sets the text view to the input of the http request
                    String test = threadConnect.textInput.toString();
                    text.setText(test.toString());

                }catch(Exception e){
                    System.out.println("Nasty Path: Start thread when button is pressed");
                }
            }
        });
    }
}