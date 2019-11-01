package android.arch.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class a {
  static a a = new a();
  
  private final Map<Class, a> b = new HashMap();
  
  private final Map<Class, Boolean> c = new HashMap();
  
  private a a(Class paramClass, Method[] paramArrayOfMethod) {
    Class clazz = paramClass.getSuperclass();
    HashMap hashMap = new HashMap();
    if (clazz != null) {
      a a2 = b(clazz);
      if (a2 != null)
        hashMap.putAll(a2.b); 
    } 
    Class[] arrayOfClass = paramClass.getInterfaces();
    int i = arrayOfClass.length;
    for (byte b1 = 0; b1 < i; b1++) {
      for (Map.Entry entry : (b(arrayOfClass[b1])).b.entrySet())
        a(hashMap, (b)entry.getKey(), (c.a)entry.getValue(), paramClass); 
    } 
    if (paramArrayOfMethod == null)
      paramArrayOfMethod = c(paramClass); 
    int j = paramArrayOfMethod.length;
    byte b2 = 0;
    boolean bool = false;
    while (b2 < j) {
      Method method = paramArrayOfMethod[b2];
      l l = (l)method.getAnnotation(l.class);
      if (l != null) {
        byte b3;
        Class[] arrayOfClass1 = method.getParameterTypes();
        if (arrayOfClass1.length > 0) {
          if (arrayOfClass1[0].isAssignableFrom(e.class)) {
            b3 = 1;
          } else {
            throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
          } 
        } else {
          b3 = 0;
        } 
        c.a a2 = l.a();
        if (arrayOfClass1.length > 1)
          if (arrayOfClass1[1].isAssignableFrom(c.a.class)) {
            if (a2 == c.a.ON_ANY) {
              b3 = 2;
            } else {
              throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
            } 
          } else {
            throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
          }  
        if (arrayOfClass1.length <= 2) {
          a(hashMap, new b(b3, method), a2, paramClass);
          bool = true;
        } else {
          throw new IllegalArgumentException("cannot have more than 2 params");
        } 
      } 
      b2++;
    } 
    a a1 = new a(hashMap);
    this.b.put(paramClass, a1);
    this.c.put(paramClass, Boolean.valueOf(bool));
    return a1;
  }
  
  private void a(Map<b, c.a> paramMap, b paramb, c.a parama, Class paramClass) {
    c.a a1 = (c.a)paramMap.get(paramb);
    if (a1 == null || parama == a1) {
      if (a1 == null)
        paramMap.put(paramb, parama); 
      return;
    } 
    Method method = paramb.b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Method ");
    stringBuilder.append(method.getName());
    stringBuilder.append(" in ");
    stringBuilder.append(paramClass.getName());
    stringBuilder.append(" already declared with different @OnLifecycleEvent value: previous value ");
    stringBuilder.append(a1);
    stringBuilder.append(", new value ");
    stringBuilder.append(parama);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private Method[] c(Class paramClass) {
    try {
      return paramClass.getDeclaredMethods();
    } catch (NoClassDefFoundError noClassDefFoundError) {
      throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", noClassDefFoundError);
    } 
  }
  
  boolean a(Class paramClass) {
    if (this.c.containsKey(paramClass))
      return ((Boolean)this.c.get(paramClass)).booleanValue(); 
    Method[] arrayOfMethod = c(paramClass);
    int i = arrayOfMethod.length;
    for (byte b1 = 0; b1 < i; b1++) {
      if ((l)arrayOfMethod[b1].getAnnotation(l.class) != null) {
        a(paramClass, arrayOfMethod);
        return true;
      } 
    } 
    this.c.put(paramClass, Boolean.valueOf(false));
    return false;
  }
  
  a b(Class paramClass) {
    a a1 = (a)this.b.get(paramClass);
    return (a1 != null) ? a1 : a(paramClass, null);
  }
  
  static class a {
    final Map<c.a, List<a.b>> a;
    
    final Map<a.b, c.a> b;
    
    a(Map<a.b, c.a> param1Map) {
      this.b = param1Map;
      this.a = new HashMap();
      for (Map.Entry entry : param1Map.entrySet()) {
        c.a a1 = (c.a)entry.getValue();
        List list = (List)this.a.get(a1);
        if (list == null) {
          list = new ArrayList();
          this.a.put(a1, list);
        } 
        list.add(entry.getKey());
      } 
    }
    
    private static void a(List<a.b> param1List, e param1e, c.a param1a, Object param1Object) {
      if (param1List != null)
        for (int i = -1 + param1List.size(); i >= 0; i--)
          ((a.b)param1List.get(i)).a(param1e, param1a, param1Object);  
    }
    
    void a(e param1e, c.a param1a, Object param1Object) {
      a((List)this.a.get(param1a), param1e, param1a, param1Object);
      a((List)this.a.get(c.a.ON_ANY), param1e, param1a, param1Object);
    }
  }
  
  static class b {
    final int a;
    
    final Method b;
    
    b(int param1Int, Method param1Method) {
      this.a = param1Int;
      this.b = param1Method;
      this.b.setAccessible(true);
    }
    
    void a(e param1e, c.a param1a, Object param1Object) {
      try {
        switch (this.a) {
          case 2:
            this.b.invoke(param1Object, new Object[] { param1e, param1a });
            return;
          case 1:
            this.b.invoke(param1Object, new Object[] { param1e });
            return;
          case 0:
            this.b.invoke(param1Object, new Object[0]);
            return;
        } 
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException("Failed to call observer method", invocationTargetException.getCause());
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException(illegalAccessException);
      } 
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object != null) {
        if (getClass() != param1Object.getClass())
          return false; 
        b b1 = (b)param1Object;
        return (this.a == b1.a && this.b.getName().equals(b1.b.getName()));
      } 
      return false;
    }
    
    public int hashCode() { return 31 * this.a + this.b.getName().hashCode(); }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\arch\lifecycle\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */