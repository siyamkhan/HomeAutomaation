package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.b.a.b;
import android.support.v4.b.a.c;
import android.support.v4.g.a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class c<T> extends d<T> {
  final Context a;
  
  private Map<b, MenuItem> c;
  
  private Map<c, SubMenu> d;
  
  c(Context paramContext, T paramT) {
    super(paramT);
    this.a = paramContext;
  }
  
  final MenuItem a(MenuItem paramMenuItem) {
    if (paramMenuItem instanceof b) {
      b b = (b)paramMenuItem;
      if (this.c == null)
        this.c = new a(); 
      paramMenuItem = (MenuItem)this.c.get(paramMenuItem);
      if (paramMenuItem == null) {
        paramMenuItem = q.a(this.a, b);
        this.c.put(b, paramMenuItem);
      } 
    } 
    return paramMenuItem;
  }
  
  final SubMenu a(SubMenu paramSubMenu) {
    if (paramSubMenu instanceof c) {
      c c1 = (c)paramSubMenu;
      if (this.d == null)
        this.d = new a(); 
      SubMenu subMenu = (SubMenu)this.d.get(c1);
      if (subMenu == null) {
        subMenu = q.a(this.a, c1);
        this.d.put(c1, subMenu);
      } 
      return subMenu;
    } 
    return paramSubMenu;
  }
  
  final void a() {
    Map map1 = this.c;
    if (map1 != null)
      map1.clear(); 
    Map map2 = this.d;
    if (map2 != null)
      map2.clear(); 
  }
  
  final void a(int paramInt) {
    Map map = this.c;
    if (map == null)
      return; 
    Iterator iterator = map.keySet().iterator();
    while (iterator.hasNext()) {
      if (paramInt == ((MenuItem)iterator.next()).getGroupId())
        iterator.remove(); 
    } 
  }
  
  final void b(int paramInt) {
    Map map = this.c;
    if (map == null)
      return; 
    Iterator iterator = map.keySet().iterator();
    while (iterator.hasNext()) {
      if (paramInt == ((MenuItem)iterator.next()).getItemId()) {
        iterator.remove();
        break;
      } 
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */