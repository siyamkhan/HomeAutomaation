package android.support.v7.widget;

import android.view.View;

class bs {
  final b a;
  
  a b;
  
  bs(b paramb) {
    this.a = paramb;
    this.b = new a();
  }
  
  View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int k;
    int i = this.a.a();
    int j = this.a.b();
    if (paramInt2 > paramInt1) {
      k = 1;
    } else {
      k = -1;
    } 
    View view = null;
    while (paramInt1 != paramInt2) {
      View view1 = this.a.a(paramInt1);
      int m = this.a.a(view1);
      int n = this.a.b(view1);
      this.b.a(i, j, m, n);
      if (paramInt3 != 0) {
        this.b.a();
        this.b.a(paramInt3);
        if (this.b.b())
          return view1; 
      } 
      if (paramInt4 != 0) {
        this.b.a();
        this.b.a(paramInt4);
        if (this.b.b())
          view = view1; 
      } 
      paramInt1 += k;
    } 
    return view;
  }
  
  boolean a(View paramView, int paramInt) {
    this.b.a(this.a.a(), this.a.b(), this.a.a(paramView), this.a.b(paramView));
    if (paramInt != 0) {
      this.b.a();
      this.b.a(paramInt);
      return this.b.b();
    } 
    return false;
  }
  
  static class a {
    int a = 0;
    
    int b;
    
    int c;
    
    int d;
    
    int e;
    
    int a(int param1Int1, int param1Int2) { return (param1Int1 > param1Int2) ? 1 : ((param1Int1 == param1Int2) ? 2 : 4); }
    
    void a() { this.a = 0; }
    
    void a(int param1Int) { this.a = param1Int | this.a; }
    
    void a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.b = param1Int1;
      this.c = param1Int2;
      this.d = param1Int3;
      this.e = param1Int4;
    }
    
    boolean b() {
      int i = this.a;
      if ((i & 0x7) != 0 && (i & a(this.d, this.b) << 0) == 0)
        return false; 
      int j = this.a;
      if ((j & 0x70) != 0 && (j & a(this.d, this.c) << 4) == 0)
        return false; 
      int k = this.a;
      if ((k & 0x700) != 0 && (k & a(this.e, this.b) << 8) == 0)
        return false; 
      int m = this.a;
      return !((m & 0x7000) != 0 && (m & a(this.e, this.c) << 12) == 0);
    }
  }
  
  static interface b {
    int a();
    
    int a(View param1View);
    
    View a(int param1Int);
    
    int b();
    
    int b(View param1View);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */