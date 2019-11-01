package android.support.v4.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

public final class j {
  public static void a(ListView paramListView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 19) {
      paramListView.scrollListBy(paramInt);
      return;
    } 
    int i = paramListView.getFirstVisiblePosition();
    if (i == -1)
      return; 
    View view = paramListView.getChildAt(0);
    if (view == null)
      return; 
    paramListView.setSelectionFromTop(i, view.getTop() - paramInt);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\widget\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */