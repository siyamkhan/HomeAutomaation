package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.c;
import android.arch.lifecycle.e;
import android.arch.lifecycle.f;
import android.arch.lifecycle.m;
import android.os.Bundle;
import android.support.v4.g.l;
import android.support.v4.h.e;
import android.view.KeyEvent;
import android.view.View;

public class ae extends Activity implements e, e.a {
  private l<Class<? extends Object>, Object> a = new l();
  
  private f b = new f(this);
  
  public c a() { return this.b; }
  
  public boolean a(KeyEvent paramKeyEvent) { return super.dispatchKeyEvent(paramKeyEvent); }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    View view = getWindow().getDecorView();
    return (view != null && e.a(view, paramKeyEvent)) ? true : e.a(this, view, this, paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent) {
    View view = getWindow().getDecorView();
    return (view != null && e.a(view, paramKeyEvent)) ? true : super.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    m.a(this);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    this.b.a(c.b.c);
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */