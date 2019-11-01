package a.a.a.a;

import a.a.a.a.a.b.x;
import a.a.a.a.a.c.e;
import a.a.a.a.a.c.f;
import a.a.a.a.a.c.m;
import org.jd.gui.api.API;

class h<Result> extends f<Void, Void, Result> {
  final i<Result> a;
  
  public h(i<Result> parami) { this.a = parami; }
  
  private x a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a.b());
    stringBuilder.append(".");
    stringBuilder.append(paramString);
    x x = new x(stringBuilder.toString(), "KitInitialization");
    x.a();
    return x;
  }
  
  protected Result a(Void... paramVarArgs) {
    Object object;
    x x = a("doInBackground");
    if (!e()) {
      object = this.a.e();
    } else {
      object = null;
    } 
    x.b();
    return (Result)object;
  }
  
  protected void a() {
    API aPI;
    super.a();
    x x = a("onPreExecute");
    try {
      boolean bool = this.a.b_();
      x.b();
      if (bool)
        return; 
      a(true);
      return;
    } catch (m m) {
      throw m;
    } catch (Exception exception) {
      c.g().e("Fabric", "Failure onPreExecute()", exception);
      x.b();
      a(true);
      return;
    } finally {}
    x.b();
    a(true);
    throw aPI;
  }
  
  protected void a(Result paramResult) {
    this.a.a(paramResult);
    this.a.h.a(paramResult);
  }
  
  public e b() { return e.c; }
  
  protected void b(Result paramResult) {
    this.a.b(paramResult);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a.b());
    stringBuilder.append(" Initialization was cancelled");
    g g = new g(stringBuilder.toString());
    this.a.h.a(g);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */