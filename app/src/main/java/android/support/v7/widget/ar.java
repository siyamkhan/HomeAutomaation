package android.support.v7.widget;

import android.view.View;

class ar {
  boolean a = true;
  
  int b;
  
  int c;
  
  int d;
  
  int e;
  
  int f = 0;
  
  int g = 0;
  
  boolean h;
  
  boolean i;
  
  View a(RecyclerView.p paramp) {
    View view = paramp.c(this.c);
    this.c += this.d;
    return view;
  }
  
  boolean a(RecyclerView.u paramu) {
    int j = this.c;
    return (j >= 0 && j < paramu.e());
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LayoutState{mAvailable=");
    stringBuilder.append(this.b);
    stringBuilder.append(", mCurrentPosition=");
    stringBuilder.append(this.c);
    stringBuilder.append(", mItemDirection=");
    stringBuilder.append(this.d);
    stringBuilder.append(", mLayoutDirection=");
    stringBuilder.append(this.e);
    stringBuilder.append(", mStartLine=");
    stringBuilder.append(this.f);
    stringBuilder.append(", mEndLine=");
    stringBuilder.append(this.g);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */