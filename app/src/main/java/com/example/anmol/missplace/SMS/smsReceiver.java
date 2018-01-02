package com.example.anmol.missplace.SMS;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.annotation.RequiresPermission;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

import com.example.anmol.missplace.Credential.SavingData;
import com.example.anmol.missplace.Credential.SecurityPinNo;

public class smsReceiver extends BroadcastReceiver {

    final SmsManager sms = SmsManager.getDefault();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {


        final Bundle bundle = intent.getExtras();

        Intent intent1 = new Intent("smsReceiver");

        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    String format = bundle.getString("format");

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i], format);

                    // Phone Number
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;

                    // Message
                    String message = currentMessage.getDisplayMessageBody();

                    System.out.println(phoneNumber);
                    System.out.println(message);

                    if (message.replaceAll("[^0-9]", "").equals(new SecurityPinNo(context).getPinNo()) && message.contains("mpla")) {
                        System.out.println(message);
                        //Reading Contacts

                        ReadContacts(message,context,senderNum);
                    }

                    // Saving Message
                    SavingData sd = new SavingData(context);
                    sd.saveData(message);

                }
            }

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e);

        }
    }

    /*
        reading the contact and sending the sms
     */
    public void ReadContacts(String message, Context ctx,String senderNum) {

        String name = message.replaceAll("[0-9]", "").replace("name", "").replaceAll("\\s+","").replace("mpla","");
        System.out.println(name);
        ContentResolver cr = ctx.getContentResolver();
        Cursor cur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null);
        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                String name1 = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phno = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                if (name1!=null && name1.contains(name)){
                        System.out.println(phno);
                        smsSend s=new smsSend(ctx);
                        s.sendSMS(senderNum,phno);
                        break;
                   }
                }
            }
        }
}