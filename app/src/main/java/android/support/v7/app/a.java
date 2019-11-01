package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.support.v7.view.b;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

public abstract class a {
  public abstract int a();
  
  public b a(b.a parama) { return null; }
  
  public void a(float paramFloat) {
    if (paramFloat == 0.0F)
      return; 
    throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
  }
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(CharSequence paramCharSequence) {}
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent) { return false; }
  
  public boolean a(KeyEvent paramKeyEvent) { return false; }
  
  public Context b() { return null; }
  
  public abstract void b(boolean paramBoolean);
  
  public void c(boolean paramBoolean) {}
  
  public boolean c() { return false; }
  
  public void d(boolean paramBoolean) {
    if (!paramBoolean)
      return; 
    throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
  }
  
  public boolean d() { return false; }
  
  public void e(boolean paramBoolean) {}
  
  public boolean e() { return false; }
  
  public void f(boolean paramBoolean) {}
  
  public boolean f() { return false; }
  
  void g() {}
  
  public void g(boolean paramBoolean) {}
  
  public static class a extends ViewGroup.MarginLayoutParams {
    public int a = 0;
    
    public a(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
      this.a = 8388627;
    }
    
    public a(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, a.j.ActionBarLayout);
      this.a = typedArray.getInt(a.j.ActionBarLayout_android_layout_gravity, 0);
      typedArray.recycle();
    }
    
    public a(a param1a) {
      super(param1a);
      this.a = param1a.a;
    }
    
    public a(ViewGroup.LayoutParams param1LayoutParams) { super(param1LayoutParams); }
  }
  
  public static interface b {
    void a(boolean param1Boolean);
  }
  
  @Deprecated
  public static abstract class c {
    public abstract Drawable a();
    
    public abstract CharSequence b();
    
    public abstract View c();
    
    public abstract void d();
    
    public abstract CharSequence e();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\app\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */