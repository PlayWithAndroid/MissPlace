package com.example.anmol.missplace.SMS;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.example.anmol.missplace.MainActivity;

public class smsSend {
    Context ctx;
    // Constructor
    public smsSend(Context ctx) {
        this.ctx = ctx;
    }

    // Sending SMS
    public void sendSMS(String number, String message) {
        Intent intent=new Intent(ctx, MainActivity.class);
        PendingIntent pi= PendingIntent.getActivities(ctx,0, new Intent[]{intent},0);
        SmsManager sms= SmsManager.getDefault();
        sms.sendTextMessage(number, null,message, pi,null);
        Toast.makeText(ctx, "Message Sent successfully!",
                Toast.LENGTH_LONG).show();
    }
}
