package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.a.a;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

public class b extends g implements DialogInterface {
  final AlertController a = new AlertController(getContext(), this, getWindow());
  
  protected b(Context paramContext, int paramInt) { super(paramContext, a(paramContext, paramInt)); }
  
  static int a(Context paramContext, int paramInt) {
    if ((0xFF & paramInt >>> 24) >= 1)
      return paramInt; 
    TypedValue typedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(a.a.alertDialogTheme, typedValue, true);
    return typedValue.resourceId;
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.a.a();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) { return this.a.a(paramInt, paramKeyEvent) ? true : super.onKeyDown(paramInt, paramKeyEvent); }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) { return this.a.b(paramInt, paramKeyEvent) ? true : super.onKeyUp(paramInt, paramKeyEvent); }
  
  public void setTitle(CharSequence paramCharSequence) {
    super.setTitle(paramCharSequence);
    this.a.a(paramCharSequence);
  }
  
  public static class a {
    private final AlertController.a a;
    
    private final int b;
    
    public a(Context param1Context) { this(param1Context, b.a(param1Context, 0)); }
    
    public a(Context param1Context, int param1Int) {
      this.a = new AlertController.a(new ContextThemeWrapper(param1Context, b.a(param1Context, param1Int)));
      this.b = param1Int;
    }
    
    public Context a() { return this.a.a; }
    
    public a a(DialogInterface.OnKeyListener param1OnKeyListener) {
      this.a.u = param1OnKeyListener;
      return this;
    }
    
    public a a(Drawable param1Drawable) {
      this.a.d = param1Drawable;
      return this;
    }
    
    public a a(View param1View) {
      this.a.g = param1View;
      return this;
    }
    
    public a a(ListAdapter param1ListAdapter, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.a a1 = this.a;
      a1.w = param1ListAdapter;
      a1.x = param1OnClickListener;
      return this;
    }
    
    public a a(CharSequence param1CharSequence) {
      this.a.f = param1CharSequence;
      return this;
    }
    
    public a a(CharSequence param1CharSequence, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.a a1 = this.a;
      a1.i = param1CharSequence;
      a1.k = param1OnClickListener;
      return this;
    }
    
    public a a(boolean param1Boolean) {
      this.a.r = param1Boolean;
      return this;
    }
    
    public a b(View param1View) {
      AlertController.a a1 = this.a;
      a1.z = param1View;
      a1.y = 0;
      a1.E = false;
      return this;
    }
    
    public a b(CharSequence param1CharSequence) {
      this.a.h = param1CharSequence;
      return this;
    }
    
    public a b(CharSequence param1CharSequence, DialogInterface.OnClickListener param1OnClickListener) {
      AlertController.a a1 = this.a;
      a1.l = param1CharSequence;
      a1.n = param1OnClickListener;
      return this;
    }
    
    public b b() {
      b b1 = new b(this.a.a, this.b);
      this.a.a(b1.a);
      b1.setCancelable(this.a.r);
      if (this.a.r)
        b1.setCanceledOnTouchOutside(true); 
      b1.setOnCancelListener(this.a.s);
      b1.setOnDismissListener(this.a.t);
      if (this.a.u != null)
        b1.setOnKeyListener(this.a.u); 
      return b1;
    }
    
    public b c() {
      b b1 = b();
      b1.show();
      return b1;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\app\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */