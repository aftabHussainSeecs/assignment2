# assignment2
Android Application
package com.example.aftabhussain.integratetwitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;




// shared preferences for storing data
public class MainActivity extends AppCompatActivity {
    TwitterLoginButton loginButton;
    EditText ed1,ed2,ed3;
    Button b1;
// preferences of seven days of week
    public static final String MyPREF1 = "Monday" ;
    public static final String MyPREF2 = "Tuesday" ;
    public static final String MyPREF3 = "Wednesday" ;
    public static final String MyPREF4 = "Thursday" ;
    public static final String MyPREF5 = "Fridy" ;

    SharedPreferences sharedpreferences;
    private Bundle savedInstanceStates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        savedInstanceStates = savedInstanceState;
        super.onCreate(savedInstanceState);
        Twitter.initialize(this);
        setContentView(R.layout.activity_main);

        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
                TwitterAuthToken authToken = session.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;
                login(session);
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Toast.makeText(MainActivity.this,"Authentication Failed!",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void login(TwitterSession session)
    {
        String username=session.getUserName();
        Intent Intent=new Intent(MainActivity.this,MyHomePage.class);
        Intent.putExtra("username",username);
        startActivity(Intent);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);

        b1=(Button)findViewById(R.id.button);

        sharedpreferences = getSharedPreferences(MyPREF1, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("9:00", "Advance programming");
        editor.putString("11:00", "Computer Networking");
        editor.putString("1200:", "Softeware Engineeing");
        editor.putString("2:00:", "Operating System");
        editor.putString("3:00:", "Artifical Intellegence");
        editor.commit();

        sharedpreferences = getSharedPreferences(MyPREF2, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedpreferences.edit();
        editor1.putString("9:00", "Operating System");
        editor1.putString("10:00", "Computer Networking");
        editor1.putString("1200:", "Softeware Engineeing");
        editor1.putString("2:00:", " Advance programming");
        editor1.putString("3:00:", "Artifical Intellegence");
        editor1.commit();
        sharedpreferences = getSharedPreferences(MyPREF3, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedpreferences.edit();
        editor2.putString("9:00", "Artifical Intellegence ");
        editor2.putString("10:00", "Computer Networking");
        editor2.putString("1200:", "Softeware Engineeing");
        editor2.putString("2:00:", " Advance programming");
        editor2.putString("3:00:", "Operating System");
        editor2.commit();
        sharedpreferences = getSharedPreferences(MyPREF4, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor3 = sharedpreferences.edit();
        editor3.putString("9:00", "Softeware Engineeing ");
        editor3.putString("10:00", "Computer Networking");
        editor3.putString("1200", "Artifical Intellegence");
        editor3.putString("2:00", " Advance programming");
        editor3.putString("3:00", "Operating System");
        editor3.commit();
        sharedpreferences = getSharedPreferences(MyPREF5, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor4 = sharedpreferences.edit();
        editor4.putString("9:00", " Computer Networking");
        editor4.putString("10:00", "Advance programming");
        editor4.putString("1200", "Artifical Intellegence");
        editor4.putString("2:00", "Softeware Engineeing");
        editor4.putString("3:00", "Operating System");
        editor4.commit();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day  = ed1.getText().toString();
                String className  = ed1.getText().toString();

                sharedpreferences = getSharedPreferences(day, Context.MODE_PRIVATE);
                String ctime = sharedpreferences.getString(className, "");

                Toast.makeText(MainActivity.this,ctime,Toast.LENGTH_LONG).show();

            }
        });



    }




}






