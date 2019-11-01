package android.support.v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b implements o {
  protected Context a;
  
  protected Context b;
  
  protected h c;
  
  protected LayoutInflater d;
  
  protected LayoutInflater e;
  
  protected p f;
  
  private o.a g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  public b(Context paramContext, int paramInt1, int paramInt2) {
    this.a = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  public o.a a() { return this.g; }
  
  public p a(ViewGroup paramViewGroup) {
    if (this.f == null) {
      this.f = (p)this.d.inflate(this.h, paramViewGroup, false);
      this.f.a(this.c);
      b(true);
    } 
    return this.f;
  }
  
  public View a(j paramj, View paramView, ViewGroup paramViewGroup) {
    p.a a1;
    if (paramView instanceof p.a) {
      a1 = (p.a)paramView;
    } else {
      a1 = b(paramViewGroup);
    } 
    a(paramj, a1);
    return (View)a1;
  }
  
  public void a(int paramInt) { this.j = paramInt; }
  
  public void a(Context paramContext, h paramh) {
    this.b = paramContext;
    this.e = LayoutInflater.from(this.b);
    this.c = paramh;
  }
  
  public void a(h paramh, boolean paramBoolean) {
    o.a a1 = this.g;
    if (a1 != null)
      a1.a(paramh, paramBoolean); 
  }
  
  public abstract void a(j paramj, p.a parama);
  
  public void a(o.a parama) { this.g = parama; }
  
  protected void a(View paramView, int paramInt) {
    ViewGroup viewGroup = (ViewGroup)paramView.getParent();
    if (viewGroup != null)
      viewGroup.removeView(paramView); 
    ((ViewGroup)this.f).addView(paramView, paramInt);
  }
  
  public boolean a(int paramInt, j paramj) { return true; }
  
  public boolean a(h paramh, j paramj) { return false; }
  
  public boolean a(u paramu) {
    o.a a1 = this.g;
    return (a1 != null) ? a1.a(paramu) : 0;
  }
  
  protected boolean a(ViewGroup paramViewGroup, int paramInt) {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public p.a b(ViewGroup paramViewGroup) { return (p.a)this.d.inflate(this.i, paramViewGroup, false); }
  
  public void b(boolean paramBoolean) {
    ViewGroup viewGroup = (ViewGroup)this.f;
    if (viewGroup == null)
      return; 
    h h1 = this.c;
    byte b1 = 0;
    if (h1 != null) {
      h1.k();
      ArrayList arrayList = this.c.j();
      int k = arrayList.size();
      byte b2 = 0;
      byte b3 = 0;
      while (b2 < k) {
        j j1 = (j)arrayList.get(b2);
        if (a(b3, j1)) {
          Object object;
          View view1 = viewGroup.getChildAt(b3);
          if (view1 instanceof p.a) {
            object = ((p.a)view1).getItemData();
          } else {
            object = null;
          } 
          View view2 = a(j1, view1, viewGroup);
          if (j1 != object) {
            view2.setPressed(false);
            view2.jumpDrawablesToCurrentState();
          } 
          if (view2 != view1)
            a(view2, b3); 
          b3++;
        } 
        b2++;
      } 
      b1 = b3;
    } 
    while (b1 < viewGroup.getChildCount()) {
      if (!a(viewGroup, b1))
        b1++; 
    } 
  }
  
  public boolean b() { return false; }
  
  public boolean b(h paramh, j paramj) { return false; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */