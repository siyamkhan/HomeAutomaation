package android.support.v4.widget;

import android.widget.ListView;

public class i extends a {
  private final ListView f;
  
  public i(ListView paramListView) {
    super(paramListView);
    this.f = paramListView;
  }
  
  public void a(int paramInt1, int paramInt2) { j.a(this.f, paramInt2); }
  
  public boolean e(int paramInt) { return false; }
  
  public boolean f(int paramInt) {
    ListView listView = this.f;
    int j = listView.getCount();
    if (j == 0)
      return false; 
    int k = listView.getChildCount();
    int m = listView.getFirstVisiblePosition();
    int n = m + k;
    if (paramInt > 0) {
      if (n >= j && listView.getChildAt(k - 1).getBottom() <= listView.getHeight())
        return false; 
    } else {
      return (paramInt < 0) ? (!(m <= 0 && listView.getChildAt(0).getTop() >= 0)) : false;
    } 
    return true;
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\widget\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */