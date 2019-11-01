package com.salyantech.homecontrolpanel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.b;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import b.a.a.a.a.a;
import b.a.a.a.a.b;
import b.a.a.a.b;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.a.d;
import com.google.android.gms.ads.a.f;
import com.google.android.gms.ads.c;
import com.salyantech.homecontrolpanel.b.a;
import com.salyantech.homecontrolpanel.c.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class c {
  private static f a;
  
  public static void a() {
    if (a.a()) {
      a.b();
    } else {
      Log.d("TAG", "The interstitial wasn't loaded yet.");
    } 
    a.a(new a() {
          public void c() { c.b().a((new d.a()).a()); }
        });
  }
  
  public static void a(Context paramContext) {
    a = new f(paramContext);
    a.a(paramContext.getString(2131755109));
    a.a((new d.a()).a());
  }
  
  public static void a(Context paramContext, Class<?> paramClass) { paramContext.startActivity(new Intent(paramContext, paramClass)); }
  
  public static void a(Context paramContext, String paramString) { Toast.makeText(paramContext, paramString, 1).show(); }
  
  public static void a(Context paramContext, String paramString1, String paramString2, View paramView) { (new b.a(paramContext)).a(paramString1).b(paramString2).a(b.b).a(a.b).a(paramView).a(12).b(14).a().b(); }
  
  public static void a(View paramView, Context paramContext, RecyclerView.a parama) {
    b.a a1 = new b.a(paramContext);
    a1.b(paramView);
    CheckBox checkBox = (CheckBox)paramView.findViewById(2131296304);
    a1.a(paramContext.getResources().getString(2131755090));
    a1.b(paramContext.getResources().getString(2131755054));
    a1.a(paramContext.getResources().getString(2131755162), new DialogInterface.OnClickListener(checkBox, paramContext, parama, a1) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (this.a.isChecked()) {
              for (byte b1 = 0; b1 < (b.a()).b.a.size(); b1++) {
                if (((a)(b.a()).b.a.get(b1)).d() == 1) {
                  ((a)(b.a()).b.a.get(b1)).a(0);
                  a.a.a(this.b, ((a)(b.a()).b.a.get(b1)).c().toLowerCase());
                } 
              } 
              this.c.c();
            } 
            a.a.b(this.b);
            this.d.b().dismiss();
          }
        });
    a1.b(paramContext.getResources().getString(2131755112), new DialogInterface.OnClickListener(a1) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) { this.a.b().dismiss(); }
        });
    a1.c();
  }
  
  public static void a(AdView paramAdView) { paramAdView.a((new c.a()).a()); }
  
  private static void a(InputStream paramInputStream, OutputStream paramOutputStream) {
    byte[] arrayOfByte = new byte[1024];
    while (true) {
      int i = paramInputStream.read(arrayOfByte);
      if (i != -1) {
        paramOutputStream.write(arrayOfByte, 0, i);
        continue;
      } 
      break;
    } 
  }
  
  public static void b(Context paramContext) {
    Object object;
    AssetManager assetManager = paramContext.getAssets();
    try {
      object = assetManager.list("Files");
    } catch (IOException iOException) {
      Log.e("tag", iOException.getMessage());
      object = null;
    } 
    int i = object.length;
    for (byte b = 0; b < i; b++) {
      String str1 = object[b];
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("File name => ");
      stringBuilder.append(str1);
      printStream.println(stringBuilder.toString());
      String str2 = (new File(String.valueOf(Environment.getExternalStorageDirectory()))).getAbsolutePath();
      try {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Files/");
        stringBuilder1.append(str1);
        InputStream inputStream = assetManager.open(stringBuilder1.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str2);
        stringBuilder2.append("/");
        stringBuilder2.append(str1);
        FileOutputStream fileOutputStream = new FileOutputStream(stringBuilder2.toString());
        a(inputStream, fileOutputStream);
        a(paramContext, paramContext.getResources().getString(2131755098));
        inputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
      } catch (Exception exception) {
        Log.e("tag", exception.getMessage());
        a(paramContext, exception.getMessage());
      } 
    } 
  }
  
  public static void c(Context paramContext) {
    try {
      Intent intent = new Intent("android.intent.action.SEND");
      intent.setType("text/plain");
      intent.putExtra("android.intent.extra.SUBJECT", "Home Control Panel");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("\nLet me recommend you this \napplication for controlling all your home appliances through your smart phone\n\n");
      stringBuilder.append("https://play.google.com/store/apps/details?id=");
      stringBuilder.append("com.salyantech.homecontrolpanel");
      stringBuilder.append("\n\n");
      paramContext.startActivity(intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString()).createChooser(intent, "choose one"));
    } catch (Exception exception) {}
  }
  
  public static void d(Context paramContext) {
    Intent intent = new Intent("android.intent.action.VIEW");
    intent.setData(Uri.parse("https://sites.google.com/view/hcp-privacy-policy"));
    paramContext.startActivity(intent);
  }
  
  public static void e(Context paramContext) { a.a.a(paramContext); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\com\salyantech\homecontrolpanel\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */