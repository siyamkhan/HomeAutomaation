package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class y implements w {
  private final Notification.Builder a;
  
  private final x.c b;
  
  private RemoteViews c;
  
  private RemoteViews d;
  
  private final List<Bundle> e = new ArrayList();
  
  private final Bundle f = new Bundle();
  
  private int g;
  
  private RemoteViews h;
  
  y(x.c paramc) {
    this.b = paramc;
    if (Build.VERSION.SDK_INT >= 26) {
      builder1 = new Notification.Builder(paramc.a, paramc.I);
    } else {
      builder1 = new Notification.Builder(paramc.a);
    } 
    this.a = builder1;
    Notification notification = paramc.N;
    Notification.Builder builder2 = this.a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, paramc.h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
    if ((0x2 & notification.flags) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Notification.Builder builder3 = builder2.setOngoing(bool1);
    if ((0x8 & notification.flags) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Notification.Builder builder4 = builder3.setOnlyAlertOnce(bool2);
    if ((0x10 & notification.flags) != 0) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    Notification.Builder builder5 = builder4.setAutoCancel(bool3).setDefaults(notification.defaults).setContentTitle(paramc.d).setContentText(paramc.e).setContentInfo(paramc.j).setContentIntent(paramc.f).setDeleteIntent(notification.deleteIntent);
    PendingIntent pendingIntent = paramc.g;
    if ((0x80 & notification.flags) != 0) {
      bool4 = true;
    } else {
      bool4 = false;
    } 
    builder5.setFullScreenIntent(pendingIntent, bool4).setLargeIcon(paramc.i).setNumber(paramc.k).setProgress(paramc.r, paramc.s, paramc.t);
    if (Build.VERSION.SDK_INT < 21)
      this.a.setSound(notification.sound, notification.audioStreamType); 
    if (Build.VERSION.SDK_INT >= 16) {
      this.a.setSubText(paramc.p).setUsesChronometer(paramc.n).setPriority(paramc.l);
      Iterator iterator = paramc.b.iterator();
      while (iterator.hasNext())
        a((x.a)iterator.next()); 
      if (paramc.B != null)
        this.f.putAll(paramc.B); 
      if (Build.VERSION.SDK_INT < 20) {
        if (paramc.x)
          this.f.putBoolean("android.support.localOnly", true); 
        if (paramc.u != null) {
          String str;
          Bundle bundle;
          this.f.putString("android.support.groupKey", paramc.u);
          if (paramc.v) {
            bundle = this.f;
            str = "android.support.isGroupSummary";
          } else {
            bundle = this.f;
            str = "android.support.useSideChannel";
          } 
          bundle.putBoolean(str, true);
        } 
        if (paramc.w != null)
          this.f.putString("android.support.sortKey", paramc.w); 
      } 
      this.c = paramc.F;
      this.d = paramc.G;
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      this.a.setShowWhen(paramc.m);
      if (Build.VERSION.SDK_INT < 21 && paramc.O != null && !paramc.O.isEmpty())
        this.f.putStringArray("android.people", (String[])paramc.O.toArray(new String[paramc.O.size()])); 
    } 
    if (Build.VERSION.SDK_INT >= 20) {
      this.a.setLocalOnly(paramc.x).setGroup(paramc.u).setGroupSummary(paramc.v).setSortKey(paramc.w);
      this.g = paramc.M;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      this.a.setCategory(paramc.A).setColor(paramc.C).setVisibility(paramc.D).setPublicVersion(paramc.E).setSound(notification.sound, notification.audioAttributes);
      for (String str : paramc.O)
        this.a.addPerson(str); 
      this.h = paramc.H;
      if (paramc.c.size() > 0) {
        Bundle bundle1 = paramc.a().getBundle("android.car.EXTENSIONS");
        if (bundle1 == null)
          bundle1 = new Bundle(); 
        Bundle bundle2 = new Bundle();
        for (byte b1 = 0; b1 < paramc.c.size(); b1++)
          bundle2.putBundle(Integer.toString(b1), z.a((x.a)paramc.c.get(b1))); 
        bundle1.putBundle("invisible_actions", bundle2);
        paramc.a().putBundle("android.car.EXTENSIONS", bundle1);
        this.f.putBundle("android.car.EXTENSIONS", bundle1);
      } 
    } 
    if (Build.VERSION.SDK_INT >= 24) {
      this.a.setExtras(paramc.B).setRemoteInputHistory(paramc.q);
      if (paramc.F != null)
        this.a.setCustomContentView(paramc.F); 
      if (paramc.G != null)
        this.a.setCustomBigContentView(paramc.G); 
      if (paramc.H != null)
        this.a.setCustomHeadsUpContentView(paramc.H); 
    } 
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.setBadgeIconType(paramc.J).setShortcutId(paramc.K).setTimeoutAfter(paramc.L).setGroupAlertBehavior(paramc.M);
      if (paramc.z)
        this.a.setColorized(paramc.y); 
      if (!TextUtils.isEmpty(paramc.I))
        this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null); 
    } 
  }
  
  private void a(Notification paramNotification) {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults = 0xFFFFFFFE & paramNotification.defaults;
    paramNotification.defaults = 0xFFFFFFFD & paramNotification.defaults;
  }
  
  private void a(x.a parama) {
    if (Build.VERSION.SDK_INT >= 20) {
      Bundle bundle;
      Notification.Action.Builder builder = new Notification.Action.Builder(parama.a(), parama.b(), parama.c());
      if (parama.f() != null) {
        RemoteInput[] arrayOfRemoteInput = ab.a(parama.f());
        int i = arrayOfRemoteInput.length;
        for (byte b1 = 0; b1 < i; b1++)
          builder.addRemoteInput(arrayOfRemoteInput[b1]); 
      } 
      if (parama.d() != null) {
        bundle = new Bundle(parama.d());
      } else {
        bundle = new Bundle();
      } 
      bundle.putBoolean("android.support.allowGeneratedReplies", parama.e());
      if (Build.VERSION.SDK_INT >= 24)
        builder.setAllowGeneratedReplies(parama.e()); 
      bundle.putInt("android.support.action.semanticAction", parama.g());
      if (Build.VERSION.SDK_INT >= 28)
        builder.setSemanticAction(parama.g()); 
      bundle.putBoolean("android.support.action.showsUserInterface", parama.i());
      builder.addExtras(bundle);
      this.a.addAction(builder.build());
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16)
      this.e.add(z.a(this.a, parama)); 
  }
  
  public Notification.Builder a() { return this.a; }
  
  public Notification b() { // Byte code:
    //   0: aload_0
    //   1: getfield b : Landroid/support/v4/app/x$c;
    //   4: getfield o : Landroid/support/v4/app/x$d;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull -> 17
    //   12: aload_1
    //   13: aload_0
    //   14: invokevirtual a : (Landroid/support/v4/app/w;)V
    //   17: aload_1
    //   18: ifnull -> 30
    //   21: aload_1
    //   22: aload_0
    //   23: invokevirtual b : (Landroid/support/v4/app/w;)Landroid/widget/RemoteViews;
    //   26: astore_2
    //   27: goto -> 32
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_0
    //   33: invokevirtual c : ()Landroid/app/Notification;
    //   36: astore_3
    //   37: aload_2
    //   38: ifnull -> 49
    //   41: aload_3
    //   42: aload_2
    //   43: putfield contentView : Landroid/widget/RemoteViews;
    //   46: goto -> 70
    //   49: aload_0
    //   50: getfield b : Landroid/support/v4/app/x$c;
    //   53: getfield F : Landroid/widget/RemoteViews;
    //   56: ifnull -> 70
    //   59: aload_0
    //   60: getfield b : Landroid/support/v4/app/x$c;
    //   63: getfield F : Landroid/widget/RemoteViews;
    //   66: astore_2
    //   67: goto -> 41
    //   70: getstatic android/os/Build$VERSION.SDK_INT : I
    //   73: bipush #16
    //   75: if_icmplt -> 100
    //   78: aload_1
    //   79: ifnull -> 100
    //   82: aload_1
    //   83: aload_0
    //   84: invokevirtual c : (Landroid/support/v4/app/w;)Landroid/widget/RemoteViews;
    //   87: astore #6
    //   89: aload #6
    //   91: ifnull -> 100
    //   94: aload_3
    //   95: aload #6
    //   97: putfield bigContentView : Landroid/widget/RemoteViews;
    //   100: getstatic android/os/Build$VERSION.SDK_INT : I
    //   103: bipush #21
    //   105: if_icmplt -> 136
    //   108: aload_1
    //   109: ifnull -> 136
    //   112: aload_0
    //   113: getfield b : Landroid/support/v4/app/x$c;
    //   116: getfield o : Landroid/support/v4/app/x$d;
    //   119: aload_0
    //   120: invokevirtual d : (Landroid/support/v4/app/w;)Landroid/widget/RemoteViews;
    //   123: astore #5
    //   125: aload #5
    //   127: ifnull -> 136
    //   130: aload_3
    //   131: aload #5
    //   133: putfield headsUpContentView : Landroid/widget/RemoteViews;
    //   136: getstatic android/os/Build$VERSION.SDK_INT : I
    //   139: bipush #16
    //   141: if_icmplt -> 165
    //   144: aload_1
    //   145: ifnull -> 165
    //   148: aload_3
    //   149: invokestatic a : (Landroid/app/Notification;)Landroid/os/Bundle;
    //   152: astore #4
    //   154: aload #4
    //   156: ifnull -> 165
    //   159: aload_1
    //   160: aload #4
    //   162: invokevirtual a : (Landroid/os/Bundle;)V
    //   165: aload_3
    //   166: areturn }
  
  protected Notification c() {
    if (Build.VERSION.SDK_INT >= 26)
      return this.a.build(); 
    if (Build.VERSION.SDK_INT >= 24) {
      Notification notification = this.a.build();
      if (this.g != 0) {
        if (notification.getGroup() != null && (0x200 & notification.flags) != 0 && this.g == 2)
          a(notification); 
        if (notification.getGroup() != null && (0x200 & notification.flags) == 0 && this.g == 1)
          a(notification); 
      } 
      return notification;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      this.a.setExtras(this.f);
      Notification notification = this.a.build();
      RemoteViews remoteViews1 = this.c;
      if (remoteViews1 != null)
        notification.contentView = remoteViews1; 
      RemoteViews remoteViews2 = this.d;
      if (remoteViews2 != null)
        notification.bigContentView = remoteViews2; 
      RemoteViews remoteViews3 = this.h;
      if (remoteViews3 != null)
        notification.headsUpContentView = remoteViews3; 
      if (this.g != 0) {
        if (notification.getGroup() != null && (0x200 & notification.flags) != 0 && this.g == 2)
          a(notification); 
        if (notification.getGroup() != null && (0x200 & notification.flags) == 0 && this.g == 1)
          a(notification); 
      } 
      return notification;
    } 
    if (Build.VERSION.SDK_INT >= 20) {
      this.a.setExtras(this.f);
      Notification notification = this.a.build();
      RemoteViews remoteViews1 = this.c;
      if (remoteViews1 != null)
        notification.contentView = remoteViews1; 
      RemoteViews remoteViews2 = this.d;
      if (remoteViews2 != null)
        notification.bigContentView = remoteViews2; 
      if (this.g != 0) {
        if (notification.getGroup() != null && (0x200 & notification.flags) != 0 && this.g == 2)
          a(notification); 
        if (notification.getGroup() != null && (0x200 & notification.flags) == 0 && this.g == 1)
          a(notification); 
      } 
      return notification;
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      SparseArray sparseArray = z.a(this.e);
      if (sparseArray != null)
        this.f.putSparseParcelableArray("android.support.actionExtras", sparseArray); 
      this.a.setExtras(this.f);
      Notification notification = this.a.build();
      RemoteViews remoteViews1 = this.c;
      if (remoteViews1 != null)
        notification.contentView = remoteViews1; 
      RemoteViews remoteViews2 = this.d;
      if (remoteViews2 != null)
        notification.bigContentView = remoteViews2; 
      return notification;
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      Notification notification = this.a.build();
      Bundle bundle1 = x.a(notification);
      Bundle bundle2 = new Bundle(this.f);
      for (String str : this.f.keySet()) {
        if (bundle1.containsKey(str))
          bundle2.remove(str); 
      } 
      bundle1.putAll(bundle2);
      SparseArray sparseArray = z.a(this.e);
      if (sparseArray != null)
        x.a(notification).putSparseParcelableArray("android.support.actionExtras", sparseArray); 
      RemoteViews remoteViews1 = this.c;
      if (remoteViews1 != null)
        notification.contentView = remoteViews1; 
      RemoteViews remoteViews2 = this.d;
      if (remoteViews2 != null)
        notification.bigContentView = remoteViews2; 
      return notification;
    } 
    return this.a.getNotification();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\app\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */