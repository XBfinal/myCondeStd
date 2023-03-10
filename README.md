# 设计模式学习

## 一、创建型模式
### 1.单例模式的特点
* 　a、单例类只能有一个实例。
* 　b、单例类必须自己创建自己的唯一实例。
* 　c、单例类必须给所有其他对象提供这一实例。
* 单例模式保证了全局对象的唯一性，比如系统启动读取配置文件就需要单例保证配置的一致性。
### 二、单例模式分类
* 1.饿汉式（静态常量）【可用】   [饿汉式链接](https://github.com/XBfinal/Design_pattern/blob/master/src/Creative_mode/Singleton_mode/SingletonTest01.java)
* 2.饿汉式（静态代码块）【可用】 [饿汉式链接](https://github.com/XBfinal/Design_pattern/blob/master/src/Creative_mode/Singleton_mode/SingletonTest01.java)

  饿汉式都可能造成内存的浪费
   
* 3.懒汉式（线程不安全）【不可用】
* 4.懒汉式（线程安全，同步方法）【不可用】
* 5.懒汉式（线程安全，同步代码块）【不可用】
* 6.双重检查【推荐使用】
* 7.静态内部类【推荐使用
* 8.枚举【推荐使用】
