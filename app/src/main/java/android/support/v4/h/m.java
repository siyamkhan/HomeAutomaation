package android.support.v4.h;

import android.view.View;

public interface m {
  boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2);
  
  void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt);
  
  void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt);
  
  boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt);
  
  void onStopNestedScroll(View paramView);
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\h\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */