package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

class b extends a {
  private final SparseIntArray a = new SparseIntArray();
  
  private final Parcel b;
  
  private final int c;
  
  private final int d;
  
  private final String e;
  
  private int f = -1;
  
  private int g = 0;
  
  b(Parcel paramParcel) { this(paramParcel, paramParcel.dataPosition(), paramParcel.dataSize(), ""); }
  
  b(Parcel paramParcel, int paramInt1, int paramInt2, String paramString) {
    this.b = paramParcel;
    this.c = paramInt1;
    this.d = paramInt2;
    this.g = this.c;
    this.e = paramString;
  }
  
  private int d(int paramInt) {
    while (true) {
      int i = this.g;
      if (i < this.d) {
        this.b.setDataPosition(i);
        int j = this.b.readInt();
        int k = this.b.readInt();
        this.g = j + this.g;
        if (k == paramInt)
          return this.b.dataPosition(); 
        continue;
      } 
      break;
    } 
    return -1;
  }
  
  public void a(int paramInt) { this.b.writeInt(paramInt); }
  
  public void a(Parcelable paramParcelable) { this.b.writeParcelable(paramParcelable, 0); }
  
  public void a(String paramString) { this.b.writeString(paramString); }
  
  public void a(byte[] paramArrayOfByte) {
    if (paramArrayOfByte != null) {
      this.b.writeInt(paramArrayOfByte.length);
      this.b.writeByteArray(paramArrayOfByte);
      return;
    } 
    this.b.writeInt(-1);
  }
  
  public void b() {
    int i = this.f;
    if (i >= 0) {
      int j = this.a.get(i);
      int k = this.b.dataPosition();
      int m = k - j;
      this.b.setDataPosition(j);
      this.b.writeInt(m);
      this.b.setDataPosition(k);
    } 
  }
  
  public boolean b(int paramInt) {
    int i = d(paramInt);
    if (i == -1)
      return false; 
    this.b.setDataPosition(i);
    return true;
  }
  
  protected a c() {
    Parcel parcel = this.b;
    int i = parcel.dataPosition();
    int j = this.g;
    if (j == this.c)
      j = this.d; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.e);
    stringBuilder.append("  ");
    return new b(parcel, i, j, stringBuilder.toString());
  }
  
  public void c(int paramInt) {
    b();
    this.f = paramInt;
    this.a.put(paramInt, this.b.dataPosition());
    a(0);
    a(paramInt);
  }
  
  public int d() { return this.b.readInt(); }
  
  public String e() { return this.b.readString(); }
  
  public byte[] f() {
    int i = this.b.readInt();
    if (i < 0)
      return null; 
    byte[] arrayOfByte = new byte[i];
    this.b.readByteArray(arrayOfByte);
    return arrayOfByte;
  }
  
  public <T extends Parcelable> T g() { return (T)this.b.readParcelable(getClass().getClassLoader()); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\androidx\versionedparcelable\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */