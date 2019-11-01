package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.b.a.b;
import android.support.v4.graphics.drawable.a;
import android.support.v4.h.c;
import android.support.v7.a.a;
import android.support.v7.c.a.a;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class j implements b {
  private View A;
  
  private c B;
  
  private MenuItem.OnActionExpandListener C;
  
  private boolean D = false;
  
  private ContextMenu.ContextMenuInfo E;
  
  h a;
  
  private final int b;
  
  private final int c;
  
  private final int d;
  
  private final int e;
  
  private CharSequence f;
  
  private CharSequence g;
  
  private Intent h;
  
  private char i;
  
  private int j = 4096;
  
  private char k;
  
  private int l = 4096;
  
  private Drawable m;
  
  private int n = 0;
  
  private u o;
  
  private Runnable p;
  
  private MenuItem.OnMenuItemClickListener q;
  
  private CharSequence r;
  
  private CharSequence s;
  
  private ColorStateList t = null;
  
  private PorterDuff.Mode u = null;
  
  private boolean v = false;
  
  private boolean w = false;
  
  private boolean x = false;
  
  private int y = 16;
  
  private int z = 0;
  
  j(h paramh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5) {
    this.a = paramh;
    this.b = paramInt2;
    this.c = paramInt1;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramCharSequence;
    this.z = paramInt5;
  }
  
  private Drawable a(Drawable paramDrawable) {
    if (paramDrawable != null && this.x && (this.v || this.w)) {
      paramDrawable = a.g(paramDrawable).mutate();
      if (this.v)
        a.a(paramDrawable, this.t); 
      if (this.w)
        a.a(paramDrawable, this.u); 
      this.x = false;
    } 
    return paramDrawable;
  }
  
  private static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString) {
    if ((paramInt1 & paramInt2) == paramInt2)
      paramStringBuilder.append(paramString); 
  }
  
  public b a(int paramInt) {
    Context context = this.a.f();
    a(LayoutInflater.from(context).inflate(paramInt, new LinearLayout(context), false));
    return this;
  }
  
  public b a(c paramc) {
    c c1 = this.B;
    if (c1 != null)
      c1.f(); 
    this.A = null;
    this.B = paramc;
    this.a.b(true);
    c c2 = this.B;
    if (c2 != null)
      c2.a(new c.b(this) {
            public void a(boolean param1Boolean) { this.a.a.a(this.a); }
          }); 
    return this;
  }
  
  public b a(View paramView) {
    this.A = paramView;
    this.B = null;
    if (paramView != null && paramView.getId() == -1) {
      int i1 = this.b;
      if (i1 > 0)
        paramView.setId(i1); 
    } 
    this.a.b(this);
    return this;
  }
  
  public b a(CharSequence paramCharSequence) {
    this.r = paramCharSequence;
    this.a.b(false);
    return this;
  }
  
  public c a() { return this.B; }
  
  CharSequence a(p.a parama) { return (parama != null && parama.a()) ? getTitleCondensed() : getTitle(); }
  
  public void a(u paramu) {
    this.o = paramu;
    paramu.setHeaderTitle(getTitle());
  }
  
  void a(ContextMenu.ContextMenuInfo paramContextMenuInfo) { this.E = paramContextMenuInfo; }
  
  public void a(boolean paramBoolean) {
    int i2;
    int i1 = 0xFFFFFFFB & this.y;
    if (paramBoolean) {
      i2 = 4;
    } else {
      i2 = 0;
    } 
    this.y = i2 | i1;
  }
  
  public b b(int paramInt) {
    setShowAsAction(paramInt);
    return this;
  }
  
  public b b(CharSequence paramCharSequence) {
    this.s = paramCharSequence;
    this.a.b(false);
    return this;
  }
  
  void b(boolean paramBoolean) {
    int i3;
    int i1 = this.y;
    int i2 = i1 & 0xFFFFFFFD;
    if (paramBoolean) {
      i3 = 2;
    } else {
      i3 = 0;
    } 
    this.y = i3 | i2;
    if (i1 != this.y)
      this.a.b(false); 
  }
  
  public boolean b() {
    MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.q;
    if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this))
      return true; 
    h h1 = this.a;
    if (h1.a(h1, this))
      return true; 
    Runnable runnable = this.p;
    if (runnable != null) {
      runnable.run();
      return true;
    } 
    if (this.h != null)
      try {
        this.a.f().startActivity(this.h);
        return true;
      } catch (ActivityNotFoundException activityNotFoundException) {
        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", activityNotFoundException);
      }  
    c c1 = this.B;
    return (c1 != null && c1.d());
  }
  
  public int c() { return this.e; }
  
  boolean c(boolean paramBoolean) {
    int i3;
    int i1 = this.y;
    int i2 = i1 & 0xFFFFFFF7;
    if (paramBoolean) {
      i3 = 0;
    } else {
      i3 = 8;
    } 
    this.y = i3 | i2;
    int i4 = this.y;
    boolean bool = false;
    if (i1 != i4)
      bool = true; 
    return bool;
  }
  
  public boolean collapseActionView() {
    if ((0x8 & this.z) == 0)
      return false; 
    if (this.A == null)
      return true; 
    MenuItem.OnActionExpandListener onActionExpandListener = this.C;
    return (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) ? this.a.d(this) : 0;
  }
  
  char d() { return this.a.c() ? this.k : this.i; }
  
  public void d(boolean paramBoolean) {
    int i1;
    if (paramBoolean) {
      i1 = 0x20 | this.y;
    } else {
      i1 = 0xFFFFFFDF & this.y;
    } 
    this.y = i1;
  }
  
  String e() {
    int i1;
    char c1 = d();
    if (c1 == '\000')
      return ""; 
    Resources resources = this.a.f().getResources();
    StringBuilder stringBuilder = new StringBuilder();
    if (ViewConfiguration.get(this.a.f()).hasPermanentMenuKey())
      stringBuilder.append(resources.getString(a.h.abc_prepend_shortcut_label)); 
    if (this.a.c()) {
      i1 = this.l;
    } else {
      i1 = this.j;
    } 
    a(stringBuilder, i1, 65536, resources.getString(a.h.abc_menu_meta_shortcut_label));
    a(stringBuilder, i1, 4096, resources.getString(a.h.abc_menu_ctrl_shortcut_label));
    a(stringBuilder, i1, 2, resources.getString(a.h.abc_menu_alt_shortcut_label));
    a(stringBuilder, i1, 1, resources.getString(a.h.abc_menu_shift_shortcut_label));
    a(stringBuilder, i1, 4, resources.getString(a.h.abc_menu_sym_shortcut_label));
    a(stringBuilder, i1, 8, resources.getString(a.h.abc_menu_function_shortcut_label));
    if (c1 != '\b') {
      if (c1 != '\n') {
        if (c1 != ' ') {
          stringBuilder.append(c1);
        } else {
          int i2 = a.h.abc_menu_space_shortcut_label;
          stringBuilder.append(resources.getString(i2));
        } 
      } else {
        int i2 = a.h.abc_menu_enter_shortcut_label;
        stringBuilder.append(resources.getString(i2));
      } 
    } else {
      int i2 = a.h.abc_menu_delete_shortcut_label;
      stringBuilder.append(resources.getString(i2));
    } 
    return stringBuilder.toString();
  }
  
  public void e(boolean paramBoolean) {
    this.D = paramBoolean;
    this.a.b(false);
  }
  
  public boolean expandActionView() {
    if (!n())
      return false; 
    MenuItem.OnActionExpandListener onActionExpandListener = this.C;
    return (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) ? this.a.c(this) : 0;
  }
  
  boolean f() { return (this.a.d() && d() != '\000'); }
  
  public boolean g() { return ((0x4 & this.y) != 0); }
  
  public ActionProvider getActionProvider() { throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()"); }
  
  public View getActionView() {
    View view = this.A;
    if (view != null)
      return view; 
    c c1 = this.B;
    if (c1 != null) {
      this.A = c1.a(this);
      return this.A;
    } 
    return null;
  }
  
  public int getAlphabeticModifiers() { return this.l; }
  
  public char getAlphabeticShortcut() { return this.k; }
  
  public CharSequence getContentDescription() { return this.r; }
  
  public int getGroupId() { return this.c; }
  
  public Drawable getIcon() {
    Drawable drawable = this.m;
    if (drawable != null)
      return a(drawable); 
    if (this.n != 0) {
      Drawable drawable1 = a.b(this.a.f(), this.n);
      this.n = 0;
      this.m = drawable1;
      return a(drawable1);
    } 
    return null;
  }
  
  public ColorStateList getIconTintList() { return this.t; }
  
  public PorterDuff.Mode getIconTintMode() { return this.u; }
  
  public Intent getIntent() { return this.h; }
  
  @CapturedViewProperty
  public int getItemId() { return this.b; }
  
  public ContextMenu.ContextMenuInfo getMenuInfo() { return this.E; }
  
  public int getNumericModifiers() { return this.j; }
  
  public char getNumericShortcut() { return this.i; }
  
  public int getOrder() { return this.d; }
  
  public SubMenu getSubMenu() { return this.o; }
  
  @CapturedViewProperty
  public CharSequence getTitle() { return this.f; }
  
  public CharSequence getTitleCondensed() {
    CharSequence charSequence = this.g;
    if (charSequence == null)
      charSequence = this.f; 
    if (Build.VERSION.SDK_INT < 18 && charSequence != null && !(charSequence instanceof String))
      charSequence = charSequence.toString(); 
    return charSequence;
  }
  
  public CharSequence getTooltipText() { return this.s; }
  
  public void h() { this.a.b(this); }
  
  public boolean hasSubMenu() { return (this.o != null); }
  
  public boolean i() { return this.a.r(); }
  
  public boolean isActionViewExpanded() { return this.D; }
  
  public boolean isCheckable() { return ((true & this.y) == 1); }
  
  public boolean isChecked() { return ((0x2 & this.y) == 2); }
  
  public boolean isEnabled() { return ((0x10 & this.y) != 0); }
  
  public boolean isVisible() {
    c c1 = this.B;
    return (c1 != null && c1.b()) ? (((0x8 & this.y) == 0 && this.B.c())) : (((0x8 & this.y) == 0));
  }
  
  public boolean j() { return ((0x20 & this.y) == 32); }
  
  public boolean k() { return ((true & this.z) == 1); }
  
  public boolean l() { return ((0x2 & this.z) == 2); }
  
  public boolean m() { return ((0x4 & this.z) == 4); }
  
  public boolean n() {
    int i1 = 0x8 & this.z;
    boolean bool = false;
    if (i1 != 0) {
      if (this.A == null) {
        c c1 = this.B;
        if (c1 != null)
          this.A = c1.a(this); 
      } 
      View view = this.A;
      bool = false;
      if (view != null)
        bool = true; 
    } 
    return bool;
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider) { throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()"); }
  
  public MenuItem setAlphabeticShortcut(char paramChar) {
    if (this.k == paramChar)
      return this; 
    this.k = Character.toLowerCase(paramChar);
    this.a.b(false);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt) {
    if (this.k == paramChar && this.l == paramInt)
      return this; 
    this.k = Character.toLowerCase(paramChar);
    this.l = KeyEvent.normalizeMetaState(paramInt);
    this.a.b(false);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean) {
    int i1 = this.y;
    this.y = paramBoolean | i1 & 0xFFFFFFFE;
    if (i1 != this.y)
      this.a.b(false); 
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean) {
    if ((0x4 & this.y) != 0) {
      this.a.a(this);
      return this;
    } 
    b(paramBoolean);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean) {
    int i1;
    if (paramBoolean) {
      i1 = 0x10 | this.y;
    } else {
      i1 = 0xFFFFFFEF & this.y;
    } 
    this.y = i1;
    this.a.b(false);
    return this;
  }
  
  public MenuItem setIcon(int paramInt) {
    this.m = null;
    this.n = paramInt;
    this.x = true;
    this.a.b(false);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable) {
    this.n = 0;
    this.m = paramDrawable;
    this.x = true;
    this.a.b(false);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList) {
    this.t = paramColorStateList;
    this.v = true;
    this.x = true;
    this.a.b(false);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode) {
    this.u = paramMode;
    this.w = true;
    this.x = true;
    this.a.b(false);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent) {
    this.h = paramIntent;
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar) {
    if (this.i == paramChar)
      return this; 
    this.i = paramChar;
    this.a.b(false);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt) {
    if (this.i == paramChar && this.j == paramInt)
      return this; 
    this.i = paramChar;
    this.j = KeyEvent.normalizeMetaState(paramInt);
    this.a.b(false);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener) {
    this.C = paramOnActionExpandListener;
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {
    this.q = paramOnMenuItemClickListener;
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2) {
    this.i = paramChar1;
    this.k = Character.toLowerCase(paramChar2);
    this.a.b(false);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2) {
    this.i = paramChar1;
    this.j = KeyEvent.normalizeMetaState(paramInt1);
    this.k = Character.toLowerCase(paramChar2);
    this.l = KeyEvent.normalizeMetaState(paramInt2);
    this.a.b(false);
    return this;
  }
  
  public void setShowAsAction(int paramInt) {
    switch (paramInt & 0x3) {
      default:
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
      case 0:
      case 1:
      case 2:
        break;
    } 
    this.z = paramInt;
    this.a.b(this);
  }
  
  public MenuItem setTitle(int paramInt) { return setTitle(this.a.f().getString(paramInt)); }
  
  public MenuItem setTitle(CharSequence paramCharSequence) {
    this.f = paramCharSequence;
    this.a.b(false);
    u u1 = this.o;
    if (u1 != null)
      u1.setHeaderTitle(paramCharSequence); 
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence) {
    this.g = paramCharSequence;
    if (paramCharSequence == null)
      this.f; 
    this.a.b(false);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean) {
    if (c(paramBoolean))
      this.a.a(this); 
    return this;
  }
  
  public String toString() {
    CharSequence charSequence = this.f;
    return (charSequence != null) ? charSequence.toString() : null;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */