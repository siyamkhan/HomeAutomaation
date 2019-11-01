package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class u extends h implements SubMenu {
  private h d;
  
  private j e;
  
  public u(Context paramContext, h paramh, j paramj) {
    super(paramContext);
    this.d = paramh;
    this.e = paramj;
  }
  
  public String a() {
    byte b;
    j j1 = this.e;
    if (j1 != null) {
      b = j1.getItemId();
    } else {
      b = 0;
    } 
    if (!b)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.a());
    stringBuilder.append(":");
    stringBuilder.append(b);
    return stringBuilder.toString();
  }
  
  public void a(h.a parama) { this.d.a(parama); }
  
  boolean a(h paramh, MenuItem paramMenuItem) { return (super.a(paramh, paramMenuItem) || this.d.a(paramh, paramMenuItem)); }
  
  public boolean b() { return this.d.b(); }
  
  public boolean c() { return this.d.c(); }
  
  public boolean c(j paramj) { return this.d.c(paramj); }
  
  public boolean d() { return this.d.d(); }
  
  public boolean d(j paramj) { return this.d.d(paramj); }
  
  public MenuItem getItem() { return this.e; }
  
  public h q() { return this.d.q(); }
  
  public void setGroupDividerEnabled(boolean paramBoolean) { this.d.setGroupDividerEnabled(paramBoolean); }
  
  public SubMenu setHeaderIcon(int paramInt) { return (SubMenu)e(paramInt); }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable) { return (SubMenu)a(paramDrawable); }
  
  public SubMenu setHeaderTitle(int paramInt) { return (SubMenu)d(paramInt); }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence) { return (SubMenu)a(paramCharSequence); }
  
  public SubMenu setHeaderView(View paramView) { return (SubMenu)a(paramView); }
  
  public SubMenu setIcon(int paramInt) {
    this.e.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable) {
    this.e.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean) { this.d.setQwertyMode(paramBoolean); }
  
  public Menu t() { return this.d; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\men\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */