package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.widget.bm;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements h.b, p, AdapterView.OnItemClickListener {
  private static final int[] a = { 16842964, 16843049 };
  
  private h b;
  
  private int c;
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 16842868); }
  
  public ExpandedMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet);
    setOnItemClickListener(this);
    bm bm = bm.a(paramContext, paramAttributeSet, a, paramInt, 0);
    if (bm.g(0))
      setBackgroundDrawable(bm.a(0)); 
    if (bm.g(1))
      setDivider(bm.a(1)); 
    bm.a();
  }
  
  public void a(h paramh) { this.b = paramh; }
  
  public boolean a(j paramj) { return this.b.a(paramj, 0); }
  
  public int getWindowAnimations() { return this.c; }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    setChildrenDrawingCacheEnabled(false);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) { a((j)getAdapter().getItem(paramInt)); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\ExpandedMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */