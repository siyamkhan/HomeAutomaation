package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.b;
import android.support.v4.h.c;
import android.support.v7.view.c;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class k extends c<b> implements MenuItem {
  private Method c;
  
  k(Context paramContext, b paramb) { super(paramContext, paramb); }
  
  a a(ActionProvider paramActionProvider) { return new a(this, this.a, paramActionProvider); }
  
  public void a(boolean paramBoolean) {
    try {
      if (this.c == null) {
        Class clazz = ((b)this.b).getClass();
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = boolean.class;
        this.c = clazz.getDeclaredMethod("setExclusiveCheckable", arrayOfClass);
      } 
      Method method = this.c;
      Object object = this.b;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      method.invoke(object, arrayOfObject);
      return;
    } catch (Exception exception) {
      Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", exception);
      return;
    } 
  }
  
  public boolean collapseActionView() { return ((b)this.b).collapseActionView(); }
  
  public boolean expandActionView() { return ((b)this.b).expandActionView(); }
  
  public ActionProvider getActionProvider() {
    c c1 = ((b)this.b).a();
    return (c1 instanceof a) ? ((a)c1).a : null;
  }
  
  public View getActionView() {
    View view = ((b)this.b).getActionView();
    if (view instanceof b)
      view = ((b)view).c(); 
    return view;
  }
  
  public int getAlphabeticModifiers() { return ((b)this.b).getAlphabeticModifiers(); }
  
  public char getAlphabeticShortcut() { return ((b)this.b).getAlphabeticShortcut(); }
  
  public CharSequence getContentDescription() { return ((b)this.b).getContentDescription(); }
  
  public int getGroupId() { return ((b)this.b).getGroupId(); }
  
  public Drawable getIcon() { return ((b)this.b).getIcon(); }
  
  public ColorStateList getIconTintList() { return ((b)this.b).getIconTintList(); }
  
  public PorterDuff.Mode getIconTintMode() { return ((b)this.b).getIconTintMode(); }
  
  public Intent getIntent() { return ((b)this.b).getIntent(); }
  
  public int getItemId() { return ((b)this.b).getItemId(); }
  
  public ContextMenu.ContextMenuInfo getMenuInfo() { return ((b)this.b).getMenuInfo(); }
  
  public int getNumericModifiers() { return ((b)this.b).getNumericModifiers(); }
  
  public char getNumericShortcut() { return ((b)this.b).getNumericShortcut(); }
  
  public int getOrder() { return ((b)this.b).getOrder(); }
  
  public SubMenu getSubMenu() { return a(((b)this.b).getSubMenu()); }
  
  public CharSequence getTitle() { return ((b)this.b).getTitle(); }
  
  public CharSequence getTitleCondensed() { return ((b)this.b).getTitleCondensed(); }
  
  public CharSequence getTooltipText() { return ((b)this.b).getTooltipText(); }
  
  public boolean hasSubMenu() { return ((b)this.b).hasSubMenu(); }
  
  public boolean isActionViewExpanded() { return ((b)this.b).isActionViewExpanded(); }
  
  public boolean isCheckable() { return ((b)this.b).isCheckable(); }
  
  public boolean isChecked() { return ((b)this.b).isChecked(); }
  
  public boolean isEnabled() { return ((b)this.b).isEnabled(); }
  
  public boolean isVisible() { return ((b)this.b).isVisible(); }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider) {
    c c1;
    b b = (b)this.b;
    if (paramActionProvider != null) {
      c1 = a(paramActionProvider);
    } else {
      c1 = null;
    } 
    b.a(c1);
    return this;
  }
  
  public MenuItem setActionView(int paramInt) {
    ((b)this.b).setActionView(paramInt);
    View view = ((b)this.b).getActionView();
    if (view instanceof CollapsibleActionView)
      ((b)this.b).setActionView(new b(view)); 
    return this;
  }
  
  public MenuItem setActionView(View paramView) {
    b b;
    if (paramView instanceof CollapsibleActionView)
      b = new b(paramView); 
    ((b)this.b).setActionView(b);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar) {
    ((b)this.b).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt) {
    ((b)this.b).setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean) {
    ((b)this.b).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean) {
    ((b)this.b).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence) {
    ((b)this.b).a(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean) {
    ((b)this.b).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt) {
    ((b)this.b).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable) {
    ((b)this.b).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList) {
    ((b)this.b).setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode) {
    ((b)this.b).setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent) {
    ((b)this.b).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar) {
    ((b)this.b).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt) {
    ((b)this.b).setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener) {
    MenuItem.OnActionExpandListener onActionExpandListener;
    b b = (b)this.b;
    if (paramOnActionExpandListener != null) {
      onActionExpandListener = new c(this, paramOnActionExpandListener);
    } else {
      onActionExpandListener = null;
    } 
    b.setOnActionExpandListener(onActionExpandListener);
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener) {
    MenuItem.OnMenuItemClickListener onMenuItemClickListener;
    b b = (b)this.b;
    if (paramOnMenuItemClickListener != null) {
      onMenuItemClickListener = new d(this, paramOnMenuItemClickListener);
    } else {
      onMenuItemClickListener = null;
    } 
    b.setOnMenuItemClickListener(onMenuItemClickListener);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2) {
    ((b)this.b).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2) {
    ((b)this.b).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt) { ((b)this.b).setShowAsAction(paramInt); }
  
  public MenuItem setShowAsActionFlags(int paramInt) {
    ((b)this.b).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt) {
    ((b)this.b).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence) {
    ((b)this.b).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence) {
    ((b)this.b).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence) {
    ((b)this.b).b(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean) { return ((b)this.b).setVisible(paramBoolean); }
  
  class a extends c {
    final ActionProvider a;
    
    public a(k this$0, Context param1Context, ActionProvider param1ActionProvider) {
      super(param1Context);
      this.a = param1ActionProvider;
    }
    
    public View a() { return this.a.onCreateActionView(); }
    
    public void a(SubMenu param1SubMenu) { this.a.onPrepareSubMenu(this.b.a(param1SubMenu)); }
    
    public boolean d() { return this.a.onPerformDefaultAction(); }
    
    public boolean e() { return this.a.hasSubMenu(); }
  }
  
  static class b extends FrameLayout implements c {
    final CollapsibleActionView a;
    
    b(View param1View) {
      super(param1View.getContext());
      this.a = (CollapsibleActionView)param1View;
      addView(param1View);
    }
    
    public void a() { this.a.onActionViewExpanded(); }
    
    public void b() { this.a.onActionViewCollapsed(); }
    
    View c() { return (View)this.a; }
  }
  
  private class c extends d<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
    c(k this$0, MenuItem.OnActionExpandListener param1OnActionExpandListener) { super(param1OnActionExpandListener); }
    
    public boolean onMenuItemActionCollapse(MenuItem param1MenuItem) { return ((MenuItem.OnActionExpandListener)this.b).onMenuItemActionCollapse(this.a.a(param1MenuItem)); }
    
    public boolean onMenuItemActionExpand(MenuItem param1MenuItem) { return ((MenuItem.OnActionExpandListener)this.b).onMenuItemActionExpand(this.a.a(param1MenuItem)); }
  }
  
  private class d extends d<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
    d(k this$0, MenuItem.OnMenuItemClickListener param1OnMenuItemClickListener) { super(param1OnMenuItemClickListener); }
    
    public boolean onMenuItemClick(MenuItem param1MenuItem) { return ((MenuItem.OnMenuItemClickListener)this.b).onMenuItemClick(this.a.a(param1MenuItem)); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */