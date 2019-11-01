package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a;
import android.support.v4.b.a.b;
import android.support.v4.graphics.drawable.a;
import android.support.v4.h.c;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class a implements b {
  private final int a;
  
  private final int b;
  
  private final int c;
  
  private final int d;
  
  private CharSequence e;
  
  private CharSequence f;
  
  private Intent g;
  
  private char h;
  
  private int i = 4096;
  
  private char j;
  
  private int k = 4096;
  
  private Drawable l;
  
  private int m = 0;
  
  private Context n;
  
  private MenuItem.OnMenuItemClickListener o;
  
  private CharSequence p;
  
  private CharSequence q;
  
  private ColorStateList r = null;
  
  private PorterDuff.Mode s = null;
  
  private boolean t = false;
  
  private boolean u = false;
  
  private int v = 16;
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence) {
    this.n = paramContext;
    this.a = paramInt2;
    this.b = paramInt1;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramCharSequence;
  }
  
  private void b() {
    if (this.l != null && (this.t || this.u)) {
      this.l = a.g(this.l);
      this.l = this.l.mutate();
      if (this.t)
        a.a(this.l, this.r); 
      if (this.u)
        a.a(this.l, this.s); 
    } 
  }
  
  public b a(int paramInt) { throw new UnsupportedOperationException(); }
  
  public b a(c paramc) { throw new UnsupportedOperationException(); }
  
  public b a(View paramView) { throw new UnsupportedOperationException(); }
  
  public b a(CharSequence paramCharSequence) {
    this.p = paramCharSequence;
    return this;
  }
  
  public c a() { return null; }
  
  public b b(int paramInt) {
    setShowAsAction(paramInt);
    return this;
  }
  
  public b b(CharSequence paramCharSequence) {
    this.q = paramCharSequence;
    return this;
  }
  
  public boolean collapseActionView() { return false; }
  
  public boolean expandActionView() { return false; }
  
  public ActionProvider getActionProvider() { throw new UnsupportedOperationException(); }
  
  public View getActionView() { return null; }
  
  public int getAlphabeticModifiers() { return this.k; }
  
  public char getAlphabeticShortcut() { return this.j; }
  
  public CharSequence getContentDescription() { return this.p; }
  
  public int getGroupId() { return this.b; }
  
  public Drawable getIcon() { return this.l; }
  
  public ColorStateList getIconTintList() { return this.r; }
  
  public PorterDuff.Mode getIconTintMode() { return this.s; }
  
  public Intent getIntent() { return this.g; }
  
  public int getItemId() { return this.a; }
  
  public ContextMenu.ContextMenuInfo getMenuInfo() { return null; }
  
  public int getNumericModifiers() { return this.i; }
  
  public char getNumericShortcut() { return this.h; }
  
  public int getOrder() { return this.d; }
  
  public SubMenu getSubMenu() { return null; }
  
  public CharSequence getTitle() { return this.e; }
  
  public CharSequence getTitleCondensed() {
    CharSequence charSequence = this.f;
    return (charSequence != null) ? charSequence : this.e;
  }
  
  public CharSequence getTooltipText() { return this.q; }
  
  public boolean hasSubMenu() { return false; }
  
  public boolean isActionViewExpanded() { return false; }
  
  public boolean isCheckable() { return ((true & this.v) != 0); }
  
  public boolean isChecked() { return ((0x2 & this.v) != 0); }
  
  public boolean isEnabled() { return ((0x10 & this.v) != 0); }
  
  public boolean isVisible() { return ((0x8 & this.v) == 0); }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider) { throw new UnsupportedOperationException(); }
  
  public MenuItem setAlphabeticShortcut(char paramChar) {
    this.j = Character.toLowerCase(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt) {
    this.j = Character.toLowerCase(paramChar);
    this.k = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean) {
    this.v = paramBoolean | 0xFFFFFFFE & this.v;
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean) {
    int i2;
    int i1 = 0xFFFFFFFD & this.v;
    if (paramBoolean) {
      i2 = 2;
    } else {
      i2 = 0;
    } 
    this.v = i2 | i1;
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean) {
    int i2;
    int i1 = 0xFFFFFFEF & this.v;
    if (paramBoolean) {
      i2 = 16;
    } else {
      i2 = 0;
    } 
    this.v = i2 | i1;
    return this;
  }
  
  public MenuItem setIcon(int paramInt) {
    this.m = paramInt;
    this.l = a.a(this.n, paramInt);
    b();
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable) {
    this.l = paramDrawable;
    this.m = 0;
    b();
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList) {
    this.r = paramColorStateList;
    this.t = true;
    b();
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode) {
    this.s = paramMode;
    this.u = true;
    b();
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent) {
    this.g = paramIntent;
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar) {
    this.h = paramChar;
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt) {
    this.h = paramChar;
    this.i = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener) { throw new UnsupportedOperationException(); }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {
    this.o = paramOnMenuItemClickListener;
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2) {
    this.h = paramChar1;
    this.j = Character.toLowerCase(paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2) {
    this.h = paramChar1;
    this.i = KeyEvent.normalizeMetaState(paramInt1);
    this.j = Character.toLowerCase(paramChar2);
    this.k = KeyEvent.normalizeMetaState(paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt) {}
  
  public MenuItem setTitle(int paramInt) {
    this.e = this.n.getResources().getString(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence) {
    this.e = paramCharSequence;
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence) {
    this.f = paramCharSequence;
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean) {
    int i1 = this.v;
    int i2 = 8;
    int i3 = i1 & i2;
    if (paramBoolean)
      i2 = 0; 
    this.v = i3 | i2;
    return this;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */