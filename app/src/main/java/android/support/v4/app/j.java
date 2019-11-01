package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class j {
  private final k<?> a;
  
  private j(k<?> paramk) { this.a = paramk; }
  
  public static j a(k<?> paramk) { return new j(paramk); }
  
  public g a(String paramString) { return this.a.b.b(paramString); }
  
  public l a() { return this.a.i(); }
  
  public View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) { return this.a.b.onCreateView(paramView, paramString, paramContext, paramAttributeSet); }
  
  public void a(Configuration paramConfiguration) { this.a.b.a(paramConfiguration); }
  
  public void a(Parcelable paramParcelable, n paramn) { this.a.b.a(paramParcelable, paramn); }
  
  public void a(g paramg) {
    m m = this.a.b;
    k k1 = this.a;
    m.a(k1, k1, paramg);
  }
  
  public void a(boolean paramBoolean) { this.a.b.a(paramBoolean); }
  
  public boolean a(Menu paramMenu) { return this.a.b.a(paramMenu); }
  
  public boolean a(Menu paramMenu, MenuInflater paramMenuInflater) { return this.a.b.a(paramMenu, paramMenuInflater); }
  
  public boolean a(MenuItem paramMenuItem) { return this.a.b.a(paramMenuItem); }
  
  public void b() { this.a.b.m(); }
  
  public void b(Menu paramMenu) { this.a.b.b(paramMenu); }
  
  public void b(boolean paramBoolean) { this.a.b.b(paramBoolean); }
  
  public boolean b(MenuItem paramMenuItem) { return this.a.b.b(paramMenuItem); }
  
  public Parcelable c() { return this.a.b.l(); }
  
  public n d() { return this.a.b.j(); }
  
  public void e() { this.a.b.n(); }
  
  public void f() { this.a.b.o(); }
  
  public void g() { this.a.b.p(); }
  
  public void h() { this.a.b.q(); }
  
  public void i() { this.a.b.r(); }
  
  public void j() { this.a.b.s(); }
  
  public void k() { this.a.b.u(); }
  
  public void l() { this.a.b.v(); }
  
  public boolean m() { return this.a.b.g(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */