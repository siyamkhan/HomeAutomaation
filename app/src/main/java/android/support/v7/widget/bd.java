package android.support.v7.widget;

import android.view.View;

class bd {
  static int a(RecyclerView.u paramu, ax paramax, View paramView1, View paramView2, RecyclerView.i parami, boolean paramBoolean) {
    if (parami.v() == 0 || paramu.e() == 0 || paramView1 == null || paramView2 == null)
      return 0; 
    if (!paramBoolean)
      return 1 + Math.abs(parami.d(paramView1) - parami.d(paramView2)); 
    int j = paramax.b(paramView2) - paramax.a(paramView1);
    return Math.min(paramax.f(), j);
  }
  
  static int a(RecyclerView.u paramu, ax paramax, View paramView1, View paramView2, RecyclerView.i parami, boolean paramBoolean1, boolean paramBoolean2) {
    if (parami.v() != 0 && paramu.e() != 0 && paramView1 != null) {
      int m;
      if (paramView2 == null)
        return 0; 
      int j = Math.min(parami.d(paramView1), parami.d(paramView2));
      int k = Math.max(parami.d(paramView1), parami.d(paramView2));
      if (paramBoolean2) {
        m = Math.max(0, -1 + paramu.e() - k);
      } else {
        m = Math.max(0, j);
      } 
      if (!paramBoolean1)
        return m; 
      int n = Math.abs(paramax.b(paramView2) - paramax.a(paramView1));
      int i1 = 1 + Math.abs(parami.d(paramView1) - parami.d(paramView2));
      return Math.round(n / i1 * m + (paramax.c() - paramax.a(paramView1)));
    } 
    return 0;
  }
  
  static int b(RecyclerView.u paramu, ax paramax, View paramView1, View paramView2, RecyclerView.i parami, boolean paramBoolean) {
    if (parami.v() == 0 || paramu.e() == 0 || paramView1 == null || paramView2 == null)
      return 0; 
    if (!paramBoolean)
      return paramu.e(); 
    int j = paramax.b(paramView2) - paramax.a(paramView1);
    int k = 1 + Math.abs(parami.d(paramView1) - parami.d(paramView2));
    return (int)(j / k * paramu.e());
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */