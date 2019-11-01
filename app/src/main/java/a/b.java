package a.a.a.a;

import android.util.Log;

public class b implements l {
  private int a = 4;
  
  public b() {}
  
  public b(int paramInt) {}
  
  public void a(int paramInt, String paramString1, String paramString2) { a(paramInt, paramString1, paramString2, false); }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean) {
    if (paramBoolean || a(paramString1, paramInt))
      Log.println(paramInt, paramString1, paramString2); 
  }
  
  public void a(String paramString1, String paramString2) { a(paramString1, paramString2, null); }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable) {
    if (a(paramString1, 3))
      Log.d(paramString1, paramString2, paramThrowable); 
  }
  
  public boolean a(String paramString, int paramInt) { return (this.a <= paramInt || Log.isLoggable(paramString, paramInt)); }
  
  public void b(String paramString1, String paramString2) { b(paramString1, paramString2, null); }
  
  public void b(String paramString1, String paramString2, Throwable paramThrowable) {
    if (a(paramString1, 2))
      Log.v(paramString1, paramString2, paramThrowable); 
  }
  
  public void c(String paramString1, String paramString2) { c(paramString1, paramString2, null); }
  
  public void c(String paramString1, String paramString2, Throwable paramThrowable) {
    if (a(paramString1, 4))
      Log.i(paramString1, paramString2, paramThrowable); 
  }
  
  public void d(String paramString1, String paramString2) { d(paramString1, paramString2, null); }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable) {
    if (a(paramString1, 5))
      Log.w(paramString1, paramString2, paramThrowable); 
  }
  
  public void e(String paramString1, String paramString2) { e(paramString1, paramString2, null); }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable) {
    if (a(paramString1, 6))
      Log.e(paramString1, paramString2, paramThrowable); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */