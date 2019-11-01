package android.support.v4.app;

import android.arch.lifecycle.e;
import android.arch.lifecycle.j;
import android.arch.lifecycle.k;
import android.arch.lifecycle.n;
import android.arch.lifecycle.o;
import android.arch.lifecycle.p;
import android.os.Bundle;
import android.support.v4.a.b;
import android.support.v4.g.d;
import android.support.v4.g.m;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class LoaderManagerImpl extends u {
  static boolean a = false;
  
  private final e b;
  
  private final LoaderViewModel c;
  
  static  {
  
  }
  
  LoaderManagerImpl(e parame, p paramp) {
    this.b = parame;
    this.c = LoaderViewModel.a(paramp);
  }
  
  public void a() { this.c.b(); }
  
  @Deprecated
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) { this.c.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString); }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);
    stringBuilder.append("LoaderManager{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" in ");
    d.a(this.b, stringBuilder);
    stringBuilder.append("}}");
    return stringBuilder.toString();
  }
  
  static class LoaderViewModel extends n {
    private static final o.a a = new o.a() {
        public <T extends n> T a(Class<T> param2Class) { return (T)new LoaderManagerImpl.LoaderViewModel(); }
      };
    
    private m<LoaderManagerImpl.a> b = new m();
    
    private boolean c = false;
    
    static LoaderViewModel a(p param1p) { return (LoaderViewModel)(new o(param1p, a)).a(LoaderViewModel.class); }
    
    protected void a() {
      super.a();
      int i = this.b.b();
      for (byte b1 = 0; b1 < i; b1++)
        ((LoaderManagerImpl.a)this.b.e(b1)).a(true); 
      this.b.c();
    }
    
    public void a(String param1String, FileDescriptor param1FileDescriptor, PrintWriter param1PrintWriter, String[] param1ArrayOfString) {
      if (this.b.b() > 0) {
        param1PrintWriter.print(param1String);
        param1PrintWriter.println("Loaders:");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1String);
        stringBuilder.append("    ");
        String str = stringBuilder.toString();
        for (byte b1 = 0; b1 < this.b.b(); b1++) {
          LoaderManagerImpl.a a1 = (LoaderManagerImpl.a)this.b.e(b1);
          param1PrintWriter.print(param1String);
          param1PrintWriter.print("  #");
          param1PrintWriter.print(this.b.d(b1));
          param1PrintWriter.print(": ");
          param1PrintWriter.println(a1.toString());
          a1.a(str, param1FileDescriptor, param1PrintWriter, param1ArrayOfString);
        } 
      } 
    }
    
    void b() {
      int i = this.b.b();
      for (byte b1 = 0; b1 < i; b1++)
        ((LoaderManagerImpl.a)this.b.e(b1)).g(); 
    }
  }
  
  static final class null implements o.a {
    public <T extends n> T a(Class<T> param1Class) { return (T)new LoaderManagerImpl.LoaderViewModel(); }
  }
  
  public static class a<D> extends j<D> implements b.a<D> {
    private final int a;
    
    private final Bundle b;
    
    private final b<D> c;
    
    private e d;
    
    private LoaderManagerImpl.b<D> e;
    
    private b<D> f;
    
    b<D> a(boolean param1Boolean) {
      if (LoaderManagerImpl.a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  Destroying: ");
        stringBuilder.append(this);
        Log.v("LoaderManager", stringBuilder.toString());
      } 
      this.c.c();
      this.c.g();
      LoaderManagerImpl.b b1 = this.e;
      if (b1 != null) {
        a(b1);
        if (param1Boolean)
          b1.b(); 
      } 
      this.c.a(this);
      if ((b1 != null && !b1.a()) || param1Boolean) {
        this.c.i();
        return this.f;
      } 
      return this.c;
    }
    
    public void a(k<? super D> param1k) {
      super.a(param1k);
      this.d = null;
      this.e = null;
    }
    
    public void a(D param1D) {
      super.a(param1D);
      b b1 = this.f;
      if (b1 != null) {
        b1.i();
        this.f = null;
      } 
    }
    
    public void a(String param1String, FileDescriptor param1FileDescriptor, PrintWriter param1PrintWriter, String[] param1ArrayOfString) {
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mId=");
      param1PrintWriter.print(this.a);
      param1PrintWriter.print(" mArgs=");
      param1PrintWriter.println(this.b);
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mLoader=");
      param1PrintWriter.println(this.c);
      b b1 = this.c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1String);
      stringBuilder.append("  ");
      b1.a(stringBuilder.toString(), param1FileDescriptor, param1PrintWriter, param1ArrayOfString);
      if (this.e != null) {
        param1PrintWriter.print(param1String);
        param1PrintWriter.print("mCallbacks=");
        param1PrintWriter.println(this.e);
        LoaderManagerImpl.b b2 = this.e;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(param1String);
        stringBuilder1.append("  ");
        b2.a(stringBuilder1.toString(), param1PrintWriter);
      } 
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mData=");
      param1PrintWriter.println(f().a(a()));
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mStarted=");
      param1PrintWriter.println(d());
    }
    
    protected void b() {
      if (LoaderManagerImpl.a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  Starting: ");
        stringBuilder.append(this);
        Log.v("LoaderManager", stringBuilder.toString());
      } 
      this.c.a();
    }
    
    protected void c() {
      if (LoaderManagerImpl.a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  Stopping: ");
        stringBuilder.append(this);
        Log.v("LoaderManager", stringBuilder.toString());
      } 
      this.c.e();
    }
    
    b<D> f() { return this.c; }
    
    void g() {
      e e1 = this.d;
      LoaderManagerImpl.b b1 = this.e;
      if (e1 != null && b1 != null) {
        super.a(b1);
        a(e1, b1);
      } 
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(64);
      stringBuilder.append("LoaderInfo{");
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append(" #");
      stringBuilder.append(this.a);
      stringBuilder.append(" : ");
      d.a(this.c, stringBuilder);
      stringBuilder.append("}}");
      return stringBuilder.toString();
    }
  }
  
  static class b<D> extends Object implements k<D> {
    private final b<D> a;
    
    private final u.a<D> b;
    
    private boolean c;
    
    public void a(D param1D) {
      if (LoaderManagerImpl.a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  onLoadFinished in ");
        stringBuilder.append(this.a);
        stringBuilder.append(": ");
        stringBuilder.append(this.a.a(param1D));
        Log.v("LoaderManager", stringBuilder.toString());
      } 
      this.b.a(this.a, param1D);
      this.c = true;
    }
    
    public void a(String param1String, PrintWriter param1PrintWriter) {
      param1PrintWriter.print(param1String);
      param1PrintWriter.print("mDeliveredData=");
      param1PrintWriter.println(this.c);
    }
    
    boolean a() { return this.c; }
    
    void b() {
      if (this.c) {
        if (LoaderManagerImpl.a) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("  Resetting: ");
          stringBuilder.append(this.a);
          Log.v("LoaderManager", stringBuilder.toString());
        } 
        this.b.a(this.a);
      } 
    }
    
    public String toString() { return this.b.toString(); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\LoaderManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */