package a.a.a.a.a.e;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

final class a {
  private static boolean a(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2) {
    if (!paramX509Certificate1.getSubjectX500Principal().equals(paramX509Certificate2.getIssuerX500Principal()))
      return false; 
    try {
      paramX509Certificate2.verify(paramX509Certificate1.getPublicKey());
      return true;
    } catch (GeneralSecurityException generalSecurityException) {
      return false;
    } 
  }
  
  public static X509Certificate[] a(X509Certificate[] paramArrayOfX509Certificate, i parami) {
    LinkedList linkedList = new LinkedList();
    boolean bool1 = parami.a(paramArrayOfX509Certificate[0]);
    linkedList.add(paramArrayOfX509Certificate[0]);
    boolean bool2 = true;
    boolean bool3 = bool1;
    byte b = 1;
    while (b < paramArrayOfX509Certificate.length) {
      if (parami.a(paramArrayOfX509Certificate[b]))
        bool3 = true; 
      if (a(paramArrayOfX509Certificate[b], paramArrayOfX509Certificate[b - true])) {
        linkedList.add(paramArrayOfX509Certificate[b]);
        b++;
      } 
    } 
    X509Certificate x509Certificate = parami.b(paramArrayOfX509Certificate[b - bool2]);
    if (x509Certificate != null) {
      linkedList.add(x509Certificate);
    } else {
      bool2 = bool3;
    } 
    if (bool2)
      return (X509Certificate[])linkedList.toArray(new X509Certificate[linkedList.size()]); 
    throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */