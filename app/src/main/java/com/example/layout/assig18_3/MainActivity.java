package com.example.layout.assig18_3;
//Package objects contain version information about the implementation and specification of a Java package

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //public keyword is used in the declaration of a class,method or field;public classes,method and fields can be accessed by the members of any class.
//extends is for extending a class. implements is for implementing an interface
//AppCompatActivity is a class from e v7 appcompat library. This is a compatibility library that back ports some features of recent versions of
// Android to older devices.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Variables, methods, and constructors, which are declared protected in a superclass can be accessed only by the subclasses
        // in other package or any class within the package of the protected members class.
        //void is a Java keyword.  Used at method declaration and definition to specify that the method does not return any type,
        // the method returns void.
        //onCreate Called when the activity is first created. This is where you should do all of your normal static set up: create views,
        // bind data to lists, etc. This method also provides you with a Bundle containing the activity's previously frozen state,
        // if there was one.Always followed by onStart().
        //Bundle is most often used for passing data through various Activities.
// This callback is called only when there is a saved instance previously saved using onSaveInstanceState().
// We restore some state in onCreate() while we can optionally restore other state here, possibly usable after onStart() has
// completed.The savedInstanceState Bundle is same as the one used in onCreate().
        // call the super class onCreate to complete the creation of activity like the view hierarchy
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //R means Resource
        //layout means design
        //  main is the xml you have created under res->layout->main.xml
        //  Whenever you want to change your current Look of an Activity or when you move from one Activity to another .
        // The other Activity must have a design to show . So we call this method in onCreate and this is the second statement to set
        // the design
        ///findViewById:A user interface element that displays text to the user.
    }
    //created a  Method sendInboxStyleNotification()
    public void sendInboxStyleNotification(View view) {
        // A View occupies a rectangular area on the screen and is responsible for drawing and event handling.
        //created object of pendingIntent
        //A PendingIntent itself is simply a reference to a token maintained by the system describing the original data used to retrieve it
        PendingIntent pendingIntent = getPendingIntent();
        //Creating Builder for Notification
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                //Setting Title
                .setContentTitle("EVENT DETAIL")
                //Setting Text
                .setContentText("Inbox Style notification!!")
                //Setting Icon
                .setSmallIcon(R.mipmap.ic_launcher);

        Notification notification = null;
        //we are giving the values as null
//The user-visible SDK version of the framework; its possible values are defined in Build.VERSION_CODES. versions to be >= to jelly bean
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            notification = new NotificationCompat.InboxStyle(builder)
//Helper class for generating large-format notifications that include a list of (up to 5) strings.
// addLine(CharSequence cs)Append a line to the digest section of the Inbox notification.
                    .addLine("Hii alll").addLine("How are you?")
                    .addLine("Helo !!").addLine("i am fine...")
                    .addLine("what about you? Doing well?")
                    .addLine("Yes, every thing is all right..")
                    .build();//to built the msg
            // Put the auto cancel notification flag
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            //creating Object NotificationManager
            //Class to notify the user of events that happen.
            NotificationManager notificationManager = getNotificationManager();
            notificationManager.notify(0, notification);
            //manager will notify us
        }
    }
    //Creating PendingIntent Method()
    public PendingIntent getPendingIntent() {
        return PendingIntent.getActivity(this, 0, new Intent(this,
                Inbox_design.class), 0);
    }
    //creating getNotificationManager() for getting the Notification
    private NotificationManager getNotificationManager() {
        //notification manager returns the service
        //Return the handle to a system-level service by class.
        //Use with getSystemService(Class) to retrieve a NotificationManager for informing the user of background events.
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

}