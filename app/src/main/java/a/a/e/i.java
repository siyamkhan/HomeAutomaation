package a.a.a.a.a.e;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;

class i {
  final KeyStore a;
  
  private final HashMap<Principal, X509Certificate> b;
  
  public i(InputStream paramInputStream, String paramString) {
    KeyStore keyStore = a(paramInputStream, paramString);
    this.b = a(keyStore);
    this.a = keyStore;
  }
  
  private KeyStore a(InputStream paramInputStream, String paramString) {
    try {
      keyStore = KeyStore.getInstance("BKS");
      bufferedInputStream = new BufferedInputStream(paramInputStream);
      try {
        keyStore.load(bufferedInputStream, paramString.toCharArray());
        return keyStore;
      } finally {
        bufferedInputStream.close();
      } 
    } catch (KeyStoreException keyStoreException) {
      throw new AssertionError(keyStoreException);
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      throw new AssertionError(noSuchAlgorithmException);
    } catch (CertificateException certificateException) {
      throw new AssertionError(certificateException);
    } catch (IOException iOException) {
      throw new AssertionError(iOException);
    } 
  }
  
  private HashMap<Principal, X509Certificate> a(KeyStore paramKeyStore) {
    try {
      HashMap hashMap = new HashMap();
      Enumeration enumeration = paramKeyStore.aliases();
      while (enumeration.hasMoreElements()) {
        X509Certificate x509Certificate = (X509Certificate)paramKeyStore.getCertificate((String)enumeration.nextElement());
        if (x509Certificate != null)
          hashMap.put(x509Certificate.getSubjectX500Principal(), x509Certificate); 
      } 
      return hashMap;
    } catch (KeyStoreException keyStoreException) {
      throw new AssertionError(keyStoreException);
    } 
  }
  
  public boolean a(X509Certificate paramX509Certificate) {
    X509Certificate x509Certificate = (X509Certificate)this.b.get(paramX509Certificate.getSubjectX500Principal());
    return (x509Certificate != null && x509Certificate.getPublicKey().equals(paramX509Certificate.getPublicKey()));
  }
  
  public X509Certificate b(X509Certificate paramX509Certificate) {
    X509Certificate x509Certificate = (X509Certificate)this.b.get(paramX509Certificate.getIssuerX500Principal());
    if (x509Certificate == null)
      return null; 
    if (x509Certificate.getSubjectX500Principal().equals(paramX509Certificate.getSubjectX500Principal()))
      return null; 
    try {
      paramX509Certificate.verify(x509Certificate.getPublicKey());
      return x509Certificate;
    } catch (GeneralSecurityException generalSecurityException) {
      return null;
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\a\a\a\a\a\e\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */