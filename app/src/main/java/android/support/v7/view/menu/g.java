package android.support.v7.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class g extends BaseAdapter {
  h a;
  
  private int b = -1;
  
  private boolean c;
  
  private final boolean d;
  
  private final LayoutInflater e;
  
  private final int f;
  
  public g(h paramh, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt) {
    this.d = paramBoolean;
    this.e = paramLayoutInflater;
    this.a = paramh;
    this.f = paramInt;
    b();
  }
  
  public h a() { return this.a; }
  
  public j a(int paramInt) {
    ArrayList arrayList;
    if (this.d) {
      arrayList = this.a.m();
    } else {
      arrayList = this.a.j();
    } 
    int i = this.b;
    if (i >= 0 && paramInt >= i)
      paramInt++; 
    return (j)arrayList.get(paramInt);
  }
  
  public void a(boolean paramBoolean) { this.c = paramBoolean; }
  
  void b() {
    j j = this.a.s();
    if (j != null) {
      ArrayList arrayList = this.a.m();
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
    ArrayList arrayList;
    if (this.d) {
      arrayList = this.a.m();
    } else {
      arrayList = this.a.j();
    } 
    return (this.b < 0) ? arrayList.size() : (-1 + arrayList.size());
  }
  
  public long getItemId(int paramInt) { return paramInt; }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    boolean bool;
    int k;
    if (paramView == null)
      paramView = this.e.inflate(this.f, paramViewGroup, false); 
    int i = a(paramInt).getGroupId();
    int j = paramInt - 1;
    if (j >= 0) {
      k = a(j).getGroupId();
    } else {
      k = i;
    } 
    ListMenuItemView listMenuItemView = (ListMenuItemView)paramView;
    if (this.a.b() && i != k) {
      bool = true;
    } else {
      bool = false;
    } 
    listMenuItemView.setGroupDividerEnabled(bool);
    p.a a1 = (p.a)paramView;
    if (this.c)
      listMenuItemView.setForceShowIcon(true); 
    a1.a(a(paramInt), 0);
    return paramView;
  }
  
  public void notifyDataSetChanged() {
    b();
    super.notifyDataSetChanged();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */