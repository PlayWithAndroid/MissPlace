package com.example.anmol.missplace.SMS;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class smsSend {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    Context ctx;

    // Constructor
    public smsSend(Context ctx) {
        this.ctx = ctx;
    }

    // Sending SMS
    public void sendSMS(String number, String message) {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address"  ,number);
        smsIntent.putExtra("sms_body"  ,message);
        try {
            System.out.println("SMS Send");
        } catch (android.content.ActivityNotFoundException ex) {
        }
    }
}
