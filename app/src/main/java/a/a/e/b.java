package a.a.a.a.a.e;

import a.a.a.a.b;
import a.a.a.a.l;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class b implements e {
  private final l a;
  
  private g b;
  
  private SSLSocketFactory c;
  
  private boolean d;
  
  public b() { this(new b()); }
  
  public b(l paraml) { this.a = paraml; }
  
  private void a() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield d : Z
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield c : Ljavax/net/ssl/SSLSocketFactory;
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	15	finally }
  
  private boolean a(String paramString) { return (paramString != null && paramString.toLowerCase(Locale.US).startsWith("https")); }
  
  private SSLSocketFactory b() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljavax/net/ssl/SSLSocketFactory;
    //   6: ifnonnull -> 24
    //   9: aload_0
    //   10: getfield d : Z
    //   13: ifne -> 24
    //   16: aload_0
    //   17: aload_0
    //   18: invokespecial c : ()Ljavax/net/ssl/SSLSocketFactory;
    //   21: putfield c : Ljavax/net/ssl/SSLSocketFactory;
    //   24: aload_0
    //   25: getfield c : Ljavax/net/ssl/SSLSocketFactory;
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: areturn
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	33	finally
    //   24	29	33	finally }
  
  private SSLSocketFactory c() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield d : Z
    //   7: aload_0
    //   8: getfield b : La/a/a/a/a/e/g;
    //   11: invokestatic a : (La/a/a/a/a/e/g;)Ljavax/net/ssl/SSLSocketFactory;
    //   14: astore_3
    //   15: aload_0
    //   16: getfield a : La/a/a/a/l;
    //   19: ldc 'Fabric'
    //   21: ldc 'Custom SSL pinning enabled'
    //   23: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: areturn
    //   32: astore_2
    //   33: aload_0
    //   34: getfield a : La/a/a/a/l;
    //   37: ldc 'Fabric'
    //   39: ldc 'Exception while validating pinned certs'
    //   41: aload_2
    //   42: invokeinterface e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: aconst_null
    //   50: areturn
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	51	finally
    //   7	28	32	java/lang/Exception
    //   7	28	51	finally
    //   33	47	51	finally }
  
  public d a(c paramc, String paramString, Map<String, String> paramMap) {
    d d1;
    switch (null.a[paramc.ordinal()]) {
      default:
        throw new IllegalArgumentException("Unsupported HTTP method!");
      case 4:
        d1 = d.e(paramString);
        break;
      case 3:
        d1 = d.d(paramString);
        break;
      case 2:
        d1 = d.b(paramString, paramMap, true);
        break;
      case 1:
        d1 = d.a(paramString, paramMap, true);
        break;
    } 
    if (a(paramString) && this.b != null) {
      SSLSocketFactory sSLSocketFactory = b();
      if (sSLSocketFactory != null)
        ((HttpsURLConnection)d1.a()).setSSLSocketFactory(sSLSocketFactory); 
    } 
    return d1;
  }
  
  public void a(g paramg) {
    if (this.b != paramg) {
      this.b = paramg;
      a();
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */