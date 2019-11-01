package android.support.v4.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class f extends g implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
  int a = 0;
  
  int b = 0;
  
  boolean c = true;
  
  boolean d = true;
  
  int e = -1;
  
  Dialog f;
  
  boolean g;
  
  boolean h;
  
  boolean i;
  
  public void a(Dialog paramDialog, int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 3:
        paramDialog.getWindow().addFlags(24);
        break;
      case 1:
      case 2:
        break;
    } 
    paramDialog.requestWindowFeature(1);
  }
  
  public void a(Context paramContext) {
    super.a(paramContext);
    if (!this.i)
      this.h = false; 
  }
  
  public void a(Bundle paramBundle) {
    boolean bool;
    super.a(paramBundle);
    if (this.I == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.d = bool;
    if (paramBundle != null) {
      this.a = paramBundle.getInt("android:style", 0);
      this.b = paramBundle.getInt("android:theme", 0);
      this.c = paramBundle.getBoolean("android:cancelable", true);
      this.d = paramBundle.getBoolean("android:showsDialog", this.d);
      this.e = paramBundle.getInt("android:backStackId", -1);
    } 
  }
  
  public void a(l paraml, String paramString) {
    this.h = false;
    this.i = true;
    q q = paraml.a();
    q.a(this, paramString);
    q.b();
  }
  
  void a(boolean paramBoolean) {
    if (this.h)
      return; 
    this.h = true;
    this.i = false;
    Dialog dialog = this.f;
    if (dialog != null)
      dialog.dismiss(); 
    this.g = true;
    if (this.e >= 0) {
      n().a(this.e, 1);
      this.e = -1;
      return;
    } 
    q q = n().a();
    q.a(this);
    if (paramBoolean) {
      q.c();
      return;
    } 
    q.b();
  }
  
  public LayoutInflater b(Bundle paramBundle) {
    if (!this.d)
      return super.b(paramBundle); 
    this.f = c(paramBundle);
    Dialog dialog = this.f;
    if (dialog != null) {
      a(dialog, this.a);
      Context context1 = this.f.getContext();
      return (LayoutInflater)context1.getSystemService("layout_inflater");
    } 
    Context context = this.C.g();
    return (LayoutInflater)context.getSystemService("layout_inflater");
  }
  
  public void b(boolean paramBoolean) { this.d = paramBoolean; }
  
  public int c() { return this.b; }
  
  public Dialog c(Bundle paramBundle) { return new Dialog(l(), c()); }
  
  public void d() {
    super.d();
    if (!this.i && !this.h)
      this.h = true; 
  }
  
  public void d(Bundle paramBundle) {
    super.d(paramBundle);
    if (!this.d)
      return; 
    View view = q();
    if (view != null)
      if (view.getParent() == null) {
        this.f.setContentView(view);
      } else {
        throw new IllegalStateException("DialogFragment can not be attached to a container view");
      }  
    h h1 = l();
    if (h1 != null)
      this.f.setOwnerActivity(h1); 
    this.f.setCancelable(this.c);
    this.f.setOnCancelListener(this);
    this.f.setOnDismissListener(this);
    if (paramBundle != null) {
      Bundle bundle = paramBundle.getBundle("android:savedDialogState");
      if (bundle != null)
        this.f.onRestoreInstanceState(bundle); 
    } 
  }
  
  public void e() {
    super.e();
    Dialog dialog = this.f;
    if (dialog != null) {
      this.g = false;
      dialog.show();
    } 
  }
  
  public void e(Bundle paramBundle) {
    super.e(paramBundle);
    Dialog dialog = this.f;
    if (dialog != null) {
      Bundle bundle = dialog.onSaveInstanceState();
      if (bundle != null)
        paramBundle.putBundle("android:savedDialogState", bundle); 
    } 
    int j = this.a;
    if (j != 0)
      paramBundle.putInt("android:style", j); 
    int k = this.b;
    if (k != 0)
      paramBundle.putInt("android:theme", k); 
    boolean bool1 = this.c;
    if (!bool1)
      paramBundle.putBoolean("android:cancelable", bool1); 
    boolean bool2 = this.d;
    if (!bool2)
      paramBundle.putBoolean("android:showsDialog", bool2); 
    int m = this.e;
    if (m != -1)
      paramBundle.putInt("android:backStackId", m); 
  }
  
  public void f() {
    super.f();
    Dialog dialog = this.f;
    if (dialog != null)
      dialog.hide(); 
  }
  
  public void g() {
    super.g();
    Dialog dialog = this.f;
    if (dialog != null) {
      this.g = true;
      dialog.dismiss();
      this.f = null;
    } 
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    if (!this.g)
      a(true); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */