package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.a.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class f implements o, AdapterView.OnItemClickListener {
  Context a;
  
  LayoutInflater b;
  
  h c;
  
  ExpandedMenuView d;
  
  int e;
  
  int f;
  
  int g;
  
  a h;
  
  private o.a i;
  
  public f(int paramInt1, int paramInt2) {
    this.g = paramInt1;
    this.f = paramInt2;
  }
  
  public f(Context paramContext, int paramInt) {
    this(paramInt, 0);
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a);
  }
  
  public p a(ViewGroup paramViewGroup) {
    if (this.d == null) {
      this.d = (ExpandedMenuView)this.b.inflate(a.g.abc_expanded_menu_layout, paramViewGroup, false);
      if (this.h == null)
        this.h = new a(this); 
      this.d.setAdapter(this.h);
      this.d.setOnItemClickListener(this);
    } 
    return this.d;
  }
  
  public ListAdapter a() {
    if (this.h == null)
      this.h = new a(this); 
    return this.h;
  }
  
  public void a(Context paramContext, h paramh) { // Byte code:
    //   0: aload_0
    //   1: getfield f : I
    //   4: istore_3
    //   5: iload_3
    //   6: ifeq -> 36
    //   9: aload_0
    //   10: new android/view/ContextThemeWrapper
    //   13: dup
    //   14: aload_1
    //   15: iload_3
    //   16: invokespecial <init> : (Landroid/content/Context;I)V
    //   19: putfield a : Landroid/content/Context;
    //   22: aload_0
    //   23: aload_0
    //   24: getfield a : Landroid/content/Context;
    //   27: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   30: putfield b : Landroid/view/LayoutInflater;
    //   33: goto -> 58
    //   36: aload_0
    //   37: getfield a : Landroid/content/Context;
    //   40: ifnull -> 58
    //   43: aload_0
    //   44: aload_1
    //   45: putfield a : Landroid/content/Context;
    //   48: aload_0
    //   49: getfield b : Landroid/view/LayoutInflater;
    //   52: ifnonnull -> 58
    //   55: goto -> 22
    //   58: aload_0
    //   59: aload_2
    //   60: putfield c : Landroid/support/v7/view/menu/h;
    //   63: aload_0
    //   64: getfield h : Landroid/support/v7/view/menu/f$a;
    //   67: astore #4
    //   69: aload #4
    //   71: ifnull -> 79
    //   74: aload #4
    //   76: invokevirtual notifyDataSetChanged : ()V
    //   79: return }
  
  public void a(h paramh, boolean paramBoolean) {
    o.a a1 = this.i;
    if (a1 != null)
      a1.a(paramh, paramBoolean); 
  }
  
  public void a(o.a parama) { this.i = parama; }
  
  public boolean a(h paramh, j paramj) { return false; }
  
  public boolean a(u paramu) {
    if (!paramu.hasVisibleItems())
      return false; 
    (new i(paramu)).a(null);
    o.a a1 = this.i;
    if (a1 != null)
      a1.a(paramu); 
    return true;
  }
  
  public void b(boolean paramBoolean) {
    a a1 = this.h;
    if (a1 != null)
      a1.notifyDataSetChanged(); 
  }
  
  public boolean b() { return false; }
  
  public boolean b(h paramh, j paramj) { return false; }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) { this.c.a(this.h.a(paramInt), this, 0); }
  
  private class a extends BaseAdapter {
    private int b = -1;
    
    public a(f this$0) { a(); }
    
    public j a(int param1Int) {
      ArrayList arrayList = this.a.c.m();
      int i = param1Int + this.a.e;
      int j = this.b;
      if (j >= 0 && i >= j)
        i++; 
      return (j)arrayList.get(i);
    }
    
    void a() {
      j j = this.a.c.s();
      if (j != null) {
        ArrayList arrayList = this.a.c.m();
        int i = arrayList.size();
        for (byte b1 = 0; b1 < i; b1++) {
          if ((j)arrayList.get(b1) == j) {
            this.b = b1;
            return;
          } 
        } 
      } 
      this.b = -1;
    }
    
    public int getCount() {
      int i = this.a.c.m().size() - this.a.e;
      return (this.b < 0) ? i : (i - 1);
    }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      if (param1View == null)
        param1View = this.a.b.inflate(this.a.g, param1ViewGroup, false); 
      ((p.a)param1View).a(a(param1Int), 0);
      return param1View;
    }
    
    public void notifyDataSetChanged() {
      a();
      super.notifyDataSetChanged();
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */