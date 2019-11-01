package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.b.a.a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

class r extends c<a> implements Menu {
  r(Context paramContext, a parama) { super(paramContext, parama); }
  
  public MenuItem add(int paramInt) { return a(((a)this.b).add(paramInt)); }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4) { return a(((a)this.b).add(paramInt1, paramInt2, paramInt3, paramInt4)); }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) { return a(((a)this.b).add(paramInt1, paramInt2, paramInt3, paramCharSequence)); }
  
  public MenuItem add(CharSequence paramCharSequence) { return a(((a)this.b).add(paramCharSequence)); }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem) {
    MenuItem[] arrayOfMenuItem;
    if (paramArrayOfMenuItem != null) {
      arrayOfMenuItem = new MenuItem[paramArrayOfMenuItem.length];
    } else {
      arrayOfMenuItem = null;
    } 
    int i = ((a)this.b).addIntentOptions(paramInt1, paramInt2, paramInt3, paramComponentName, paramArrayOfIntent, paramIntent, paramInt4, arrayOfMenuItem);
    if (arrayOfMenuItem != null) {
      byte b = 0;
      int j = arrayOfMenuItem.length;
      while (b < j) {
        paramArrayOfMenuItem[b] = a(arrayOfMenuItem[b]);
        b++;
      } 
    } 
    return i;
  }
  
  public SubMenu addSubMenu(int paramInt) { return a(((a)this.b).addSubMenu(paramInt)); }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4) { return a(((a)this.b).addSubMenu(paramInt1, paramInt2, paramInt3, paramInt4)); }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence) { return a(((a)this.b).addSubMenu(paramInt1, paramInt2, paramInt3, paramCharSequence)); }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence) { return a(((a)this.b).addSubMenu(paramCharSequence)); }
  
  public void clear() {
    a();
    ((a)this.b).clear();
  }
  
  public void close() { ((a)this.b).close(); }
  
  public MenuItem findItem(int paramInt) { return a(((a)this.b).findItem(paramInt)); }
  
  public MenuItem getItem(int paramInt) { return a(((a)this.b).getItem(paramInt)); }
  
  public boolean hasVisibleItems() { return ((a)this.b).hasVisibleItems(); }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent) { return ((a)this.b).isShortcutKey(paramInt, paramKeyEvent); }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2) { return ((a)this.b).performIdentifierAction(paramInt1, paramInt2); }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2) { return ((a)this.b).performShortcut(paramInt1, paramKeyEvent, paramInt2); }
  
  public void removeGroup(int paramInt) {
    a(paramInt);
    ((a)this.b).removeGroup(paramInt);
  }
  
  public void removeItem(int paramInt) {
    b(paramInt);
    ((a)this.b).removeItem(paramInt);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2) { ((a)this.b).setGroupCheckable(paramInt, paramBoolean1, paramBoolean2); }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean) { ((a)this.b).setGroupEnabled(paramInt, paramBoolean); }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean) { ((a)this.b).setGroupVisible(paramInt, paramBoolean); }
  
  public void setQwertyMode(boolean paramBoolean) { ((a)this.b).setQwertyMode(paramBoolean); }
  
  public int size() { return ((a)this.b).size(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */