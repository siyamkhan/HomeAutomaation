package a.a.a.a.a.e;

import a.a.a.a.c;
import a.a.a.a.l;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class h implements X509TrustManager {
  private static final X509Certificate[] a = new X509Certificate[0];
  
  private final TrustManager[] b;
  
  private final i c;
  
  private final long d;
  
  private final List<byte[]> e = new LinkedList();
  
  private final Set<X509Certificate> f = Collections.synchronizedSet(new HashSet());
  
  public h(i parami, g paramg) {
    this.b = a(parami);
    this.c = parami;
    this.d = paramg.d();
    for (String str : paramg.c())
      this.e.add(a(str)); 
  }
  
  private void a(X509Certificate[] paramArrayOfX509Certificate) {
    if (this.d != -1L && System.currentTimeMillis() - this.d > 15552000000L) {
      l l = c.g();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Certificate pins are stale, (");
      stringBuilder.append(System.currentTimeMillis() - this.d);
      stringBuilder.append(" millis vs ");
      stringBuilder.append(15552000000L);
      stringBuilder.append(" millis) falling back to system trust.");
      l.d("Fabric", stringBuilder.toString());
      return;
    } 
    X509Certificate[] arrayOfX509Certificate = a.a(paramArrayOfX509Certificate, this.c);
    int j = arrayOfX509Certificate.length;
    for (byte b1 = 0; b1 < j; b1++) {
      if (a(arrayOfX509Certificate[b1]))
        return; 
    } 
    throw new CertificateException("No valid pins found in chain!");
  }
  
  private void a(X509Certificate[] paramArrayOfX509Certificate, String paramString) {
    TrustManager[] arrayOfTrustManager = this.b;
    int j = arrayOfTrustManager.length;
    for (byte b1 = 0; b1 < j; b1++)
      ((X509TrustManager)arrayOfTrustManager[b1]).checkServerTrusted(paramArrayOfX509Certificate, paramString); 
  }
  
  private boolean a(X509Certificate paramX509Certificate) {
    try {
      byte[] arrayOfByte = MessageDigest.getInstance("SHA1").digest(paramX509Certificate.getPublicKey().getEncoded());
      Iterator iterator = this.e.iterator();
      while (iterator.hasNext()) {
        boolean bool = Arrays.equals((byte[])iterator.next(), arrayOfByte);
        if (bool)
          return true; 
      } 
      return false;
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new CertificateException(noSuchAlgorithmException);
    } 
  }
  
  private byte[] a(String paramString) {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    for (byte b1 = 0; b1 < j; b1 += 2)
      arrayOfByte[b1 / 2] = (byte)((Character.digit(paramString.charAt(b1), 16) << 4) + Character.digit(paramString.charAt(b1 + 1), 16)); 
    return arrayOfByte;
  }
  
  private TrustManager[] a(i parami) {
    try {
      TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
      trustManagerFactory.init(parami.a);
      return trustManagerFactory.getTrustManagers();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError(noSuchAlgorithmException);
    } catch (KeyStoreException keyStoreException) {
      throw new AssertionError(keyStoreException);
    } 
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) { throw new CertificateException("Client certificates not supported!"); }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {
    if (this.f.contains(paramArrayOfX509Certificate[0]))
      return; 
    a(paramArrayOfX509Certificate, paramString);
    a(paramArrayOfX509Certificate);
    this.f.add(paramArrayOfX509Certificate[0]);
  }
  
  public X509Certificate[] getAcceptedIssuers() { return a; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\e\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */