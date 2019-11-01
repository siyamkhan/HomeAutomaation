package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

abstract class m implements o, s, AdapterView.OnItemClickListener {
  private Rect a;
  
  protected static int a(ListAdapter paramListAdapter, ViewGroup paramViewGroup, Context paramContext, int paramInt) {
    byte b = 0;
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    int k = paramListAdapter.getCount();
    ViewGroup viewGroup = paramViewGroup;
    View view = null;
    int n = 0;
    int i1 = 0;
    while (b < k) {
      FrameLayout frameLayout;
      int i2 = paramListAdapter.getItemViewType(b);
      if (i2 != i1) {
        view = null;
        i1 = i2;
      } 
      if (viewGroup == null)
        frameLayout = new FrameLayout(paramContext); 
      view = paramListAdapter.getView(b, view, frameLayout);
      view.measure(i, j);
      int i3 = view.getMeasuredWidth();
      if (i3 >= paramInt)
        return paramInt; 
      if (i3 > n)
        n = i3; 
      b++;
    } 
    return n;
  }
  
  protected static g a(ListAdapter paramListAdapter) { return (paramListAdapter instanceof HeaderViewListAdapter) ? (g)((HeaderViewListAdapter)paramListAdapter).getWrappedAdapter() : (g)paramListAdapter; }
  
  protected static boolean b(h paramh) {
    int i = paramh.size();
    for (byte b = 0; b < i; b++) {
      MenuItem menuItem = paramh.getItem(b);
      if (menuItem.isVisible() && menuItem.getIcon() != null)
        return true; 
    } 
    return false;
  }
  
  public abstract void a(int paramInt);
  
  public void a(Context paramContext, h paramh) {}
  
  public void a(Rect paramRect) { this.a = paramRect; }
  
  public abstract void a(h paramh);
  
  public abstract void a(View paramView);
  
  public abstract void a(PopupWindow.OnDismissListener paramOnDismissListener);
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a(h paramh, j paramj) { return false; }
  
  public abstract void b(int paramInt);
  
  public boolean b(h paramh, j paramj) { return false; }
  
  public abstract void c(int paramInt);
  
  public abstract void c(boolean paramBoolean);
  
  protected boolean f() { return true; }
  
  public Rect g() { return this.a; }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    byte b;
    ListAdapter listAdapter = (ListAdapter)paramAdapterView.getAdapter();
    h h = (a(listAdapter)).a;
    MenuItem menuItem = (MenuItem)listAdapter.getItem(paramInt);
    if (f()) {
      b = 0;
    } else {
      b = 4;
    } 
    h.a(menuItem, this, b);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */