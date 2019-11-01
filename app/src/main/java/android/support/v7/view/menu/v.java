package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class v extends r implements SubMenu {
  v(Context paramContext, c paramc) { super(paramContext, paramc); }
  
  public c b() { return (c)this.b; }
  
  public void clearHeader() { b().clearHeader(); }
  
  public MenuItem getItem() { return a(b().getItem()); }
  
  public SubMenu setHeaderIcon(int paramInt) {
    b().setHeaderIcon(paramInt);
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable) {
    b().setHeaderIcon(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt) {
    b().setHeaderTitle(paramInt);
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence) {
    b().setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView) {
    b().setHeaderView(paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt) {
    b().setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable) {
    b().setIcon(paramDrawable);
    return this;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */