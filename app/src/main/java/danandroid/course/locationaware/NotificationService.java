package danandroid.course.locationaware;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;


//Service = Main thread
//Intent Service = Background/Secondarythread
public class NotificationService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * Service name Used to name the worker thread, important only for debugging.
     */

    //Required Empty constructor:
    public NotificationService() {
        super("NotificationService");
    }

    //here the service will get it's mission parameters
    //the entry point to the service
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //Do some work:
        //How do we report the result?
        //Push notification: Te only UI that a service is meant to do.

        //Context context = this;

        //Build the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        //Bare minimum:
        builder.setContentTitle("This is the Title");
        builder.setContentText("The Text");
        builder.setSmallIcon(R.drawable.ic_snote);//Icon that matches the standards.
        //Pending Intent:
        //builder.setContentIntent()

        builder.setAutoCancel(true);

        Intent contentIntent = new Intent(this, MapsActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 1, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pi);

        Notification notification = builder.build();
        //title
        //message
        //icon
        //Action?

        // Context.getSystemService
        //NotificationManager nm2 = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //LayoutInflater inflater = ....

        //Show the notification
        NotificationManagerCompat nm = NotificationManagerCompat.from(this/*Context*/);
        nm.notify(1, notification);


        //Another option: Using the service as a Worker Service (Thread) -> How do we report? Broadcasts

    }
}
