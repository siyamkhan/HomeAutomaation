package a.a.a.a.a.b;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class u implements Closeable {
  private static final Logger b = Logger.getLogger(u.class.getName());
  
  int a;
  
  private final RandomAccessFile c;
  
  private int d;
  
  private a e;
  
  private a f;
  
  private final byte[] g = new byte[16];
  
  public u(File paramFile) {
    if (!paramFile.exists())
      a(paramFile); 
    this.c = b(paramFile);
    e();
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt) { return ((0xFF & paramArrayOfByte[paramInt]) << '\030') + ((0xFF & paramArrayOfByte[paramInt + 1]) << '\020') + ((0xFF & paramArrayOfByte[paramInt + 2]) << '\b') + (0xFF & paramArrayOfByte[paramInt + 3]); }
  
  private a a(int paramInt) {
    if (paramInt == 0)
      return a.a; 
    this.c.seek(paramInt);
    return new a(paramInt, this.c.readInt());
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    a(this.g, new int[] { paramInt1, paramInt2, paramInt3, paramInt4 });
    this.c.seek(0L);
    this.c.write(this.g);
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3) {
    RandomAccessFile randomAccessFile;
    int i = b(paramInt1);
    int j = i + paramInt3;
    int k = this.a;
    if (j <= k) {
      this.c.seek(i);
      randomAccessFile = this.c;
    } else {
      int m = k - i;
      this.c.seek(i);
      this.c.write(paramArrayOfByte, paramInt2, m);
      this.c.seek(16L);
      randomAccessFile = this.c;
      paramInt2 += m;
      paramInt3 -= m;
    } 
    randomAccessFile.write(paramArrayOfByte, paramInt2, paramInt3);
  }
  
  private static void a(File paramFile) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramFile.getPath());
    stringBuilder.append(".tmp");
    File file = new File(stringBuilder.toString());
    RandomAccessFile randomAccessFile = b(file);
    try {
      randomAccessFile.setLength(4096L);
      randomAccessFile.seek(0L);
      byte[] arrayOfByte = new byte[16];
      a(arrayOfByte, new int[] { 4096, 0, 0, 0 });
      randomAccessFile.write(arrayOfByte);
      randomAccessFile.close();
      if (file.renameTo(paramFile))
        return; 
      throw new IOException("Rename failed!");
    } finally {
      randomAccessFile.close();
    } 
  }
  
  private static void a(byte[] paramArrayOfByte, int... paramVarArgs) {
    int i = paramVarArgs.length;
    byte b1 = 0;
    byte b2 = 0;
    while (b1 < i) {
      b(paramArrayOfByte, b2, paramVarArgs[b1]);
      b2 += 4;
      b1++;
    } 
  }
  
  private int b(int paramInt) {
    int i = this.a;
    return (paramInt < i) ? paramInt : (paramInt + 16 - i);
  }
  
  private static RandomAccessFile b(File paramFile) { return new RandomAccessFile(paramFile, "rwd"); }
  
  private static <T> T b(T paramT, String paramString) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(paramString);
  }
  
  private void b(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3) {
    RandomAccessFile randomAccessFile;
    int i = b(paramInt1);
    int j = i + paramInt3;
    int k = this.a;
    if (j <= k) {
      this.c.seek(i);
      randomAccessFile = this.c;
    } else {
      int m = k - i;
      this.c.seek(i);
      this.c.readFully(paramArrayOfByte, paramInt2, m);
      this.c.seek(16L);
      randomAccessFile = this.c;
      paramInt2 += m;
      paramInt3 -= m;
    } 
    randomAccessFile.readFully(paramArrayOfByte, paramInt2, paramInt3);
  }
  
  private static void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
    paramArrayOfByte[paramInt1] = (byte)(paramInt2 >> 24);
    paramArrayOfByte[paramInt1 + 1] = (byte)(paramInt2 >> 16);
    paramArrayOfByte[paramInt1 + 2] = (byte)(paramInt2 >> 8);
    paramArrayOfByte[paramInt1 + 3] = (byte)paramInt2;
  }
  
  private void c(int paramInt) {
    int i = paramInt + 4;
    int j = f();
    if (j >= i)
      return; 
    int k = this.a;
    do {
      j += k;
      k <<= 1;
    } while (j < i);
    d(k);
    int m = b(4 + this.f.b + this.f.c);
    if (m < this.e.b) {
      FileChannel fileChannel = this.c.getChannel();
      fileChannel.position(this.a);
      long l = (m - 4);
      if (fileChannel.transferTo(16L, l, fileChannel) != l)
        throw new AssertionError("Copied insufficient number of bytes!"); 
    } 
    if (this.f.b < this.e.b) {
      int n = -16 + this.a + this.f.b;
      a(k, this.d, this.e.b, n);
      this.f = new a(n, this.f.c);
    } else {
      a(k, this.d, this.e.b, this.f.b);
    } 
    this.a = k;
  }
  
  private void d(int paramInt) {
    this.c.setLength(paramInt);
    this.c.getChannel().force(true);
  }
  
  private void e() {
    this.c.seek(0L);
    this.c.readFully(this.g);
    this.a = a(this.g, 0);
    if (this.a <= this.c.length()) {
      this.d = a(this.g, 4);
      int i = a(this.g, 8);
      int j = a(this.g, 12);
      this.e = a(i);
      this.f = a(j);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("File is truncated. Expected length: ");
    stringBuilder.append(this.a);
    stringBuilder.append(", Actual length: ");
    stringBuilder.append(this.c.length());
    throw new IOException(stringBuilder.toString());
  }
  
  private int f() { return this.a - a(); }
  
  public int a() { return (this.d == 0) ? 16 : ((this.f.b >= this.e.b) ? (16 + 4 + this.f.b - this.e.b + this.f.c) : (4 + this.f.b + this.f.c + this.a - this.e.b)); }
  
  public void a(c paramc) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : La/a/a/a/a/b/u$a;
    //   6: getfield b : I
    //   9: istore_3
    //   10: iconst_0
    //   11: istore #4
    //   13: iload #4
    //   15: aload_0
    //   16: getfield d : I
    //   19: if_icmpge -> 75
    //   22: aload_0
    //   23: iload_3
    //   24: invokespecial a : (I)La/a/a/a/a/b/u$a;
    //   27: astore #5
    //   29: aload_1
    //   30: new a/a/a/a/a/b/u$b
    //   33: dup
    //   34: aload_0
    //   35: aload #5
    //   37: aconst_null
    //   38: invokespecial <init> : (La/a/a/a/a/b/u;La/a/a/a/a/b/u$a;La/a/a/a/a/b/u$1;)V
    //   41: aload #5
    //   43: getfield c : I
    //   46: invokeinterface a : (Ljava/io/InputStream;I)V
    //   51: aload_0
    //   52: iconst_4
    //   53: aload #5
    //   55: getfield b : I
    //   58: iadd
    //   59: aload #5
    //   61: getfield c : I
    //   64: iadd
    //   65: invokespecial b : (I)I
    //   68: istore_3
    //   69: iinc #4, 1
    //   72: goto -> 13
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	78	finally
    //   13	69	78	finally }
  
  public void a(byte[] paramArrayOfByte) { a(paramArrayOfByte, 0, paramArrayOfByte.length); }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 'buffer'
    //   5: invokestatic b : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   8: pop
    //   9: iload_2
    //   10: iload_3
    //   11: ior
    //   12: iflt -> 196
    //   15: iload_3
    //   16: aload_1
    //   17: arraylength
    //   18: iload_2
    //   19: isub
    //   20: if_icmpgt -> 196
    //   23: aload_0
    //   24: iload_3
    //   25: invokespecial c : (I)V
    //   28: aload_0
    //   29: invokevirtual b : ()Z
    //   32: istore #6
    //   34: iload #6
    //   36: ifeq -> 46
    //   39: bipush #16
    //   41: istore #7
    //   43: goto -> 69
    //   46: aload_0
    //   47: iconst_4
    //   48: aload_0
    //   49: getfield f : La/a/a/a/a/b/u$a;
    //   52: getfield b : I
    //   55: iadd
    //   56: aload_0
    //   57: getfield f : La/a/a/a/a/b/u$a;
    //   60: getfield c : I
    //   63: iadd
    //   64: invokespecial b : (I)I
    //   67: istore #7
    //   69: new a/a/a/a/a/b/u$a
    //   72: dup
    //   73: iload #7
    //   75: iload_3
    //   76: invokespecial <init> : (II)V
    //   79: astore #8
    //   81: aload_0
    //   82: getfield g : [B
    //   85: iconst_0
    //   86: iload_3
    //   87: invokestatic b : ([BII)V
    //   90: aload_0
    //   91: aload #8
    //   93: getfield b : I
    //   96: aload_0
    //   97: getfield g : [B
    //   100: iconst_0
    //   101: iconst_4
    //   102: invokespecial a : (I[BII)V
    //   105: aload_0
    //   106: iconst_4
    //   107: aload #8
    //   109: getfield b : I
    //   112: iadd
    //   113: aload_1
    //   114: iload_2
    //   115: iload_3
    //   116: invokespecial a : (I[BII)V
    //   119: iload #6
    //   121: ifeq -> 134
    //   124: aload #8
    //   126: getfield b : I
    //   129: istore #9
    //   131: goto -> 143
    //   134: aload_0
    //   135: getfield e : La/a/a/a/a/b/u$a;
    //   138: getfield b : I
    //   141: istore #9
    //   143: aload_0
    //   144: aload_0
    //   145: getfield a : I
    //   148: iconst_1
    //   149: aload_0
    //   150: getfield d : I
    //   153: iadd
    //   154: iload #9
    //   156: aload #8
    //   158: getfield b : I
    //   161: invokespecial a : (IIII)V
    //   164: aload_0
    //   165: aload #8
    //   167: putfield f : La/a/a/a/a/b/u$a;
    //   170: aload_0
    //   171: iconst_1
    //   172: aload_0
    //   173: getfield d : I
    //   176: iadd
    //   177: putfield d : I
    //   180: iload #6
    //   182: ifeq -> 193
    //   185: aload_0
    //   186: aload_0
    //   187: getfield f : La/a/a/a/a/b/u$a;
    //   190: putfield e : La/a/a/a/a/b/u$a;
    //   193: aload_0
    //   194: monitorexit
    //   195: return
    //   196: new java/lang/IndexOutOfBoundsException
    //   199: dup
    //   200: invokespecial <init> : ()V
    //   203: athrow
    //   204: astore #4
    //   206: aload_0
    //   207: monitorexit
    //   208: aload #4
    //   210: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	204	finally
    //   15	34	204	finally
    //   46	69	204	finally
    //   69	119	204	finally
    //   124	131	204	finally
    //   134	143	204	finally
    //   143	180	204	finally
    //   185	193	204	finally
    //   196	204	204	finally }
  
  public boolean a(int paramInt1, int paramInt2) { return (paramInt1 + 4 + a() <= paramInt2); }
  
  public boolean b() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : I
    //   6: istore_2
    //   7: iload_2
    //   8: ifne -> 16
    //   11: iconst_1
    //   12: istore_3
    //   13: goto -> 18
    //   16: iconst_0
    //   17: istore_3
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_3
    //   21: ireturn
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally }
  
  public void c() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual b : ()Z
    //   6: ifne -> 114
    //   9: aload_0
    //   10: getfield d : I
    //   13: iconst_1
    //   14: if_icmpne -> 24
    //   17: aload_0
    //   18: invokevirtual d : ()V
    //   21: goto -> 111
    //   24: aload_0
    //   25: iconst_4
    //   26: aload_0
    //   27: getfield e : La/a/a/a/a/b/u$a;
    //   30: getfield b : I
    //   33: iadd
    //   34: aload_0
    //   35: getfield e : La/a/a/a/a/b/u$a;
    //   38: getfield c : I
    //   41: iadd
    //   42: invokespecial b : (I)I
    //   45: istore_2
    //   46: aload_0
    //   47: iload_2
    //   48: aload_0
    //   49: getfield g : [B
    //   52: iconst_0
    //   53: iconst_4
    //   54: invokespecial b : (I[BII)V
    //   57: aload_0
    //   58: getfield g : [B
    //   61: iconst_0
    //   62: invokestatic a : ([BI)I
    //   65: istore_3
    //   66: aload_0
    //   67: aload_0
    //   68: getfield a : I
    //   71: aload_0
    //   72: getfield d : I
    //   75: iconst_1
    //   76: isub
    //   77: iload_2
    //   78: aload_0
    //   79: getfield f : La/a/a/a/a/b/u$a;
    //   82: getfield b : I
    //   85: invokespecial a : (IIII)V
    //   88: aload_0
    //   89: aload_0
    //   90: getfield d : I
    //   93: iconst_1
    //   94: isub
    //   95: putfield d : I
    //   98: aload_0
    //   99: new a/a/a/a/a/b/u$a
    //   102: dup
    //   103: iload_2
    //   104: iload_3
    //   105: invokespecial <init> : (II)V
    //   108: putfield e : La/a/a/a/a/b/u$a;
    //   111: aload_0
    //   112: monitorexit
    //   113: return
    //   114: new java/util/NoSuchElementException
    //   117: dup
    //   118: invokespecial <init> : ()V
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	122	finally
    //   24	111	122	finally
    //   114	122	122	finally }
  
  public void close() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/io/RandomAccessFile;
    //   6: invokevirtual close : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally }
  
  public void d() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: sipush #4096
    //   6: iconst_0
    //   7: iconst_0
    //   8: iconst_0
    //   9: invokespecial a : (IIII)V
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield d : I
    //   17: aload_0
    //   18: getstatic a/a/a/a/a/b/u$a.a : La/a/a/a/a/b/u$a;
    //   21: putfield e : La/a/a/a/a/b/u$a;
    //   24: aload_0
    //   25: getstatic a/a/a/a/a/b/u$a.a : La/a/a/a/a/b/u$a;
    //   28: putfield f : La/a/a/a/a/b/u$a;
    //   31: aload_0
    //   32: getfield a : I
    //   35: sipush #4096
    //   38: if_icmple -> 48
    //   41: aload_0
    //   42: sipush #4096
    //   45: invokespecial d : (I)V
    //   48: aload_0
    //   49: sipush #4096
    //   52: putfield a : I
    //   55: aload_0
    //   56: monitorexit
    //   57: return
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Exception table:
    //   from	to	target	type
    //   2	48	58	finally
    //   48	55	58	finally }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append('[');
    stringBuilder.append("fileLength=");
    stringBuilder.append(this.a);
    stringBuilder.append(", size=");
    stringBuilder.append(this.d);
    stringBuilder.append(", first=");
    stringBuilder.append(this.e);
    stringBuilder.append(", last=");
    stringBuilder.append(this.f);
    stringBuilder.append(", element lengths=[");
    try {
      a(new c(this, stringBuilder) {
            boolean a = true;
            
            public void a(InputStream param1InputStream, int param1Int) {
              if (this.a) {
                this.a = false;
              } else {
                this.b.append(", ");
              } 
              this.b.append(param1Int);
            }
          });
    } catch (IOException iOException) {
      b.log(Level.WARNING, "read error", iOException);
    } 
    stringBuilder.append("]]");
    return stringBuilder.toString();
  }
  
  static class a {
    static final a a = new a(0, 0);
    
    final int b;
    
    final int c;
    
    a(int param1Int1, int param1Int2) {
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getClass().getSimpleName());
      stringBuilder.append("[position = ");
      stringBuilder.append(this.b);
      stringBuilder.append(", length = ");
      stringBuilder.append(this.c);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
  
  private final class b extends InputStream {
    private int b;
    
    private int c;
    
    private b(u this$0, u.a param1a) {
      this.b = u.a(this$0, 4 + param1a.b);
      this.c = param1a.c;
    }
    
    public int read() {
      if (this.c == 0)
        return -1; 
      u.a(this.a).seek(this.b);
      int i = u.a(this.a).read();
      this.b = u.a(this.a, 1 + this.b);
      this.c = -1 + this.c;
      return i;
    }
    
    public int read(byte[] param1ArrayOfByte, int param1Int1, int param1Int2) {
      u.a(param1ArrayOfByte, "buffer");
      if ((param1Int1 | param1Int2) >= 0 && param1Int2 <= param1ArrayOfByte.length - param1Int1) {
        int i = this.c;
        if (i > 0) {
          if (param1Int2 > i)
            param1Int2 = i; 
          u.a(this.a, this.b, param1ArrayOfByte, param1Int1, param1Int2);
          this.b = u.a(this.a, param1Int2 + this.b);
          this.c -= param1Int2;
          return param1Int2;
        } 
        return -1;
      } 
      throw new ArrayIndexOutOfBoundsException();
    }
  }
  
  public static interface c {
    void a(InputStream param1InputStream, int param1Int);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */