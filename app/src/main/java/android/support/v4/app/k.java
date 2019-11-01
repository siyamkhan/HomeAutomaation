package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.g.k;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class k<E> extends i {
  private final Activity a;
  
  final m b = new m();
  
  private final Context c;
  
  private final Handler d;
  
  private final int e;
  
  k(Activity paramActivity, Context paramContext, Handler paramHandler, int paramInt) {
    this.a = paramActivity;
    this.c = (Context)k.a(paramContext, "context == null");
    this.d = (Handler)k.a(paramHandler, "handler == null");
    this.e = paramInt;
  }
  
  k(h paramh) { this(paramh, paramh, paramh.a, 0); }
  
  public View a(int paramInt) { return null; }
  
  public void a(g paramg, Intent paramIntent, int paramInt, Bundle paramBundle) {
    if (paramInt == -1) {
      this.c.startActivity(paramIntent);
      return;
    } 
    throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
  }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public boolean a() { return true; }
  
  public boolean a(g paramg) { return true; }
  
  public LayoutInflater b() { return LayoutInflater.from(this.c); }
  
  void b(g paramg) {}
  
  public void c() {}
  
  public boolean d() { return true; }
  
  public int e() { return this.e; }
  
  Activity f() { return this.a; }
  
  Context g() { return this.c; }
  
  Handler h() { return this.d; }
  
  m i() { return this.b; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */