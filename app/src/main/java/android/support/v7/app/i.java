package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.h.r;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.aj;
import android.support.v7.widget.bn;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.util.ArrayList;

class i extends a {
  aj a;
  
  boolean b;
  
  Window.Callback c;
  
  private boolean d;
  
  private boolean e;
  
  private ArrayList<a.b> f = new ArrayList();
  
  private final Runnable g = new Runnable(this) {
      public void run() { this.a.i(); }
    };
  
  private final Toolbar.c h = new Toolbar.c(this) {
      public boolean a(MenuItem param1MenuItem) { return this.a.c.onMenuItemSelected(0, param1MenuItem); }
    };
  
  i(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback) {
    this.a = new bn(paramToolbar, false);
    this.c = new c(this, paramCallback);
    this.a.a(this.c);
    paramToolbar.setOnMenuItemClickListener(this.h);
    this.a.a(paramCharSequence);
  }
  
  private Menu j() {
    if (!this.d) {
      this.a.a(new a(this), new b(this));
      this.d = true;
    } 
    return this.a.q();
  }
  
  public int a() { return this.a.o(); }
  
  public void a(float paramFloat) { r.a(this.a.a(), paramFloat); }
  
  public void a(int paramInt1, int paramInt2) {
    int j = this.a.o();
    this.a.c(paramInt1 & paramInt2 | j & (paramInt2 ^ 0xFFFFFFFF));
  }
  
  public void a(Configuration paramConfiguration) { super.a(paramConfiguration); }
  
  public void a(CharSequence paramCharSequence) { this.a.a(paramCharSequence); }
  
  public void a(boolean paramBoolean) {
    byte b1;
    if (paramBoolean) {
      b1 = 2;
    } else {
      b1 = 0;
    } 
    a(b1, 2);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent) {
    Menu menu = j();
    if (menu != null) {
      byte b1;
      if (paramKeyEvent != null) {
        b1 = paramKeyEvent.getDeviceId();
      } else {
        b1 = -1;
      } 
      int j = KeyCharacterMap.load(b1).getKeyboardType();
      boolean bool = true;
      if (j == bool)
        bool = false; 
      menu.setQwertyMode(bool);
      return menu.performShortcut(paramInt, paramKeyEvent, 0);
    } 
    return false;
  }
  
  public boolean a(KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 1)
      c(); 
    return true;
  }
  
  public Context b() { return this.a.b(); }
  
  public void b(boolean paramBoolean) {
    byte b1;
    if (paramBoolean) {
      b1 = 4;
    } else {
      b1 = 0;
    } 
    a(b1, 4);
  }
  
  public void c(boolean paramBoolean) {}
  
  public boolean c() { return this.a.k(); }
  
  public boolean d() { return this.a.l(); }
  
  public void e(boolean paramBoolean) {}
  
  public boolean e() {
    this.a.a().removeCallbacks(this.g);
    r.a(this.a.a(), this.g);
    return true;
  }
  
  public void f(boolean paramBoolean) {}
  
  public boolean f() {
    if (this.a.c()) {
      this.a.d();
      return true;
    } 
    return false;
  }
  
  void g() { this.a.a().removeCallbacks(this.g); }
  
  public void g(boolean paramBoolean) {
    if (paramBoolean == this.e)
      return; 
    this.e = paramBoolean;
    int j = this.f.size();
    for (byte b1 = 0; b1 < j; b1++)
      ((a.b)this.f.get(b1)).a(paramBoolean); 
  }
  
  public Window.Callback h() { return this.c; }
  
  void i() {
    Menu menu = j();
    if (menu instanceof h) {
      object = (h)menu;
    } else {
      object = null;
    } 
    if (object != null)
      object.h(); 
    try {
      menu.clear();
      if (!this.c.onCreatePanelMenu(0, menu) || !this.c.onPreparePanel(0, null, menu))
        menu.clear(); 
      return;
    } finally {
      if (object != null)
        object.i(); 
    } 
  }
  
  private final class a implements o.a {
    private boolean b;
    
    a(i this$0) {}
    
    public void a(h param1h, boolean param1Boolean) {
      if (this.b)
        return; 
      this.b = true;
      this.a.a.n();
      if (this.a.c != null)
        this.a.c.onPanelClosed(108, param1h); 
      this.b = false;
    }
    
    public boolean a(h param1h) {
      if (this.a.c != null) {
        this.a.c.onMenuOpened(108, param1h);
        return true;
      } 
      return false;
    }
  }
  
  private final class b implements h.a {
    b(i this$0) {}
    
    public void a(h param1h) {
      if (this.a.c != null) {
        if (this.a.a.i()) {
          this.a.c.onPanelClosed(108, param1h);
          return;
        } 
        if (this.a.c.onPreparePanel(0, null, param1h))
          this.a.c.onMenuOpened(108, param1h); 
      } 
    }
    
    public boolean a(h param1h, MenuItem param1MenuItem) { return false; }
  }
  
  private class c extends i {
    public c(i this$0, Window.Callback param1Callback) { super(param1Callback); }
    
    public View onCreatePanelView(int param1Int) { return (param1Int == 0) ? new View(this.a.a.b()) : super.onCreatePanelView(param1Int); }
    
    public boolean onPreparePanel(int param1Int, View param1View, Menu param1Menu) {
      boolean bool = super.onPreparePanel(param1Int, param1View, param1Menu);
      if (bool && !this.a.b) {
        this.a.a.m();
        this.a.b = true;
      } 
      return bool;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\app\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */