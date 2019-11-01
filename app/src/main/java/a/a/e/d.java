package a.a.a.a.a.e;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;
import org.jd.gui.api.API;

public class d {
  private static final String[] b = new String[0];
  
  private static b c = b.a;
  
  public final URL a;
  
  private HttpURLConnection d = null;
  
  private final String e;
  
  private e f;
  
  private boolean g;
  
  private boolean h = true;
  
  private boolean i = false;
  
  private int j = 8192;
  
  private String k;
  
  private int l;
  
  public d(CharSequence paramCharSequence, String paramString) {
    try {
      this.a = new URL(paramCharSequence.toString());
      this.e = paramString;
      return;
    } catch (MalformedURLException malformedURLException) {
      throw new c(malformedURLException);
    } 
  }
  
  public static d a(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean) {
    String str = a(paramCharSequence, paramMap);
    if (paramBoolean)
      str = a(str); 
    return b(str);
  }
  
  public static String a(CharSequence paramCharSequence) {
    try {
      URL uRL = new URL(paramCharSequence.toString());
      String str1 = uRL.getHost();
      int m = uRL.getPort();
      if (m != -1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append(':');
        stringBuilder.append(Integer.toString(m));
        str1 = stringBuilder.toString();
      } 
      String str2 = str1;
      try {
        URI uRI = new URI(uRL.getProtocol(), str2, uRL.getPath(), uRL.getQuery(), uRL.getRef());
        String str = uRI.toASCIIString();
        int n = str.indexOf('?');
        if (n > 0) {
          int i1 = n + 1;
          if (i1 < str.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str.substring(0, i1));
            stringBuilder.append(str.substring(i1).replace("+", "%2B").replace("#", "%23"));
            str = stringBuilder.toString();
          } 
        } 
        return str;
      } catch (URISyntaxException uRISyntaxException) {
        IOException iOException = new IOException("Parsing URI failed");
        iOException.initCause(uRISyntaxException);
        throw new c(iOException);
      } 
    } catch (IOException iOException) {
      throw new c(iOException);
    } 
  }
  
  public static String a(CharSequence paramCharSequence, Map<?, ?> paramMap) { // Byte code:
    //   0: aload_0
    //   1: invokeinterface toString : ()Ljava/lang/String;
    //   6: astore_2
    //   7: aload_1
    //   8: ifnull -> 184
    //   11: aload_1
    //   12: invokeinterface isEmpty : ()Z
    //   17: ifeq -> 22
    //   20: aload_2
    //   21: areturn
    //   22: new java/lang/StringBuilder
    //   25: dup
    //   26: aload_2
    //   27: invokespecial <init> : (Ljava/lang/String;)V
    //   30: astore_3
    //   31: aload_2
    //   32: aload_3
    //   33: invokestatic a : (Ljava/lang/String;Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_2
    //   38: aload_3
    //   39: invokestatic b : (Ljava/lang/String;Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_1
    //   44: invokeinterface entrySet : ()Ljava/util/Set;
    //   49: invokeinterface iterator : ()Ljava/util/Iterator;
    //   54: astore #6
    //   56: aload #6
    //   58: invokeinterface next : ()Ljava/lang/Object;
    //   63: checkcast java/util/Map$Entry
    //   66: astore #7
    //   68: aload_3
    //   69: aload #7
    //   71: invokeinterface getKey : ()Ljava/lang/Object;
    //   76: invokevirtual toString : ()Ljava/lang/String;
    //   79: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_3
    //   84: bipush #61
    //   86: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload #7
    //   92: invokeinterface getValue : ()Ljava/lang/Object;
    //   97: astore #10
    //   99: aload #10
    //   101: ifnull -> 111
    //   104: aload_3
    //   105: aload #10
    //   107: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload #6
    //   113: invokeinterface hasNext : ()Z
    //   118: ifeq -> 179
    //   121: aload_3
    //   122: bipush #38
    //   124: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload #6
    //   130: invokeinterface next : ()Ljava/lang/Object;
    //   135: checkcast java/util/Map$Entry
    //   138: astore #12
    //   140: aload_3
    //   141: aload #12
    //   143: invokeinterface getKey : ()Ljava/lang/Object;
    //   148: invokevirtual toString : ()Ljava/lang/String;
    //   151: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_3
    //   156: bipush #61
    //   158: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload #12
    //   164: invokeinterface getValue : ()Ljava/lang/Object;
    //   169: astore #10
    //   171: aload #10
    //   173: ifnull -> 111
    //   176: goto -> 104
    //   179: aload_3
    //   180: invokevirtual toString : ()Ljava/lang/String;
    //   183: astore_2
    //   184: aload_2
    //   185: areturn }
  
  private static StringBuilder a(String paramString, StringBuilder paramStringBuilder) {
    if (2 + paramString.indexOf(':') == paramString.lastIndexOf('/'))
      paramStringBuilder.append('/'); 
    return paramStringBuilder;
  }
  
  public static d b(CharSequence paramCharSequence) { return new d(paramCharSequence, "GET"); }
  
  public static d b(CharSequence paramCharSequence, Map<?, ?> paramMap, boolean paramBoolean) {
    String str = a(paramCharSequence, paramMap);
    if (paramBoolean)
      str = a(str); 
    return c(str);
  }
  
  private static StringBuilder b(String paramString, StringBuilder paramStringBuilder) {
    char c1 = '?';
    int m = paramString.indexOf(c1);
    int n = -1 + paramStringBuilder.length();
    if (m == -1) {
      paramStringBuilder.append(c1);
      return paramStringBuilder;
    } 
    if (m < n) {
      char c2 = paramString.charAt(n);
      c1 = '&';
      if (c2 != c1) {
        paramStringBuilder.append(c1);
        return paramStringBuilder;
      } 
    } 
    return paramStringBuilder;
  }
  
  public static d c(CharSequence paramCharSequence) { return new d(paramCharSequence, "POST"); }
  
  public static d d(CharSequence paramCharSequence) { return new d(paramCharSequence, "PUT"); }
  
  public static d e(CharSequence paramCharSequence) { return new d(paramCharSequence, "DELETE"); }
  
  private static String f(String paramString) { return (paramString != null && paramString.length() > 0) ? paramString : "UTF-8"; }
  
  private Proxy p() { return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.k, this.l)); }
  
  private HttpURLConnection q() {
    try {
      HttpURLConnection httpURLConnection;
      if (this.k != null) {
        httpURLConnection = c.a(this.a, p());
      } else {
        httpURLConnection = c.a(this.a);
      } 
      httpURLConnection.setRequestMethod(this.e);
      return httpURLConnection;
    } catch (IOException iOException) {
      throw new c(iOException);
    } 
  }
  
  public int a(String paramString, int paramInt) {
    k();
    return a().getHeaderFieldInt(paramString, paramInt);
  }
  
  public d a(int paramInt) {
    a().setConnectTimeout(paramInt);
    return this;
  }
  
  protected d a(InputStream paramInputStream, OutputStream paramOutputStream) {
    a<d> a1 = new a<d>(this, paramInputStream, this.h, paramInputStream, paramOutputStream) {
        public d a() {
          byte[] arrayOfByte = new byte[d.a(this.c)];
          while (true) {
            int i = this.a.read(arrayOfByte);
            if (i != -1) {
              this.b.write(arrayOfByte, 0, i);
              continue;
            } 
            break;
          } 
          return this.c;
        }
      };
    return (d)a1.call();
  }
  
  public d a(String paramString, Number paramNumber) { return a(paramString, null, paramNumber); }
  
  public d a(String paramString1, String paramString2) {
    a().setRequestProperty(paramString1, paramString2);
    return this;
  }
  
  public d a(String paramString1, String paramString2, Number paramNumber) {
    String str;
    if (paramNumber != null) {
      str = paramNumber.toString();
    } else {
      str = null;
    } 
    return b(paramString1, paramString2, str);
  }
  
  protected d a(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("form-data; name=\"");
    stringBuilder.append(paramString1);
    if (paramString2 != null) {
      stringBuilder.append("\"; filename=\"");
      stringBuilder.append(paramString2);
    } 
    stringBuilder.append('"');
    f("Content-Disposition", stringBuilder.toString());
    if (paramString3 != null)
      f("Content-Type", paramString3); 
    return f("\r\n");
  }
  
  public d a(String paramString1, String paramString2, String paramString3, File paramFile) {
    bufferedInputStream = null;
    try {
      bufferedInputStream1 = new BufferedInputStream(new FileInputStream(paramFile));
      try {
        return a(paramString1, paramString2, paramString3, bufferedInputStream1);
      } catch (IOException null) {
      
      } finally {
        API aPI = null;
      } 
    } catch (IOException iOException) {
    
    } finally {
      API aPI;
    } 
    throw new c(iOException);
  }
  
  public d a(String paramString1, String paramString2, String paramString3, InputStream paramInputStream) {
    try {
      m();
      a(paramString1, paramString2, paramString3);
      a(paramInputStream, this.f);
      return this;
    } catch (IOException iOException) {
      throw new c(iOException);
    } 
  }
  
  public d a(String paramString1, String paramString2, String paramString3, String paramString4) {
    try {
      m();
      a(paramString1, paramString2, paramString3);
      this.f.a(paramString4);
      return this;
    } catch (IOException iOException) {
      throw new c(iOException);
    } 
  }
  
  public d a(Map.Entry<String, String> paramEntry) { return a((String)paramEntry.getKey(), (String)paramEntry.getValue()); }
  
  public d a(boolean paramBoolean) {
    a().setUseCaches(paramBoolean);
    return this;
  }
  
  public String a(String paramString) {
    ByteArrayOutputStream byteArrayOutputStream = c();
    try {
      return byteArrayOutputStream.toString(a(e(), byteArrayOutputStream).f(paramString));
    } catch (IOException iOException) {
      throw new c(iOException);
    } 
  }
  
  public HttpURLConnection a() {
    if (this.d == null)
      this.d = q(); 
    return this.d;
  }
  
  public int b() {
    try {
      j();
      return a().getResponseCode();
    } catch (IOException iOException) {
      throw new c(iOException);
    } 
  }
  
  public d b(String paramString1, String paramString2, String paramString3) { return a(paramString1, paramString2, null, paramString3); }
  
  public String b(String paramString) {
    k();
    return a().getHeaderField(paramString);
  }
  
  public String b(String paramString1, String paramString2) { return c(b(paramString1), paramString2); }
  
  public int c(String paramString) { return a(paramString, -1); }
  
  protected ByteArrayOutputStream c() {
    int m = i();
    return (m > 0) ? new ByteArrayOutputStream(m) : new ByteArrayOutputStream();
  }
  
  protected String c(String paramString1, String paramString2) { // Byte code:
    //   0: aload_1
    //   1: ifnull -> 207
    //   4: aload_1
    //   5: invokevirtual length : ()I
    //   8: ifne -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_1
    //   14: invokevirtual length : ()I
    //   17: istore_3
    //   18: iconst_1
    //   19: aload_1
    //   20: bipush #59
    //   22: invokevirtual indexOf : (I)I
    //   25: iadd
    //   26: istore #4
    //   28: iload #4
    //   30: ifeq -> 207
    //   33: iload #4
    //   35: iload_3
    //   36: if_icmpne -> 41
    //   39: aconst_null
    //   40: areturn
    //   41: aload_1
    //   42: bipush #59
    //   44: iload #4
    //   46: invokevirtual indexOf : (II)I
    //   49: istore #5
    //   51: iload #5
    //   53: iconst_m1
    //   54: if_icmpne -> 60
    //   57: iload_3
    //   58: istore #5
    //   60: iload #4
    //   62: iload #5
    //   64: if_icmpge -> 207
    //   67: aload_1
    //   68: bipush #61
    //   70: iload #4
    //   72: invokevirtual indexOf : (II)I
    //   75: istore #6
    //   77: iload #6
    //   79: iconst_m1
    //   80: if_icmpeq -> 182
    //   83: iload #6
    //   85: iload #5
    //   87: if_icmpge -> 182
    //   90: aload_2
    //   91: aload_1
    //   92: iload #4
    //   94: iload #6
    //   96: invokevirtual substring : (II)Ljava/lang/String;
    //   99: invokevirtual trim : ()Ljava/lang/String;
    //   102: invokevirtual equals : (Ljava/lang/Object;)Z
    //   105: ifeq -> 182
    //   108: aload_1
    //   109: iload #6
    //   111: iconst_1
    //   112: iadd
    //   113: iload #5
    //   115: invokevirtual substring : (II)Ljava/lang/String;
    //   118: invokevirtual trim : ()Ljava/lang/String;
    //   121: astore #7
    //   123: aload #7
    //   125: invokevirtual length : ()I
    //   128: istore #8
    //   130: iload #8
    //   132: ifeq -> 182
    //   135: iload #8
    //   137: iconst_2
    //   138: if_icmple -> 179
    //   141: bipush #34
    //   143: aload #7
    //   145: iconst_0
    //   146: invokevirtual charAt : (I)C
    //   149: if_icmpne -> 179
    //   152: iload #8
    //   154: iconst_1
    //   155: isub
    //   156: istore #9
    //   158: bipush #34
    //   160: aload #7
    //   162: iload #9
    //   164: invokevirtual charAt : (I)C
    //   167: if_icmpne -> 179
    //   170: aload #7
    //   172: iconst_1
    //   173: iload #9
    //   175: invokevirtual substring : (II)Ljava/lang/String;
    //   178: areturn
    //   179: aload #7
    //   181: areturn
    //   182: iload #5
    //   184: iconst_1
    //   185: iadd
    //   186: istore #4
    //   188: aload_1
    //   189: bipush #59
    //   191: iload #4
    //   193: invokevirtual indexOf : (II)I
    //   196: istore #5
    //   198: iload #5
    //   200: iconst_m1
    //   201: if_icmpne -> 60
    //   204: goto -> 57
    //   207: aconst_null
    //   208: areturn }
  
  public d d(String paramString) { return d(paramString, null); }
  
  public d d(String paramString1, String paramString2) {
    if (paramString2 != null && paramString2.length() > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append("; charset=");
      stringBuilder.append(paramString2);
      return a("Content-Type", stringBuilder.toString());
    } 
    return a("Content-Type", paramString1);
  }
  
  public String d() { return a(g()); }
  
  public d e(String paramString1, String paramString2) { return b(paramString1, null, paramString2); }
  
  public BufferedInputStream e() { return new BufferedInputStream(f(), this.j); }
  
  public d f(CharSequence paramCharSequence) {
    try {
      l();
      this.f.a(paramCharSequence.toString());
      return this;
    } catch (IOException iOException) {
      throw new c(iOException);
    } 
  }
  
  public d f(String paramString1, String paramString2) { return f(paramString1).f(": ").f(paramString2).f("\r\n"); }
  
  public InputStream f() {
    InputStream inputStream;
    if (b() < 400) {
      try {
        inputStream = a().getInputStream();
      } catch (IOException iOException) {
        throw new c(iOException);
      } 
    } else {
      inputStream = a().getErrorStream();
      if (inputStream == null)
        try {
          inputStream = a().getInputStream();
        } catch (IOException iOException) {
          throw new c(iOException);
        }  
    } 
    if (this.i) {
      if (!"gzip".equals(h()))
        return inputStream; 
      try {
        return new GZIPInputStream(inputStream);
      } catch (IOException iOException) {
        throw new c(iOException);
      } 
    } 
    return inputStream;
  }
  
  public String g() { return b("Content-Type", "charset"); }
  
  public String h() { return b("Content-Encoding"); }
  
  public int i() { return c("Content-Length"); }
  
  protected d j() { // Byte code:
    //   0: aload_0
    //   1: getfield f : La/a/a/a/a/e/d$e;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull -> 11
    //   9: aload_0
    //   10: areturn
    //   11: aload_0
    //   12: getfield g : Z
    //   15: ifeq -> 26
    //   18: aload_1
    //   19: ldc_w '\\r\\n--00content0boundary00--\\r\\n'
    //   22: invokevirtual a : (Ljava/lang/String;)La/a/a/a/a/e/d$e;
    //   25: pop
    //   26: aload_0
    //   27: getfield h : Z
    //   30: ifeq -> 43
    //   33: aload_0
    //   34: getfield f : La/a/a/a/a/e/d$e;
    //   37: invokevirtual close : ()V
    //   40: goto -> 53
    //   43: aload_0
    //   44: getfield f : La/a/a/a/a/e/d$e;
    //   47: invokevirtual close : ()V
    //   50: goto -> 54
    //   53: pop
    //   54: aload_0
    //   55: aconst_null
    //   56: putfield f : La/a/a/a/a/e/d$e;
    //   59: aload_0
    //   60: areturn
    // Exception table:
    //   from	to	target	type
    //   33	40	53	java/io/IOException }
  
  protected d k() {
    try {
      return j();
    } catch (IOException iOException) {
      throw new c(iOException);
    } 
  }
  
  protected d l() {
    if (this.f != null)
      return this; 
    a().setDoOutput(true);
    String str = c(a().getRequestProperty("Content-Type"), "charset");
    this.f = new e(a().getOutputStream(), str, this.j);
    return this;
  }
  
  protected d m() {
    String str;
    e e1;
    if (!this.g) {
      this.g = true;
      d("multipart/form-data; boundary=00content0boundary00").l();
      e1 = this.f;
      str = "--00content0boundary00\r\n";
    } else {
      e1 = this.f;
      str = "\r\n--00content0boundary00\r\n";
    } 
    e1.a(str);
    return this;
  }
  
  public URL n() { return a().getURL(); }
  
  public String o() { return a().getRequestMethod(); }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(o());
    stringBuilder.append(' ');
    stringBuilder.append(n());
    return stringBuilder.toString();
  }
  
  protected static abstract class a<V> extends d<V> {
    private final Closeable a;
    
    private final boolean b;
    
    protected a(Closeable param1Closeable, boolean param1Boolean) {
      this.a = param1Closeable;
      this.b = param1Boolean;
    }
    
    protected void c() {
      Closeable closeable = this.a;
      if (closeable instanceof Flushable)
        ((Flushable)closeable).flush(); 
      if (this.b) {
        try {
          this.a.close();
          return;
        } catch (IOException iOException) {}
      } else {
        this.a.close();
      } 
    }
  }
  
  public static interface b {
    public static final b a = new b() {
        public HttpURLConnection a(URL param2URL) { return (HttpURLConnection)param2URL.openConnection(); }
        
        public HttpURLConnection a(URL param2URL, Proxy param2Proxy) { return (HttpURLConnection)param2URL.openConnection(param2Proxy); }
      };
    
    HttpURLConnection a(URL param1URL);
    
    HttpURLConnection a(URL param1URL, Proxy param1Proxy);
  }
  
  static final class null implements b {
    public HttpURLConnection a(URL param1URL) { return (HttpURLConnection)param1URL.openConnection(); }
    
    public HttpURLConnection a(URL param1URL, Proxy param1Proxy) { return (HttpURLConnection)param1URL.openConnection(param1Proxy); }
  }
  
  public static class c extends RuntimeException {
    protected c(IOException param1IOException) { super(param1IOException); }
    
    public IOException a() { return (IOException)super.getCause(); }
  }
  
  protected static abstract class d<V> extends Object implements Callable<V> {
    protected abstract V b();
    
    protected abstract void c();
    
    public V call() {
      API aPI;
      boolean bool = true;
      try {
      
      } catch (c c) {
        throw c;
      } catch (IOException iOException) {
        try {
          throw new d.c(iOException);
        } finally {}
      } finally {
        API aPI1 = null;
        aPI = aPI1;
      } 
      try {
        c();
      } catch (IOException iOException) {
        if (!bool)
          throw new d.c(iOException); 
      } 
      throw aPI;
    }
  }
  
  public static class e extends BufferedOutputStream {
    private final CharsetEncoder a;
    
    public e(OutputStream param1OutputStream, String param1String, int param1Int) {
      super(param1OutputStream, param1Int);
      this.a = Charset.forName(d.e(param1String)).newEncoder();
    }
    
    public e a(String param1String) {
      ByteBuffer byteBuffer = this.a.encode(CharBuffer.wrap(param1String));
      write(byteBuffer.array(), 0, byteBuffer.limit());
      return this;
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */