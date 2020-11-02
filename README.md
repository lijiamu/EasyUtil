# EasyUtil
Android常用Util集合。  
util功能:  
[APKDemo下载](http://d.7short.com/EasyUtil)
#### ☆DateUtil  日期格式转换    
支持年月日时分秒自由组合转换。  
#### ☆DensityUtil 单位转换（android常用单位dip、sp与px互转）  
#### ☆MathUtil 数学类工具类  
验证值是否是数字、是否是整数、四舍五入后的值。  
#### ☆MD5Util   
MD5加密  
#### ☆ToastUtil 统一吐司类  
#### ☆LogUtil 统一日志类  
支持输出文件名+方法名+代码行数+输出的msg,方便快速定位日志打印位置。  
#### ☆PickerViewUtil  
1.支持选择日期（年月日时分秒自由组合，例如yyyy-MM-dd）；  
2.支持选择城市（省市区）；  
3.支持自定义选项选择；  
#### ☆TitleBar 自定义标题栏  
详细情况 请参考demo
```xml
  <com.view.titlebar.TitleBar
            android:id="@+id/mTitleBar"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginBottom="20dp"
            android:background="@drawable/shape_gradient"
            app:barStyle="transparent"
            app:leftBackground="@null"
            app:leftTitle="返回"
            app:title="对话框"
            app:titleColor="@null"/>
```
  
使用  
Step 1.Add it in your root build.gradle at the end of repositories:
```java
    allprojects {
        repositories {
    		...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```java
	dependencies {
	        implementation 'com.github.lijiamu:EasyUtil:Tag'
	}
```
   
感谢[Android轮子哥](https://github.com/getActivity)

注：如有侵权请联系邮箱421294020@qq.com删除
