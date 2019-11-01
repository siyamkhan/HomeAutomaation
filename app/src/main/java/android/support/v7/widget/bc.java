package android.support.v7.widget;

class bc {
  private int a = 0;
  
  private int b = 0;
  
  private int c = Integer.MIN_VALUE;
  
  private int d = Integer.MIN_VALUE;
  
  private int e = 0;
  
  private int f = 0;
  
  private boolean g = false;
  
  private boolean h = false;
  
  public int a() { return this.a; }
  
  public void a(int paramInt1, int paramInt2) {
    this.c = paramInt1;
    this.d = paramInt2;
    this.h = true;
    if (this.g) {
      if (paramInt2 != Integer.MIN_VALUE)
        this.a = paramInt2; 
      if (paramInt1 != Integer.MIN_VALUE) {
        this.b = paramInt1;
        return;
      } 
    } else {
      if (paramInt1 != Integer.MIN_VALUE)
        this.a = paramInt1; 
      if (paramInt2 != Integer.MIN_VALUE)
        this.b = paramInt2; 
    } 
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean == this.g)
      return; 
    this.g = paramBoolean;
    if (this.h) {
      if (paramBoolean) {
        int k = this.d;
        if (k == Integer.MIN_VALUE)
          k = this.e; 
        this.a = k;
        int j = this.c;
        if (j != Integer.MIN_VALUE) {
          this.b = j;
          return;
        } 
      } else {
        int k = this.c;
        if (k == Integer.MIN_VALUE)
          k = this.e; 
        this.a = k;
        int j = this.d;
        if (j != Integer.MIN_VALUE) {
          this.b = j;
          return;
        } 
      } 
    } else {
      this.a = this.e;
    } 
    int i = this.f;
    this.b = i;
  }
  
  public int b() { return this.b; }
  
  public void b(int paramInt1, int paramInt2) {
    this.h = false;
    if (paramInt1 != Integer.MIN_VALUE) {
      this.e = paramInt1;
      this.a = paramInt1;
    } 
    if (paramInt2 != Integer.MIN_VALUE) {
      this.f = paramInt2;
      this.b = paramInt2;
    } 
  }
  
  public int c() { return this.g ? this.b : this.a; }
  
  public int d() { return this.g ? this.a : this.b; }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */