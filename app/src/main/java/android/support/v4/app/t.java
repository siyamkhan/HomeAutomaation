package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.h.r;
import android.support.v4.h.t;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class t {
  static String a(Map<String, String> paramMap, String paramString) {
    for (Map.Entry entry : paramMap.entrySet()) {
      if (paramString.equals(entry.getValue()))
        return (String)entry.getKey(); 
    } 
    return null;
  }
  
  protected static void a(List<View> paramList, View paramView) {
    int i = paramList.size();
    if (a(paramList, paramView, i))
      return; 
    paramList.add(paramView);
    for (int j = i; j < paramList.size(); j++) {
      View view = (View)paramList.get(j);
      if (view instanceof ViewGroup) {
        ViewGroup viewGroup = (ViewGroup)view;
        int k = viewGroup.getChildCount();
        for (byte b = 0; b < k; b++) {
          View view1 = viewGroup.getChildAt(b);
          if (!a(paramList, view1, i))
            paramList.add(view1); 
        } 
      } 
    } 
  }
  
  protected static boolean a(List paramList) { return (paramList == null || paramList.isEmpty()); }
  
  private static boolean a(List<View> paramList, View paramView, int paramInt) {
    for (byte b = 0; b < paramInt; b++) {
      if (paramList.get(b) == paramView)
        return true; 
    } 
    return false;
  }
  
  public abstract Object a(Object paramObject1, Object paramObject2, Object paramObject3);
  
  ArrayList<String> a(ArrayList<View> paramArrayList) {
    ArrayList arrayList = new ArrayList();
    int i = paramArrayList.size();
    for (byte b = 0; b < i; b++) {
      View view = (View)paramArrayList.get(b);
      arrayList.add(r.n(view));
      r.a(view, null);
    } 
    return arrayList;
  }
  
  protected void a(View paramView, Rect paramRect) {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  void a(View paramView, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, ArrayList<String> paramArrayList3, Map<String, String> paramMap) {
    int i = paramArrayList2.size();
    ArrayList arrayList = new ArrayList();
    for (byte b = 0; b < i; b++) {
      View view = (View)paramArrayList1.get(b);
      String str = r.n(view);
      arrayList.add(str);
      if (str != null) {
        r.a(view, null);
        String str1 = (String)paramMap.get(str);
        for (byte b1 = 0; b1 < i; b1++) {
          if (str1.equals(paramArrayList3.get(b1))) {
            r.a((View)paramArrayList2.get(b1), str);
            break;
          } 
        } 
      } 
    } 
    Runnable runnable = new Runnable(this, i, paramArrayList2, paramArrayList3, paramArrayList1, arrayList) {
        public void run() {
          for (byte b1 = 0; b1 < this.a; b1++) {
            r.a((View)this.b.get(b1), (String)this.c.get(b1));
            r.a((View)this.d.get(b1), (String)this.e.get(b1));
          } 
        }
      };
    aa.a(paramView, runnable);
  }
  
  void a(View paramView, ArrayList<View> paramArrayList, Map<String, String> paramMap) { aa.a(paramView, new Runnable(this, paramArrayList, paramMap) {
          public void run() {
            int i = this.a.size();
            for (byte b1 = 0; b1 < i; b1++) {
              View view = (View)this.a.get(b1);
              String str = r.n(view);
              if (str != null)
                r.a(view, t.a(this.b, str)); 
            } 
          }
        }); }
  
  public abstract void a(ViewGroup paramViewGroup, Object paramObject);
  
  void a(ViewGroup paramViewGroup, ArrayList<View> paramArrayList, Map<String, String> paramMap) { aa.a(paramViewGroup, new Runnable(this, paramArrayList, paramMap) {
          public void run() {
            int i = this.a.size();
            for (byte b1 = 0; b1 < i; b1++) {
              View view = (View)this.a.get(b1);
              String str = r.n(view);
              r.a(view, (String)this.b.get(str));
            } 
          }
        }); }
  
  public abstract void a(Object paramObject, Rect paramRect);
  
  public abstract void a(Object paramObject, View paramView);
  
  public abstract void a(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  public abstract void a(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3);
  
  public abstract void a(Object paramObject, ArrayList<View> paramArrayList);
  
  public abstract void a(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  void a(ArrayList<View> paramArrayList, View paramView) {
    ViewGroup viewGroup;
    if (paramView.getVisibility() == 0) {
      if (paramView instanceof ViewGroup) {
        viewGroup = (ViewGroup)paramView;
        if (t.a(viewGroup)) {
          paramArrayList.add(viewGroup);
          return;
        } 
        int i = viewGroup.getChildCount();
        for (byte b = 0; b < i; b++)
          a(paramArrayList, viewGroup.getChildAt(b)); 
        return;
      } 
    } else {
      return;
    } 
    paramArrayList.add(viewGroup);
  }
  
  void a(Map<String, View> paramMap, View paramView) {
    if (paramView.getVisibility() == 0) {
      String str = r.n(paramView);
      if (str != null)
        paramMap.put(str, paramView); 
      if (paramView instanceof ViewGroup) {
        ViewGroup viewGroup = (ViewGroup)paramView;
        int i = viewGroup.getChildCount();
        for (byte b = 0; b < i; b++)
          a(paramMap, viewGroup.getChildAt(b)); 
      } 
    } 
  }
  
  public abstract boolean a(Object paramObject);
  
  public abstract Object b(Object paramObject);
  
  public abstract Object b(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract void b(Object paramObject, View paramView);
  
  public abstract void b(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  public abstract void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  public abstract Object c(Object paramObject);
  
  public abstract void c(Object paramObject, View paramView);
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */