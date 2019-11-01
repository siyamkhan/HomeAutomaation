package android.support.e;

import android.os.IBinder;

class aj implements al {
  private final IBinder a;
  
  aj(IBinder paramIBinder) { this.a = paramIBinder; }
  
  public boolean equals(Object paramObject) { return (paramObject instanceof aj && ((aj)paramObject).a.equals(this.a)); }
  
  public int hashCode() { return this.a.hashCode(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */