DiffUtilRv
----
我認為最佳MVVM-RecyclerView交互範例

#### 我認為

ViewModel:

- 定義物件集合如何被建構
- 以公開方法敘述使用者行為並且對資料集合做修改(故只要看ViewModel我們就可以得知該頁面大部分功能）
- 資料使用LiveData發布給View

Adapter(View):

- 定義單一物件如何在畫面上顯示
- 沒有任何修改資料順序、內容的代碼。其餘都在ViewModel內完成

Activity(View):

- 將使用者行為轉導到ViewModel