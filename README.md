# SaveStudy

This project is done with Android Studio.


### Versions:
Android Studio Chipmunk: 2021.2.1 Patch2.  
Tested on: Pixel 4, Pixel 5, Pixel XL. 




### Getting started  
Download or clone this repository and import it into Android Studio.   
  
    
      
        
        



Requirements for showing Graph and showing GIF image.  
Add to the android section in buidl.gradle following code.

```
implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'
implementation 'pl.droidsonroids.gif:android-gif-drawable:1.2.25'
```
↓  
```
dependencies {
    implementation 'androidx.appcompat:appcompat:1.5.1'
    implementation 'com.google.android.material:material:1.7.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.4'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.0'
    implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'
    implementation 'pl.droidsonroids.gif:android-gif-drawable:1.2.25'
}
```  

### Main Page
4 options on the main page.  
If you want to see the results, you can press Completed button, or Graph button.  
If you want to go to Timer Page, you can press Timer button.  
You usually want to start from Plan Page to decide which task and subject you want to complete.  

![スクリーンショット (305)](https://user-images.githubusercontent.com/64859961/211694676-20aa0032-d70d-4f97-9c78-aeaa8a13f8b1.png)

### Plan Page
You can enter a task and a subject.  

![スクリーンショット (307)](https://user-images.githubusercontent.com/64859961/211694742-610807c5-3f8c-4dfa-9e84-039760c64d9c.png)

### Timer Page
-Start button  
It is a count up timer.  

-Pause button  
It pauses the timer and resume once you press start again.   

-Reset button  
It resets timer to 0.  

-Record button  
It records the time displayed on the top.  
![スクリーンショット (300)](https://user-images.githubusercontent.com/64859961/211694760-d7fbc71d-0dbc-4cbf-8a1f-e3cda6a0f3c9.png)  


### Timer Page  
Time Page Demo  
![app demo2](https://user-images.githubusercontent.com/64859961/211703774-c2a8ddc8-4745-41ea-bf93-e9a03700c3e9.gif)


### Summary Page
  
-Shows the task and subject you entered.  
-Shows amount of time you study.  
![スクリーンショット (301)](https://user-images.githubusercontent.com/64859961/211694771-2d9b3a4d-4662-4aef-874a-4988446c0fc8.png)

### Result Page
Shows 2 options of page you want to go.  
-Completed Tasks page  
-Graph Page  
![スクリーンショット (306)](https://user-images.githubusercontent.com/64859961/211694785-1f4918b6-d964-404a-9b78-405e8508c4d1.png)

### Completed Tasks Page  
It shows most recent completed task on the top, and oldest completed task at the bottom.  
It shows three things.  
-Subject
-Task
-Amount of time you study for that task  
![スクリーンショット (302)](https://user-images.githubusercontent.com/64859961/211694803-41af5327-8b71-4552-96e1-885517d31866.png)


### Graph Page  
It shows total time you study for each days  
![スクリーンショット (304)](https://user-images.githubusercontent.com/64859961/211694812-e4ad02ad-ef8b-474b-9613-c86f9d6dc9fa.png)
