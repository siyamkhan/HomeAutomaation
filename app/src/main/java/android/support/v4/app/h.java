package android.support.v4.app;

import android.arch.lifecycle.c;
import android.arch.lifecycle.p;
import android.arch.lifecycle.q;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.g.m;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;

public class h extends ae implements q, a.a, a.c {
  final Handler a = new Handler(this) {
      public void handleMessage(Message param1Message) {
        if (param1Message.what != 2) {
          super.handleMessage(param1Message);
          return;
        } 
        this.a.c();
        this.a.b.m();
      }
    };
  
  final j b = j.a(new a(this));
  
  boolean c;
  
  boolean d;
  
  boolean e = true;
  
  boolean f;
  
  boolean g;
  
  boolean h;
  
  int i;
  
  m<String> j;
  
  private p k;
  
  private static boolean a(l paraml, c.b paramb) {
    Iterator iterator = paraml.c().iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      g g1 = (g)iterator.next();
      if (g1 == null)
        continue; 
      if (g1.a().a().a(c.b.d)) {
        g1.ac.a(paramb);
        bool = true;
      } 
      l l1 = g1.p();
      if (l1 != null)
        bool |= a(l1, paramb); 
    } 
    return bool;
  }
  
  private int b(g paramg) {
    if (this.j.b() < 65534) {
      while (this.j.f(this.i) >= 0)
        this.i = (1 + this.i) % 65534; 
      int n = this.i;
      this.j.b(n, paramg.p);
      this.i = (1 + this.i) % 65534;
      return n;
    } 
    throw new IllegalStateException("Too many pending Fragment activity results.");
  }
  
  static void b(int paramInt) {
    if ((paramInt & 0xFFFF0000) == 0)
      return; 
    throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
  }
  
  private void g() {
    do {
    
    } while (a(f(), c.b.c));
  }
  
  public c a() { return super.a(); }
  
  final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) { return this.b.a(paramView, paramString, paramContext, paramAttributeSet); }
  
  public final void a(int paramInt) {
    if (!this.f && paramInt != -1)
      b(paramInt); 
  }
  
  public void a(g paramg) {}
  
  public void a(g paramg, Intent paramIntent, int paramInt, Bundle paramBundle) {
    this.h = true;
    if (paramInt == -1)
      try {
        a.a(this, paramIntent, -1, paramBundle);
        return;
      } finally {
        this.h = false;
      }  
    b(paramInt);
    a.a(this, paramIntent, (1 + b(paramg) << 16) + (paramInt & 0xFFFF), paramBundle);
    this.h = false;
  }
  
  protected boolean a(View paramView, Menu paramMenu) { return super.onPreparePanel(0, paramView, paramMenu); }
  
  public p b() {
    if (getApplication() != null) {
      if (this.k == null) {
        b b1 = (b)getLastNonConfigurationInstance();
        if (b1 != null)
          this.k = b1.b; 
        if (this.k == null)
          this.k = new p(); 
      } 
      return this.k;
    } 
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  protected void c() { this.b.h(); }
  
  public Object d() { return null; }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("  ");
    String str = stringBuilder.toString();
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.c);
    paramPrintWriter.print(" mResumed=");
    paramPrintWriter.print(this.d);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.e);
    if (getApplication() != null)
      u.a(this).a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString); 
    this.b.a().a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  @Deprecated
  public void e() { invalidateOptionsMenu(); }
  
  public l f() { return this.b.a(); }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    this.b.b();
    int n = paramInt1 >> 16;
    if (n != 0) {
      int i1 = n - 1;
      String str = (String)this.j.a(i1);
      this.j.c(i1);
      if (str == null) {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        return;
      } 
      g g1 = this.b.a(str);
      if (g1 == null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Activity result no fragment exists for who: ");
        stringBuilder.append(str);
        Log.w("FragmentActivity", stringBuilder.toString());
        return;
      } 
      g1.a(paramInt1 & 0xFFFF, paramInt2, paramIntent);
      return;
    } 
    a.b b1 = a.a();
    if (b1 != null && b1.a(this, paramInt1, paramInt2, paramIntent))
      return; 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed() {
    l l = this.b.a();
    boolean bool = l.d();
    if (bool && Build.VERSION.SDK_INT <= 25)
      return; 
    if (bool || !l.b())
      super.onBackPressed(); 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    this.b.b();
    this.b.a(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle) {
    this.b.a(null);
    super.onCreate(paramBundle);
    b b1 = (b)getLastNonConfigurationInstance();
    if (b1 != null && b1.b != null && this.k == null)
      this.k = b1.b; 
    if (paramBundle != null) {
      Parcelable parcelable = paramBundle.getParcelable("android:support:fragments");
      j j1 = this.b;
      n n = null;
      if (b1 != null)
        n = b1.c; 
      j1.a(parcelable, n);
      if (paramBundle.containsKey("android:support:next_request_index")) {
        this.i = paramBundle.getInt("android:support:next_request_index");
        int[] arrayOfInt = paramBundle.getIntArray("android:support:request_indicies");
        String[] arrayOfString = paramBundle.getStringArray("android:support:request_fragment_who");
        if (arrayOfInt == null || arrayOfString == null || arrayOfInt.length != arrayOfString.length) {
          Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
        } else {
          this.j = new m(arrayOfInt.length);
          for (byte b2 = 0; b2 < arrayOfInt.length; b2++)
            this.j.b(arrayOfInt[b2], arrayOfString[b2]); 
        } 
      } 
    } 
    if (this.j == null) {
      this.j = new m();
      this.i = 0;
    } 
    this.b.e();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu) { return (paramInt == 0) ? (super.onCreatePanelMenu(paramInt, paramMenu) | this.b.a(paramMenu, getMenuInflater())) : super.onCreatePanelMenu(paramInt, paramMenu); }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    View view = a(paramView, paramString, paramContext, paramAttributeSet);
    return (view == null) ? super.onCreateView(paramView, paramString, paramContext, paramAttributeSet) : view;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    View view = a(null, paramString, paramContext, paramAttributeSet);
    return (view == null) ? super.onCreateView(paramString, paramContext, paramAttributeSet) : view;
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.k != null && !isChangingConfigurations())
      this.k.a(); 
    this.b.k();
  }
  
  public void onLowMemory() {
    super.onLowMemory();
    this.b.l();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) { return super.onMenuItemSelected(paramInt, paramMenuItem) ? true : ((paramInt != 0) ? ((paramInt != 6) ? false : this.b.b(paramMenuItem)) : this.b.a(paramMenuItem)); }
  
  public void onMultiWindowModeChanged(boolean paramBoolean) { this.b.a(paramBoolean); }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    this.b.b();
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu) {
    if (paramInt == 0)
      this.b.b(paramMenu); 
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPause() {
    super.onPause();
    this.d = false;
    if (this.a.hasMessages(2)) {
      this.a.removeMessages(2);
      c();
    } 
    this.b.i();
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean) { this.b.b(paramBoolean); }
  
  protected void onPostResume() {
    super.onPostResume();
    this.a.removeMessages(2);
    c();
    this.b.m();
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu) { return (paramInt == 0 && paramMenu != null) ? (a(paramView, paramMenu) | this.b.a(paramMenu)) : super.onPreparePanel(paramInt, paramView, paramMenu); }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {
    this.b.b();
    int n = 0xFFFF & paramInt >> 16;
    if (n != 0) {
      int i1 = n - 1;
      String str = (String)this.j.a(i1);
      this.j.c(i1);
      if (str == null) {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        return;
      } 
      g g1 = this.b.a(str);
      if (g1 == null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Activity result no fragment exists for who: ");
        stringBuilder.append(str);
        Log.w("FragmentActivity", stringBuilder.toString());
        return;
      } 
      g1.a(paramInt & 0xFFFF, paramArrayOfString, paramArrayOfInt);
    } 
  }
  
  protected void onResume() {
    super.onResume();
    this.a.sendEmptyMessage(2);
    this.d = true;
    this.b.m();
  }
  
  public final Object onRetainNonConfigurationInstance() {
    Object object = d();
    n n = this.b.d();
    if (n == null && this.k == null && object == null)
      return null; 
    b b1 = new b();
    b1.a = object;
    b1.b = this.k;
    b1.c = n;
    return b1;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    g();
    Parcelable parcelable = this.b.c();
    if (parcelable != null)
      paramBundle.putParcelable("android:support:fragments", parcelable); 
    if (this.j.b() > 0) {
      paramBundle.putInt("android:support:next_request_index", this.i);
      int[] arrayOfInt = new int[this.j.b()];
      String[] arrayOfString = new String[this.j.b()];
      for (byte b1 = 0; b1 < this.j.b(); b1++) {
        arrayOfInt[b1] = this.j.d(b1);
        arrayOfString[b1] = (String)this.j.e(b1);
      } 
      paramBundle.putIntArray("android:support:request_indicies", arrayOfInt);
      paramBundle.putStringArray("android:support:request_fragment_who", arrayOfString);
    } 
  }
  
  protected void onStart() {
    super.onStart();
    this.e = false;
    if (!this.c) {
      this.c = true;
      this.b.f();
    } 
    this.b.b();
    this.b.m();
    this.b.g();
  }
  
  public void onStateNotSaved() { this.b.b(); }
  
  protected void onStop() {
    super.onStop();
    this.e = true;
    g();
    this.b.j();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt) {
    if (!this.h && paramInt != -1)
      b(paramInt); 
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {
    if (!this.h && paramInt != -1)
      b(paramInt); 
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4) {
    if (!this.g && paramInt1 != -1)
      b(paramInt1); 
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle) {
    if (!this.g && paramInt1 != -1)
      b(paramInt1); 
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  class a extends k<h> {
    public a(h this$0) { super(this$0); }
    
    public View a(int param1Int) { return this.a.findViewById(param1Int); }
    
    public void a(g param1g, Intent param1Intent, int param1Int, Bundle param1Bundle) { this.a.a(param1g, param1Intent, param1Int, param1Bundle); }
    
    public void a(String param1String, FileDescriptor param1FileDescriptor, PrintWriter param1PrintWriter, String[] param1ArrayOfString) { this.a.dump(param1String, param1FileDescriptor, param1PrintWriter, param1ArrayOfString); }
    
    public boolean a() {
      Window window = this.a.getWindow();
      return (window != null && window.peekDecorView() != null);
    }
    
    public boolean a(g param1g) { return true ^ this.a.isFinishing(); }
    
    public LayoutInflater b() { return this.a.getLayoutInflater().cloneInContext(this.a); }
    
    public void b(g param1g) { this.a.a(param1g); }
    
    public void c() { this.a.e(); }
    
    public boolean d() { return (this.a.getWindow() != null); }
    
    public int e() {
      Window window = this.a.getWindow();
      return (window == null) ? 0 : (window.getAttributes()).windowAnimations;
    }
  }
  
  static final class b {
    Object a;
    
    p b;
    
    n c;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */