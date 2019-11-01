package android.support.v7.view;

import android.content.Context;
import android.support.v4.b.a.a;
import android.support.v4.b.a.b;
import android.support.v4.g.l;
import android.support.v7.view.menu.q;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public class f extends ActionMode {
  final Context a;
  
  final b b;
  
  public f(Context paramContext, b paramb) {
    this.a = paramContext;
    this.b = paramb;
  }
  
  public void finish() { this.b.c(); }
  
  public View getCustomView() { return this.b.i(); }
  
  public Menu getMenu() { return q.a(this.a, (a)this.b.b()); }
  
  public MenuInflater getMenuInflater() { return this.b.a(); }
  
  public CharSequence getSubtitle() { return this.b.g(); }
  
  public Object getTag() { return this.b.j(); }
  
  public CharSequence getTitle() { return this.b.f(); }
  
  public boolean getTitleOptionalHint() { return this.b.k(); }
  
  public void invalidate() { this.b.d(); }
  
  public boolean isTitleOptional() { return this.b.h(); }
  
  public void setCustomView(View paramView) { this.b.a(paramView); }
  
  public void setSubtitle(int paramInt) { this.b.b(paramInt); }
  
  public void setSubtitle(CharSequence paramCharSequence) { this.b.a(paramCharSequence); }
  
  public void setTag(Object paramObject) { this.b.a(paramObject); }
  
  public void setTitle(int paramInt) { this.b.a(paramInt); }
  
  public void setTitle(CharSequence paramCharSequence) { this.b.b(paramCharSequence); }
  
  public void setTitleOptionalHint(boolean paramBoolean) { this.b.a(paramBoolean); }
  
  public static class a implements b.a {
    final ActionMode.Callback a;
    
    final Context b;
    
    final ArrayList<f> c;
    
    final l<Menu, Menu> d;
    
    public a(Context param1Context, ActionMode.Callback param1Callback) {
      this.b = param1Context;
      this.a = param1Callback;
      this.c = new ArrayList();
      this.d = new l();
    }
    
    private Menu a(Menu param1Menu) {
      Menu menu = (Menu)this.d.get(param1Menu);
      if (menu == null) {
        menu = q.a(this.b, (a)param1Menu);
        this.d.put(param1Menu, menu);
      } 
      return menu;
    }
    
    public void a(b param1b) { this.a.onDestroyActionMode(b(param1b)); }
    
    public boolean a(b param1b, Menu param1Menu) { return this.a.onCreateActionMode(b(param1b), a(param1Menu)); }
    
    public boolean a(b param1b, MenuItem param1MenuItem) { return this.a.onActionItemClicked(b(param1b), q.a(this.b, (b)param1MenuItem)); }
    
    public ActionMode b(b param1b) {
      int i = this.c.size();
      for (byte b1 = 0; b1 < i; b1++) {
        f f1 = (f)this.c.get(b1);
        if (f1 != null && f1.b == param1b)
          return f1; 
      } 
      f f = new f(this.b, param1b);
      this.c.add(f);
      return f;
    }
    
    public boolean b(b param1b, Menu param1Menu) { return this.a.onPrepareActionMode(b(param1b), a(param1Menu)); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */