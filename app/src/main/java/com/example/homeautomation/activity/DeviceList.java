package com.salyantech.homecontrolpanel.activity;

import android.app.AlertDialog;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.a.a;
import android.support.v4.app.a;
import android.support.v7.app.c;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.salyantech.homecontrolpanel.b;
import com.salyantech.homecontrolpanel.b.a;
import com.salyantech.homecontrolpanel.c;
import java.util.ArrayList;
import java.util.Set;

public class DeviceList extends c {
  public static String k = "device_address";
  
  private Button l;
  
  private ListView m;
  
  private AdapterView.OnItemClickListener n = new AdapterView.OnItemClickListener(this) {
      public void onItemClick(AdapterView param1AdapterView, View param1View, int param1Int, long param1Long) {
        String str1 = ((TextView)param1View).getText().toString();
        String str2 = str1.substring(-17 + str1.length());
        (b.a()).b.d = true;
        (b.a()).b.e = str2;
        c.a(this.a, PanelActivity.class);
      }
    };
  
  static  {
  
  }
  
  private void a(String paramString, DialogInterface.OnClickListener paramOnClickListener) { (new AlertDialog.Builder(this)).setMessage(paramString).setPositiveButton("OK", paramOnClickListener).setNegativeButton("Cancel", null).create().show(); }
  
  private void k() {
    c.e(this);
    if (!(b.a()).b.c) {
      c.a(this, getResources().getString(2131755118), getResources().getString(2131755152), this.l);
      (b.a()).b.c = true;
    } 
    l();
  }
  
  private void l() { this.l.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) { DeviceList.a(this.a); }
        }); }
  
  private void m() {
    Set set = a.a.b.getBondedDevices();
    ArrayList arrayList = new ArrayList();
    if (set.size() > 0) {
      for (BluetoothDevice bluetoothDevice : set) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bluetoothDevice.getName());
        stringBuilder.append("\n");
        stringBuilder.append(bluetoothDevice.getAddress());
        arrayList.add(stringBuilder.toString());
      } 
    } else {
      c.a(this, getResources().getString(2131755113));
    } 
    ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367043, arrayList);
    this.m.setAdapter(arrayAdapter);
    this.m.setOnItemClickListener(this.n);
  }
  
  private void n() {
    a((Toolbar)findViewById(2131296482));
    if (!o())
      p(); 
    this.l = (Button)findViewById(2131296297);
    this.m = (ListView)findViewById(2131296372);
  }
  
  private boolean o() { return (a.a(getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0); }
  
  private void p() { a.a(this, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 200); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131492894);
    n();
    k();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {
    if (paramInt != 200)
      return; 
    if (paramArrayOfInt.length > 0) {
      int i = paramArrayOfInt[0];
      boolean bool = false;
      if (i == 0)
        bool = true; 
      if (bool)
        return; 
      if (Build.VERSION.SDK_INT >= 23 && shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE"))
        a("You need to allow access to both the permissions", new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                if (Build.VERSION.SDK_INT >= 23)
                  this.a.requestPermissions(new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, 200); 
              }
            }); 
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\com\salyantech\homecontrolpanel\activity\DeviceList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */