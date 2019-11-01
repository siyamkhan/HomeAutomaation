package android.support.v7.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.a;
import android.support.v4.app.af;
import android.support.v4.app.h;
import android.support.v4.app.v;
import android.support.v7.view.b;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.br;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public class c extends h implements af.a, d {
  private e k;
  
  private int l = 0;
  
  private Resources m;
  
  private boolean a(int paramInt, KeyEvent paramKeyEvent) {
    if (Build.VERSION.SDK_INT < 26 && !paramKeyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(paramKeyEvent.getMetaState()) && paramKeyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(paramKeyEvent.getKeyCode())) {
      Window window = getWindow();
      if (window != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(paramKeyEvent))
        return true; 
    } 
    return false;
  }
  
  public b a(b.a parama) { return null; }
  
  public void a(af paramaf) { paramaf.a(this); }
  
  public void a(b paramb) {}
  
  public void a(Toolbar paramToolbar) { j().a(paramToolbar); }
  
  public boolean a(Intent paramIntent) { return v.a(this, paramIntent); }
  
  public Intent a_() { return v.a(this); }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) { j().b(paramView, paramLayoutParams); }
  
  public void b(Intent paramIntent) { v.b(this, paramIntent); }
  
  public void b(af paramaf) {}
  
  public void b(b paramb) {}
  
  public void closeOptionsMenu() {
    a a1 = g();
    if (getWindow().hasFeature(0) && (a1 == null || !a1.d()))
      super.closeOptionsMenu(); 
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    int i = paramKeyEvent.getKeyCode();
    a a1 = g();
    return (i == 82 && a1 != null && a1.a(paramKeyEvent)) ? true : super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void e() { j().f(); }
  
  public <T extends View> T findViewById(int paramInt) { return (T)j().a(paramInt); }
  
  public a g() { return j().a(); }
  
  public MenuInflater getMenuInflater() { return j().b(); }
  
  public Resources getResources() {
    if (this.m == null && br.a())
      this.m = new br(this, super.getResources()); 
    Resources resources = this.m;
    if (resources == null)
      resources = super.getResources(); 
    return resources;
  }
  
  public boolean h() {
    Intent intent = a_();
    if (intent != null) {
      if (a(intent)) {
        af af = af.a(this);
        a(af);
        b(af);
        af.a();
        try {
          a.a(this);
        } catch (IllegalStateException illegalStateException) {
          finish();
        } 
      } else {
        b(intent);
      } 
      return true;
    } 
    return false;
  }
  
  @Deprecated
  public void i() {}
  
  public void invalidateOptionsMenu() { j().f(); }
  
  public e j() {
    if (this.k == null)
      this.k = e.a(this, this); 
    return this.k;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    j().a(paramConfiguration);
    if (this.m != null) {
      DisplayMetrics displayMetrics = super.getResources().getDisplayMetrics();
      this.m.updateConfiguration(paramConfiguration, displayMetrics);
    } 
  }
  
  public void onContentChanged() { i(); }
  
  protected void onCreate(Bundle paramBundle) {
    e e1 = j();
    e1.h();
    e1.a(paramBundle);
    if (e1.i() && this.l != 0)
      if (Build.VERSION.SDK_INT >= 23) {
        onApplyThemeResource(getTheme(), this.l, false);
      } else {
        setTheme(this.l);
      }  
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    j().g();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) { return a(paramInt, paramKeyEvent) ? true : super.onKeyDown(paramInt, paramKeyEvent); }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
    if (super.onMenuItemSelected(paramInt, paramMenuItem))
      return true; 
    a a1 = g();
    return (paramMenuItem.getItemId() == 16908332 && a1 != null && (0x4 & a1.a()) != 0) ? h() : 0;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu) { return super.onMenuOpened(paramInt, paramMenu); }
  
  public void onPanelClosed(int paramInt, Menu paramMenu) { super.onPanelClosed(paramInt, paramMenu); }
  
  protected void onPostCreate(Bundle paramBundle) {
    super.onPostCreate(paramBundle);
    j().b(paramBundle);
  }
  
  protected void onPostResume() {
    super.onPostResume();
    j().e();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    j().c(paramBundle);
  }
  
  protected void onStart() {
    super.onStart();
    j().c();
  }
  
  protected void onStop() {
    super.onStop();
    j().d();
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt) {
    super.onTitleChanged(paramCharSequence, paramInt);
    j().a(paramCharSequence);
  }
  
  public void openOptionsMenu() {
    a a1 = g();
    if (getWindow().hasFeature(0) && (a1 == null || !a1.c()))
      super.openOptionsMenu(); 
  }
  
  public void setContentView(int paramInt) { j().b(paramInt); }
  
  public void setContentView(View paramView) { j().a(paramView); }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) { j().a(paramView, paramLayoutParams); }
  
  public void setTheme(int paramInt) {
    super.setTheme(paramInt);
    this.l = paramInt;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\app\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */