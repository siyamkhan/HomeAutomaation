package a.a.a.a.a.e;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class f {
  public static final SSLSocketFactory a(g paramg) {
    SSLContext sSLContext = SSLContext.getInstance("TLS");
    sSLContext.init(null, new TrustManager[] { new h(new i(paramg.a(), paramg.b()), paramg) }null);
    return sSLContext.getSocketFactory();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */