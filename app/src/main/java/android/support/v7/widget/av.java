package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class av extends at implements au {
  private static Method a;
  
  private au b;
  
  static  {
    try {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = boolean.class;
      a = PopupWindow.class.getDeclaredMethod("setTouchModal", arrayOfClass);
      return;
    } catch (NoSuchMethodException noSuchMethodException) {
      Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
      return;
    } 
  }
  
  public av(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) { super(paramContext, paramAttributeSet, paramInt1, paramInt2); }
  
  am a(Context paramContext, boolean paramBoolean) {
    a a1 = new a(paramContext, paramBoolean);
    a1.setHoverListener(this);
    return a1;
  }
  
  public void a(h paramh, MenuItem paramMenuItem) {
    au au1 = this.b;
    if (au1 != null)
      au1.a(paramh, paramMenuItem); 
  }
  
  public void a(au paramau) { this.b = paramau; }
  
  public void a(Object paramObject) {
    if (Build.VERSION.SDK_INT >= 23)
      this.g.setEnterTransition((Transition)paramObject); 
  }
  
  public void b(h paramh, MenuItem paramMenuItem) {
    au au1 = this.b;
    if (au1 != null)
      au1.b(paramh, paramMenuItem); 
  }
  
  public void b(Object paramObject) {
    if (Build.VERSION.SDK_INT >= 23)
      this.g.setExitTransition((Transition)paramObject); 
  }
  
  public void c(boolean paramBoolean) {
    Method method = a;
    if (method != null)
      try {
        PopupWindow popupWindow = this.g;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Boolean.valueOf(paramBoolean);
        method.invoke(popupWindow, arrayOfObject);
        return;
      } catch (Exception exception) {
        Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
      }  
  }
  
  public static class a extends am {
    final int b;
    
    final int c;
    
    private au d;
    
    private MenuItem e;
    
    public a(Context param1Context, boolean param1Boolean) {
      super(param1Context, param1Boolean);
      Configuration configuration = param1Context.getResources().getConfiguration();
      if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
        this.b = 21;
        this.c = 22;
        return;
      } 
      this.b = 22;
      this.c = 21;
    }
    
    public boolean onHoverEvent(MotionEvent param1MotionEvent) {
      if (this.d != null) {
        int i;
        ListAdapter listAdapter = getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
          HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter)listAdapter;
          i = headerViewListAdapter.getHeadersCount();
          listAdapter = headerViewListAdapter.getWrappedAdapter();
        } else {
          i = 0;
        } 
        g g = (g)listAdapter;
        int j = param1MotionEvent.getAction();
        j j1 = null;
        if (j != 10) {
          int k = pointToPosition((int)param1MotionEvent.getX(), (int)param1MotionEvent.getY());
          j1 = null;
          if (k != -1) {
            int m = k - i;
            j1 = null;
            if (m >= 0) {
              int n = g.getCount();
              j1 = null;
              if (m < n)
                j1 = g.a(m); 
            } 
          } 
        } 
        MenuItem menuItem = this.e;
        if (menuItem != j1) {
          h h = g.a();
          if (menuItem != null)
            this.d.a(h, menuItem); 
          this.e = j1;
          if (j1 != null)
            this.d.b(h, j1); 
        } 
      } 
      return super.onHoverEvent(param1MotionEvent);
    }
    
    public boolean onKeyDown(int param1Int, KeyEvent param1KeyEvent) {
      ListMenuItemView listMenuItemView = (ListMenuItemView)getSelectedView();
      if (listMenuItemView != null && param1Int == this.b) {
        if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu())
          performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId()); 
        return true;
      } 
      if (listMenuItemView != null && param1Int == this.c) {
        setSelection(-1);
        ((g)getAdapter()).a().a(false);
        return true;
      } 
      return super.onKeyDown(param1Int, param1KeyEvent);
    }
    
    public void setHoverListener(au param1au) { this.d = param1au; }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */