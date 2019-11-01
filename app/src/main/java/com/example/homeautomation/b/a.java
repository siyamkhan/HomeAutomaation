package com.salyantech.homecontrolpanel.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.salyantech.homecontrolpanel.c;
import java.io.IOException;
import java.util.UUID;

public class a {
  public static a a;
  
  private static final UUID c = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
  
  public BluetoothAdapter b;
  
  private BluetoothSocket d = null;
  
  private ProgressDialog e;
  
  private boolean f = false;
  
  static  {
    a = new a();
  }
  
  private void c(Context paramContext) {
    BluetoothAdapter bluetoothAdapter = this.b;
    if (bluetoothAdapter == null) {
      c.a(paramContext, paramContext.getResources().getString(2131755056));
      d(paramContext);
      return;
    } 
    if (!bluetoothAdapter.isEnabled()) {
      Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
      ((Activity)paramContext).startActivityForResult(intent, 1);
    } 
  }
  
  private void d(Context paramContext) { ((Activity)paramContext).finish(); }
  
  public void a(Context paramContext) {
    this.b = BluetoothAdapter.getDefaultAdapter();
    c(paramContext);
  }
  
  public void a(Context paramContext, String paramString) {
    BluetoothSocket bluetoothSocket = this.d;
    if (bluetoothSocket != null)
      try {
        bluetoothSocket.getOutputStream().write(paramString.getBytes());
        return;
      } catch (IOException iOException) {
        c.a(paramContext, paramContext.getResources().getString(2131755094));
      }  
  }
  
  public a b(Context paramContext, String paramString) { return new a(this, paramContext, paramString); }
  
  public void b(Context paramContext) {
    BluetoothSocket bluetoothSocket = this.d;
    if (bluetoothSocket != null)
      try {
        this.f = false;
        bluetoothSocket.close();
        return;
      } catch (IOException iOException) {
        c.a(paramContext, paramContext.getResources().getString(2131755094));
      }  
  }
  
  @SuppressLint({"StaticFieldLeak"})
  public class a extends AsyncTask<Void, Void, Void> {
    private boolean b = true;
    
    private Context c;
    
    private String d;
    
    public a(a this$0, Context param1Context, String param1String) {
      this.c = param1Context;
      this.d = param1String;
    }
    
    protected Void a(Void... param1VarArgs) {
      try {
        if (a.a(this.a) == null || !a.b(this.a)) {
          this.a.b = BluetoothAdapter.getDefaultAdapter();
          BluetoothDevice bluetoothDevice = this.a.b.getRemoteDevice(this.d);
          a.a(this.a, bluetoothDevice.createInsecureRfcommSocketToServiceRecord(a.a()));
          BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
          a.a(this.a).connect();
        } 
      } catch (IOException iOException) {
        this.b = false;
      } 
      return null;
    }
    
    protected void a(Void param1Void) {
      super.onPostExecute(param1Void);
      if (!this.b) {
        Context context = this.c;
        c.a(context, context.getResources().getString(2131755086));
      } else {
        Context context = this.c;
        c.a(context, context.getResources().getString(2131755084));
        a.a(this.a, true);
      } 
      a.c(this.a).dismiss();
    }
    
    protected void onPreExecute() {
      a a1 = this.a;
      Context context = this.c;
      a.a(a1, ProgressDialog.show(context, context.getResources().getString(2131755085), this.c.getResources().getString(2131755128)));
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\com\salyantech\homecontrolpanel\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */