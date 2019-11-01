package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class x {
  public static Bundle a(Notification paramNotification) { return (Build.VERSION.SDK_INT >= 19) ? paramNotification.extras : ((Build.VERSION.SDK_INT >= 16) ? z.a(paramNotification) : null); }
  
  public static class a {
    final Bundle a;
    
    boolean b = true;
    
    public int c;
    
    public CharSequence d;
    
    public PendingIntent e;
    
    private final ab[] f;
    
    private final ab[] g;
    
    private boolean h;
    
    private final int i;
    
    public a(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent) { this(param1Int, param1CharSequence, param1PendingIntent, new Bundle(), null, null, true, 0, true); }
    
    a(int param1Int1, CharSequence param1CharSequence, PendingIntent param1PendingIntent, Bundle param1Bundle, ab[] param1ArrayOfab1, ab[] param1ArrayOfab2, boolean param1Boolean1, int param1Int2, boolean param1Boolean2) {
      this.c = param1Int1;
      this.d = x.c.d(param1CharSequence);
      this.e = param1PendingIntent;
      if (param1Bundle == null)
        param1Bundle = new Bundle(); 
      this.a = param1Bundle;
      this.f = param1ArrayOfab1;
      this.g = param1ArrayOfab2;
      this.h = param1Boolean1;
      this.i = param1Int2;
      this.b = param1Boolean2;
    }
    
    public int a() { return this.c; }
    
    public CharSequence b() { return this.d; }
    
    public PendingIntent c() { return this.e; }
    
    public Bundle d() { return this.a; }
    
    public boolean e() { return this.h; }
    
    public ab[] f() { return this.f; }
    
    public int g() { return this.i; }
    
    public ab[] h() { return this.g; }
    
    public boolean i() { return this.b; }
  }
  
  public static class b extends d {
    private CharSequence e;
    
    public b a(CharSequence param1CharSequence) {
      this.e = x.c.d(param1CharSequence);
      return this;
    }
    
    public void a(w param1w) {
      if (Build.VERSION.SDK_INT >= 16) {
        Notification.BigTextStyle bigTextStyle = (new Notification.BigTextStyle(param1w.a())).setBigContentTitle(this.b).bigText(this.e);
        if (this.d)
          bigTextStyle.setSummaryText(this.c); 
      } 
    }
  }
  
  public static class c {
    String A;
    
    Bundle B;
    
    int C = 0;
    
    int D = 0;
    
    Notification E;
    
    RemoteViews F;
    
    RemoteViews G;
    
    RemoteViews H;
    
    String I;
    
    int J = 0;
    
    String K;
    
    long L;
    
    int M = 0;
    
    Notification N = new Notification();
    
    @Deprecated
    public ArrayList<String> O;
    
    public Context a;
    
    public ArrayList<x.a> b = new ArrayList();
    
    ArrayList<x.a> c = new ArrayList();
    
    CharSequence d;
    
    CharSequence e;
    
    PendingIntent f;
    
    PendingIntent g;
    
    RemoteViews h;
    
    Bitmap i;
    
    CharSequence j;
    
    int k;
    
    int l;
    
    boolean m = true;
    
    boolean n;
    
    x.d o;
    
    CharSequence p;
    
    CharSequence[] q;
    
    int r;
    
    int s;
    
    boolean t;
    
    String u;
    
    boolean v;
    
    String w;
    
    boolean x = false;
    
    boolean y;
    
    boolean z;
    
    @Deprecated
    public c(Context param1Context) { this(param1Context, null); }
    
    public c(Context param1Context, String param1String) {
      this.a = param1Context;
      this.I = param1String;
      this.N.when = System.currentTimeMillis();
      this.N.audioStreamType = -1;
      this.l = 0;
      this.O = new ArrayList();
    }
    
    private void a(int param1Int, boolean param1Boolean) {
      int i1;
      Notification notification;
      if (param1Boolean) {
        notification = this.N;
        i1 = param1Int | notification.flags;
      } else {
        notification = this.N;
        i1 = notification.flags & (param1Int ^ 0xFFFFFFFF);
      } 
      notification.flags = i1;
    }
    
    protected static CharSequence d(CharSequence param1CharSequence) {
      if (param1CharSequence == null)
        return param1CharSequence; 
      if (param1CharSequence.length() > 5120)
        param1CharSequence = param1CharSequence.subSequence(0, 5120); 
      return param1CharSequence;
    }
    
    public Bundle a() {
      if (this.B == null)
        this.B = new Bundle(); 
      return this.B;
    }
    
    public c a(int param1Int) {
      this.N.icon = param1Int;
      return this;
    }
    
    public c a(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent) {
      this.b.add(new x.a(param1Int, param1CharSequence, param1PendingIntent));
      return this;
    }
    
    public c a(long param1Long) {
      this.N.when = param1Long;
      return this;
    }
    
    public c a(PendingIntent param1PendingIntent) {
      this.f = param1PendingIntent;
      return this;
    }
    
    public c a(x.d param1d) {
      if (this.o != param1d) {
        this.o = param1d;
        x.d d1 = this.o;
        if (d1 != null)
          d1.a(this); 
      } 
      return this;
    }
    
    public c a(CharSequence param1CharSequence) {
      this.d = d(param1CharSequence);
      return this;
    }
    
    public c a(String param1String) {
      this.I = param1String;
      return this;
    }
    
    public c a(boolean param1Boolean) {
      a(16, param1Boolean);
      return this;
    }
    
    public Notification b() { return (new y(this)).b(); }
    
    public c b(int param1Int) {
      this.l = param1Int;
      return this;
    }
    
    public c b(CharSequence param1CharSequence) {
      this.e = d(param1CharSequence);
      return this;
    }
    
    public c b(boolean param1Boolean) {
      this.x = param1Boolean;
      return this;
    }
    
    public c c(CharSequence param1CharSequence) {
      this.N.tickerText = d(param1CharSequence);
      return this;
    }
  }
  
  public static abstract class d {
    protected x.c a;
    
    CharSequence b;
    
    CharSequence c;
    
    boolean d = false;
    
    public void a(Bundle param1Bundle) {}
    
    public void a(w param1w) {}
    
    public void a(x.c param1c) {
      if (this.a != param1c) {
        this.a = param1c;
        x.c c1 = this.a;
        if (c1 != null)
          c1.a(this); 
      } 
    }
    
    public RemoteViews b(w param1w) { return null; }
    
    public RemoteViews c(w param1w) { return null; }
    
    public RemoteViews d(w param1w) { return null; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */