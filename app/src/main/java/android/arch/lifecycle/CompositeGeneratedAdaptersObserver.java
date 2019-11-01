package android.arch.lifecycle;

public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {
  private final b[] a;
  
  CompositeGeneratedAdaptersObserver(b[] paramArrayOfb) { this.a = paramArrayOfb; }
  
  public void a(e parame, c.a parama) {
    i i = new i();
    b[] arrayOfb1 = this.a;
    int j = arrayOfb1.length;
    byte b1 = 0;
    for (byte b2 = 0; b2 < j; b2++)
      arrayOfb1[b2].a(parame, parama, false, i); 
    b[] arrayOfb2 = this.a;
    int k = arrayOfb2.length;
    while (b1 < k) {
      arrayOfb2[b1].a(parame, parama, true, i);
      b1++;
    } 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\arch\lifecycle\CompositeGeneratedAdaptersObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */