# Best practice Challenge for MVVM x RecyclerView

2021/8/29 更新
ViewHolder傳入ViewModel有點智障,應該改成傳入interface,以後在改
-----------------------

大概遵循MVVM官方推薦的架構
ViewModel主要負責處理LiveData的傳送，Repository主要負責資料的來源和一些邏輯判斷

使用ListAdapter是因為官方幫我們整合好了，不需要再像DiffUtil在那邊new有的沒的和操作

在SpecialActivity裡面展示了Recyclerview最新的功能***ConcatAdapter***，它可以透過合併Adapter的方法來達到以前在一個Adapter裡面需要多種ItewViewType的功能，這裡要注意的是宣告ConcatAdapter我把setIsolateViewTypes(false)簡單來說這樣可以在GridLayoutManager拿到各個獨立設定的ViewType，拿到ViewType我就可以決定這個類型一行要有幾個之類的，建議還是看官網文件會比較清楚。

至於用ViewBinding的原因有幾個，kotlin的synthetic以後要被棄用了，懶得寫findViewById()，不會DataBinding學不動

### 主要使用語言 Kotlin 1.3.71

### 主要使用的Library
#### UI
* Recyclerview 1.2.0
* ViewBinding (Gradle 3.6以上內建的樣子)

#### NetWork
* Retrofit 2.9.0
* adapter-rxjava3:2.9.0
* converter-moshi:2.9.0
* rxkotlin:3.0.1
* rxandroid:3.0.0

#### MVVM
* lifecycle-viewmodel-ktx:2.3.1
* lifecycle-livedata-ktx:2.3.1

#### Json
* moshi-kotlin:1.9.2
* moshi-kotlin-codegen:1.11.0
