package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

class s extends t {
  private static boolean a(Transition paramTransition) { return (!a(paramTransition.getTargetIds()) || !a(paramTransition.getTargetNames()) || !a(paramTransition.getTargetTypes())); }
  
  public Object a(Object paramObject1, Object paramObject2, Object paramObject3) {
    TransitionSet transitionSet = new TransitionSet();
    if (paramObject1 != null)
      transitionSet.addTransition((Transition)paramObject1); 
    if (paramObject2 != null)
      transitionSet.addTransition((Transition)paramObject2); 
    if (paramObject3 != null)
      transitionSet.addTransition((Transition)paramObject3); 
    return transitionSet;
  }
  
  public void a(ViewGroup paramViewGroup, Object paramObject) { TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject); }
  
  public void a(Object paramObject, Rect paramRect) {
    if (paramObject != null)
      ((Transition)paramObject).setEpicenterCallback(new Transition.EpicenterCallback(this, paramRect) {
            public Rect onGetEpicenter(Transition param1Transition) {
              Rect rect = this.a;
              return (rect == null || rect.isEmpty()) ? null : this.a;
            }
          }); 
  }
  
  public void a(Object paramObject, View paramView) {
    if (paramView != null) {
      Transition transition = (Transition)paramObject;
      Rect rect = new Rect();
      a(paramView, rect);
      transition.setEpicenterCallback(new Transition.EpicenterCallback(this, rect) {
            public Rect onGetEpicenter(Transition param1Transition) { return this.a; }
          });
    } 
  }
  
  public void a(Object paramObject, View paramView, ArrayList<View> paramArrayList) {
    TransitionSet transitionSet = (TransitionSet)paramObject;
    List list = transitionSet.getTargets();
    list.clear();
    int i = paramArrayList.size();
    for (byte b = 0; b < i; b++)
      a(list, (View)paramArrayList.get(b)); 
    list.add(paramView);
    paramArrayList.add(paramView);
    a(transitionSet, paramArrayList);
  }
  
  public void a(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3) {
    Transition transition = (Transition)paramObject1;
    Transition.TransitionListener transitionListener = new Transition.TransitionListener(this, paramObject2, paramArrayList1, paramObject3, paramArrayList2, paramObject4, paramArrayList3) {
        public void onTransitionCancel(Transition param1Transition) {}
        
        public void onTransitionEnd(Transition param1Transition) {}
        
        public void onTransitionPause(Transition param1Transition) {}
        
        public void onTransitionResume(Transition param1Transition) {}
        
        public void onTransitionStart(Transition param1Transition) {
          Object object1 = this.a;
          if (object1 != null)
            this.g.b(object1, this.b, null); 
          Object object2 = this.c;
          if (object2 != null)
            this.g.b(object2, this.d, null); 
          Object object3 = this.e;
          if (object3 != null)
            this.g.b(object3, this.f, null); 
        }
      };
    transition.addListener(transitionListener);
  }
  
  public void a(Object paramObject, ArrayList<View> paramArrayList) {
    Transition transition = (Transition)paramObject;
    if (transition == null)
      return; 
    boolean bool = transition instanceof TransitionSet;
    byte b = 0;
    if (bool) {
      TransitionSet transitionSet = (TransitionSet)transition;
      int i = transitionSet.getTransitionCount();
      while (b < i) {
        a(transitionSet.getTransitionAt(b), paramArrayList);
        b++;
      } 
    } else if (!a(transition) && a(transition.getTargets())) {
      int i = paramArrayList.size();
      while (b < i) {
        transition.addTarget((View)paramArrayList.get(b));
        b++;
      } 
    } 
  }
  
  public void a(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2) {
    TransitionSet transitionSet = (TransitionSet)paramObject;
    if (transitionSet != null) {
      transitionSet.getTargets().clear();
      transitionSet.getTargets().addAll(paramArrayList2);
      b(transitionSet, paramArrayList1, paramArrayList2);
    } 
  }
  
  public boolean a(Object paramObject) { return paramObject instanceof Transition; }
  
  public Object b(Object paramObject) { return (paramObject != null) ? ((Transition)paramObject).clone() : null; }
  
  public Object b(Object paramObject1, Object paramObject2, Object paramObject3) {
    TransitionSet transitionSet = (Transition)paramObject1;
    Transition transition1 = (Transition)paramObject2;
    Transition transition2 = (Transition)paramObject3;
    if (transitionSet != null && transition1 != null) {
      transitionSet = (new TransitionSet()).addTransition(transitionSet).addTransition(transition1).setOrdering(1);
    } else if (transitionSet == null) {
      if (transition1 != null) {
        Transition transition = transition1;
      } else {
        transitionSet = null;
      } 
    } 
    if (transition2 != null) {
      TransitionSet transitionSet1 = new TransitionSet();
      if (transitionSet != null)
        transitionSet1.addTransition(transitionSet); 
      transitionSet1.addTransition(transition2);
      return transitionSet1;
    } 
    return transitionSet;
  }
  
  public void b(Object paramObject, View paramView) {
    if (paramObject != null)
      ((Transition)paramObject).addTarget(paramView); 
  }
  
  public void b(Object paramObject, View paramView, ArrayList<View> paramArrayList) { ((Transition)paramObject).addListener(new Transition.TransitionListener(this, paramView, paramArrayList) {
          public void onTransitionCancel(Transition param1Transition) {}
          
          public void onTransitionEnd(Transition param1Transition) {
            param1Transition.removeListener(this);
            this.a.setVisibility(8);
            int i = this.b.size();
            for (byte b1 = 0; b1 < i; b1++)
              ((View)this.b.get(b1)).setVisibility(0); 
          }
          
          public void onTransitionPause(Transition param1Transition) {}
          
          public void onTransitionResume(Transition param1Transition) {}
          
          public void onTransitionStart(Transition param1Transition) {}
        }); }
  
  public void b(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2) {
    Transition transition = (Transition)paramObject;
    boolean bool = transition instanceof TransitionSet;
    byte b = 0;
    if (bool) {
      TransitionSet transitionSet = (TransitionSet)transition;
      int i = transitionSet.getTransitionCount();
      while (b < i) {
        b(transitionSet.getTransitionAt(b), paramArrayList1, paramArrayList2);
        b++;
      } 
    } else if (!a(transition)) {
      List list = transition.getTargets();
      if (list != null && list.size() == paramArrayList1.size() && list.containsAll(paramArrayList1)) {
        int i;
        if (paramArrayList2 == null) {
          i = 0;
          b = 0;
        } else {
          i = paramArrayList2.size();
        } 
        while (b < i) {
          transition.addTarget((View)paramArrayList2.get(b));
          b++;
        } 
        for (int j = -1 + paramArrayList1.size(); j >= 0; j--)
          transition.removeTarget((View)paramArrayList1.get(j)); 
      } 
    } 
  }
  
  public Object c(Object paramObject) {
    if (paramObject == null)
      return null; 
    TransitionSet transitionSet = new TransitionSet();
    transitionSet.addTransition((Transition)paramObject);
    return transitionSet;
  }
  
  public void c(Object paramObject, View paramView) {
    if (paramObject != null)
      ((Transition)paramObject).removeTarget(paramView); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */