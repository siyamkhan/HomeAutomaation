package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.support.v7.a.a;
import android.support.v7.app.b;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

class i implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, o.a {
  f a;
  
  private h b;
  
  private b c;
  
  private o.a d;
  
  public i(h paramh) { this.b = paramh; }
  
  public void a() {
    b b1 = this.c;
    if (b1 != null)
      b1.dismiss(); 
  }
  
  public void a(IBinder paramIBinder) {
    h h1 = this.b;
    b.a a1 = new b.a(h1.f());
    this.a = new f(a1.a(), a.g.abc_list_menu_item_layout);
    this.a.a(this);
    this.b.a(this.a);
    a1.a(this.a.a(), this);
    View view = h1.p();
    if (view != null) {
      a1.a(view);
    } else {
      a1.a(h1.o()).a(h1.n());
    } 
    a1.a(this);
    this.c = a1.b();
    this.c.setOnDismissListener(this);
    WindowManager.LayoutParams layoutParams = this.c.getWindow().getAttributes();
    layoutParams.type = 1003;
    if (paramIBinder != null)
      layoutParams.token = paramIBinder; 
    layoutParams.flags = 0x20000 | layoutParams.flags;
    this.c.show();
  }
  
  public void a(h paramh, boolean paramBoolean) {
    if (paramBoolean || paramh == this.b)
      a(); 
    o.a a1 = this.d;
    if (a1 != null)
      a1.a(paramh, paramBoolean); 
  }
  
  public boolean a(h paramh) {
    o.a a1 = this.d;
    return (a1 != null) ? a1.a(paramh) : 0;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) { this.b.a((j)this.a.a().getItem(paramInt), 0); }
  
  public void onDismiss(DialogInterface paramDialogInterface) { this.a.a(this.b, true); }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 82 || paramInt == 4)
      if (paramKeyEvent.getAction() == 0 && paramKeyEvent.getRepeatCount() == 0) {
        Window window = this.c.getWindow();
        if (window != null) {
          View view = window.getDecorView();
          if (view != null) {
            KeyEvent.DispatcherState dispatcherState = view.getKeyDispatcherState();
            if (dispatcherState != null) {
              dispatcherState.startTracking(paramKeyEvent, this);
              return true;
            } 
          } 
        } 
      } else if (paramKeyEvent.getAction() == 1 && !paramKeyEvent.isCanceled()) {
        Window window = this.c.getWindow();
        if (window != null) {
          View view = window.getDecorView();
          if (view != null) {
            KeyEvent.DispatcherState dispatcherState = view.getKeyDispatcherState();
            if (dispatcherState != null && dispatcherState.isTracking(paramKeyEvent)) {
              this.b.a(true);
              paramDialogInterface.dismiss();
              return true;
            } 
          } 
        } 
      }  
    return this.b.performShortcut(paramInt, paramKeyEvent, 0);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */