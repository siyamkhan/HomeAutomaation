package com.salyantech.homecontrolpanel;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.a.e;

public class b {
  static b a;
  
  public a b;
  
  String c = "0";
  
  protected String d;
  
  protected SharedPreferences e;
  
  e f = new e();
  
  private String g = "SessionData";
  
  private Context h;
  
  public static b a() {
    if (a == null)
      a = new b(); 
    return a;
  }
  
  public String a(Integer paramInteger) {
    paramInteger.intValue();
    return this.e.getString(paramInteger.toString(), "");
  }
  
  public void a(Context paramContext) {
    this.h = paramContext;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramContext.getPackageName());
    stringBuilder1.append(".prefFile");
    this.d = stringBuilder1.toString();
    this.e = paramContext.getSharedPreferences(this.d, 0);
    this.c = a(Integer.valueOf(21));
    String str = a(Integer.valueOf(100));
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("SessionData: ");
    stringBuilder2.append(str);
    Log.d("TAG", stringBuilder2.toString());
    if (!this.c.equals("2") || str.length() <= 1) {
      this.c = "2";
      this.b = new a();
      b();
      return;
    } 
    if (str.length() > 1)
      try {
        this.b = (a)this.f.a(str, a.class);
        return;
      } catch (Exception exception) {
        this.b = new a();
        return;
      }  
  }
  
  public void a(Integer paramInteger, String paramString) { this.e.edit().putString(paramInteger.toString(), paramString).apply(); }
  
  public void b() {
    a(Integer.valueOf(21), this.c);
    String str = this.f.a(this.b, a.class);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("saveData: ");
    stringBuilder.append(str);
    Log.d("TAG", stringBuilder.toString());
    a(Integer.valueOf(100), str);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\com\salyantech\homecontrolpanel\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */