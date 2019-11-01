package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.a.a;
import android.support.v4.b.a.a;
import android.support.v4.h.c;
import android.support.v4.h.s;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h implements a {
  private static final int[] d = { 1, 4, 5, 3, 2, 0 };
  
  private boolean A;
  
  CharSequence a;
  
  Drawable b;
  
  View c;
  
  private final Context e;
  
  private final Resources f;
  
  private boolean g;
  
  private boolean h;
  
  private a i;
  
  private ArrayList<j> j;
  
  private ArrayList<j> k;
  
  private boolean l;
  
  private ArrayList<j> m;
  
  private ArrayList<j> n;
  
  private boolean o;
  
  private int p = 0;
  
  private ContextMenu.ContextMenuInfo q;
  
  private boolean r = false;
  
  private boolean s = false;
  
  private boolean t = false;
  
  private boolean u = false;
  
  private boolean v = false;
  
  private ArrayList<j> w = new ArrayList();
  
  private CopyOnWriteArrayList<WeakReference<o>> x = new CopyOnWriteArrayList();
  
  private j y;
  
  private boolean z = false;
  
  public h(Context paramContext) {
    this.e = paramContext;
    this.f = paramContext.getResources();
    this.j = new ArrayList();
    this.k = new ArrayList();
    this.l = true;
    this.m = new ArrayList();
    this.n = new ArrayList();
    this.o = true;
    e(true);
  }
  
  private static int a(ArrayList<j> paramArrayList, int paramInt) {
    for (int i1 = -1 + paramArrayList.size(); i1 >= 0; i1--) {
      if (((j)paramArrayList.get(i1)).c() <= paramInt)
        return i1 + 1; 
    } 
    return 0;
  }
  
  private j a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5) { return new j(this, paramInt1, paramInt2, paramInt3, paramInt4, paramCharSequence, paramInt5); }
  
  private void a(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView) {
    Resources resources = e();
    if (paramView != null) {
      this.c = paramView;
      this.a = null;
      this.b = null;
    } else {
      if (paramInt1 > 0) {
        this.a = resources.getText(paramInt1);
      } else if (paramCharSequence != null) {
        this.a = paramCharSequence;
      } 
      if (paramInt2 > 0) {
        this.b = a.a(f(), paramInt2);
      } else if (paramDrawable != null) {
        this.b = paramDrawable;
      } 
      this.c = null;
    } 
    b(false);
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    if (paramInt >= 0) {
      if (paramInt >= this.j.size())
        return; 
      this.j.remove(paramInt);
      if (paramBoolean)
        b(true); 
    } 
  }
  
  private boolean a(u paramu, o paramo) {
    if (this.x.isEmpty())
      return false; 
    boolean bool = false;
    if (paramo != null)
      bool = paramo.a(paramu); 
    for (WeakReference weakReference : this.x) {
      o o1 = (o)weakReference.get();
      if (o1 == null) {
        this.x.remove(weakReference);
        continue;
      } 
      if (!bool)
        bool = o1.a(paramu); 
    } 
    return bool;
  }
  
  private void d(boolean paramBoolean) {
    if (this.x.isEmpty())
      return; 
    h();
    for (WeakReference weakReference : this.x) {
      o o1 = (o)weakReference.get();
      if (o1 == null) {
        this.x.remove(weakReference);
        continue;
      } 
      o1.b(paramBoolean);
    } 
    i();
  }
  
  private void e(boolean paramBoolean) {
    boolean bool = true;
    if (!paramBoolean || (this.f.getConfiguration()).keyboard == bool || !s.c(ViewConfiguration.get(this.e), this.e))
      bool = false; 
    this.h = bool;
  }
  
  private static int f(int paramInt) {
    int i1 = (0xFFFF0000 & paramInt) >> 16;
    if (i1 >= 0) {
      int[] arrayOfInt = d;
      if (i1 < arrayOfInt.length)
        return arrayOfInt[i1] << 16 | paramInt & 0xFFFF; 
    } 
    throw new IllegalArgumentException("order does not contain a valid category.");
  }
  
  public int a(int paramInt1, int paramInt2) {
    int i1 = size();
    if (paramInt2 < 0)
      paramInt2 = 0; 
    while (paramInt2 < i1) {
      if (((j)this.j.get(paramInt2)).getGroupId() == paramInt1)
        return paramInt2; 
      paramInt2++;
    } 
    return -1;
  }
  
  public h a(int paramInt) {
    this.p = paramInt;
    return this;
  }
  
  protected h a(Drawable paramDrawable) {
    a(0, null, 0, paramDrawable, null);
    return this;
  }
  
  protected h a(View paramView) {
    a(0, null, 0, null, paramView);
    return this;
  }
  
  protected h a(CharSequence paramCharSequence) {
    a(0, paramCharSequence, 0, null, null);
    return this;
  }
  
  j a(int paramInt, KeyEvent paramKeyEvent) {
    ArrayList arrayList = this.w;
    arrayList.clear();
    a(arrayList, paramInt, paramKeyEvent);
    if (arrayList.isEmpty())
      return null; 
    int i1 = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
    paramKeyEvent.getKeyData(keyData);
    int i2 = arrayList.size();
    if (i2 == 1)
      return (j)arrayList.get(0); 
    boolean bool = c();
    for (byte b1 = 0; b1 < i2; b1++) {
      char c1;
      j j1 = (j)arrayList.get(b1);
      if (bool) {
        c1 = j1.getAlphabeticShortcut();
      } else {
        c1 = j1.getNumericShortcut();
      } 
      if ((c1 == keyData.meta[0] && (i1 & 0x2) == 0) || (c1 == keyData.meta[2] && (i1 & 0x2) != 0) || (bool && c1 == '\b' && paramInt == 67))
        return j1; 
    } 
    return null;
  }
  
  protected MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) {
    int i1 = f(paramInt3);
    j j1 = a(paramInt1, paramInt2, paramInt3, i1, paramCharSequence, this.p);
    ContextMenu.ContextMenuInfo contextMenuInfo = this.q;
    if (contextMenuInfo != null)
      j1.a(contextMenuInfo); 
    ArrayList arrayList = this.j;
    arrayList.add(a(arrayList, i1), j1);
    b(true);
    return j1;
  }
  
  protected String a() { return "android:menu:actionviewstates"; }
  
  public void a(Bundle paramBundle) {
    int i1 = size();
    SparseArray sparseArray = null;
    for (byte b1 = 0; b1 < i1; b1++) {
      MenuItem menuItem = getItem(b1);
      View view = menuItem.getActionView();
      if (view != null && view.getId() != -1) {
        if (sparseArray == null)
          sparseArray = new SparseArray(); 
        view.saveHierarchyState(sparseArray);
        if (menuItem.isActionViewExpanded())
          paramBundle.putInt("android:menu:expandedactionview", menuItem.getItemId()); 
      } 
      if (menuItem.hasSubMenu())
        ((u)menuItem.getSubMenu()).a(paramBundle); 
    } 
    if (sparseArray != null)
      paramBundle.putSparseParcelableArray(a(), sparseArray); 
  }
  
  public void a(a parama) { this.i = parama; }
  
  void a(j paramj) {
    this.l = true;
    b(true);
  }
  
  public void a(o paramo) { a(paramo, this.e); }
  
  public void a(o paramo, Context paramContext) {
    this.x.add(new WeakReference(paramo));
    paramo.a(paramContext, this);
    this.o = true;
  }
  
  void a(MenuItem paramMenuItem) {
    int i1 = paramMenuItem.getGroupId();
    int i2 = this.j.size();
    h();
    for (byte b1 = 0; b1 < i2; b1++) {
      j j1 = (j)this.j.get(b1);
      if (j1.getGroupId() == i1 && j1.g() && j1.isCheckable()) {
        boolean bool;
        if (j1 == paramMenuItem) {
          bool = true;
        } else {
          bool = false;
        } 
        j1.b(bool);
      } 
    } 
    i();
  }
  
  void a(List<j> paramList, int paramInt, KeyEvent paramKeyEvent) {
    boolean bool = c();
    int i1 = paramKeyEvent.getModifiers();
    KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
    if (!paramKeyEvent.getKeyData(keyData) && paramInt != 67)
      return; 
    int i2 = this.j.size();
    for (byte b1 = 0; b1 < i2; b1++) {
      boolean bool1;
      int i3;
      char c1;
      j j1 = (j)this.j.get(b1);
      if (j1.hasSubMenu())
        ((h)j1.getSubMenu()).a(paramList, paramInt, paramKeyEvent); 
      if (bool) {
        c1 = j1.getAlphabeticShortcut();
      } else {
        c1 = j1.getNumericShortcut();
      } 
      if (bool) {
        i3 = j1.getAlphabeticModifiers();
      } else {
        i3 = j1.getNumericModifiers();
      } 
      if ((i1 & 0x1100F) == (i3 & 0x1100F)) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (bool1 && c1 != '\000' && (c1 == keyData.meta[0] || c1 == keyData.meta[2] || (bool && c1 == '\b' && paramInt == 67)) && j1.isEnabled())
        paramList.add(j1); 
    } 
  }
  
  public final void a(boolean paramBoolean) {
    if (this.v)
      return; 
    this.v = true;
    for (WeakReference weakReference : this.x) {
      o o1 = (o)weakReference.get();
      if (o1 == null) {
        this.x.remove(weakReference);
        continue;
      } 
      o1.a(this, paramBoolean);
    } 
    this.v = false;
  }
  
  boolean a(h paramh, MenuItem paramMenuItem) {
    a a1 = this.i;
    return (a1 != null && a1.a(paramh, paramMenuItem));
  }
  
  public boolean a(MenuItem paramMenuItem, int paramInt) { return a(paramMenuItem, null, paramInt); }
  
  public boolean a(MenuItem paramMenuItem, o paramo, int paramInt) {
    j j1 = (j)paramMenuItem;
    if (j1 != null) {
      boolean bool1;
      if (!j1.isEnabled())
        return false; 
      boolean bool = j1.b();
      c c1 = j1.a();
      if (c1 != null && c1.e()) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (j1.n()) {
        bool |= j1.expandActionView();
        if (bool) {
          a(true);
          return bool;
        } 
      } else {
        if (j1.hasSubMenu() || bool1) {
          if ((paramInt & 0x4) == 0)
            a(false); 
          if (!j1.hasSubMenu())
            j1.a(new u(f(), this, j1)); 
          u u1 = (u)j1.getSubMenu();
          if (bool1)
            c1.a(u1); 
          bool |= a(u1, paramo);
          if (!bool) {
            a(true);
            return bool;
          } 
          return bool;
        } 
        if ((paramInt & true) == 0) {
          a(true);
          return bool;
        } 
      } 
      return bool;
    } 
    return false;
  }
  
  public MenuItem add(int paramInt) { return a(0, 0, 0, this.f.getString(paramInt)); }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4) { return a(paramInt1, paramInt2, paramInt3, this.f.getString(paramInt4)); }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) { return a(paramInt1, paramInt2, paramInt3, paramCharSequence); }
  
  public MenuItem add(CharSequence paramCharSequence) { return a(0, 0, 0, paramCharSequence); }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem) {
    byte b1;
    PackageManager packageManager = this.e.getPackageManager();
    List list = packageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    if (list != null) {
      b1 = list.size();
    } else {
      b1 = 0;
    } 
    int i1 = paramInt4 & true;
    byte b2 = 0;
    if (i1 == 0)
      removeGroup(paramInt1); 
    while (b2 < b1) {
      Intent intent1;
      ResolveInfo resolveInfo = (ResolveInfo)list.get(b2);
      if (resolveInfo.specificIndex < 0) {
        intent1 = paramIntent;
      } else {
        intent1 = paramArrayOfIntent[resolveInfo.specificIndex];
      } 
      Intent intent2 = new Intent(intent1);
      intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
      MenuItem menuItem = add(paramInt1, paramInt2, paramInt3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
      if (paramArrayOfMenuItem != null && resolveInfo.specificIndex >= 0)
        paramArrayOfMenuItem[resolveInfo.specificIndex] = menuItem; 
      b2++;
    } 
    return b1;
  }
  
  public SubMenu addSubMenu(int paramInt) { return addSubMenu(0, 0, 0, this.f.getString(paramInt)); }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4) { return addSubMenu(paramInt1, paramInt2, paramInt3, this.f.getString(paramInt4)); }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) {
    j j1 = (j)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    u u1 = new u(this.e, this, j1);
    j1.a(u1);
    return u1;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence) { return addSubMenu(0, 0, 0, paramCharSequence); }
  
  public int b(int paramInt) {
    int i1 = size();
    for (byte b1 = 0; b1 < i1; b1++) {
      if (((j)this.j.get(b1)).getItemId() == paramInt)
        return b1; 
    } 
    return -1;
  }
  
  public void b(Bundle paramBundle) {
    if (paramBundle == null)
      return; 
    SparseArray sparseArray = paramBundle.getSparseParcelableArray(a());
    int i1 = size();
    for (byte b1 = 0; b1 < i1; b1++) {
      MenuItem menuItem = getItem(b1);
      View view = menuItem.getActionView();
      if (view != null && view.getId() != -1)
        view.restoreHierarchyState(sparseArray); 
      if (menuItem.hasSubMenu())
        ((u)menuItem.getSubMenu()).b(paramBundle); 
    } 
    int i2 = paramBundle.getInt("android:menu:expandedactionview");
    if (i2 > 0) {
      MenuItem menuItem = findItem(i2);
      if (menuItem != null)
        menuItem.expandActionView(); 
    } 
  }
  
  void b(j paramj) {
    this.o = true;
    b(true);
  }
  
  public void b(o paramo) {
    for (WeakReference weakReference : this.x) {
      o o1 = (o)weakReference.get();
      if (o1 == null || o1 == paramo)
        this.x.remove(weakReference); 
    } 
  }
  
  public void b(boolean paramBoolean) {
    if (!this.r) {
      if (paramBoolean) {
        this.l = true;
        this.o = true;
      } 
      d(paramBoolean);
      return;
    } 
    this.s = true;
    if (paramBoolean)
      this.t = true; 
  }
  
  public boolean b() { return this.z; }
  
  public int c(int paramInt) { return a(paramInt, 0); }
  
  public void c(boolean paramBoolean) { this.A = paramBoolean; }
  
  boolean c() { return this.g; }
  
  public boolean c(j paramj) {
    boolean bool1 = this.x.isEmpty();
    boolean bool2 = false;
    if (bool1)
      return false; 
    h();
    for (WeakReference weakReference : this.x) {
      o o1 = (o)weakReference.get();
      if (o1 == null) {
        this.x.remove(weakReference);
        continue;
      } 
      bool2 = o1.a(this, paramj);
      if (bool2)
        break; 
    } 
    i();
    if (bool2)
      this.y = paramj; 
    return bool2;
  }
  
  public void clear() {
    j j1 = this.y;
    if (j1 != null)
      d(j1); 
    this.j.clear();
    b(true);
  }
  
  public void clearHeader() {
    this.b = null;
    this.a = null;
    this.c = null;
    b(false);
  }
  
  public void close() { a(true); }
  
  protected h d(int paramInt) {
    a(paramInt, null, 0, null, null);
    return this;
  }
  
  public boolean d() { return this.h; }
  
  public boolean d(j paramj) {
    boolean bool1 = this.x.isEmpty();
    boolean bool2 = false;
    if (!bool1) {
      if (this.y != paramj)
        return false; 
      h();
      for (WeakReference weakReference : this.x) {
        o o1 = (o)weakReference.get();
        if (o1 == null) {
          this.x.remove(weakReference);
          continue;
        } 
        bool2 = o1.b(this, paramj);
        if (bool2)
          break; 
      } 
      i();
      if (bool2)
        this.y = null; 
    } 
    return bool2;
  }
  
  Resources e() { return this.f; }
  
  protected h e(int paramInt) {
    a(0, null, paramInt, null, null);
    return this;
  }
  
  public Context f() { return this.e; }
  
  public MenuItem findItem(int paramInt) {
    int i1 = size();
    for (byte b1 = 0; b1 < i1; b1++) {
      j j1 = (j)this.j.get(b1);
      if (j1.getItemId() == paramInt)
        return j1; 
      if (j1.hasSubMenu()) {
        MenuItem menuItem = j1.getSubMenu().findItem(paramInt);
        if (menuItem != null)
          return menuItem; 
      } 
    } 
    return null;
  }
  
  public void g() {
    a a1 = this.i;
    if (a1 != null)
      a1.a(this); 
  }
  
  public MenuItem getItem(int paramInt) { return (MenuItem)this.j.get(paramInt); }
  
  public void h() {
    if (!this.r) {
      this.r = true;
      this.s = false;
      this.t = false;
    } 
  }
  
  public boolean hasVisibleItems() {
    if (this.A)
      return true; 
    int i1 = size();
    for (byte b1 = 0; b1 < i1; b1++) {
      if (((j)this.j.get(b1)).isVisible())
        return true; 
    } 
    return false;
  }
  
  public void i() {
    this.r = false;
    if (this.s) {
      this.s = false;
      b(this.t);
    } 
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent) { return (a(paramInt, paramKeyEvent) != null); }
  
  public ArrayList<j> j() {
    if (!this.l)
      return this.k; 
    this.k.clear();
    int i1 = this.j.size();
    for (byte b1 = 0; b1 < i1; b1++) {
      j j1 = (j)this.j.get(b1);
      if (j1.isVisible())
        this.k.add(j1); 
    } 
    this.l = false;
    this.o = true;
    return this.k;
  }
  
  public void k() {
    ArrayList arrayList = j();
    if (!this.o)
      return; 
    Iterator iterator = this.x.iterator();
    boolean bool;
    for (bool = false; iterator.hasNext(); bool |= o1.b()) {
      WeakReference weakReference = (WeakReference)iterator.next();
      o o1 = (o)weakReference.get();
      if (o1 == null) {
        this.x.remove(weakReference);
        continue;
      } 
    } 
    if (bool) {
      this.m.clear();
      this.n.clear();
      int i1 = arrayList.size();
      for (byte b1 = 0; b1 < i1; b1++) {
        ArrayList arrayList1;
        j j1 = (j)arrayList.get(b1);
        if (j1.j()) {
          arrayList1 = this.m;
        } else {
          arrayList1 = this.n;
        } 
        arrayList1.add(j1);
      } 
    } else {
      this.m.clear();
      this.n.clear();
      this.n.addAll(j());
    } 
    this.o = false;
  }
  
  public ArrayList<j> l() {
    k();
    return this.m;
  }
  
  public ArrayList<j> m() {
    k();
    return this.n;
  }
  
  public CharSequence n() { return this.a; }
  
  public Drawable o() { return this.b; }
  
  public View p() { return this.c; }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2) { return a(findItem(paramInt1), paramInt2); }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2) {
    boolean bool;
    j j1 = a(paramInt1, paramKeyEvent);
    if (j1 != null) {
      bool = a(j1, paramInt2);
    } else {
      bool = false;
    } 
    if ((paramInt2 & 0x2) != 0)
      a(true); 
    return bool;
  }
  
  public h q() { return this; }
  
  boolean r() { return this.u; }
  
  public void removeGroup(int paramInt) {
    int i1 = c(paramInt);
    if (i1 >= 0) {
      int i2 = this.j.size() - i1;
      byte b1 = 0;
      while (true) {
        byte b2 = b1 + true;
        if (b1 < i2 && ((j)this.j.get(i1)).getGroupId() == paramInt) {
          a(i1, false);
          b1 = b2;
          continue;
        } 
        break;
      } 
      b(true);
    } 
  }
  
  public void removeItem(int paramInt) { a(b(paramInt), true); }
  
  public j s() { return this.y; }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    int i1 = this.j.size();
    for (byte b1 = 0; b1 < i1; b1++) {
      j j1 = (j)this.j.get(b1);
      if (j1.getGroupId() == paramInt) {
        j1.a(paramBoolean2);
        j1.setCheckable(paramBoolean1);
      } 
    } 
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean) { this.z = paramBoolean; }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean) {
    int i1 = this.j.size();
    for (byte b1 = 0; b1 < i1; b1++) {
      j j1 = (j)this.j.get(b1);
      if (j1.getGroupId() == paramInt)
        j1.setEnabled(paramBoolean); 
    } 
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean) {
    int i1 = this.j.size();
    byte b1 = 0;
    boolean bool = false;
    while (b1 < i1) {
      j j1 = (j)this.j.get(b1);
      if (j1.getGroupId() == paramInt && j1.c(paramBoolean))
        bool = true; 
      b1++;
    } 
    if (bool)
      b(true); 
  }
  
  public void setQwertyMode(boolean paramBoolean) {
    this.g = paramBoolean;
    b(false);
  }
  
  public int size() { return this.j.size(); }
  
  public static interface a {
    void a(h param1h);
    
    boolean a(h param1h, MenuItem param1MenuItem);
  }
  
  public static interface b {
    boolean a(j param1j);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */