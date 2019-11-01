package android.support.e;

import android.view.View;
import android.view.WindowId;

class ak implements al {
  private final WindowId a;
  
  ak(View paramView) { this.a = paramView.getWindowId(); }
  
  public boolean equals(Object paramObject) { return (paramObject instanceof ak && ((ak)paramObject).a.equals(this.a)); }
  
  public int hashCode() { return this.a.hashCode(); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\e\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */